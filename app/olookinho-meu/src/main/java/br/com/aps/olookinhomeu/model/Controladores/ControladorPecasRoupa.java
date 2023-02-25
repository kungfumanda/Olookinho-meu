package br.com.aps.olookinhomeu.model.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.aps.olookinhomeu.model.Fachada.Fachada;

@Controller
public class ControladorPecasRoupa {
	
	@Autowired
	private Fachada fachada;
	
	@GetMapping("/PecasDeRoupa")
	public String index() {
		return "PecasDeRoupa/index";
	}
}
