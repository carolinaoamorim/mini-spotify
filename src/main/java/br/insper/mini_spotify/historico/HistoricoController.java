package br.insper.mini_spotify.historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class HistoricoController {
    @Autowired
    private HistoricoService historicoService;

    @GetMapping("/historicos")
    public Collection<Historico> listarHistorico() {
        return historicoService.listarHistorico();
    }

    @GetMapping("historicos/usuario/{id}")
    public List<Historico> listarPorUsuario(@PathVariable Long id) {
        return historicoService.listarPorUsuario(id);
    }
}
