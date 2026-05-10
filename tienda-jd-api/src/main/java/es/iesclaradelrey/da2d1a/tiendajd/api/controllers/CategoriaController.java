package es.iesclaradelrey.da2d1a.tiendajd.api.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.CategoriaDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.ProductoDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.mappers.CategoriaMapper;
import es.iesclaradelrey.da2d1a.tiendajd.api.mappers.ProductoMapper;
import es.iesclaradelrey.da2d1a.tiendajd.api.services.CategoriaApiService;
import es.iesclaradelrey.da2d1a.tiendajd.api.services.ProductoApiService;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api/v1/categories")
public class CategoriaController {

    private final CategoriaApiService categoriaService;
    private final CategoriaMapper categoriaMapper;
    private final ProductoApiService productoService;
    private final ProductoMapper productoMapper;

    public CategoriaController(CategoriaApiService categoriaService,
                               CategoriaMapper categoriaMapper,
                               ProductoApiService productoService,
                               ProductoMapper productoMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
        this.productoService = productoService;
        this.productoMapper = productoMapper;
    }

    @GetMapping
    public List<CategoriaDto> getAllCategories() {
        return categoriaMapper.toDtoList(categoriaService.findAllSortedByName());
    }

    @GetMapping("/{categoryId}/products")
    public List<ProductoDto> getProductsByCategory(@PathVariable("categoryId") Long categoryId) {
        List<Producto> productos = productoService.findByCategoria(categoryId);
        return productoMapper.toDtoList(productos);
    }
}