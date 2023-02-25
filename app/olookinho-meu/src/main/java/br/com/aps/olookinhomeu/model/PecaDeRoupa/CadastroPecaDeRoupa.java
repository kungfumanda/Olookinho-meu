package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class CadastroPecaDeRoupa{

    @Autowired
    private IRepositorioPecaDeRoupa repositorioPecaDeRoupa;

    public void addPecaDeRoupa(String nome, String tipo, String imagemPath) throws IOException{
        byte[] imagemData = Files.readAllBytes(Paths.get(imagemPath));
        PecaDeRoupa pecaDeRoupa = new PecaDeRoupa();

        pecaDeRoupa.setNome(nome);
        pecaDeRoupa.setTipo(tipo);
        pecaDeRoupa.setImagem(imagemData);

        repositorioPecaDeRoupa.addPecaDeRoupa(pecaDeRoupa);
    }

    public void deletarPecaDeRoupa(long id){
        repositorioPecaDeRoupa.deletarPecaDeRoupa(id);
    }

    public List<PecaDeRoupa> consultarPecasDeRoupa(){
        return repositorioPecaDeRoupa.consultarPecasDeRoupa();
    }
}