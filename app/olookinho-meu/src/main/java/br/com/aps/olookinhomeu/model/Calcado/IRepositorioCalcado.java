package br.com.aps.olookinhomeu.model.Calcado;

import java.util.List;

public interface IRepositorioCalcado {
   
    void deletarCalcado(long id);
    void addCalcado(Calcado calcado);
    List<Calcado> consultarCalcado();
    
}