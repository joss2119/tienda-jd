package es.iesclaradelrey.da2d1a.tiendajd.common.repositories;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private Map<Long, Producto> mapaProducto = new HashMap<>();

    @Override
    public List<Producto> findAll() {
        return new ArrayList<>(mapaProducto.values());
    }

    @Override
    public Producto findById(Long id) {
        return mapaProducto.get(id);
    }

    @Override
    public Producto save(Producto producto) {
        mapaProducto.put(producto.getId(), producto);
        return producto;
    }

    @Override
    public List<Producto> findByCategoriaId(Long categoriaId) {
        return mapaProducto.values().stream()
                .filter(p -> p.getCategoria() != null && p.getCategoria().getId().equals(categoriaId))
                .collect(Collectors.toList());
    }
}