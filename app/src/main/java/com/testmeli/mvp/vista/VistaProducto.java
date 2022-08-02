package com.testmeli.mvp.vista;

import com.testmeli.mvp.modelo.Clases.Producto;

import java.util.List;

public interface VistaProducto extends  VistaGeneral{

    void mostrarProductos(List<Producto> productos);
    void getProductos(String info);
}
