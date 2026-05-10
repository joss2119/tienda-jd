package es.iesclaradelrey.da2d1a.tiendajd.security.listeners;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.EventoSeguridad;
import es.iesclaradelrey.da2d1a.tiendajd.common.enums.TipoEvento;
import es.iesclaradelrey.da2d1a.tiendajd.common.repositories.EventoSeguridadRepository;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaSeguridadListener {

    private final EventoSeguridadRepository eventoRepository;

    public AuditoriaSeguridadListener(EventoSeguridadRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    // Escucha logins exitosos
    @EventListener
    public void onLoginSuccess(AuthenticationSuccessEvent event) {
        Object principal = event.getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            eventoRepository.save(new EventoSeguridad(username, TipoEvento.LOGIN_EXITO));
        }
    }

    // Escucha logins fallidos
    @EventListener
    public void onLoginFailure(AbstractAuthenticationFailureEvent event) {
        // En un fallo, el principal suele ser el String del username intentado
        String username = (String) event.getAuthentication().getPrincipal();
        eventoRepository.save(new EventoSeguridad(username, TipoEvento.LOGIN_ERROR));
    }

    // Escucha cierres de sesión
    @EventListener
    public void onLogoutSuccess(LogoutSuccessEvent event) {
        if (event.getAuthentication() != null) {
            Object principal = event.getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                eventoRepository.save(new EventoSeguridad(username, TipoEvento.LOGOUT));
            }
        }
    }
}