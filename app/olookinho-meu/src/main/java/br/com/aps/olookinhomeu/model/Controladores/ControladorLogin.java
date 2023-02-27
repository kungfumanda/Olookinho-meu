package br.com.aps.olookinhomeu.model.Controladores;

import org.springframework.stereotype.Component;

import br.com.aps.olookinhomeu.SubsistemaComunicacaoAPILogin.ISubsistemaComunicacaoAPILogin;
import br.com.aps.olookinhomeu.model.Usuario.CadastroUsuario;
import br.com.aps.olookinhomeu.model.Usuario.Usuario;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ControladorLogin {

    @Autowired
    private CadastroUsuario cadastroUsuario;

    @Autowired
    private ISubsistemaComunicacaoAPILogin subsistemaComunicacaoAPILogin;

    public Boolean requisitarLogin() {
        String email = subsistemaComunicacaoAPILogin.consultarEmail();
        if(email == null) {
			return null;
		}

        Usuario usuario = cadastroUsuario.consultarUsuarioPorEmail(email);
        Usuario.atual = usuario;
        return usuario != null;
    }
}