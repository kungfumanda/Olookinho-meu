package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import jakarta.persistence.*;

@Entity
@Table(name = "PecasDeRoupa")
public abstract class PecaDeRoupa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem){
        this.imagem = imagem;
    }
}
