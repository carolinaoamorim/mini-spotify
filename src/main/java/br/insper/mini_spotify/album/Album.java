package br.insper.mini_spotify.album;

import br.insper.mini_spotify.artista.Artista;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Album {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    @JsonIgnore // na saida no json nao fica uma relacao infinita
    private Artista artista;

    @CreationTimestamp
    private LocalDate dataLancamento;
}