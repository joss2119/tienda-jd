package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public String listar(Model model){
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "categorias";
    }

    @GetMapping("/{id}")
    public String categoria(Model model, @PathVariable Long id){
        Categoria categoria = categoriaService.findById(id).orElse(null);

        if (categoria != null) {
            model.addAttribute("categoriaDetallada", categoria);

            List<Producto> productosOrdenados = categoria.getProductos().stream()
                    .sorted(Comparator.comparing(Producto::getNombre))
                    .collect(Collectors.toList());

            model.addAttribute("listaProductos", productosOrdenados);
        } else {
            return "redirect:/categorias";
        }

        return "detalle";
    }
}