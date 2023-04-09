package br.com.aps.olookinhomeu.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.aps.olookinhomeu.model.Fachada.Fachada;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

@RequestMapping("/pecas-de-roupa")
@Controller
public class CadastroPecaDeRoupaController {
    @Autowired
    private Fachada fachada;

    @GetMapping("/new")
    public String showCadastrarPecaDeRoupa(Model model) {
        model.addAttribute("pecaDeRoupa", new PecaDeRoupa());
        return "TelaCadastroPecaDeRoupa";
    }

    @PostMapping("/new")
    public String cadastrarPecaDeRoupa(@RequestParam("nome") String nome, @RequestParam("tipo") String tipo,
            @RequestParam("imagem") MultipartFile imagem, Model model) throws IOException {

        try {
            fachada.cadastrarPecaDeRoupa(nome, tipo, imagem);
        } catch (Exception e) {
            model.addAttribute("errorMsg",
                    "Erro ao cadastrar a peça de roupa. Verifique o tamanho da imagem e tente novamente.");
            return "TelaCadastroPecaDeRoupa";
        }

        model.addAttribute("msg", "Peça de roupa cadastrada com sucesso!");

        return "redirect:/pecas-de-roupa";
    }
}
