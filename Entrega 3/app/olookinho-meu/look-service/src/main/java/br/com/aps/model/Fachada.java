package br.com.aps.model;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.aps.model.look.ControladorLook;
import br.com.aps.model.look.Look;


@Component
public class Fachada {

	@Autowired
	private ControladorLook controladorLook;
	
	public List<Look> consultarLooks() {
		return controladorLook.consultarLooks();
	}

	public Look consultarLookPeloId(Long id) {
		return controladorLook.consultarLookPeloId(id);
	}

	public void criarLook(String nome, Set<PecaDeRoupa> pecasDeRoupa) {
		controladorLook.addLook(nome, pecasDeRoupa);
	}

	public void deletarLook(Long id) {
		controladorLook.deletarLook(id);
	}

}
