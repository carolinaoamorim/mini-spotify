package br.insper.mini_spotify.album;

import br.insper.mini_spotify.artista.Artista;
import br.insper.mini_spotify.artista.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    private ArtistaService artistaService;

    public Album criarAlbum(Album album) {
        if (album.getTitulo() == null) {
            throw new RuntimeException("Dados inválidos");
        }

        Artista artista = artistaService.getArtista(album.getArtista().getId());
        album.setArtista(artista);
        return albumRepository.save(album);
    }

    public List<Album> listarAlbum() {
        return albumRepository.findAll();
    }

    public Album getAlbum(String id) {
        return albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Album não encontrado"));
    }

    public Album atualizarAlbum(String id, Album alb) {
        Album album = getAlbum(id);
        album.setTitulo(alb.getTitulo());
        album.setDataLancamento(alb.getDataLancamento());
        album.setArtista(alb.getArtista());
        return albumRepository.save(album);
    }

    public void deleteAlbum(String id) {
        Album album = getAlbum(id);
        albumRepository.delete(album);
    }

}
