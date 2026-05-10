package es.iesclaradelrey.da2d1a.tiendajd.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "es.iesclaradelrey.da2d1a.tiendajd")
@EnableJpaRepositories(basePackages = "es.iesclaradelrey.da2d1a.tiendajd")
@EntityScan(basePackages = "es.iesclaradelrey.da2d1a.tiendajd")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}