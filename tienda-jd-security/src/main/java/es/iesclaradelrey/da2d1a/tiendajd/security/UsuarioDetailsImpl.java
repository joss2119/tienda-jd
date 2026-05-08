package es.iesclaradelrey.da2d1a.tiendajd.security;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.CuentaUsuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioDetailsImpl implements UserDetails {

    private final CuentaUsuario cuentaUsuario;

    // Constructor que recibe nuestra entidad de base de datos
    public UsuarioDetailsImpl(CuentaUsuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // En la actividad 9 no hay roles aún, así que devolvemos una lista vacía.
        // Lo cambiaremos en la actividad 10 cuando añadamos roles.
        return List.of();
    }

    @Override
    public String getPassword() {
        return cuentaUsuario.getPassword();
    }

    @Override
    public String getUsername() {
        return cuentaUsuario.getUsername();
    }

    // Estos 4 métodos booleanos los ponemos a true para indicar que la cuenta es válida
    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    // Método extra para recuperar el usuario original si lo necesitamos
    public CuentaUsuario getCuentaUsuario() {
        return cuentaUsuario;
    }
}