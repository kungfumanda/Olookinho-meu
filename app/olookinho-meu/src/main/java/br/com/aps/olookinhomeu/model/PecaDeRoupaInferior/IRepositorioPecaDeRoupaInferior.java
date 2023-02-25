package br.com.aps.olookinhomeu.model.PecaDeRoupaInferior;

import java.util.List;

public interface IRepositorioPecaDeRoupaInferior {
   
    void deletarPecaDeRoupaInferior(long id);
    void addPecaDeRoupaInferior(PecaDeRoupaInferior pecaDeRoupaInferior);
    List<PecaDeRoupaInferior> consultarPecasDeRoupaInferior();
    
}