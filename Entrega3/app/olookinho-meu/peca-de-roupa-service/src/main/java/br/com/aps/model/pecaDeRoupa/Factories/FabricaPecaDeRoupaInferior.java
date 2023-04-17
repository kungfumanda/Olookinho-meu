package br.com.aps.model.pecaDeRoupa.Factories;

import br.com.aps.model.pecaDeRoupa.PecaDeRoupa;
import br.com.aps.model.pecaDeRoupa.PecaDeRoupaInferior;

public class FabricaPecaDeRoupaInferior implements Factory {
    public PecaDeRoupa createPecaDeRoupa() {
        return new PecaDeRoupaInferior();
    }
}