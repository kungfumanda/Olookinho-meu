package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import java.util.List;

public interface IRepositorioPecaDeRoupa {
   
    void deletarPecaDeRoupa(long id);
    void addPecaDeRoupa(PecaDeRoupa pecaDeRoupa);
    List<PecaDeRoupa> consultarPecasDeRoupa();
    
}