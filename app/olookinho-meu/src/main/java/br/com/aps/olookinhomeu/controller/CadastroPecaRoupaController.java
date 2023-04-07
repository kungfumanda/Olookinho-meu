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

@Controller
public class CadastroPecaRoupaController {

    @Autowired
    private Fachada fachada;

    @GetMapping("/form-new-peca-roupa")
    public String mostrarFormNovaLista() {
        return "nova_lista";
    }
    
//    @RequestMapping("/new-peca-roupa")
//    public String cadastrarPecaDeRoupa(@RequestParam("nome") String nome, @RequestParam("tipo") String tipo,
//        @RequestParam("imagem") MultipartFile imagem, Model model) throws IOException {

//        fachada.cadastrarPecaDeRoupa(nome, tipo, imagem.getBytes());
//        model.addAttribute("msg", "Peça de roupa cadastrada com sucesso!");

//        return "redirect:/";
//    }
}
