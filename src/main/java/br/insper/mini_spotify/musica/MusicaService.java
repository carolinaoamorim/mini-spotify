package br.insper.mini_spotify.musica;

import br.insper.mini_spotify.album.Album;
import br.insper.mini_spotify.album.AlbumService;
import br.insper.mini_spotify.artista.Artista;
import br.insper.mini_spotify.artista.ArtistaService;
import br.insper.mini_spotify.historico.Historico;
import br.insper.mini_spotify.historico.HistoricoService;
import br.insper.mini_spotify.relatorios.Top10;
import br.insper.mini_spotify.usuario.Usuario;
import br.insper.mini_spotify.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private HistoricoService historicoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private AlbumService albumService;

    public Musica criarMusica(Musica musica) {
        if (musica.getTitulo() == null) {
            throw new RuntimeException("Dados inválidos");
        }

        Artista artista = artistaService.getArtista(musica.getArtista().getId());
        Album album = albumService.getAlbum(musica.getAlbum().getId());
        musica.setArtista(artista);
        musica.setAlbum(album);

        return musicaRepository.save(musica);
    }

    public List<Musica> listarMusica() {
        return musicaRepository.findAll();
    }

    public Musica getMusica(String id) {
        return musicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Música não encontrada"));
    }

    public Musica atualizarMusica(String id, Musica mus) {
        Musica musica = getMusica(id);
        musica.setTitulo(mus.getTitulo());
        musica.setDuracaoSegundos(mus.getDuracaoSegundos());
        musica.setNumeroFaixa(mus.getNumeroFaixa());
        musica.setAlbum(mus.getAlbum());
        musica.setArtista(mus.getArtista());
        musica.setTotalReproducoes(mus.getTotalReproducoes());
        return musicaRepository.save(musica);
    }

    public void deleteMusica(String id) {
        musicaRepository.deleteById(id);
    }

    public Musica reproduzirMusica(String id, String userId) {
        Usuario usuario = usuarioService.getUsuario(userId);

        if (!usuario.isAtivo()) {
            throw new RuntimeException("Usuário inativo");
        }

        Musica musica = getMusica(id);
        musica.setTotalReproducoes(musica.getTotalReproducoes() + 1);
        musicaRepository.save(musica);

        // registra no historico
        Historico historico = new Historico();
        historico.setUsuario(usuario);
        historico.setMusica(musica);
        historicoService.registrarHistorico(historico);

        return musica;
    }

    public List<Top10> getTop10() {

        List<Musica> ordenadas = musicaRepository.findTop10ByOrderByTotalReproducoesDesc();
        // funcao do java que ordena a lista antes de percorrer

        List<Top10> resultado = new ArrayList<>();

        for (Musica m : ordenadas) {
            resultado.add(new Top10(m.getTitulo(), m.getArtista().getNome(), m.getTotalReproducoes()));
        }
        return resultado;

    }

}
