package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Listado de TODOS los productos
    @GetMapping({"", "/"})
    public String listarProductos(Model model) {
        model.addAttribute("listaProductos", productoService.findAll());
        return "productos";
    }

    // Detalle de un producto específico
    @GetMapping("/{id}/{nombreEscapado}")
    public String detalleProducto(Model model, @PathVariable Long id, @PathVariable String nombreEscapado) {
        Producto producto = productoService.findById(id).orElse(null);

        model.addAttribute("producto", producto);

        return "detalleProducto";
    }
}