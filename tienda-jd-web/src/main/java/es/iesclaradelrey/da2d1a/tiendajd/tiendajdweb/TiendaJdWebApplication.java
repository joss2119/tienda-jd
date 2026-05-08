package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "es.iesclaradelrey.da2d1a.tiendajd.common",
        "es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb",
        "es.iesclaradelrey.da2d1a.tiendajd.security" // <-- Añadimos el nuevo módulo
})
@EntityScan("es.iesclaradelrey.da2d1a.tiendajd.common.entities")
@EnableJpaRepositories("es.iesclaradelrey.da2d1a.tiendajd.common.repositories")
public class TiendaJdWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaJdWebApplication.class, args);
    }
}