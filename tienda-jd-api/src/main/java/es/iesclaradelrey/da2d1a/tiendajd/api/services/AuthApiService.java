package es.iesclaradelrey.da2d1a.tiendajd.api.services;

import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.LoginRequestDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.LoginResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthApiService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthApiService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
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
}