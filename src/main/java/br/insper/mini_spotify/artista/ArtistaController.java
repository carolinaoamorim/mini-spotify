package br.insper.mini_spotify.artista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @GetMapping("/artistas")
    public Collection<Artista> getArtistas() {
        return artistaService.listarArtistas();
    }

    @PostMapping("/artistas")
    public Artista saveArtista(@RequestBody Artista artista) {
        return artistaService.criarArtista(artista);
    }

    @GetMapping("/artistas/{id}")
    public Artista getArtista(@PathVariable Long id) {
        return artistaService.getArtista(id);
    }

    @PutMapping("/artistas/{id}")
    public Artista atualizarArtista(@PathVariable Long id, @RequestBody Artista dados) {
        return artistaService.atualizarArtista(id, dados);
    }

    @DeleteMapping("/artistas/{id}")
    public void deleteArtista(@PathVariable Long id) {
        artistaService.deleteArtista(id);
    }
}
