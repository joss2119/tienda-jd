package es.iesclaradelrey.da2d1a.tiendajd.api.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.LoginRequestDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.LoginResponseDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.TokenRefreshRequestDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.services.AuthApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthApiService authService;

    public AuthController(AuthApiService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh")
    public LoginResponseDto refresh(@RequestBody TokenRefreshRequestDto refreshRequest) {
        return authService.refreshToken(refreshRequest);
    }
}