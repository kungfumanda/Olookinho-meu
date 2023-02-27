package  br.com.aps.olookinhomeu.SubsistemaComunicacaoAPILogin.Google;


import  br.com.aps.olookinhomeu.SubsistemaComunicacaoAPILogin.IUsuarioAPILogin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class UsuarioGoogle implements IUsuarioAPILogin, OAuth2User {

    private OAuth2User oauth2User;

    public UsuarioGoogle(OAuth2User oauth2User) {
        super();
        this.oauth2User = oauth2User;
    }

    @Override
    public String getNome() {
        return oauth2User.getAttribute("name");
    }
    @Override
    public String getEmail() {
        return oauth2User.getAttribute("email");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return getNome();
    }
}