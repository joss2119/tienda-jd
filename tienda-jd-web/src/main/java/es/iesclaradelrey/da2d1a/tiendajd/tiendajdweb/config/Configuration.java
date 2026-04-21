package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.config;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.CategoriaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Configuration implements CommandLineRunner {

    private final CategoriaService categoriaService;

    Configuration (CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoriaService.save(new Categoria(1L,"Vinilos", "Diferentes generos", 15374, null));
        categoriaService.save(new Categoria(2L,"Mantenimiento de Discos", "Limpieza y cuidado", 12, null));
        categoriaService.save(new Categoria(3L,"Productos Personalizadfos", "Personaliza tus vinilos con la imagen favorita que quieras", 1, null));
        categoriaService.save(new Categoria(4L,"Reproductores", "escucha tu musica  con los reproductores de vinilo", 1, null));
    }
}
