package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/marcas")
public class MarcaAdminController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaAdminController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    // --- LISTADO ---
    @GetMapping
    public String listarMarcas(Model model) {
        model.addAttribute("listaMarcas", marcaService.findAll());
        return "admin/marcas";
    }

    @GetMapping("/")
    public String listarMarcasConBarra() {
        return "redirect:/admin/marcas";
    }

    // --- CREAR ---
    @GetMapping("/nueva")
    public String formularioNuevaMarca(Model model) {
        model.addAttribute("marca", new Marca());
        return "admin/marca-form";
    }

    @PostMapping("/nueva")
    public String guardarNuevaMarca(@ModelAttribute Marca marca) {
        try {
            marcaService.save(marca);
            return "redirect:/admin/marcas"; // Si va bien, vuelve al listado
        } catch (Exception e) {
            return "admin/marca-form"; // Si hay error, recarga el formulario[cite: 2]
        }
    }

    // --- EDITAR ---
    @GetMapping("/{id}/edit")
    public String formularioEditarMarca(@PathVariable Long id, Model model) {
        Marca marca = marcaService.findById(id).orElse(null);
        if (marca == null) {
            return "redirect:/admin/marcas";
        }
        model.addAttribute("marca", marca); // Va con los datos precargados[cite: 2]
        return "admin/marca-form";
    }

    @PostMapping("/{id}/edit")
    public String actualizarMarca(@PathVariable Long id, @ModelAttribute Marca marca) {
        try {
            marca.setId(id); // Aseguramos que actualiza y no crea uno nuevo
            marcaService.save(marca);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            return "admin/marca-form";
        }
    }

    // --- ELIMINAR ---
    @GetMapping("/{id}/delete")
    public String confirmacionBorrarMarca(@PathVariable Long id, Model model) {
        Marca marca = marcaService.findById(id).orElse(null);
        if (marca == null) {
            return "redirect:/admin/marcas";
        }
        model.addAttribute("marca", marca);
        return "admin/marca-delete";
    }

    @PostMapping("/{id}/delete")
    public String borrarMarca(@PathVariable Long id) {
        try {
            marcaService.deleteById(id);
            return "redirect:/admin/marcas";
        } catch (Exception e) {
            return "redirect:/admin/marcas"; // Aquí en el futuro se enviará el mensaje de error[cite: 2]
        }
    }
}