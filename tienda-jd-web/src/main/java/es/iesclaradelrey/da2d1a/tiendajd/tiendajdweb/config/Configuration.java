package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.config;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Configuration implements CommandLineRunner {

    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    Configuration (CategoriaService categoriaService, ProductoService productoService) {
        this.categoriaService = categoriaService;
        this.productoService = productoService;
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = categoriaService.save(new Categoria(1L,"Vinilos", "Diferentes generos", 15374, null));
        Categoria cat2 = categoriaService.save(new Categoria(2L,"Mantenimiento de Discos", "Limpieza y cuidado", 12, null));
        Categoria cat3 = categoriaService.save(new Categoria(3L,"Productos Personalizados", "Personaliza tus vinilos", 1, null));
        Categoria cat4 = categoriaService.save(new Categoria(4L,"Reproductores", "Escucha tu musica", 1, null));

        productoService.save(new Producto(1L, "Daft Punk - Discovery", "Doble vinilo LP", 29.99, 10, null, cat1));
        productoService.save(new Producto(2L, "Pink Floyd - Dark Side", "Edición remasterizada", 35.50, 5, null, cat1));
        productoService.save(new Producto(3L, "Kit Limpieza Pro", "Cepillo y líquido antiestático", 18.90, 15, null, cat2));
        productoService.save(new Producto(4L, "Tocadiscos Audio-Technica", "Tracción directa", 250.00, 3, null, cat4));
    }
}