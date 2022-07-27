package com.testmeli.MVP.presentador;

import android.content.Context;

import com.testmeli.MVP.modelo.Clases.Producto;
import com.testmeli.MVP.modelo.Repository.RepositoryProductoWeb;
import com.testmeli.MVP.vista.VistaProducto;

import java.util.List;

public class PresentadorProductoImpl implements PresentadorProducto {

    VistaProducto vistaProducto;
    RepositoryProductoWeb repositoryProductoWeb;

    public PresentadorProductoImpl(VistaProducto vistaProducto, Context context) {
        this.vistaProducto = vistaProducto;
        repositoryProductoWeb = new RepositoryProductoWeb(context,this);
    }


    @Override
    public void mostrarProductos(List<Producto> productos) {
        cancelarDialogoCargando();
        System.out.println("Productos obtenidos "+ productos.size());

    }

    @Override
    public void getProductos(String data) {
        repositoryProductoWeb.getProductos(data);

    }



    @Override
    public void showErrorMessageDialog(int titulo, int mensaje) {

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
