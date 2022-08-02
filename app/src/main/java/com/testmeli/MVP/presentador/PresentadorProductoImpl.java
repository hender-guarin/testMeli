package com.testmeli.MVP.presentador;

import android.content.Context;

import com.testmeli.MVP.modelo.Clases.Producto;
import com.testmeli.MVP.modelo.Repository.RepositoryProductoWeb;
import com.testmeli.MVP.vista.VistaProducto;

import java.util.ArrayList;
import java.util.List;

public class PresentadorProductoImpl implements PresentadorProducto {

    VistaProducto vistaProducto;
    RepositoryProductoWeb repositoryProductoWeb;
    List<Producto> productos2;

    public PresentadorProductoImpl(VistaProducto vistaProducto, Context context) {
        this.vistaProducto = vistaProducto;
        repositoryProductoWeb = new RepositoryProductoWeb(context,this);
        productos2= new ArrayList<>();
    }


    @Override
    public void getProductos(String data) {
        repositoryProductoWeb.getProductos(data);
    }

    @Override
    public void mostrarProducto(List<Producto> productos) {
        vistaProducto.mostrarProductos(productos);
    }


    @Override
    public void showErrorMessageDialog(int titulo, int mensaje) {
        vistaProducto.showAlertDialogInf(titulo,mensaje);
    }

    @Override
    public void showErrorMessageDialog(int titulo, String mensaje) {
        vistaProducto.showAlertDialogInf(titulo,mensaje);
    }

    @Override
    public void cancelarDialogoCargando() {
        vistaProducto.cancelDialogCargando();

    }
}
