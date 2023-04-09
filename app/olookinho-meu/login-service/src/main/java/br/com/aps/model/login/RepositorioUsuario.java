package  br.com.aps.olookinhomeu.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RepositorioUsuario implements IRepositorioUsuario {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> consultarTodosUsuarios() {
        return usuarioDAO.findAll();
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        this.usuarioDAO.save(usuario);
    }

    @Override
    public Usuario consultarUsuarioPorId(long id) {
        Optional<Usuario> optional = usuarioDAO.findById(id);
        Usuario usuario = null;
        if(optional.isPresent()) {
            usuario = optional.get();
        } else {
            throw new RuntimeException("Usuario com id " + id + " não encontrado");
        }
        return usuario;
    }

    @Override
    public Usuario consultarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioDAO.findFirstByEmail(email);
        if(usuario != null) {
            return usuario;
        } else {
            throw new RuntimeException("Usuario com email " + email + " não encontrado");
        }
    }

    @Override
    public void deletarUsuarioPorId(long id) {
        usuarioDAO.deleteById(id);
    }
}
