package br.insper.mini_spotify.artista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    public Artista criarArtista(Artista artista) {
        if (artista.getNome() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        return artistaRepository.save(artista);
    }

    public List<Artista> listarArtistas() {
        return artistaRepository.findAll();
    }


    public Artista getArtista(String id) {
        return artistaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista não encontrado"));
    }

    public Artista atualizarArtista(String id, Artista art) {
        Artista artista = getArtista(id);
        artista.setNome(art.getNome());
        artista.setGeneroMusical(art.getGeneroMusical());
        artista.setPaisOrigem(art.getPaisOrigem());
        return artistaRepository.save(artista);
    }

    public void deleteArtista(String id) {
        Artista artista = getArtista(id);
        artistaRepository.delete(artista);
    }

}
