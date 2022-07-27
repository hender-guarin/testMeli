package com.testmeli.MVP.presentador;

import android.content.Context;

import com.testmeli.MVP.modelo.Repository.RepositoryProductoWeb;
import com.testmeli.MVP.vista.VistaProducto;

public class PresentadorProductoImpl implements PresentadorProducto {

    VistaProducto vistaProducto;
    RepositoryProductoWeb repositoryProductoWeb;

    public PresentadorProductoImpl(VistaProducto vistaProducto, Context context) {
        this.vistaProducto = vistaProducto;
        repositoryProductoWeb = new RepositoryProductoWeb(context,this);
    }

    @Override
    public void consultarProductos(String producto) {

    }

    @Override
    public void getProductos(String data) {
        repositoryProductoWeb.getProductos("aaaa");

    }



    @Override
    public void showErrorMessageDialog(int titulo, int mensaje) {

    }

    @Override
    public void showErrorMessageDialog(int titulo, String mensaje) {

    }

    @Override
    public void cancelarDialogoCargando() {

    }
}
