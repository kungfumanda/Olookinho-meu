package br.com.aps.olookinhomeu.model.PecaDeRoupaInferior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class CadastroPecaDeRoupaInferior{

    @Autowired
    private IRepositorioPecaDeRoupaInferior repositorioPecaDeRoupaInferior;

    public void addPecaDeRoupaInferior(String nome, String tipo, String imagemPath) throws IOException{
        byte[] imagemData = Files.readAllBytes(Paths.get(imagemPath));
        PecaDeRoupaInferior pecaDeRoupaInferior = new PecaDeRoupaInferior();

        pecaDeRoupaInferior.setNome(nome);
        pecaDeRoupaInferior.setTipo(tipo);
        pecaDeRoupaInferior.setImagem(imagemData);

        repositorioPecaDeRoupaInferior.addPecaDeRoupaInferior(pecaDeRoupaInferior);
    }

    public void deletarPecaDeRoupaInferior(long id){
        repositorioPecaDeRoupaInferior.deletarPecaDeRoupaInferior(id);
    }

    public List<PecaDeRoupaInferior> consultarPecasDeRoupaInferior(){
        return repositorioPecaDeRoupaInferior.consultarPecasDeRoupaInferior();
    }
}