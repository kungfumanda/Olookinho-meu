package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import java.util.List;

public interface IRepositorioPecaDeRoupa {
   
    void deletarPecaDeRoupa(Long id);
    void addPecaDeRoupa(PecaDeRoupa pecaDeRoupa);
    List<PecaDeRoupa> consultarPecasDeRoupa();
    PecaDeRoupa consultarPecaDeRoupaPeloID(Long id);
    void salvarPecaDeRoupa(PecaDeRoupa pecaDeRoupa);
    List<PecaDeRoupa> consultarPecasDeRoupaPeloTipo(String tipo);
}