package com.testmeli.MVP.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.testmeli.MVP.modelo.Clases.Producto;
import com.testmeli.MVP.presentador.PresentadorProducto;
import com.testmeli.MVP.presentador.PresentadorProductoImpl;
import com.testmeli.R;

import java.util.List;

public class ActivityBuscador extends AppCompatActivity  implements  VistaProducto{

    private PresentadorProducto presentadorProducto;
    private RecyclerView recyclerView;
    private View view;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentadorProducto= new PresentadorProductoImpl(this,getApplicationContext());
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        getProductos("aaaaaaaa");
    }


    @Override
    public void showAlertDialogInf(int titulo, String mensaje) {
        cancelDialogCargando();
        Toast.makeText(getApplicationContext(), getString(titulo) + " : " + mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialogCargando(int titulo, int mensaje) {
        cancelDialogCargando();
        progressDialog.setTitle(getString(titulo));
        progressDialog.setMessage(getString(mensaje));
        progressDialog.show();

    }

    @Override
    public void cancelDialogCargando() {
        if (progressDialog.isShowing()) progressDialog.dismiss();

    }

    @Override
    public void mostrarProductos(List<Producto> userList) {

    }

    @Override
    public void getProductos(String info) {
        showDialogCargando(R.string.informacion, R.string.consultando_productos);
        presentadorProducto.getProductos(info);
    }
}