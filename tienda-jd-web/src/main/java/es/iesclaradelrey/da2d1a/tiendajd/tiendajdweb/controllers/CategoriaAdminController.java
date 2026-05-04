package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/categorias")
public class CategoriaAdminController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaAdminController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "admin/categorias";
    }

    @GetMapping("/")
    public String listarCategoriasConBarra() {
        return "redirect:/admin/categorias";
    }

    @GetMapping("/nueva")
    public String formularioNuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/categoria-form";
    }

    @PostMapping("/nueva")
    public String guardarNuevaCategoria(@ModelAttribute Categoria categoria) {
        try {
            categoriaService.save(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            return "admin/categoria-form";
        }
    }

    @GetMapping("/{id}/edit")
    public String formularioEditarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id).orElse(null);
        if (categoria == null) {
            return "redirect:/admin/categorias";
        }
        model.addAttribute("categoria", categoria);
        return "admin/categoria-form";
    }

    @PostMapping("/{id}/edit")
    public String actualizarCategoria(@PathVariable Long id, @ModelAttribute Categoria categoria) {
        try {
            categoria.setId(id);
            categoriaService.save(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            return "admin/categoria-form";
        }
    }

    @GetMapping("/{id}/delete")
    public String confirmacionBorrarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.findById(id).orElse(null);
        if (categoria == null) {
            return "redirect:/admin/categorias";
        }
        model.addAttribute("categoria", categoria);
        return "admin/categoria-delete";
    }

    @PostMapping("/{id}/delete")
    public String borrarCategoria(@PathVariable Long id) {
        try {
            categoriaService.deleteById(id);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            return "redirect:/admin/categorias";
        }
    }
}