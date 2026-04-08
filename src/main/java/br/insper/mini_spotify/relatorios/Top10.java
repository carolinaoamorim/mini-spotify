package br.insper.mini_spotify.relatorios;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Top10 {

    private String tituloMusica;
    private String nomeArtista;
    private Long totalReproducoes;

}
