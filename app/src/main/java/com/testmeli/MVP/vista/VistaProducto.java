package com.testmeli.MVP.vista;

import com.testmeli.MVP.modelo.Clases.Producto;

import java.util.List;

public interface VistaProducto extends  VistaGeneral{

    void mostrarProductos(List<Producto> productos);
    void getProductos(String info);
}
