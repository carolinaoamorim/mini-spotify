package br.insper.mini_spotify.relatorios;

public class Top10 {

    private String tituloMusica;
    private String nomeArtista;
    private Long totalReproducoes;

    public Top10(String tituloMusica, String nomeArtista, Long totalReproducoes) {
        this.tituloMusica = tituloMusica;
        this.nomeArtista = nomeArtista;
        this.totalReproducoes = totalReproducoes;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public Long getTotalReproducoes() {
        return totalReproducoes;
    }

}
