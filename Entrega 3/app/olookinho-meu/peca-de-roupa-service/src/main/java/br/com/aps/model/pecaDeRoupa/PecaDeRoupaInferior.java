package br.com.aps.model.pecaDeRoupa;

import jakarta.persistence.Entity;

@Entity
public class PecaDeRoupaInferior extends PecaDeRoupa {
    {
        this.setTipo("Inferior");
    }
}