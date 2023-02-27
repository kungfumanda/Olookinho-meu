package br.com.aps.olookinhomeu.model.Usuario;

import java.util.List;

public interface IRepositorioUsuario {

    void adicionarUsuario(Usuario usuario);
    List<Usuario> consultarTodosUsuarios();
    Usuario consultarUsuarioPorId(long id);
    Usuario consultarUsuarioPorEmail(String email);
    void deletarUsuarioPorId(long id);
}
