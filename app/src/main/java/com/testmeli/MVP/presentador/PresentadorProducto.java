package com.testmeli.MVP.presentador;

import com.testmeli.MVP.modelo.Clases.Producto;

import java.util.List;

public interface PresentadorProducto extends PresentadorGeneral {

     void getProductos(String data);
    void mostrarProducto(List <Producto> productos);

}
