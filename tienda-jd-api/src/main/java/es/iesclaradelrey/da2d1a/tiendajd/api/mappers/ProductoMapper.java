package es.iesclaradelrey.da2d1a.tiendajd.api.mappers;

import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.MarcaDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.ProductoDto;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface ProductoMapper {
    ProductoDto toDto(Producto producto);
    List<ProductoDto> toDtoList(List<Producto> productos);

    // Mapeo automático para la Marca
    MarcaDto toMarcaDto(Marca marca);
}