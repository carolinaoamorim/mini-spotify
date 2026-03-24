package br.insper.mini_spotify.historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/historicos/usuario/{id}")
    public List<Historico> listarPorUsuario(@PathVariable String id) {
        return historicoService.listarPorUsuario(id);
    }

    @PostMapping("/historicos")
    public Historico registrarHistorico(@RequestBody Historico historico) {
        return historicoService.registrarHistorico(historico);
    }

    @GetMapping("/historicos/{id}")
    public Historico getHistorico(@PathVariable String id) {
        return historicoService.getHistorico(id);
    }

    @PutMapping("/historicos/{id}")
    public Historico atualizarHistorico(@PathVariable String id, @RequestBody Historico dados) {
        return historicoService.atualizarHistorico(id, dados);
    }

    @DeleteMapping("/historicos/{id}")
    public void deletarHistorico(@PathVariable String id) {
        historicoService.deletarHistorico(id);
    }

}
