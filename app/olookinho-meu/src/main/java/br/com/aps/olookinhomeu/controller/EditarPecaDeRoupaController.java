package br.com.aps.olookinhomeu.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.aps.olookinhomeu.model.Fachada.Fachada;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import br.com.aps.olookinhomeu.model.util.ImageUtil;

@RequestMapping("/pecas-de-roupa")
@Controller
public class EditarPecaDeRoupaController {

    @Autowired
    private Fachada fachada;

    @GetMapping("/{id}/edit")
    public String editarPecaDeRoupa(@PathVariable Long id, Model model) {

        try {
            PecaDeRoupa pecaDeRoupa = fachada.consultarPecaDeRoupaPeloId(id);

            model.addAttribute("pecaDeRoupa", pecaDeRoupa);
            model.addAttribute("imgUtil", new ImageUtil());
            return "TelaEditarPecaDeRoupa";

        } catch (Exception e) {
            model.addAttribute("errormsg", "Id de roupa invalido");
            return "redirect:/pecas-de-roupa";
        }
    }

    @PostMapping("/{id}/edit")
    public String editarPecaDeRoupa(@PathVariable Long id, @RequestParam("nome") String nome,
            @RequestParam("imagem") MultipartFile imagem, Model model) throws IOException {

        try {
            PecaDeRoupa pecaDeRoupa = fachada.consultarPecaDeRoupaPeloId(id);

            pecaDeRoupa.setNome(nome);

            if (imagem != null) {
                System.out.println("aaaaaaaaaaaa" + imagem.getContentType());
                ImageUtil imageUtil = new ImageUtil();
                imageUtil.setImagem(pecaDeRoupa, imagem);
            }

            fachada.editarPecaDeRoupa(pecaDeRoupa);
            return "redirect:/pecas-de-roupa";
        } catch (Exception e) {
            return "TelaEditarRoupa";
        }
    }
}
