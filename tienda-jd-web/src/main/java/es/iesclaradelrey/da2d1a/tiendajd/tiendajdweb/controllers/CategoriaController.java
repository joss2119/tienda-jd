package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.services.CategoriaService;
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
    public String categoria(
            Model model,
            @PathVariable Long id){
        model.addAttribute("categoriaDetallada", categoriaService.findById(id));
        return "detalle";
    }
}
