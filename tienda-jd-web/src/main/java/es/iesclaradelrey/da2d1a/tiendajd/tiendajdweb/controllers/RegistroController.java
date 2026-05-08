package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import es.iesclaradelrey.da2d1a.tiendajd.common.dtos.RegistroUsuarioDto;
import es.iesclaradelrey.da2d1a.tiendajd.common.services.CuentaUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistroController {

    private final CuentaUsuarioService cuentaUsuarioService;

    public RegistroController(CuentaUsuarioService cuentaUsuarioService) {
        this.cuentaUsuarioService = cuentaUsuarioService;
    }

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("registroDto", new RegistroUsuarioDto());
        return "registro";
    }

    @PostMapping
    public String procesarRegistro(@ModelAttribute("registroDto") RegistroUsuarioDto registroDto, Model model) {
        try {
            cuentaUsuarioService.registrarNuevoUsuario(registroDto);
            return "redirect:/productos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }
}