package br.com.aps.olookinhomeu.model.Look;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

import java.util.List;


public interface IRepositorioLook {

    void addLook(Look look);

    void editarLook(Look look);

    List<Look> consultarLooks();

    Look consultarLookPeloId(Long id);

    Look addPecaDeRoupa(Long id, PecaDeRoupa pecaDeRoupa);

    void deletarLook(Long id);
}