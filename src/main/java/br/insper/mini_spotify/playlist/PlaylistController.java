package br.insper.mini_spotify.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlists")
    public Collection<Playlist> getPlaylists() {
        return playlistService.listarPlaylist();
    }

    @PostMapping("/playlists")
    public Playlist savePlaylist(@RequestBody Playlist playlist) {
        return playlistService.criarPlaylist(playlist);
    }

    @GetMapping("/playlists/{id}")
    public Playlist getPlaylist(@PathVariable Long id) {
        return playlistService.getPlaylist(id);
    }

    @PutMapping("/playlists/{id}")
    public Playlist atualizarPlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
        return playlistService.atualizarPlaylist(id, playlist);
    }

    @DeleteMapping("/playlist/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }

    @PostMapping("/playlists/{playlistId}/musicas/{musicaId}")
    public Playlist savePlaylist(@PathVariable Long playlistId, @PathVariable Long musicaId, @RequestHeader("X-USER-ID") Long usuarioId) {
        return playlistService.adicionarMusica(playlistId, musicaId, usuarioId);
    }
}
