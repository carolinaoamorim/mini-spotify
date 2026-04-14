package br.insper.mini_spotify.historico;

import br.insper.mini_spotify.musica.Musica;
import br.insper.mini_spotify.usuario.Usuario;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

// escolhi o histório como a entidade a mais inspirado na própria função do spotify que mostra a ultima música que alguem reproduziu
@Getter
@Setter
@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "musica_id")
    private Musica musica;

    @CreationTimestamp
    private LocalDateTime dataReproducao;

}
