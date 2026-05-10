package es.iesclaradelrey.da2d1a.tiendajd.api.services;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajd.common.repositories.ProductoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoApiService {
    private final ProductoRepository productoRepository;

    public ProductoApiService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAllSortedByName() {
        return (List<Producto>) productoRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public List<Producto> findByCategoria(Long categoriaId) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nombre");
        return productoRepository.findByCategoriasId(categoriaId, sort);
    }
}