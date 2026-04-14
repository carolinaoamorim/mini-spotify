package br.insper.mini_spotify.musica;

import br.insper.mini_spotify.album.Album;
import br.insper.mini_spotify.artista.Artista;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int duracaoSegundos;

    @Column(nullable = false)
    private int numeroFaixa;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @Column
    private Long totalReproducoes = 0L;

}