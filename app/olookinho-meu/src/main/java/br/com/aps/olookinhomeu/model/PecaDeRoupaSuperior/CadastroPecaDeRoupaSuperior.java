package br.com.aps.olookinhomeu.model.PecaDeRoupaSuperior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class CadastroPecaDeRoupaSuperior{

    @Autowired
    private IRepositorioPecaDeRoupaSuperior repositorioPecaDeRoupaSuperior;

    public void addPecaDeRoupa(String nome, String tipo, String imagemPath) throws IOException{
        byte[] imagemData = Files.readAllBytes(Paths.get(imagemPath));
        PecaDeRoupaSuperior pecaDeRoupaSuperior = new PecaDeRoupaSuperior();

        pecaDeRoupaSuperior.setNome(nome);
        pecaDeRoupaSuperior.setImagem(imagemData);

        repositorioPecaDeRoupaSuperior.addPecaDeRoupaSuperior(pecaDeRoupaSuperior);
    }

    public void deletarPecaDeRoupa(long id){
        repositorioPecaDeRoupaSuperior.deletarPecaDeRoupaSuperior(id);
    }

    public List<PecaDeRoupaSuperior> consultarPecasDeRoupa(){
        return repositorioPecaDeRoupaSuperior.consultarPecasDeRoupaSuperior();
    }
}