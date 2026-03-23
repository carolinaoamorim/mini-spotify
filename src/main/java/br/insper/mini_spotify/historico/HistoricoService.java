package br.insper.mini_spotify.historico;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class HistoricoService {

    private HashMap<Long, Historico> historicos = new HashMap();

    public Historico registrarHistorico(Historico historico) {
        historico.setDataReproducao(LocalDateTime.now());
        historicos.put(historico.getId(), historico);
        return historico;
    }

    public Collection<Historico> listarHistorico() {
        return historicos.values();
    }

    public List<Historico> listarPorUsuario(Long usuarioId) {
        List<Historico> resultado = new ArrayList<>();
        for (Historico history : historicos.values()) {
            if (history.getUsuario().getId().equals(usuarioId)) {
                resultado.add(history);
            }
        }
        return resultado;
    }
}
