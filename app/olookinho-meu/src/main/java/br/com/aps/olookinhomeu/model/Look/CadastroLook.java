package br.com.aps.olookinhomeu.model.Look;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

@Component
public class CadastroLook {

    @Autowired
    private IRepositorioLook repositorioLook;

    public void addLook(String nome, Set<PecaDeRoupa> pecasDeRoupa) {

        Look look = new Look();

        if (pecasDeRoupa.isEmpty()) { // checar se tem como tratar isso direto no front // tem, mas acho melhor ter
                                      // outro check // se for pra ter outro check, talvez seja uma excecao, mas dps a
                                      // gt checa
            throw new RuntimeException("Nao ha pecas de roupa para criar um look");
        } else {
                look.setPecasDeRoupa(pecasDeRoupa);

            }
            look.setNome(nome);

            repositorioLook.addLook(look);
        }


    // public void editarLook(Long id, String nome, List<PecaDeRoupa> pecasDeRoupa) {
    //     Look selectedLook = repositorioLook.consultarLookPeloId(id);
    //     if (selectedLook == null) {
    //         throw new RuntimeException("Nao ha look com esse ID");
    //     } else {
    //         if(!pecasDeRoupa.isEmpty()){
    //             for (PecaDeRoupa peca : pecasDeRoupa) {
    //                 String tipo = peca.getTipo();
    
    //                 switch (tipo) {
    //                     case "Calcado":
    //                         selectedLook.setCalcado(peca);
    //                         break;
    //                     case "Superior":
    //                         selectedLook.setPecaDeRoupaSuperior(peca);
    //                         break;
    //                     case "Inferior":
    //                         selectedLook.setPecaDeRoupaInferior(peca);
    //                         break;
    //                     default:
    //                         break; // talvez excecao
    //                 }
    //             }
    //         }
    //         selectedLook.setNome(nome);
            
    //         repositorioLook.editarLook(selectedLook);
    //     }
    // }

    public void deletarLook(Long id) {
        repositorioLook.deletarLook(id);
    }

    public List<Look> consultarLooks() {
        return repositorioLook.consultarLooks();
    }

    public Look consultarLookPeloId(Long id) {
        return repositorioLook.consultarLookPeloId(id);
    }

}