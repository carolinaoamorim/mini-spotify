package br.insper.mini_spotify.album;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;

@Service
public class AlbumService {

    private HashMap<Long, Album> albuns = new HashMap<>();

    public Album criarAlbum(Album album) {
        if (album.getTitulo() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        albuns.put(album.getId(), album);
        return album;
    }

    public Collection<Album> listarAlbum() {
        return albuns.values();
    }

    public Album getAlbum(Long id) {
        Album album = albuns.get(id);
        if (album == null) {
            throw new RuntimeException("Album não encontrado");
        }
        return album;
    }

    public Album atualizarAlbum(Long id, Album alb) {
        Album album = getAlbum(id);
        album.setTitulo(alb.getTitulo());
        album.setDataLancamento(alb.getDataLancamento());
        album.setArtista(alb.getArtista());
        return album;
    }

    public void deleteAlbum(Long id) {
        Album album = getAlbum(id);
        albuns.remove(id);
    }

}
