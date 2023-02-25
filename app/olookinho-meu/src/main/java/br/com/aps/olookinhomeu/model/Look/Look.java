package br.com.aps.olookinhomeu.model.Look;

import java.util.List;

import br.com.aps.olookinhomeu.model.PecaDeRoupaSuperior.PecaDeRoupaSuperior;
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
    private List<PecaDeRoupaSuperior> pecasDeRoupas;

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

    public List<PecaDeRoupaSuperior> getPecasDeRoupa(){
        return pecasDeRoupas;
    }

    public void setPecasDeRoupa(List<PecaDeRoupaSuperior> pecasDeRoupas){
        this.pecasDeRoupas = pecasDeRoupas;
    }
}
