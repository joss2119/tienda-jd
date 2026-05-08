package es.iesclaradelrey.da2d1a.tiendajd.common.repositories;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.CuentaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaUsuarioRepository extends JpaRepository<CuentaUsuario, Long> {
    Optional<CuentaUsuario> findByUsername(String username);
}