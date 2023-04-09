package br.com.aps.olookinhomeu.model.Look;

import org.springframework.stereotype.Component;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupaDAO;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class RepositorioLook implements IRepositorioLook {

    @Autowired
    private LookDAO lookDAO;

    @Autowired
    private PecaDeRoupaDAO pecaDeRoupaDAO;

    @Override
    public void addLook(Look look) {
        this.lookDAO.save(look);
    }

    @Override
    public void editarLook(Look look) { // lembrar de ver bd
        this.lookDAO.save(look);
    }

    @Override
    public List<Look> consultarLooks() {
        return lookDAO.findAll();
    }

    @Override
    public Look consultarLookPeloId(Long id) {
        Optional<Look> lookOptional = lookDAO.findById(id);
        Look look;
        if (lookOptional.isPresent()) {
            look = lookOptional.get();
        } else {
            throw new RuntimeException("Nao existe look  que corresponda ao id: " + id);
        }
        return look;
    }

    @Override
    public Look addPecaDeRoupa(Long id, PecaDeRoupa pecaDeRoupa) {
        Optional<Look> lookOptional = lookDAO.findById(id);
        Look look;

        if (lookOptional.isPresent()) {
            look = lookOptional.get();
            look.getPecasDeRoupa().add(pecaDeRoupa);
            return lookDAO.save(look);

        } else {
            throw new RuntimeException("Nao existe look  que corresponda ao id: " + id);
        }

    }

    @Override
    public void deletarLook(Long id) {
        Optional<Look> lookOptional = lookDAO.findById(id);
        Look look;
        if (lookOptional.isPresent()) {
            look = lookOptional.get();
           Set<PecaDeRoupa> pecaDeRoupas = look.getPecasDeRoupa();

           for(PecaDeRoupa pecaDeRoupa : pecaDeRoupas){
            pecaDeRoupa.getLooks().remove(look);
            pecaDeRoupaDAO.save(pecaDeRoupa);
           }
           lookDAO.delete(look);
        }
    }

    @Override
    public Set<PecaDeRoupa> getPecasDeRoupaByLook(Long id) {
        Optional<Look> lookOptional = lookDAO.findById(id);
        Set<PecaDeRoupa> pecasDoLook = null;
        Look look;
        if (lookOptional.isPresent()) {
            look = lookOptional.get();
            pecasDoLook = look.getPecasDeRoupa();
        }
        return pecasDoLook;
    }

}
