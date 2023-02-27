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

    public void addPecaDeRoupa(String nome, String tipo, byte[] imagemData) throws IOException{
    
        PecaDeRoupa pecaDeRoupa = gerarPecadeRoupa(tipo);
        
        pecaDeRoupa.setNome(nome);
        pecaDeRoupa.setImagem(imagemData);

        repositorioPecaDeRoupa.addPecaDeRoupa(pecaDeRoupa);
    }

    public void deletarPecaDeRoupa(Long id){
        repositorioPecaDeRoupa.deletarPecaDeRoupa(id);
    }

    public List<PecaDeRoupa> consultarPecasDeRoupa(){
        return repositorioPecaDeRoupa.consultarPecasDeRoupa();
    }

    public PecaDeRoupa consultarPecaDeRoupaPeloId(Long id) {
    return repositorioPecaDeRoupa.consultarPecaDeRoupaPeloID(id);
    }

    private PecaDeRoupa gerarPecadeRoupa(String tipo) {
        PecaDeRoupa pecaDeRoupa = new PecaDeRoupa();

        switch (tipo) {
            case "Superior":
                pecaDeRoupa = fabricaSuperior.createPecaDeRoupa();
                 break;
            case "Inferior":
                pecaDeRoupa = fabricaInferior.createPecaDeRoupa();
                 break;
            case "Calcado":
                pecaDeRoupa = fabricaCalcado.createPecaDeRoupa();
                 break;
            default:
                break;
        }
        return pecaDeRoupa;
    }
}