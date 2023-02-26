package br.com.aps.olookinhomeu.model.Look;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import jakarta.persistence.*;

@Entity
@Table(name = "Looks")
public class Look {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "peca_de_roupa_superior")
    private PecaDeRoupa pecaDeRoupaSuperior;
    @Column(name = "peca_de_roupa_inferior")
    private PecaDeRoupa pecaDeRoupaInferior;
    @Column(name = "calcado")
    private PecaDeRoupa calcado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PecaDeRoupa getPecaDeRoupaSuperior() {
        return pecaDeRoupaSuperior;
    }

    public void setPecaDeRoupaSuperior(PecaDeRoupa pecaDeRoupaSuperior) {
        this.pecaDeRoupaSuperior = pecaDeRoupaSuperior;
    }

    public PecaDeRoupa getPecaDeRoupaInferior() {
        return pecaDeRoupaInferior;
    }

    public void setPecaDeRoupaInferior(PecaDeRoupa pecaDeRoupaInferior) {
        this.pecaDeRoupaInferior = pecaDeRoupaInferior;
    }

    public PecaDeRoupa getCalcado() {
        return calcado;
    }

    public void setCalcado(PecaDeRoupa calcado) {
        this.calcado = calcado;
    }


    public LookMemento salvarMemento() {
        return new LookMemento(this.nome, this.pecaDeRoupaSuperior, this.pecaDeRoupaInferior, this.calcado);
    }

    public void restaurarMemento(LookMemento memento) {
        this.nome = memento.getNome();
        this.pecaDeRoupaSuperior = memento.getPecaDeRoupaSuperior();
        this.pecaDeRoupaInferior = memento.getPecaDeRoupaInferior();
        this.calcado = memento.getCalcado();
    }

}
