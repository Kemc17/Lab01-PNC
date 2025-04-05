package com.dog;

public class Disco {
    private String artista;
    private String titulo;
    private Integer ventasTotales;

    public Disco(String artista, String titulo, Integer ventasTotales) {
        this.artista = artista;
        this.titulo = titulo;
        this.ventasTotales = ventasTotales;
    }

    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getVentasTotales() {
        return ventasTotales;
    }
    public void setVentasTotales(Integer ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

}
