package br.com.aps.olookinhomeu.model.Look;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LookDAO extends JpaRepository<Look, Long> {
    Look findFirstByNome(String nome);
}
