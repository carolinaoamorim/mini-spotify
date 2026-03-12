package br.insper.mini_spotify.usuario;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UsuarioService {

    private HashMap<Long, Usuario> usuarios = new HashMap<>();

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Collection<Usuario> listarUsuarios() {
        return usuarios.values().stream().filter(Usuario::isAtivo).toList();
    }


    public Usuario getUsuario(Long id) {
        Usuario usuario = usuarios.get(id);
        if (usuario == null || !usuario.isAtivo()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return usuario;
    }

    public Usuario atualizarUsuario(Long id, Usuario user) {
        Usuario usuario = getUsuario(id);
        usuario.setNome(user.getNome());
        usuario.setEmail(user.getEmail());
        usuario.setTipoPlano(user.getTipoPlano());
        return usuario;
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = getUsuario(id);
        usuario.setAtivo(false);
    }

}
