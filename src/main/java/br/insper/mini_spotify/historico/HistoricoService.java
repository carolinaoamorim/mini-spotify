package br.insper.mini_spotify.historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public Historico registrarHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

    public Historico getHistorico(String id) {
        return historicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Histórico não encontrado"));
    }

    public List<Historico> listarHistorico() {
        return historicoRepository.findAll();
    }

    public List<Historico> listarPorUsuario(String usuarioId) {
        return historicoRepository.findByUsuarioId(usuarioId);
    }

    public Historico atualizarHistorico(String id, Historico dados) {
        Historico historico = getHistorico(id);
        historico.setUsuario(dados.getUsuario());
        historico.setMusica(dados.getMusica());
        return historicoRepository.save(historico);
    }

    public void deletarHistorico(String id) {
        historicoRepository.deleteById(id);
    }
}
