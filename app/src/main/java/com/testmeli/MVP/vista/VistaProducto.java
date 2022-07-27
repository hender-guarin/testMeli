package com.testmeli.MVP.vista;

import com.testmeli.MVP.modelo.Clases.Producto;

import java.util.List;

public interface VistaProducto extends  VistaGeneral{

    void mostrarProductos(List<Producto> userList);
    void getProductos(String info);
}
