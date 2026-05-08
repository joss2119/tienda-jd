package es.iesclaradelrey.da2d1a.tiendajd.security;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.CuentaUsuario;
import es.iesclaradelrey.da2d1a.tiendajd.common.repositories.CuentaUsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .collect(Collectors.toList());

        System.out.println("Cargando usuario: " + username + " con roles: " + authorities);

        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                authorities
        );
    }
}