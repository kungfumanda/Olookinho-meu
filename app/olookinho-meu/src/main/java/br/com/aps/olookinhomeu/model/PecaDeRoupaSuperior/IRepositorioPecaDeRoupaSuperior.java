package br.com.aps.olookinhomeu.model.PecaDeRoupaSuperior;

import java.util.List;

public interface IRepositorioPecaDeRoupaSuperior {
   
    void deletarPecaDeRoupaSuperior(long id);
    void addPecaDeRoupaSuperior(PecaDeRoupaSuperior pecaDeRoupaSuperior);
    List<PecaDeRoupaSuperior> consultarPecasDeRoupaSuperior();
    
}