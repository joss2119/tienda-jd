package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final ProductoService productoService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService, ProductoService productoService) {
        this.categoriaService = categoriaService;
        this.productoService = productoService;
    }

    @GetMapping()
    public String listar(Model model){
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "categorias";
    }

    @GetMapping("/{id}")
    public String categoria(Model model, @PathVariable Long id){
        model.addAttribute("categoriaDetallada", categoriaService.findById(id).orElse(null));

        model.addAttribute("listaProductos", productoService.findByCategoriaId(id));

        return "detalle";
    }
}