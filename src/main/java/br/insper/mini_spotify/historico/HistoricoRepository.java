package br.insper.mini_spotify.historico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, String> {
    List<Historico> findByUsuarioId(String usuarioId);
}