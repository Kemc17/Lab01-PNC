package com.dog;

public class Artista {
    private String id;
    private String nombre;
    private String discoMasVendido;
    private Integer ventasTotales;

    public Artista(String id, String nombre, String discoMasVendido, Integer ventasTotales) {
        this.id = id;
        this.nombre = nombre;
        this.discoMasVendido = discoMasVendido;
        this.ventasTotales = ventasTotales;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDiscoMasVendido() {
        return discoMasVendido;
    }
    public void setDiscoMasVendido(String discoMasVendido) {
        this.discoMasVendido = discoMasVendido;
    }
    public Integer getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(Integer ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", discoMasVendido='" + discoMasVendido + '\'' +
                ", ventasTotales='" + ventasTotales + '\'' +
                '}';
    }
}
