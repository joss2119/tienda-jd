package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "es.iesclaradelrey.da2d1a.tiendajd.common",
        "es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb"
})
public class TiendaJdWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaJdWebApplication.class, args);
    }

}
