package br.insper.mini_spotify.artista;

import java.util.Collection;
import java.util.HashMap;

public class ArtistaService {

    private HashMap<Long, Artista> artistas = new HashMap<>();

    public Artista criarArtista(Artista artista) {
        if (artista.getNome() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        artistas.put(artista.getId(), artista);
        return artista;
    }

    public Collection<Artista> listarArtistas() {
        return artistas.values();
    }


    public Artista getArtista(Long id) {
        Artista artista = artistas.get(id);
        if (artista == null) {
            throw new RuntimeException("Artista não encontrado");
        }
        return artista;
    }

    public Artista atualizarArtista(Long id, Artista art) {
        Artista artista = getArtista(id);
        artista.setNome(art.getNome());
        artista.setGeneroMusical(art.getGeneroMusical());
        artista.setPaisOrigem(art.getPaisOrigem());
        return artista;
    }

    public void deleteArtista(Long id) {
        Artista artista = getArtista(id);
        artistas.remove(id);
    }

}
