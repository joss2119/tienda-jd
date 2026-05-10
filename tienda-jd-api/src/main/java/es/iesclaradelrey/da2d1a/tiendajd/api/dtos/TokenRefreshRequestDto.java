package es.iesclaradelrey.da2d1a.tiendajd.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRefreshRequestDto {
    private String refreshToken;
}