package com.testmeli.mvp.presentador;

import com.testmeli.mvp.modelo.clases.Producto;

import java.util.List;

public interface PresentadorProducto extends PresentadorGeneral {

     void getProductos(String data);
    void mostrarProducto(List <Producto> productos);

}
