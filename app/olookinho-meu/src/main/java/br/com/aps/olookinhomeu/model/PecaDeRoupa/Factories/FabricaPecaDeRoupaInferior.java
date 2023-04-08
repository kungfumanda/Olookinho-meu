package br.com.aps.olookinhomeu.model.PecaDeRoupa.Factories;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupaInferior;

public class FabricaPecaDeRoupaInferior implements Factory {
    public PecaDeRoupa createPecaDeRoupa() {
        return new PecaDeRoupaInferior();
    }
}