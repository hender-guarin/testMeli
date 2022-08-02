package com.testmeli.mvp.modelo.Clases;

import java.io.Serializable;

public class Direccion  implements Serializable {

    private final String state_name;
    private final String city_name;

    public Direccion(String state_name, String city_name) {
        this.state_name = state_name;
        this.city_name = city_name;
    }

    public String getState_name() {
        return state_name;
    }

    public String getCity_name() {
        return city_name;
    }

}
