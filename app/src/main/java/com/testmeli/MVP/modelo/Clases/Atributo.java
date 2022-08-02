package com.testmeli.MVP.modelo.Clases;

import java.io.Serializable;

public class Atributo  implements Serializable {

     private final String nombre;
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
