package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositorioPecaDeRoupa implements IRepositorioPecaDeRoupa {

  @Autowired
    private PecaDeRoupaDAO pecaDeRoupaDAO;

	@Override
	public void deletarPecaDeRoupa(Long id) {
		pecaDeRoupaDAO.deleteById(id);
		
	}

	@Override
	public void addPecaDeRoupa(PecaDeRoupa pecaDeRoupa) {
		this.pecaDeRoupaDAO.save(pecaDeRoupa);
		
	}

	@Override
	public List<PecaDeRoupa> consultarPecaDeRoupa() {
		return pecaDeRoupaDAO.findAll();
	}

	@Override
    public PecaDeRoupa consultarPecaDeRoupaPeloID(Long id) {
        Optional<PecaDeRoupa> pecaDeRoupaOptional = pecaDeRoupaDAO.findById(id);
        PecaDeRoupa pecaDeRoupa = null;
        if(pecaDeRoupaOptional.isPresent()){
            pecaDeRoupa = pecaDeRoupaOptional.get();
        } else {
            throw new RuntimeException("Nao existe peca de roupa  que corresponda ao id: "  + id);
        }
        return pecaDeRoupa;
    }

	
	
}