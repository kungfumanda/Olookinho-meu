package br.com.aps.olookinhomeu.model.PecaDeRoupaSuperior;

import jakarta.persistence.*;

@Entity
@Table(name = "PecasDeRoupaSuperiores")
public class PecaDeRoupaSuperior {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Lob
    private byte[] imagem;

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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem){
        this.imagem = imagem;
    }
}
