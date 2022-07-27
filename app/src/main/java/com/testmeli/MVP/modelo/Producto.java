package com.testmeli.MVP.modelo;

import java.util.List;

public class Producto {

    private String titulo;
    private String precio;
    private int cantidadesDisponibles;
    private int cantidadesVendidas;
    private String urlImagen;
    private Direccion direccion;
    private List<Atributo> atributos;

    public Producto(String titulo, String precio, int cantidadesDisponibles, int cantidadesVendidas, String urlImagen, Direccion direccion, List<Atributo> atributos) {
        this.titulo = titulo;
        this.precio = precio;
        this.cantidadesDisponibles = cantidadesDisponibles;
        this.cantidadesVendidas = cantidadesVendidas;
        this.urlImagen = urlImagen;
        this.direccion = direccion;
        this.atributos = atributos;
    }

    public Producto() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getCantidadesDisponibles() {
        return cantidadesDisponibles;
    }

    public void setCantidadesDisponibles(int cantidadesDisponibles) {
        this.cantidadesDisponibles = cantidadesDisponibles;
    }

    public int getCantidadesVendidas() {
        return cantidadesVendidas;
    }

    public void setCantidadesVendidas(int cantidadesVendidas) {
        this.cantidadesVendidas = cantidadesVendidas;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }
}
