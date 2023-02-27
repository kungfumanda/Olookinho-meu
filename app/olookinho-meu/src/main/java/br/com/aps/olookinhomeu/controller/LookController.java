package br.com.aps.olookinhomeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


import br.com.aps.olookinhomeu.dto.LookDTO;
import br.com.aps.olookinhomeu.model.Fachada.Fachada;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

@Controller
@RequestMapping("/looks")
public class LookController{

    @Autowired
    private Fachada fachada;

    @GetMapping("")
    public ModelAndView getLooks(Model model) {
        ModelAndView mv = new ModelAndView("TelaListarLooks");
        mv.addObject("looks", fachada.listarLooks());
        return mv; 
    }

    @GetMapping("/new")
    public String getFormLooks(Model model) {
        return "TelaCriarLook";
    }

    @PostMapping("")
    public String criarLook(LookDTO lookDTO) {
            ArrayList<PecaDeRoupa> pecasDeRoupa = new ArrayList<>();

            for (Long idPecaDeRoupa : lookDTO.getIdsPecasDeRoupa()) {
                PecaDeRoupa pecaDeRoupa = fachada.consultarPecaDeRoupaPeloId(idPecaDeRoupa);
                if (pecaDeRoupa != null) {
                    pecasDeRoupa.add(pecaDeRoupa);
                }
            }
            fachada.criarLook(lookDTO.getNome(), pecasDeRoupa);

            return "redirect:/looks";
    }

    @DeleteMapping("/{id}")
    public String deletarLook(@PathVariable("id") Long id) {
        fachada.deletarLook(id);
        return "redirect:/looks"; }

// Falta ajeitar o editar
    @GetMapping("/{id}/edit")
    public ModelAndView editarLookForm(@PathVariable("id") Long id, LookDTO lookDTO) {
    
        List<PecaDeRoupa> pecasDeRoupa = new ArrayList<>();

        for (Long idPecaDeRoupa : lookDTO.getIdsPecasDeRoupa()) {
            PecaDeRoupa pecaDeRoupa = fachada.consultarPecaDeRoupaPeloId(idPecaDeRoupa);
            if (pecaDeRoupa != null) {
                pecasDeRoupa.add(pecaDeRoupa);
            }
        }
        //checar se passamos a peca ou o id pro html para editar
        ModelAndView mv = new ModelAndView("TelaEditarLooks");
        mv.addObject("pecasLook", pecasDeRoupa);
        
        return mv;
    }

    @PutMapping("/{id}")
    public String editarLook(@PathVariable("id") Long id, LookDTO lookDTO) {
           // A gente nao tem um getLookById namoral
            
            //fachada.editarLook(id, lookDTO.getNome(), pecasDeRoupa);
            
            return "redirect:/looks";
    }

} 



