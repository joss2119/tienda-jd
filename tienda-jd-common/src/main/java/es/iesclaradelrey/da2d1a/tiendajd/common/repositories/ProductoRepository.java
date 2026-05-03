package es.iesclaradelrey.da2d1a.tiendajd.common.repositories;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // ¡Dejamos esto vacío! JPA ya nos da el findAll, findById y save gratis.
    // Y eliminamos el findByCategoriaId para cumplir la regla de la Fase 7.
}