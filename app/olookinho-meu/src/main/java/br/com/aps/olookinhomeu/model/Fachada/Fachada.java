package br.com.aps.olookinhomeu.model.Fachada;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aps.olookinhomeu.model.Controladores.ControladorLogin;
import br.com.aps.olookinhomeu.model.Controladores.ControladorLooks;
import br.com.aps.olookinhomeu.model.Controladores.ControladorPecaDeRoupa;

import br.com.aps.olookinhomeu.model.Look.Look;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

@Component
public class Fachada {
	
	@Autowired
	private ControladorLogin controladorLogin;
	@Autowired
	private ControladorLooks controladorLook;
	@Autowired
	private ControladorPecaDeRoupa controladorPecaDeRoupa;
	
	public void loginUsuario() {
		//oq vamos colocar aqui?? nao tem classe de cadastrodelogin
	}
		
	public void criarLook(String nome, List<PecaDeRoupa> pecasDeRoupa) {
		 controladorLook.adicionarLook(nome, pecasDeRoupa);
	}
	
	public void editarLook() {
		//nao foi implementado ainda
	}
	
	public List<Look> listarLooks() { 
		return controladorLook.listarLooks();
	}
	
	public void deletarLook(Long id) {
		controladorLook.deletarLook(id);
	}

	public void cadastrarPecaDeRoupa(String nome, String tipo, String imagemPath) throws IOException {
				
		controladorPecaDeRoupa.cadastrarPecaDeRoupa(nome, tipo, imagemPath);
	}

	public void deletarPecaDeRoupa(Long id) {
        controladorPecaDeRoupa.deletarPecaDeRoupa(id);
    }

	public List<PecaDeRoupa> consultarPecasDeRoupa() {
		return controladorPecaDeRoupa.consultarPecasDeRoupa();
	}

	public PecaDeRoupa consultarPecaDeRoupaPeloId(Long id) {
    	return controladorPecaDeRoupa.consultarPecaDeRoupaPeloId(id);
    }



}
