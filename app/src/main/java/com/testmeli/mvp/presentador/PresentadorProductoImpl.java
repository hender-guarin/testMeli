package com.testmeli.mvp.presentador;

import android.content.Context;

import com.testmeli.mvp.modelo.clases.Producto;
import com.testmeli.mvp.modelo.repository.RepositoryProductoWeb;
import com.testmeli.mvp.vista.VistaProducto;

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
