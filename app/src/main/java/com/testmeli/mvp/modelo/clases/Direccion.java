package com.testmeli.mvp.modelo.clases;

import java.io.Serializable;

public class Direccion  implements Serializable {

    private final String estado;
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
