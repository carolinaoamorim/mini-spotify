package br.insper.mini_spotify.historico;

import br.insper.mini_spotify.musica.Musica;
import br.insper.mini_spotify.usuario.Usuario;

import java.time.LocalDateTime;

// escolhi o histório como a entidade a mais inspirado na própria função do spotify que mostra a ultima música que alguem reproduziu
public class Historico {
    private String id;
    private Usuario usuario;
    private Musica musica;
    private LocalDateTime dataReproducao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public LocalDateTime getDataReproducao() {
        return dataReproducao;
    }

    public void setDataReproducao(LocalDateTime dataReproducao) {
        this.dataReproducao = dataReproducao;
    }

}
