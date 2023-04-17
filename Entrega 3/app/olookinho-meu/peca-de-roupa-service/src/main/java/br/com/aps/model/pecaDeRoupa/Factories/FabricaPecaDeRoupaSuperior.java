package br.com.aps.model.pecaDeRoupa.Factories;

import br.com.aps.model.pecaDeRoupa.PecaDeRoupa;
import br.com.aps.model.pecaDeRoupa.PecaDeRoupaSuperior;

public class FabricaPecaDeRoupaSuperior implements Factory {
    public PecaDeRoupa createPecaDeRoupa() {
        return new PecaDeRoupaSuperior();
    }
}