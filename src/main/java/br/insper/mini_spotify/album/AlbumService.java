package br.insper.mini_spotify.album;

import br.insper.mini_spotify.artista.Artista;
import br.insper.mini_spotify.artista.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class AlbumService {

    private HashMap<String, Album> albuns = new HashMap<>();

    @Autowired
    private ArtistaService artistaService;

    public Album criarAlbum(Album album) {
        if (album.getTitulo() == null) {
            throw new RuntimeException("Dados inválidos");
        }

        Artista artista = artistaService.getArtista(album.getArtista().getId());
        album.setArtista(artista);

        album.setId(UUID.randomUUID().toString());
        albuns.put(album.getId(), album);
        return album;
    }

    public Collection<Album> listarAlbum() {
        return albuns.values();
    }

    public Album getAlbum(String id) {
        Album album = albuns.get(id);
        if (album == null) {
            throw new RuntimeException("Album não encontrado");
        }
        return album;
    }

    public Album atualizarAlbum(String id, Album alb) {
        Album album = getAlbum(id);
        album.setTitulo(alb.getTitulo());
        album.setDataLancamento(alb.getDataLancamento());
        album.setArtista(alb.getArtista());
        return album;
    }

    public void deleteAlbum(String id) {
        albuns.remove(id);
    }

}
