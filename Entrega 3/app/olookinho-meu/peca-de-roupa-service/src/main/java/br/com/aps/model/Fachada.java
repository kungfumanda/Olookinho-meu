package br.com.aps.model;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.aps.model.pecaDeRoupa.ControladorPecaDeRoupa;
import br.com.aps.model.pecaDeRoupa.PecaDeRoupa;


@Component
public class Fachada {


	@Autowired
	private static ControladorPecaDeRoupa controladorPecaDeRoupa;


	public void cadastrarPecaDeRoupa(String nome, String tipo, MultipartFile imagemData) throws IOException {

		controladorPecaDeRoupa.cadastrarPecaDeRoupa(nome, tipo, imagemData);
	}

	public void deletarPecaDeRoupa(Long id) {
		controladorPecaDeRoupa.deletarPecaDeRoupa(id);
	}

	public static List<PecaDeRoupa> consultarPecasDeRoupa() {
		return controladorPecaDeRoupa.consultarPecasDeRoupa();
	}

	public PecaDeRoupa consultarPecaDeRoupaPeloId(Long id) {
		return controladorPecaDeRoupa.consultarPecaDeRoupaPeloId(id);
	}

	public List<PecaDeRoupa> consultarPecasDeRoupaPeloTipo(String tipo) {
		return controladorPecaDeRoupa.consultarPecasDeRoupaPeloTipo(tipo);
	}

	public void editarPecaDeRoupa(PecaDeRoupa pecaDeRoupa) throws Exception {
		controladorPecaDeRoupa.editarPecaDeRoupa(pecaDeRoupa);

	}

}
