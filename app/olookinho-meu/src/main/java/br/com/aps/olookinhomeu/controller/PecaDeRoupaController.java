package br.com.aps.olookinhomeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import br.com.aps.olookinhomeu.model.Fachada.Fachada;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

@RequestMapping("/pecas-de-roupa")
@Controller
public class PecaDeRoupaController{

    @Autowired
    private Fachada fachada;

	@GetMapping("")
	public String consultarPecasDeRoupa(Model model) {
		List<PecaDeRoupa> pecasDeRoupa = fachada.consultarPecasDeRoupa();
		model.addAttribute("pecasDeRoupa", pecasDeRoupa);

		return "TelaListarPecasDeRoupa";
	}

    @GetMapping("/{id}")
	public String consultarPecaDeRoupaPeloId(@RequestParam("id") Long id, Model model) {
		PecaDeRoupa peca = fachada.consultarPecaDeRoupaPeloId(id);
		if (peca != null) {
			model.addAttribute("peca", peca);
		} else {
			model.addAttribute("msg", "Peça de roupa não encontrada!");
		}
		return "consultarPecaDeRoupaPeloId";
	}

    @GetMapping("/new")
	public String cadastrarPecaDeRoupa() {
		return "TelaCadastrarPecaDeRoupa";
	}

	@PostMapping("")
	public String cadastrarPecaDeRoupa(@RequestParam("nome") String nome, @RequestParam("tipo") String tipo,
		@RequestParam("imagem") MultipartFile imagem, Model model) throws IOException {

		fachada.cadastrarPecaDeRoupa(nome, tipo, imagem.getBytes());
		model.addAttribute("msg", "Peça de roupa cadastrada com sucesso!");

		return "TelaListarPecasDeRoupa";
	}

    @DeleteMapping("/{id}")
    public String deletarLook(@PathVariable("id") Long id) {
        fachada.deletarLook(id);
        return "TelaListarPecasDeRoupa"; }

}
