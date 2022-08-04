package com.testmeli.mvp.modelo.clases;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Atributo  implements Serializable {

     @SerializedName(value = "name")
     private final String nombre;
     @SerializedName(value = "value_name")
     private final String valor;

     public Atributo(String nombre, String valor) {
          this.nombre = nombre;
          this.valor = valor;
     }

     public String getNombre() {
          return nombre;
     }

     public String getValor() {
          return valor;
     }

}
