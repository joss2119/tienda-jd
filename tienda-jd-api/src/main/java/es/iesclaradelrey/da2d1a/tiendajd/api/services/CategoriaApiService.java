package es.iesclaradelrey.da2d1a.tiendajd.api.services;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajd.common.repositories.CategoriaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaApiService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaApiService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAllSortedByName() {
        // Usamos Sort de PagingAndSortingRepository (que JpaRepository hereda)
        return (List<Categoria>) categoriaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
    }
}