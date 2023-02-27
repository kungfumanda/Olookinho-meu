package br.com.aps.olookinhomeu.model.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import br.com.aps.olookinhomeu.model.Look.CadastroLook;
import br.com.aps.olookinhomeu.model.Look.Look;

@Component
public class ControladorLooks {

	@Autowired
	private CadastroLook cadastroLook;

	public void adicionarLook(String nome, List<PecaDeRoupa> pecasDeRoupa){
		cadastroLook.addLook(nome, pecasDeRoupa);
	}

	public void editarLook(Long idLook ,String nome,  List<PecaDeRoupa> pecasDeRoupa){
		cadastroLook.editarLook(idLook, nome, pecasDeRoupa);

	}

	public List<Look> listarLooks(){
		return cadastroLook.consultarLooks();

	}

	public void deletarLook(Long idLook){
		cadastroLook.deletarLook(idLook);
	}
	
}
