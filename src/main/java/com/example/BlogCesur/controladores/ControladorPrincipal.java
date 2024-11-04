package com.example.BlogCesur.controladores;

import com.example.BlogCesur.repositorios.RepositorioNoticias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
    @Autowired
    private RepositorioNoticias repositorioNoticias;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("noticias", repositorioNoticias.findAll());
        return "index";
    }
}
