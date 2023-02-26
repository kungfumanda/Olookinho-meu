package br.com.aps.olookinhomeu.model.Look;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Component
public class RepositorioLook implements IRepositorioLook {
    
    @Autowired
    private LookDAO lookDAO;

    @Override
    public void addLook(Look look) {
        this.lookDAO.save(look);
    }

    @Override
    public void atualizarLook(Look look) { // lembrar de ver bd
        this.lookDAO.save(look);
    }

    @Override
    public List<Look> consultarLooks() {
        return lookDAO.findAll();
    }

    @Override
    public Look consultarLookPeloId(Long id) {
        Optional<Look> lookOptional = lookDAO.findById(id);
        Look look = null;
        if(lookOptional.isPresent()){
            look = lookOptional.get();
        } else {
            throw new RuntimeException("Não existe look  que corresponda ao id: "  + id);
        }
        return look;
    }

    @Override
    public void deletarLook(Long id) {
        lookDAO.deleteById(id);
    }



}