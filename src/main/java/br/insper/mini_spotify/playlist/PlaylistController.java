package br.insper.mini_spotify.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlists")
    public List<Playlist> getPlaylists() {
        return playlistService.listarPlaylist();
    }

    @PostMapping("/playlists")
    public Playlist savePlaylist(@RequestBody Playlist playlist) {
        return playlistService.criarPlaylist(playlist);
    }

    @GetMapping("/playlists/{id}")
    public Playlist getPlaylist(@PathVariable String id) {
        return playlistService.getPlaylist(id);
    }

    @PutMapping("/playlists/{id}")
    public Playlist atualizarPlaylist(@PathVariable String id, @RequestBody Playlist playlist) {
        return playlistService.atualizarPlaylist(id, playlist);
    }

    @DeleteMapping("/playlists/{id}")
    public void deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylist(id);
    }

    @PostMapping("/playlists/{playlistId}/musicas/{musicaId}")
    public Playlist savePlaylist(@PathVariable String playlistId, @PathVariable String musicaId, @RequestHeader("X-USER-ID") String usuarioId) {
        return playlistService.adicionarMusica(playlistId, musicaId, usuarioId);
    }
}
