package  br.com.aps.olookinhomeu.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroUsuario {

    @Autowired
    private IRepositorioUsuario repositorioUsuario;

    public List<Usuario> consultarTodosUsuarios() {
        return repositorioUsuario.consultarTodosUsuarios();
    }

    public void adicionarUsuario(String nome, String email) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);

        repositorioUsuario.adicionarUsuario(usuario);
    }

    public Usuario consultarUsuarioPorId(long id) {
        return repositorioUsuario.consultarUsuarioPorId(id);
    }

    public Usuario consultarUsuarioPorEmail(String email) {
        return repositorioUsuario.consultarUsuarioPorEmail(email);
    }

    public void deletarUsuarioPorId(long id) {
        repositorioUsuario.deletarUsuarioPorId(id);
    }
}
