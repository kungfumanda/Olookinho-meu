package br.com.aps.olookinhomeu.model.PecaDeRoupa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaDeRoupaDAO extends JpaRepository<PecaDeRoupa, Long> {

    PecaDeRoupa findFirstByNome(String nome);

}