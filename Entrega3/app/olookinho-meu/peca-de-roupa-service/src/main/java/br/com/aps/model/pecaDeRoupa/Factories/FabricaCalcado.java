package br.com.aps.model.pecaDeRoupa.Factories;

import br.com.aps.model.pecaDeRoupa.Calcado;
import br.com.aps.model.pecaDeRoupa.PecaDeRoupa;

public class FabricaCalcado implements Factory {
    public PecaDeRoupa createPecaDeRoupa() {
        return new Calcado();
    }
}