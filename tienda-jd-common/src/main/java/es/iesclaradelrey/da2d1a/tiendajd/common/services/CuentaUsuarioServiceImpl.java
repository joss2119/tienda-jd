package es.iesclaradelrey.da2d1a.tiendajd.common.services;

import es.iesclaradelrey.da2d1a.tiendajd.common.dtos.RegistroUsuarioDto;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.CuentaUsuario;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Rol;
import es.iesclaradelrey.da2d1a.tiendajd.common.repositories.CuentaUsuarioRepository;
import es.iesclaradelrey.da2d1a.tiendajd.common.repositories.RolRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CuentaUsuarioServiceImpl implements CuentaUsuarioService {

    private final CuentaUsuarioRepository cuentaUsuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public CuentaUsuarioServiceImpl(CuentaUsuarioRepository cuentaUsuarioRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.cuentaUsuarioRepository = cuentaUsuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CuentaUsuario registrarNuevoUsuario(RegistroUsuarioDto dto) {
        if (!dto.isAceptaCondiciones()) {
            throw new IllegalArgumentException("Debe aceptar los términos y condiciones.");
        }

        CuentaUsuario nuevoUsuario = new CuentaUsuario();
        nuevoUsuario.setUsername(dto.getUsername());
        nuevoUsuario.setNombre(dto.getNombre());
        nuevoUsuario.setEmail(dto.getEmail());
        nuevoUsuario.setTelefono(dto.getTelefono());
        nuevoUsuario.setFechaNacimiento(dto.getFechaNacimiento());
        nuevoUsuario.setPassword(passwordEncoder.encode(dto.getPassword()));

        // Asignar rol por defecto
        Rol rolUser = rolRepository.findByNombre("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado en base de datos."));
        nuevoUsuario.getRoles().add(rolUser);

        return cuentaUsuarioRepository.save(nuevoUsuario);
    }
}