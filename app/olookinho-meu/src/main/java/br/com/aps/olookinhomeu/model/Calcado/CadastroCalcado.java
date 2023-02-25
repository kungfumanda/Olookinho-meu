package br.com.aps.olookinhomeu.model.Calcado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class CadastroCalcado{

    @Autowired
    private IRepositorioCalcado repositorioCalcado;

    public void addPecaDeRoupa(String nome, String tipo, String imagemPath) throws IOException{
        byte[] imagemData = Files.readAllBytes(Paths.get(imagemPath));
        Calcado calcado = new Calcado();

        calcado.setNome(nome);
        calcado.setTipo(tipo);
        calcado.setImagem(imagemData);

        repositorioCalcado.addCalcado(calcado);
    }

    public void deletarPecaDeRoupa(long id){
        repositorioCalcado.deletarCalcado(id);
    }

    public List<Calcado> consultarPecasDeRoupa(){
        return repositorioCalcado.consultarCalcado();
    }
}