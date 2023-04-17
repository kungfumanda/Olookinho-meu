package br.com.aps.model.pecaDeRoupa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.aps.model.pecaDeRoupa.Factories.*;
import br.com.aps.model.util.ImageUtil;

import java.io.IOException;
import java.util.*;



@Component
public class CadastroPecaDeRoupa {

    Factory fabricaSuperior = new FabricaPecaDeRoupaSuperior();
    Factory fabricaInferior = new FabricaPecaDeRoupaInferior();
    Factory fabricaCalcado = new FabricaCalcado();

    ImageUtil imageUtil = new ImageUtil();

    @Autowired
    private IRepositorioPecaDeRoupa repositorioPecaDeRoupa;

    public void addPecaDeRoupa(String nome, String tipo, MultipartFile imagem) throws IOException {

        PecaDeRoupa pecaDeRoupa = gerarPecadeRoupa(tipo);
        pecaDeRoupa.setNome(nome);

        if (imagem != null) {
            pecaDeRoupa = imageUtil.setImagem(pecaDeRoupa, imagem);
        }

        repositorioPecaDeRoupa.addPecaDeRoupa(pecaDeRoupa);
    }

    public void deletarPecaDeRoupa(Long id) {
        repositorioPecaDeRoupa.deletarPecaDeRoupa(id);
    }

    public List<PecaDeRoupa> consultarPecasDeRoupa() {
        return repositorioPecaDeRoupa.consultarPecasDeRoupa();
    }

    public List<PecaDeRoupa> consultarPecasDeRoupaPeloTipo(String tipo) {
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

    public void editarPecaDeRoupa(PecaDeRoupa pecaDeRoupa) throws Exception {
        if (consultarPecaDeRoupaPeloId(pecaDeRoupa.getId()) == null) {
            throw new Exception("Nao existe roupa com o id informado");
        }

        repositorioPecaDeRoupa.salvarPecaDeRoupa(pecaDeRoupa);
    }
}