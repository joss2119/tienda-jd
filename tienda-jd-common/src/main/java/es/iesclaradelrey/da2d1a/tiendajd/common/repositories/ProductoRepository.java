package es.iesclaradelrey.da2d1a.tiendajd.common.repositories;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import java.util.List;

public interface ProductoRepository {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);

    List<Producto> findByCategoriaId(Long categoriaId);
}