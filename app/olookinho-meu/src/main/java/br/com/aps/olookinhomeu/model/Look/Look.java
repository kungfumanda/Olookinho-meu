package br.com.aps.olookinhomeu.model.Look;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

import java.util.List;
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

    @Column(name = "pecas")
    private List<PecaDeRoupa> pecasDeRoupas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public List<PecaDeRoupa> getPecasDeRoupa(){
        return pecasDeRoupas;
    }

    public void setPecasDeRoupa(List<PecaDeRoupa> pecasDeRoupas){
        this.pecasDeRoupas = pecasDeRoupas;
    }
}
