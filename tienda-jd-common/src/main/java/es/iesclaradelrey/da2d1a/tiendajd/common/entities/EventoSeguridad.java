package es.iesclaradelrey.da2d1a.tiendajd.common.entities;

import es.iesclaradelrey.da2d1a.tiendajd.common.enums.TipoEvento;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eventos_seguridad")
public class EventoSeguridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false, length = 100)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoEvento tipoEvento;

    @PrePersist
    protected void onCreate() {
        this.fechaHora = LocalDateTime.now();
    }

    public EventoSeguridad() {}

    public EventoSeguridad(String username, TipoEvento tipoEvento) {
        this.username = username;
        this.tipoEvento = tipoEvento;
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public TipoEvento getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(TipoEvento tipoEvento) { this.tipoEvento = tipoEvento; }
}