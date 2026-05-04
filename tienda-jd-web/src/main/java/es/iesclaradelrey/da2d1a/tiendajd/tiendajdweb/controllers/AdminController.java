package es.iesclaradelrey.da2d1a.tiendajd.tiendajdweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("/")
    public String indexConBarra() {
        return "redirect:/admin";
    }
}