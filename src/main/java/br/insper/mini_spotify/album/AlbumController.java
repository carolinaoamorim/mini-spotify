package br.insper.mini_spotify.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/albuns")
    public Collection<Album> getAlbuns() {
        return albumService.listarAlbum();
    }

    @PostMapping("/albuns")
    public Album saveAlbum(@RequestBody Album album) {
        return albumService.criarAlbum(album);
    }

    @GetMapping("/albuns/{id}")
    public Album getAlbum(@PathVariable Long id) {
        return albumService.getAlbum(id);
    }

    @PutMapping("/albuns/{id}")
    public Album atualizarAlbum(@PathVariable Long id, @RequestBody Album dados) {
        return albumService.atualizarAlbum(id, dados);
    }

    @DeleteMapping("/albuns/{id}")
    public void deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
    }
}
