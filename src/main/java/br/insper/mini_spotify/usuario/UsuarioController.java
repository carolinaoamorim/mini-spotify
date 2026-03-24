package br.insper.mini_spotify.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public Collection<Usuario> getUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/usuarios")
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuario(@PathVariable String id) {
        return usuarioService.getUsuario(id);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario atualizarUsuario(@PathVariable String id, @RequestBody Usuario dados) {
        return usuarioService.atualizarUsuario(id, dados);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarioService.deleteUsuario(id);
    }
}
