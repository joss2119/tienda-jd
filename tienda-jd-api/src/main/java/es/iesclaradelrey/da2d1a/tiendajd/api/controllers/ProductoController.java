package es.iesclaradelrey.da2d1a.tiendajd.api.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.api.dtos.ProductoDto;
import es.iesclaradelrey.da2d1a.tiendajd.api.mappers.ProductoMapper;
import es.iesclaradelrey.da2d1a.tiendajd.api.services.ProductoApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductoController {

    private final ProductoApiService productoService;
    private final ProductoMapper productoMapper;

    public ProductoController(ProductoApiService productoService, ProductoMapper productoMapper) {
        this.productoService = productoService;
        this.productoMapper = productoMapper;
    }

    @GetMapping
    public List<ProductoDto> getAllProducts() {
        return productoMapper.toDtoList(productoService.findAllSortedByName());
    }
}