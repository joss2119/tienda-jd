package es.iesclaradelrey.da2d1a.tiendajd.common.services;

import es.iesclaradelrey.da2d1a.tiendajd.common.dtos.RegistroUsuarioDto;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.CuentaUsuario;
import java.util.Optional;

public interface CuentaUsuarioService {
    CuentaUsuario registrarNuevoUsuario(RegistroUsuarioDto registroDto);

    Optional<CuentaUsuario> findByUsername(String username);
    Optional<CuentaUsuario> findById(Long id);
}