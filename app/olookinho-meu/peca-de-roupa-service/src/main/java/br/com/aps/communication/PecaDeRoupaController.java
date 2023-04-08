package br.com.aps.communication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.aps.model.Fachada;
import br.com.aps.model.pecaDeRoupa.PecaDeRoupa;
import br.com.aps.model.util.ImageUtil;

import java.util.List;



@RequestMapping("/pecas-de-roupa")
@Controller
public class PecaDeRoupaController {

	@Autowired
	private Fachada fachada;

	@GetMapping("")
	public String consultarPecasDeRoupa(Model model) {
		List<PecaDeRoupa> pecasDeRoupa = Fachada.consultarPecasDeRoupa();

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

}
