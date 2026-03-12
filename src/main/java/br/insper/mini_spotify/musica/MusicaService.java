package br.insper.mini_spotify.musica;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MusicaService {

    private HashMap<Long, Musica> musicas = new HashMap<>();

    public Musica criarMusica(Musica musica) {
        if (musica.getTitulo() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        musicas.put(musica.getId(), musica);
        return musica;
    }

    public Collection<Musica> listarMusica() {
        return musicas.values();
    }

    public Musica getMusica(Long id) {
        Musica musica = musicas.get(id);
        if (musica == null) {
            throw new RuntimeException("Música não encontrada");
        }
        return musica;
    }

    public Musica atualizarMusica(Long id, Musica mus) {
        Musica musica = getMusica(id);
        musica.setTitulo(mus.getTitulo());
        musica.setDuracaoSegundos(mus.getDuracaoSegundos());
        musica.setNumeroFaixa(mus.getNumeroFaixa());
        musica.setAlbum(mus.getAlbum());
        musica.setArtista(mus.getArtista());
        musica.setTotalReproducoes(mus.getTotalReproducoes());
        return musica;
    }

    public void deleteMusica(Long id) {
        Musica musica = getMusica(id);
        musicas.remove(id);
    }

}
