package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import jakarta.persistence.*;

@Entity
@Table(name = "PecasDeRoupa")
public class PecaDeRoupa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Lob
    @Column(name="imagem", length = 1000)
    private byte[] imagem;

    @Column(name = "nomeImagem")
    private String nomeImagem;

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

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String ni) {
        this.nomeImagem = ni;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem){
        this.imagem = imagem;
    }

}
