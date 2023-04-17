package br.com.aps.model.look;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ControladorLook {
    @Autowired
    private CadastroLook cadastroLook;

    public void addLook(String nome, Set<PecaDeRoupa> pecasDeRoupa){
        cadastroLook.addLook(nome, pecasDeRoupa);
    }
    public void deletarLook(Long id) {
        cadastroLook.deletarLook(id);
    }

    public List<Look> consultarLooks() {
        return cadastroLook.consultarLooks();
    }

    public Look consultarLookPeloId(Long id) {
        return cadastroLook.consultarLookPeloId(id);
    }

    public Set<PecaDeRoupa> getPecasDeRoupaByLook(Long id){
        return cadastroLook.getPecasDeRoupaByLook(id);
    }
}
