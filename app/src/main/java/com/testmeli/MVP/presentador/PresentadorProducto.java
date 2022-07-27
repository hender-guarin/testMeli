package com.testmeli.MVP.presentador;

import com.testmeli.MVP.modelo.Clases.Producto;

import java.util.List;

public interface PresentadorProducto extends PresentadorGeneral {

    void mostrarProductos(List <Producto> productos);

    void getProductos(String data);
}
