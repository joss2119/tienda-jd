package es.iesclaradelrey.da2d1a.tiendajd.api.mappers;

import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.CategoriaDto;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaDto toDto(Categoria categoria);
    List<CategoriaDto> toDtoList(List<Categoria> categorias);
}