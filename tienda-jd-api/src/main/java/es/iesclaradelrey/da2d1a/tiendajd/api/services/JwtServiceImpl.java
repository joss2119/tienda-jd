package es.iesclaradelrey.da2d1a.tiendajd.api.services;


import es.iesclaradelrey.da2d1a.tiendajd.api.enums.TipoToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.access-token-expiration}")
    private long accessTokenExpiration;

    @Value("${jwt.refresh-token-expiration}")
    private long refreshTokenExpiration;

    // Generar Access Token
    @Override
    public String generateAccessToken(UserDetails user) {
        return buildToken(user, accessTokenExpiration, TipoToken.ACCESO);
    }

    // Generar Refresh Token
    @Override
    public String generateRefreshToken(UserDetails user) {
        return buildToken(user, refreshTokenExpiration, TipoToken.REFRESCO);
    }

    // Método privado para construir el token (reutilización de código)
    private String buildToken(UserDetails user, long expiration, TipoToken tipo) {
        return Jwts.builder()
                .setSubject(user.getUsername()) // Claim estándar "Subject"
                .setIssuedAt(new Date(System.currentTimeMillis())) // "issuedAt"
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // "expiration"
                .claim("type", tipo.name()) // Claim personalizado "type" [cite: 82]
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // Firma digital
                .compact();
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    @Override
    public Boolean isTokenValid(String token, UserDetails user) {
        final String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    // --- Métodos auxiliares para manejo de Claims ---

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey()) // Valida la firma al extraer
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}