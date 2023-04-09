package br.com.aps.olookinhomeu.model.Look;

import java.util.HashSet;
import java.util.Set;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;
import jakarta.persistence.*;

@Entity
@Table(name = "Looks")
public class Look {

    @Id
    @Column(name = "LookId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Look_PecaDeRoupa", joinColumns = { @JoinColumn(name = "LookId") }, inverseJoinColumns = {
            @JoinColumn(name = "PecaDeRoupaId") })
    private Set<PecaDeRoupa> pecasDeRoupa = new HashSet<>();

    public void removerPecasDeRoupa(PecaDeRoupa pecaDeRoupa){
        pecasDeRoupa.remove(pecaDeRoupa);
        pecaDeRoupa.getLooks().remove(this);
    }

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

    public Set<PecaDeRoupa> getPecasDeRoupa() {
        return pecasDeRoupa;
    }

    public void setPecasDeRoupa(Set<PecaDeRoupa> pecasDeRoupa) {
        this.pecasDeRoupa = pecasDeRoupa;
    }
    


    public LookMemento salvarMemento() {
        return new LookMemento(this.nome, this.pecasDeRoupa);
    }

    public void restaurarMemento(LookMemento memento) {
        this.nome = memento.getNome();
        this.pecasDeRoupa = memento.getPecasDeRoupa();
    }

}
