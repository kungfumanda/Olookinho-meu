package br.com.aps.olookinhomeu.model.Fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aps.olookinhomeu.model.Controladores.ControladorLooks;
import br.com.aps.olookinhomeu.model.Controladores.ControladorPecasRoupa;

@Component
public class Fachada {
	
	@Autowired
	private ControladorPecasRoupa controladorPecasRoupa;
	@Autowired
	private ControladorLooks controladorLooks;

	public void loginUsusario() {
		
	}
	
	public void criarLook() {
		
	}
	
	public void editarLook() {
		
	}
	
	public void listarLooks() { //isso nao deveria ser void ne
		
	}
	
	public void deletarLook() {
		
	}
}
