package es.iesclaradelrey.da2d1a.tiendajd.api.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class ProductoDto {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int descuento;
    private int stock;
    private String imagen;
    private MarcaDto marca;
    private List<CategoriaDto> categorias;
}