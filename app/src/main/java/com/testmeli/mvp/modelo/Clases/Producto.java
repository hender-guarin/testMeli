package com.testmeli.mvp.modelo.Clases;

import java.io.Serializable;
import java.util.List;

public class Producto  implements Serializable {

    private final String titulo;
    private final String precio;
    private final String unidadesDisponible;
    private final String unidadesVendida;
    private final String urlImagen;
    private final Direccion direccion;
    private final List<Atributo> atributos;


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

    public String getPrecio() {
        return precio;
    }


    public String getUrlImagen() {
        return urlImagen;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public String getUnidadesDisponible() {
        return unidadesDisponible;
    }

    public String getUnidadesVendida() {
        return unidadesVendida;
    }

}
