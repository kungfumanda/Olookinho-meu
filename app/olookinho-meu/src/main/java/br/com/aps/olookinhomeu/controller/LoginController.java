package  br.com.aps.olookinhomeu.controller;

import  br.com.aps.olookinhomeu.model.Fachada.Fachada;
import  br.com.aps.olookinhomeu.model.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private Fachada fachada;

    @GetMapping("/requestLogin")
    public String requestLogin() {
        Boolean sucesso = fachada.loginUsuario();

        if(!sucesso) return "tela_login";
        return  "redirect:/TelaListarLooks";
    }
}
