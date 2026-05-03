package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajd.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.MarcaService;
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
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping("/{id}")
    public String detalleMarca(Model model, @PathVariable Long id) {
        Marca marca = marcaService.findById(id).orElse(null);

        if (marca != null) {
            model.addAttribute("marca", marca);

            List<Producto> productosOrdenados = marca.getProductos().stream()
                    .sorted(Comparator.comparing(Producto::getNombre))
                    .collect(Collectors.toList());

            model.addAttribute("listaProductos", productosOrdenados);
            return "detalleMarca";
        } else {
            return "redirect:/productos";
        }
    }
}