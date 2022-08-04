package com.testmeli.mvp.modelo.clases;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Producto  implements Serializable {

    @SerializedName(value = "title")
    private final String titulo;
    @SerializedName(value = "price")
    private final String precio;
    @SerializedName(value = "available_quantity")
    private final String unidadesDisponible;
    @SerializedName(value = "sold_quantity")
    private final String unidadesVendida;
    @SerializedName(value = "thumbnail")
    private final String urlImagen;
    @SerializedName(value = "address")
    private final Direccion direccion;
    @SerializedName(value = "attributes")
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
