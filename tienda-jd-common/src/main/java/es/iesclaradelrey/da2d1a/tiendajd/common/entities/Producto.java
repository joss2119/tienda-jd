package es.iesclaradelrey.da2d1a.tiendajd.common.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 13, unique = true)
    private String codigo;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(length = 50)
    private String marca;

    @Column(nullable = false, length = 4000)
    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int descuento;

    private int stock;

    @Column(length = 500)
    private String imagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Constructores
    public Producto() {}
    public Producto(Categoria categoria, String imagen, int stock, int descuento, double precio, String descripcion, String marca, String nombre, String codigo, Long id) {
        this.categoria = categoria;
        this.imagen = imagen;
        this.stock = stock;
        this.descuento = descuento;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.nombre = nombre;
        this.codigo = codigo;
        this.id = id;
    }

    // Getters y Setters


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}