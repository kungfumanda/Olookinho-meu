package br.com.aps.olookinhomeu.model.Fachada;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.aps.olookinhomeu.model.Controladores.ControladorLogin;
import br.com.aps.olookinhomeu.model.Controladores.ControladorLook;
import br.com.aps.olookinhomeu.model.Controladores.ControladorPecaDeRoupa;
import br.com.aps.olookinhomeu.model.Look.Look;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

@Component
public class Fachada {
	
	@Autowired
	private ControladorLogin controladorLogin;

	@Autowired
	private ControladorPecaDeRoupa controladorPecaDeRoupa;
	
	@Autowired
	private ControladorLook controladorLook;
	
	public Boolean loginUsuario() {
        return controladorLogin.requisitarLogin();
    }	

	public void cadastrarPecaDeRoupa(String nome, String tipo, MultipartFile imagemData) throws IOException {
				
		controladorPecaDeRoupa.cadastrarPecaDeRoupa(nome, tipo, imagemData);
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

	 public void editarPecaDeRoupa(Long id, String nome, String tipo, MultipartFile imagemData)  throws IOException{
	 	controladorPecaDeRoupa.editarPecaDeRoupa(id, nome, tipo, imagemData);
	}

	public List<Look> consultarLooks(){
		return controladorLook.consultarLooks();
	}




}
