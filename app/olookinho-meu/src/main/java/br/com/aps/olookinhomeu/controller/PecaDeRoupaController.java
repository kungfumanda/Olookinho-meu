package br.com.aps.olookinhomeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("/{id}/delete")
	public String deletarPecaDeRoupa(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		try {
			fachada.deletarPecaDeRoupa(id);
		} catch (Exception e) {
			if (fachada.consultarPecaDeRoupaPeloId(id) != null) {
				redirectAttributes.addAttribute("errorMsg",
						"Por favor, edite os looks associados a esta peça antes de deletá-la.");
				return "redirect:/pecas-de-roupa";
			}
		}
		redirectAttributes.addAttribute("sucMsg", "Peça deletada com sucesso.");
		return "redirect:/pecas-de-roupa";
	}

}
