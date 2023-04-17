package br.com.aps.model.pecaDeRoupa;

import java.util.List;

public interface IRepositorioPecaDeRoupa {
   
    void deletarPecaDeRoupa(Long id);
    void addPecaDeRoupa(PecaDeRoupa pecaDeRoupa);
    List<PecaDeRoupa> consultarPecasDeRoupa();
    PecaDeRoupa consultarPecaDeRoupaPeloID(Long id);
    void salvarPecaDeRoupa(PecaDeRoupa pecaDeRoupa);
    List<PecaDeRoupa> consultarPecasDeRoupaPeloTipo(String tipo);
}