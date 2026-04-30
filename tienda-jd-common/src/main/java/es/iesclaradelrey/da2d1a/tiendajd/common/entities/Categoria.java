package es.iesclaradelrey.da2d1a.tiendajd.common.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(length = 2000)
    private String descripcion;

    private int minimo;

    @Column(length = 500)
    private String imagen;

    // Constructores
    public Categoria() {}
    public Categoria(Long id, String nombre, String descripcion, int minimo, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.minimo = minimo;
        this.imagen = imagen;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMinimo() {
        return minimo;
    }
    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
