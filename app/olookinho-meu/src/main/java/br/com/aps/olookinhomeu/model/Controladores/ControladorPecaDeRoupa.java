package br.com.aps.olookinhomeu.model.Controladores;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.CadastroPecaDeRoupa;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

@Component
public class ControladorPecaDeRoupa {
	
	@Autowired
	private CadastroPecaDeRoupa cadastroPecaDeRoupa;
	
	public void deletarPecaDeRoupa(Long id) {
        cadastroPecaDeRoupa.deletarPecaDeRoupa(id);
    }

	public void cadastrarPecaDeRoupa(String nome, String tipo, MultipartFile imagem) throws IOException {
		cadastroPecaDeRoupa.addPecaDeRoupa(nome, tipo, imagem);
	}

	public List<PecaDeRoupa> consultarPecasDeRoupa() {
		return cadastroPecaDeRoupa.consultarPecasDeRoupa();
	}

	public PecaDeRoupa consultarPecaDeRoupaPeloId(Long id) {
    	return cadastroPecaDeRoupa.consultarPecaDeRoupaPeloId(id);
    }

	public void editarPecaDeRoupa(Long id, String nome, String tipo, MultipartFile imagem) throws IOException {
		cadastroPecaDeRoupa.editarPecaDeRoupa(id, nome, tipo, imagem);
	}

	public List<PecaDeRoupa> consultarPecasDeRoupaPeloTipo(String tipo){
		return cadastroPecaDeRoupa.consultarPecasDeRoupaPeloTipo(tipo);
	}

}
