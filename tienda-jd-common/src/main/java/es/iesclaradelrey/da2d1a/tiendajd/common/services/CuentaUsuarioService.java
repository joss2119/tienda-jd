package es.iesclaradelrey.da2d1a.tiendajd.common.services;

import es.iesclaradelrey.da2d1a.tiendajd.common.dtos.RegistroUsuarioDto;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.CuentaUsuario;

public interface CuentaUsuarioService {
    CuentaUsuario registrarNuevoUsuario(RegistroUsuarioDto registroDto);
}