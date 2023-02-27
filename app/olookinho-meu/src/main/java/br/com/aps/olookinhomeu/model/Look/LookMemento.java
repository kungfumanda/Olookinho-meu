package br.com.aps.olookinhomeu.model.Look;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

public class LookMemento{
    private String nome;
    private PecaDeRoupa pecaDeRoupaSuperior;
    private PecaDeRoupa pecaDeRoupaInferior;
    private PecaDeRoupa calcado;
    
    public LookMemento(String nome, PecaDeRoupa pecaDeRoupaSuperior, PecaDeRoupa pecaDeRoupaInferior, PecaDeRoupa calcado){
        this.nome = nome;
        this.pecaDeRoupaSuperior = pecaDeRoupaSuperior;
        this.pecaDeRoupaInferior = pecaDeRoupaInferior;
        this.calcado = calcado;
    }
    
    public String getNome() {
        return nome;
    }
    
    public PecaDeRoupa getPecaDeRoupaSuperior() {
        return pecaDeRoupaSuperior;
    }
    
    public PecaDeRoupa getPecaDeRoupaInferior() {
        return pecaDeRoupaInferior;
    }
    
    public PecaDeRoupa getCalcado() {
        return calcado;
    }
}
