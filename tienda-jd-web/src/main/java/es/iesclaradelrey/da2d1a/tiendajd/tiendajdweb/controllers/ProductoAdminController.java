package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.MarcaService;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/productos")
public class ProductoAdminController {

    private final ProductoService productoService;
    private final MarcaService marcaService;
    private final CategoriaService categoriaService;

    @Autowired
    public ProductoAdminController(ProductoService productoService, MarcaService marcaService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("listaProductos", productoService.findAll());
        return "admin/productos";
    }

    @GetMapping("/")
    public String listarProductosConBarra() {
        return "redirect:/admin/productos";
    }

    @GetMapping("/nueva")
    public String formularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaMarcas", marcaService.findAll());
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "admin/producto-form";
    }

    @PostMapping("/nueva")
    public String guardarNuevoProducto(@ModelAttribute Producto producto) {
        try {
            productoService.save(producto);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            return "redirect:/admin/productos/nueva";
        }
    }

    @GetMapping("/{id}/edit")
    public String formularioEditarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.findById(id).orElse(null);
        if (producto == null) {
            return "redirect:/admin/productos";
        }
        model.addAttribute("producto", producto);
        model.addAttribute("listaMarcas", marcaService.findAll());
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "admin/producto-form";
    }

    @PostMapping("/{id}/edit")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute Producto producto) {
        try {
            producto.setId(id);
            productoService.save(producto);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            return "redirect:/admin/productos/" + id + "/edit";
        }
    }

    @GetMapping("/{id}/delete")
    public String confirmacionBorrarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.findById(id).orElse(null);
        if (producto == null) {
            return "redirect:/admin/productos";
        }
        model.addAttribute("producto", producto);
        return "admin/producto-delete";
    }

    @PostMapping("/{id}/delete")
    public String borrarProducto(@PathVariable Long id) {
        try {
            productoService.deleteById(id);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            return "redirect:/admin/productos";
        }
    }
}