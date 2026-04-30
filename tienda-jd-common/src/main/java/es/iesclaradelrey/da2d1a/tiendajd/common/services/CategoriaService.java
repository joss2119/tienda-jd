package es.iesclaradelrey.da2d1a.tiendajd.common.services;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    public List<Categoria> findAll();
    public Optional<Categoria> findById(Long id);
    public Categoria save(Categoria categoria);
}
