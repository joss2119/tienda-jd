package es.iesclaradelrey.da2d1a.tiendajd.common.services;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajd.common.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll(){
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id){
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
