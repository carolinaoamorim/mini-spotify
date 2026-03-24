package br.insper.mini_spotify.artista;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class ArtistaService {

    private HashMap<String, Artista> artistas = new HashMap<>();

    public Artista criarArtista(Artista artista) {
        if (artista.getNome() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        artista.setId(UUID.randomUUID().toString());
        artistas.put(artista.getId(), artista);
        return artista;
    }

    public Collection<Artista> listarArtistas() {
        return artistas.values();
    }


    public Artista getArtista(String id) {
        Artista artista = artistas.get(id);
        if (artista == null) {
            throw new RuntimeException("Artista não encontrado");
        }
        return artista;
    }

    public Artista atualizarArtista(String id, Artista art) {
        Artista artista = getArtista(id);
        artista.setNome(art.getNome());
        artista.setGeneroMusical(art.getGeneroMusical());
        artista.setPaisOrigem(art.getPaisOrigem());
        return artista;
    }

    public void deleteArtista(String id) {
        Artista artista = getArtista(id);
        artistas.remove(id);
    }

}
