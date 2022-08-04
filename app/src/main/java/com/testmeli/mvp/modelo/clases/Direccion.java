package com.testmeli.mvp.modelo.clases;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Direccion  implements Serializable {

    @SerializedName(value = "state_name")
    private final String estado;
    @SerializedName(value = "city_name")
    private final String ciudad;

    public Direccion(String estado, String ciudad) {
        this.estado = estado;
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public String getCiudad() {
        return ciudad;
    }

}
