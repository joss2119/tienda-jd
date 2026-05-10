package es.iesclaradelrey.da2d1a.tiendajd.api.dtos;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class LoginResponseDto {
    private String accessToken;
    private String refreshToken;
}