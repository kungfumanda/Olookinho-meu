package br.com.aps.model.look;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LookDAO extends JpaRepository<Look, Long> {
    Look findFirstByNome(String nome);
}
