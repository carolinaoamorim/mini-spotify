package br.insper.mini_spotify.musica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    // rotas obrigatorias

    @GetMapping("/musicas")
    public Collection<Musica> getMusicas() {
        return musicaService.listarMusica();
    }

    @PostMapping("/musicas")
    public Musica saveMusica(@RequestBody Musica musica) {
        return musicaService.criarMusica(musica);
    }

    @GetMapping("/musicas/{id}")
    public Musica getMusica(@PathVariable String id) {
        return musicaService.getMusica(id);
    }

    @PutMapping("/musicas/{id}")
    public Musica atualizarMusica(@PathVariable String id, @RequestBody Musica dados) {
        return musicaService.atualizarMusica(id, dados);
    }

    @DeleteMapping("/musicas/{id}")
    public void deleteMusica(@PathVariable String id) {
        musicaService.deleteMusica(id);
    }

    // reproduzir musica
    @PostMapping("/musicas/{id}/reproduzir")
    public Musica reproduzirMusica(@PathVariable String id, @RequestHeader("X-USER-ID") String userId) {
        return musicaService.reproduzirMusica(id, userId);
    }

}
