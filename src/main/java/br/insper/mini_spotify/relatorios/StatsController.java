package br.insper.mini_spotify.relatorios;

import br.insper.mini_spotify.musica.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StatsController {

    @Autowired
    private MusicaService musicaService;

    @GetMapping("/relatorios/top-musicas")
    public Collection<Top10> getTop10() {
        return musicaService.getTop10();
    }
}
