package br.insper.mini_spotify.playlist;

import br.insper.mini_spotify.musica.Musica;
import br.insper.mini_spotify.musica.MusicaService;
import br.insper.mini_spotify.usuario.Usuario;
import br.insper.mini_spotify.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private MusicaService musicaService;

    @Autowired
    private UsuarioService usuarioService;

    public Playlist criarPlaylist(Playlist playlist) {
        if (playlist.getNome() == null) {
            throw new RuntimeException("Dados inválidos");
        }

        Usuario usuario = usuarioService.getUsuario(playlist.getUsuario().getId());
        playlist.setUsuario(usuario);

        return playlistRepository.save(playlist);
    }

    public List<Playlist> listarPlaylist() {
        return playlistRepository.findAll();
    }

    public Playlist getPlaylist(String id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist não encontrada"));
    }

    public Playlist atualizarPlaylist(String id, Playlist play) {
        Playlist playlist = getPlaylist(id);
        playlist.setNome(play.getNome());
        playlist.setPublica(play.isPublica());
        playlist.setUsuario(play.getUsuario());
        playlist.setMusicas(play.getMusicas());
        return playlistRepository.save(playlist);
    }

    public void deletePlaylist(String id) {
        playlistRepository.deleteById(id);
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
        return playlistRepository.save(playlist);
    }
}
