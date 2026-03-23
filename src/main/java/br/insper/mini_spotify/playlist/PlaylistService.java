package br.insper.mini_spotify.playlist;

import br.insper.mini_spotify.musica.Musica;
import br.insper.mini_spotify.musica.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class PlaylistService {
    private HashMap<Long, Playlist> playlists = new HashMap<>();

    @Autowired
    private MusicaService musicaService;

    public Playlist criarPlaylist(Playlist playlist) {
        if (playlist.getNome() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        playlists.put(playlist.getId(), playlist);
        return playlist;
    }

    public Collection<Playlist> listarPlaylist() {
        return playlists.values();
    }

    public Playlist getPlaylist(Long id) {
        Playlist playlist = playlists.get(id);
        if (playlist == null) {
            throw new RuntimeException("Playlist não encontrada");
        }
        return playlist;
    }

    public Playlist atualizarPlaylist(Long id, Playlist play) {
        Playlist playlist = getPlaylist(id);
        playlist.setNome(play.getNome());
        playlist.setPublica(play.isPublica());
        playlist.setDataCriacao(play.getDataCriacao());
        playlist.setUsuario(play.getUsuario());
        playlist.setMusicas(play.getMusicas());
        return playlist;
    }

    public void deletePlaylist(Long id) {
        Playlist playlist = getPlaylist(id);
        playlists.remove(id);
    }

    public Playlist adicionarMusica(Long id, Long musicaId, Long usuarioId) {
        Playlist playlist = playlists.get(id);

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
