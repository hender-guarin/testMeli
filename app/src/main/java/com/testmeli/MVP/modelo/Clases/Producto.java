package com.testmeli.MVP.modelo.Clases;

import java.io.Serializable;
import java.util.List;

public class Producto  implements Serializable {

    private String titulo;
    private String precio;
    private String unidadesDisponible;
    private String unidadesVendida;
    private String urlImagen;
    private Direccion direccion;
    private List<Atributo> atributos;


    public Producto() {
    }

    public Producto(String titulo, String precio, String cantidadesDisponibles, String cantidadesVendidas, String urlImagen, Direccion direccion, List<Atributo> atributos) {
        this.titulo = titulo;
        this.precio = precio;
        this.unidadesDisponible = cantidadesDisponibles;
        this.unidadesVendida = cantidadesVendidas;
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

    public String getUnidadesDisponible() {
        return unidadesDisponible;
    }

    public void setUnidadesDisponible(String unidadesDisponible) {
        this.unidadesDisponible = unidadesDisponible;
    }

    public String getUnidadesVendida() {
        return unidadesVendida;
    }

    public void setUnidadesVendida(String unidadesVendida) {
        this.unidadesVendida = unidadesVendida;
    }
}
