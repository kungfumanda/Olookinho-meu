package br.com.aps.model.pecaDeRoupa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaDeRoupaDAO extends JpaRepository<PecaDeRoupa, Long> {

    PecaDeRoupa findFirstByNome(String nome);
    List<PecaDeRoupa> findByTipo(String nome);

}