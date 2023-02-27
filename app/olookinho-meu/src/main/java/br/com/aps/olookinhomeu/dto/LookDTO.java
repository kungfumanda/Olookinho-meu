package br.com.aps.olookinhomeu.dto;
import java.util.List;

public class LookDTO {

    private String nome;
    private List<Long> idsPecasDeRoupa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getIdsPecasDeRoupa() {
        return idsPecasDeRoupa;
    }

    public void setIdsPecasDeRoupa(List<Long> idsPecasDeRoupa) {
        this.idsPecasDeRoupa = idsPecasDeRoupa;
    }

}