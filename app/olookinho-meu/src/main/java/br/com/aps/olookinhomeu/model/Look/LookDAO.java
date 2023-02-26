package br.com.aps.olookinhomeu.model.Look;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LookDAO extends JpaRepository<Look, Long> {
    Look findFirstByNome(String nome);
}
