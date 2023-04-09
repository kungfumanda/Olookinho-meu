package br.com.aps.olookinhomeu.model.Look;
import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

import java.util.List;
import java.util.Set;


public interface IRepositorioLook {

    void addLook(Look look);

    void editarLook(Look look);

    List<Look> consultarLooks();

    Look consultarLookPeloId(Long id);

    Look addPecaDeRoupa(Long id, PecaDeRoupa pecaDeRoupa);

    void deletarLook(Long id);

    Set<PecaDeRoupa> getPecasDeRoupaByLook(Long id);
}