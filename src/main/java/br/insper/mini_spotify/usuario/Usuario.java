package br.insper.mini_spotify.usuario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;


    private TipoPlano tipoPlano;

    @Column(nullable = false)
    private boolean ativo;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public enum TipoPlano {
        FREE, PREMIUM
    }

}