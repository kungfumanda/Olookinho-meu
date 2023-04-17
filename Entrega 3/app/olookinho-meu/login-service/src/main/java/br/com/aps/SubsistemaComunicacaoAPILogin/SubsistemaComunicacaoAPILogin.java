package br.com.aps.olookinhomeu.SubsistemaComunicacaoAPILogin;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;

public abstract class SubsistemaComunicacaoAPILogin extends DefaultOAuth2UserService implements ISubsistemaComunicacaoAPILogin  {
    public abstract IUsuarioAPILogin cadastrarUsuario();
    public abstract String consultarEmail();
}