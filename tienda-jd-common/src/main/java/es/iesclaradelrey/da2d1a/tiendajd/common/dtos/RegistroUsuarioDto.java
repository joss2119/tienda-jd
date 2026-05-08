package es.iesclaradelrey.da2d1a.tiendajd.common.dtos;

import java.time.LocalDate;

public class RegistroUsuarioDto {

    private String username;
    private String password;
    private String nombre;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private boolean aceptaCondiciones;

    // Constructor
    public RegistroUsuarioDto() {}

    // --- GETTERS Y SETTERS ---
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public boolean isAceptaCondiciones() { return aceptaCondiciones; }
    public void setAceptaCondiciones(boolean aceptaCondiciones) { this.aceptaCondiciones = aceptaCondiciones; }
}