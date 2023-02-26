package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.Factories.*;

@Component
public class CadastroPecaDeRoupa{

    AbstractFactory fabricaSuperior = new FabricaPecaDeRoupaSuperior();
    AbstractFactory fabricaInferior = new FabricaPecaDeRoupaInferior();
    AbstractFactory fabricaCalcado = new FabricaCalcado();

    @Autowired
    private IRepositorioPecaDeRoupa repositorioPecaDeRoupa;

    public void addPecaDeRoupa(String nome, String tipo, String imagemPath) throws IOException{
        PecaDeRoupa pecaDeRoupa = new PecaDeRoupa();
        
        byte[] imagemData = Files.readAllBytes(Paths.get(imagemPath));

        pecaDeRoupa.setNome(nome);
        switch (tipo) {
            case "Superior":
                PecaDeRoupa pecaSuperior = fabricaSuperior.createPecaDeRoupa();
            case "Inferior":
                PecaDeRoupa pecaInferior = fabricaInferior.createPecaDeRoupa();
            case "Calcado":
                PecaDeRoupa pecaCalcado = fabricaCalcado.createPecaDeRoupa();
            default:
                pecaDeRoupa.setTipo(tipo);
        }
        pecaDeRoupa.setImagem(imagemData);

        repositorioPecaDeRoupa.addPecaDeRoupa(pecaDeRoupa);
    }

    public void deletarPecaDeRoupa(Long id){
        repositorioPecaDeRoupa.deletarPecaDeRoupa(id);
    }

    public List<PecaDeRoupa> consultarPecaDeRoupa(){
        return repositorioPecaDeRoupa.consultarPecaDeRoupa();
    }

    public PecaDeRoupa consultarPecaDeRoupaPeloId(Long id) {
    return repositorioPecaDeRoupa.consultarPecaDeRoupaPeloID(id);
    }
}