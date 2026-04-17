package es.iesclaradelrey.da2d1a.tiendajd.common.repositories;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private Map<Long, Categoria> mapaCategoria = new HashMap<>();

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) mapaCategoria.values();
    }

    @Override
    public Categoria findById(Long id) {
        return mapaCategoria.get(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        mapaCategoria.put(categoria.getId(), categoria);
    }
}
