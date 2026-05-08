package es.iesclaradelrey.da2d1a.tiendajd.security;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.CuentaUsuario;
import es.iesclaradelrey.da2d1a.tiendajd.common.repositories.CuentaUsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CuentaUsuarioRepository cuentaUsuarioRepository;

    public UserDetailsServiceImpl(CuentaUsuarioRepository cuentaUsuarioRepository) {
        this.cuentaUsuarioRepository = cuentaUsuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CuentaUsuario usuario = cuentaUsuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new UsuarioDetailsImpl(usuario);
    }
}