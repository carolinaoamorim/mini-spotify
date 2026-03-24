package br.insper.mini_spotify.historico;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class HistoricoService {

    private HashMap<String, Historico> historicos = new HashMap<>();

    public Historico registrarHistorico(Historico historico) {
        historico.setDataReproducao(LocalDateTime.now());
        historico.setId(UUID.randomUUID().toString());
        historicos.put(historico.getId(), historico);
        return historico;
    }

    public Historico getHistorico(String id) {
        Historico historico = historicos.get(id);
        if (historico == null) {
            throw new RuntimeException("Histórico não encontrado");
        }
        return historico;
    }

    public Collection<Historico> listarHistorico() {
        return historicos.values();
    }

    public List<Historico> listarPorUsuario(String usuarioId) {
        List<Historico> resultado = new ArrayList<>();
        for (Historico history : historicos.values()) {
            if (history.getUsuario().getId().equals(usuarioId)) {
                resultado.add(history);
            }
        }
        return resultado;
    }

    public Historico atualizarHistorico(String id, Historico dados) {
        Historico historico = getHistorico(id);
        historico.setUsuario(dados.getUsuario());
        historico.setMusica(dados.getMusica());
        return historico;
    }

    public void deletarHistorico(String id) {
        historicos.remove(id);
    }
}
