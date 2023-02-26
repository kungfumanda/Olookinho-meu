package br.com.aps.olookinhomeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.aps.olookinhomeu.model.Fachada.Fachada;

@Controller
public class LookController{

     @Autowired
    private Fachada fachada;

     @GetMapping("/look")
    public String getLooks(Model model) {
        model.addAttribute("look", fachada.listarLooks());
        return "look";
    }

    @GetMapping("/cliente/inserir/")
    public String novoCliente(@RequestParam(name = "nome") String nome){
        Conta conta = new Conta(idCounter.get(), String.valueOf(idCounter.get()));
        fachada.inserirConta(conta);
        Cliente cliente = new Cliente(idCounter.getAndIncrement(), nome, conta);
        fachada.inserirCliente(cliente);
        return "redirect:/cliente";
    }

}
