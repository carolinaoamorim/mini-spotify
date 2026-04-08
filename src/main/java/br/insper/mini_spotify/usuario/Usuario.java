package br.insper.mini_spotify.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
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