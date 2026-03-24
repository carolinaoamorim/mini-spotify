package br.insper.mini_spotify.playlist;

import br.insper.mini_spotify.musica.Musica;
import br.insper.mini_spotify.musica.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PlaylistService {
    private HashMap<String, Playlist> playlists = new HashMap<>();

    @Autowired
    private MusicaService musicaService;

    public Playlist criarPlaylist(Playlist playlist) {
        if (playlist.getNome() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        playlist.setId(UUID.randomUUID().toString());
        playlist.setDataCriacao(LocalDateTime.now());
        playlists.put(playlist.getId(), playlist);
        return playlist;
    }

    public Collection<Playlist> listarPlaylist() {
        return playlists.values();
    }

    public Playlist getPlaylist(String id) {
        Playlist playlist = playlists.get(id);
        if (playlist == null) {
            throw new RuntimeException("Playlist não encontrada");
        }
        return playlist;
    }

    public Playlist atualizarPlaylist(String id, Playlist play) {
        Playlist playlist = getPlaylist(id);
        playlist.setNome(play.getNome());
        playlist.setPublica(play.isPublica());
        playlist.setDataCriacao(play.getDataCriacao());
        playlist.setUsuario(play.getUsuario());
        playlist.setMusicas(play.getMusicas());
        return playlist;
    }

    public void deletePlaylist(String id) {
        Playlist playlist = getPlaylist(id);
        playlists.remove(id);
    }

    public Playlist adicionarMusica(String id, String musicaId, String usuarioId) {
        Playlist playlist = getPlaylist(id);

        if (!playlist.getUsuario().getId().equals(usuarioId)) {
            throw new RuntimeException("Apenas o dono pode adicionar músicas");
        }

        Musica musica = musicaService.getMusica(musicaId);
        for (Musica music : playlist.getMusicas()) {
            if (music.getId().equals(musicaId)) {
                throw new RuntimeException("Musica já esta na playlist");
            }
        }

        playlist.getMusicas().add(musica);
        return playlist;
    }
}
