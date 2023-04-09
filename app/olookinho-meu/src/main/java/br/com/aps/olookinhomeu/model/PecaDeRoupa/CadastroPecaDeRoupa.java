package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.*;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.Factories.*;

@Component
public class CadastroPecaDeRoupa{

    AbstractFactory fabricaSuperior = new FabricaPecaDeRoupaSuperior();
    AbstractFactory fabricaInferior = new FabricaPecaDeRoupaInferior();
    AbstractFactory fabricaCalcado = new FabricaCalcado();

    @Autowired
    private IRepositorioPecaDeRoupa repositorioPecaDeRoupa;

    public void addPecaDeRoupa(String nome, String tipo, MultipartFile imagem) throws IOException{
    
        PecaDeRoupa pecaDeRoupa = gerarPecadeRoupa(tipo);
        pecaDeRoupa.setNome(nome);
        if (imagem != null) {
        setImagem(pecaDeRoupa, imagem);
        }
        repositorioPecaDeRoupa.addPecaDeRoupa(pecaDeRoupa);
    }

    private void setImagem(PecaDeRoupa pecaDeRoupa, MultipartFile imagem) throws IOException {
        String fileName = StringUtils.cleanPath(imagem.getOriginalFilename());
        try {
            pecaDeRoupa.setNomeImagem(fileName);
            pecaDeRoupa.setImagem(imagem.getBytes());             
        } catch (IOException ex) {
            throw new IOException("Could not store file " + fileName);
        }
    }

    public void deletarPecaDeRoupa(Long id){
        repositorioPecaDeRoupa.deletarPecaDeRoupa(id);
    }

    public List<PecaDeRoupa> consultarPecasDeRoupa(){
        return repositorioPecaDeRoupa.consultarPecasDeRoupa();
    }

    public List<PecaDeRoupa> consultarPecasDeRoupaPeloTipo(String tipo){
        return repositorioPecaDeRoupa.consultarPecasDeRoupaPeloTipo(tipo);
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

    public void editarPecaDeRoupa(Long id, String nome, String tipo, MultipartFile imagemData) throws IOException {
        PecaDeRoupa pecaDeRoupa = consultarPecaDeRoupaPeloId(id);
        PecaDeRoupa editedPecaDeRoupa = null;
        if( tipo != pecaDeRoupa.getTipo()){
            editedPecaDeRoupa = gerarPecadeRoupa(tipo);
        }else{
            editedPecaDeRoupa = gerarPecadeRoupa(pecaDeRoupa.getTipo());
        }
        editedPecaDeRoupa.setNome(nome);
        if(imagemData != null){
            setImagem(editedPecaDeRoupa, imagemData);
        }
        
        repositorioPecaDeRoupa.salvarPecaDeRoupa(editedPecaDeRoupa);
    }
}