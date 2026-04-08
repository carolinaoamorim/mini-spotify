package br.insper.mini_spotify.musica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, String> {
    List<Musica> findTop10ByOrderByTotalReproducoesDesc();
}
