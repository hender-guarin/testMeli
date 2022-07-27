package com.testmeli.MVP.modelo.Repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.testmeli.MVP.modelo.Clases.Producto;
import com.testmeli.MVP.presentador.PresentadorProducto;

import java.util.ArrayList;
import java.util.List;

public class RepositoryProductoWeb implements  RepositoryProducto{

    Context context;
    PresentadorProducto presentadorProducto;
    List<Producto> productos=new ArrayList<>();


    public RepositoryProductoWeb(Context context, PresentadorProducto presentadorProducto) {
        this.context = context;
        this.presentadorProducto = presentadorProducto;
    }

    @Override
    public void getProductos() {

        if (!verificarConexion()) {

        }

    }

    @Override
    public void setProductos(List<Producto> productos) {

    }

    @Override
    public boolean verificarConexion() {
     ConnectivityManager con = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
     NetworkInfo networkInfo = con.getActiveNetworkInfo();
     return networkInfo != null && networkInfo.isConnected();
    }
}
