package br.insper.mini_spotify.playlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, String> {
    List<Playlist> findByUsuarioId(String usuarioId);
    List<Playlist> findByPublicaTrue();
}
