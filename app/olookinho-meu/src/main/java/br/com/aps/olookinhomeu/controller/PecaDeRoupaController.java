package br.com.aps.olookinhomeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import br.com.aps.olookinhomeu.model.Fachada.Fachada;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import br.com.aps.olookinhomeu.model.util.ImageUtil;

@RequestMapping("/pecas-de-roupa")
@Controller
public class PecaDeRoupaController {

	@Autowired
	private Fachada fachada;

	@GetMapping("")
	public String consultarPecasDeRoupa(Model model) {
		List<PecaDeRoupa> pecasDeRoupa = fachada.consultarPecasDeRoupa();

		model.addAttribute("pecasDeRoupa", pecasDeRoupa);
		model.addAttribute("imgUtil", new ImageUtil());

		return "TelaListarPecaRoupa";
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

	@GetMapping("/{id}/delete")
	public String deletarPecaDeRoupa(@PathVariable Long id) {
		fachada.deletarPecaDeRoupa(id);
		return "redirect:/pecas-de-roupa";
	}

	@GetMapping("/{id}/edit")
	public String editarPecaDeRoupa(@PathVariable Long id, Model model) {
		model.addAttribute("pecaDeRoupa", fachada.consultarPecaDeRoupaPeloId(id));
		return "TelaEditarRoupa";
	}

	@PutMapping("/{id}/edit")
	public String editarPecaDeRoupa(@PathVariable Long id, @RequestParam("nome") String nome,
			@RequestParam("tipo") String tipo,
			@RequestParam("imagem") MultipartFile imagem, Model model) throws IOException {
		model.addAttribute("pecaDeRoupa", fachada.consultarPecaDeRoupaPeloId(id));
		fachada.editarPecaDeRoupa(id, nome, tipo, imagem);
		return "redirect:/pecas-de-roupa";
	}

}
