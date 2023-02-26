package br.com.aps.olookinhomeu.model.Controladores;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	public void cadastrarPecaDeRoupa(String nome, String tipo, String imagemPath) throws IOException {
		cadastroPecaDeRoupa.addPecaDeRoupa(nome, tipo, imagemPath);
	}

	public List<PecaDeRoupa> consultarPecasDeRoupa() {
		return cadastroPecaDeRoupa.consultarPecaDeRoupa();
	}

	public PecaDeRoupa consultarPecaDeRoupaPeloId(Long id) {
    	return cadastroPecaDeRoupa.consultarPecaDeRoupaPeloId(id);
    }

}
