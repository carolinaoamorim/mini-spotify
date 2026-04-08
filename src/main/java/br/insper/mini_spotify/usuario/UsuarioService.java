package br.insper.mini_spotify.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getEmail() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        usuario.setAtivo(true);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findByAtivoTrue();
    }

    public Usuario getUsuario(String id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (!usuario.isAtivo()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return usuario;
    }

    public Usuario atualizarUsuario(String id, Usuario user) {
        Usuario usuario = getUsuario(id);
        usuario.setNome(user.getNome());
        usuario.setEmail(user.getEmail());
        usuario.setTipoPlano(user.getTipoPlano());
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String id) {
        Usuario usuario = getUsuario(id);
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

}
