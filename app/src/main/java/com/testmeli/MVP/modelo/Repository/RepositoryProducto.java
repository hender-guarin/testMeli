package com.testmeli.MVP.modelo.Repository;

import com.testmeli.MVP.modelo.Clases.Producto;

import java.util.List;

public interface RepositoryProducto extends RepositoryGeneral {

    void getProductos(String info);

    void setProductos(List<Producto> productos);


}
