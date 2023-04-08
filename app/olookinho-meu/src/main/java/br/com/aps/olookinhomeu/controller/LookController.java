package br.com.aps.olookinhomeu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aps.olookinhomeu.model.Fachada.Fachada;
import br.com.aps.olookinhomeu.model.Look.Look;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

@RequestMapping("/looks")
@Controller
public class LookController {
    @Autowired
    private Fachada fachada;

    @GetMapping("")
    public String consultarLooks(Model model){
        List<Look> looks = fachada.consultarLooks();
        model.addAttribute("looks", looks);
        return "TelaListarLooks";
    }

    @GetMapping("/new")
    public String showCadastrarLook(Model model){
        List<PecaDeRoupa> pecaDeRoupas = fachada.consultarPecasDeRoupa();
        model.addAttribute("look", new Look());
        model.addAttribute("pecasDeRoupa", pecaDeRoupas);
        return "TelaCadastroLook";
    }
}
