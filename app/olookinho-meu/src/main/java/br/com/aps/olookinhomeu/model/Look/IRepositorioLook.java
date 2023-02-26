package br.com.aps.olookinhomeu.model.Look;

import java.util.List;

public interface IRepositorioLook {

    void addLook(Look look);

    void atualizarLook(Look look);

    List<Look> consultarLooks();

    Look consultarLookPeloId(Long id);

    void deletarLook(Long id);
}