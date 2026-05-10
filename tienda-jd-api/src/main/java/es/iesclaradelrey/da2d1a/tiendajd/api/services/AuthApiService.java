package es.iesclaradelrey.da2d1a.tiendajd.api.services;

import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.LoginRequestDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.LoginResponseDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.TokenRefreshRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthApiService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public AuthApiService(AuthenticationManager authenticationManager,
                          JwtService jwtService,
                          UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public LoginResponseDto login(LoginRequestDto request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails user = (UserDetails) auth.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new LoginResponseDto(accessToken, refreshToken);
    }

    public LoginResponseDto refreshToken(TokenRefreshRequestDto request) {
        String refreshToken = request.getRefreshToken();
        String username = jwtService.extractUsername(refreshToken);

        if (username != null && !jwtService.isTokenExpired(refreshToken)) {
            UserDetails user = userDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(refreshToken, user)) {
                String newAccessToken = jwtService.generateAccessToken(user);
                return new LoginResponseDto(newAccessToken, refreshToken);
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token de refresco inválido");
    }
}