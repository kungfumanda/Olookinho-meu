package br.com.aps.olookinhomeu.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.aps.olookinhomeu.model.Fachada.Fachada;
import br.com.aps.olookinhomeu.model.Look.Look;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import br.com.aps.olookinhomeu.model.util.ImageUtil;

@RequestMapping("/looks")
@Controller
public class LookController {
    @Autowired
    private Fachada fachada;

    @GetMapping("")
    public String consultarLooks(Model model) {
        List<Look> looks = fachada.consultarLooks();
        model.addAttribute("looks", looks);
        return "TelaListarLooks";
    }

    @GetMapping("/new")
    public String showCadastrarLook(Model model) {
        List<PecaDeRoupa> pecasDeRoupaSup = fachada.consultarPecasDeRoupaPeloTipo("Superior");
        List<PecaDeRoupa> pecasDeRoupaInf = fachada.consultarPecasDeRoupaPeloTipo("Inferior");
        List<PecaDeRoupa> pecasDeRoupaCalc = fachada.consultarPecasDeRoupaPeloTipo("Calcado");

        model.addAttribute("look", new Look());
        model.addAttribute("imgUtil", new ImageUtil());

        model.addAttribute("pecasDeRoupaSup", pecasDeRoupaSup);
        model.addAttribute("pecasDeRoupaInf", pecasDeRoupaInf);
        model.addAttribute("pecasDeRoupaCalc", pecasDeRoupaCalc);

        return "TelaCadastroLook";
    }

    @PostMapping("/new")
    public String cadastrarLook(@RequestParam("nome") String nome, @RequestParam("pecaSup") Long sup_id,
            @RequestParam("pecaInf") Long inf_id, @RequestParam("pecaCalc") Long calc_id, Model model) {
        Set<PecaDeRoupa> selectedPecasDeRoupa = new HashSet<>();
        Long[] PecaDeRoupaIds = { sup_id, inf_id, calc_id };
        for (Long id : PecaDeRoupaIds) {
            PecaDeRoupa pecaDeRoupa = fachada.consultarPecaDeRoupaPeloId(id);
            selectedPecasDeRoupa.add(pecaDeRoupa);
        }
        fachada.criarLook(nome, selectedPecasDeRoupa);

        return "redirect:/looks";
    }

    @GetMapping("/{id}/delete")
	public String deletarPecaDeRoupa(@PathVariable Long id) {
		fachada.deletarLook(id);
		return "redirect:/looks";
	}

    @GetMapping("/{id}/view")
        public String verLook(@PathVariable Long id, Model model){
            model.addAttribute("imgUtil", new ImageUtil());
            model.addAttribute("pecasDeRoupa", fachada.getPecasDeRoupaByLook(id));
            model.addAttribute("look", fachada.consultarLookPeloId(id));
            return "TelaVerLook";
        }
    
}

