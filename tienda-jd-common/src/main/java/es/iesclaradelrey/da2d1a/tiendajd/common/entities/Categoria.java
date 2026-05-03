package es.iesclaradelrey.da2d1a.tiendajd.common.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

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

    // Relación ManyToMany: Una categoría puede tener varios productos
    @ManyToMany(mappedBy = "categorias")
    private List<Producto> productos = new ArrayList<>();

    public Categoria() {}
    public Categoria(Long id, String nombre, String descripcion, int minimo, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.minimo = minimo;
        this.imagen = imagen;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public int getMinimo() { return minimo; }
    public void setMinimo(int minimo) { this.minimo = minimo; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
}