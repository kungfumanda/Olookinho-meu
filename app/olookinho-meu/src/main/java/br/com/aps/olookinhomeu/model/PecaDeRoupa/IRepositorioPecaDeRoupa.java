package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import java.util.List;

public interface IRepositorioPecaDeRoupa {
   
    void deletarPecaDeRoupa(Long id);
    void addPecaDeRoupa(PecaDeRoupa pecaDeRoupa);
    List<PecaDeRoupa> consultarPecaDeRoupa();
    PecaDeRoupa consultarPecaDeRoupaPeloID(Long id);
    
}