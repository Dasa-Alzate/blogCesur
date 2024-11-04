package com.example.BlogCesur.controladores;

import com.example.BlogCesur.entidades.Noticia;
import com.example.BlogCesur.repositorios.RepositorioNoticias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class ControladorCRUD {
    @Autowired
    private RepositorioNoticias repositorioNoticias;
    @GetMapping("/crud/noticias")
    public String crudNoticias(Model model) {
        model.addAttribute("noticias", repositorioNoticias.findAll());
        return "listaNoticias";
    }

    @GetMapping("/crud/noticias/insertar")
    public String crudNoticiasInsertar(Model model) {
        Noticia noticia = new Noticia();
        noticia.setFecha(Date.valueOf(LocalDate.now()));
        model.addAttribute("noticia", noticia);
        return "formularioNoticias";
    }

    @PostMapping("/crud/noticias/insertar")
    public String recibeFormulario(@ModelAttribute Noticia noticia) {
        repositorioNoticias.save(noticia);
        return "redirect:/crud/noticias/insertar";
    }
}
