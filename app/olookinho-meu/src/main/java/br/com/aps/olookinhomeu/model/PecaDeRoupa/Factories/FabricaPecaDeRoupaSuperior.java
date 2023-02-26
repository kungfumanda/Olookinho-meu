package br.com.aps.olookinhomeu.model.PecaDeRoupa.Factories;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupaSuperior;

public class FabricaPecaDeRoupaSuperior implements AbstractFactory {
    public PecaDeRoupa createPecaDeRoupa() {
        return new PecaDeRoupaSuperior();
    }
}