package com.testmeli.MVP.modelo.Clases;

import java.io.Serializable;
import java.util.List;

public class Producto  implements Serializable {

    private String titulo;
    private String precio;
    private String cantidadesDisponibles;
    private String cantidadesVendidas;
    private String urlImagen;
    private Direccion direccion;
    private List<Atributo> atributos;


    public Producto() {
    }

    public Producto(String titulo, String precio, String cantidadesDisponibles, String cantidadesVendidas, String urlImagen, Direccion direccion, List<Atributo> atributos) {
        this.titulo = titulo;
        this.precio = precio;
        this.cantidadesDisponibles = cantidadesDisponibles;
        this.cantidadesVendidas = cantidadesVendidas;
        this.urlImagen = urlImagen;
        this.direccion = direccion;
        this.atributos = atributos;
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

    public String getCantidadesDisponibles() {
        return cantidadesDisponibles;
    }

    public void setCantidadesDisponibles(String cantidadesDisponibles) {
        this.cantidadesDisponibles = cantidadesDisponibles;
    }

    public String getCantidadesVendidas() {
        return cantidadesVendidas;
    }

    public void setCantidadesVendidas(String cantidadesVendidas) {
        this.cantidadesVendidas = cantidadesVendidas;
    }
}
