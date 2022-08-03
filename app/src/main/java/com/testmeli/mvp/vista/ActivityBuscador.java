package com.testmeli.mvp.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.testmeli.mvp.modelo.clases.Producto;
import com.testmeli.mvp.presentador.PresentadorProducto;
import com.testmeli.mvp.presentador.PresentadorProductoImpl;
import com.testmeli.mvp.vista.adaptadores.ProductoAdapter;
import com.testmeli.R;
import com.testmeli.util.Util;

import java.util.List;

public class ActivityBuscador extends AppCompatActivity  implements  VistaProducto{

    private PresentadorProducto presentadorProducto;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    public void initView(){
        presentadorProducto= new PresentadorProductoImpl(this,getApplicationContext());
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        EditText edInfo= findViewById(R.id.ed_informacion);
        ImageView imgBuscar= findViewById(R.id.btn_buscar);
        recyclerView= findViewById(R.id.rv_result);

        Util.ocultarTeclado(getApplicationContext(),edInfo);

        imgBuscar.setOnClickListener(view -> {
            Util.ocultarTeclado(getApplicationContext(),edInfo);
            String info= edInfo.getText().toString();

            if(info.isEmpty()){
                showAlertDialogInf(R.string.informacion,"Ingrese la palabra a buscar");
                recyclerView.setAdapter(null);
            }else {
                   getProductos(info);
            }
        });

    }

    @Override
    public void showAlertDialogInf(int titulo, int mensaje) {
        cancelDialogCargando();
        Toast.makeText(getApplicationContext(), getString(titulo) + " : " + getString(mensaje), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlertDialogInf(int titulo, String mensaje) {
        cancelDialogCargando();
        Toast.makeText(getApplicationContext(), getString(titulo) + " : " + mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialogCargando(int titulo, int mensaje) {
        progressDialog.setTitle(getString(titulo));
        progressDialog.setMessage(getString(mensaje));
        progressDialog.show();

    }

    @Override
    public void cancelDialogCargando() {
        if (progressDialog.isShowing()) progressDialog.dismiss();

    }


    @Override
    public void mostrarProductos(List<Producto> productos) {
        cancelDialogCargando();
        if(productos==null || productos.size()==0){
            showAlertDialogInf(R.string.Error,R.string.sin_reultados);
            recyclerView.setAdapter(null);
        }else {

            ProductoAdapter productoAdapter = new ProductoAdapter(productos,getApplicationContext(),interfaceProducto());
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(productoAdapter);
            recyclerView.setHasFixedSize(true);
        }

    }

    @Override
    public void getProductos(String info) {
        showDialogCargando(R.string.informacion, R.string.consultando_productos);
        String data= remplazarCaracteresEspeciales(info);
       presentadorProducto.getProductos(data);
    }

    public ProductoSeleccionado interfaceProducto(){
        return producto -> {
            Intent intent = new Intent(getApplicationContext(), DetalleProducto.class);
            intent.putExtra("producto", producto);
            startActivity(intent);
        };
    }

    public String remplazarCaracteresEspeciales(String info){

        String rta=info;
        rta=rta.replace(" ","%20");
        rta=rta.replace("?","%20");
        rta=rta.replace("¿","%20");
        rta=rta.replace("¡","%20");
        rta=rta.replace("!","%20");
        rta=rta.replace("ñ","n");
        rta=rta.replace("Ñ","N");
        rta=rta.replace("Á","A");
        rta=rta.replace("É","E");
        rta=rta.replace("Í","I");
        rta=rta.replace("Ó","O");
        rta=rta.replace("Ú","U");
        rta=rta.replace("á","a");
        rta=rta.replace("é","e");
        rta=rta.replace("í","i");
        rta=rta.replace("ó","o");
        rta=rta.replace("ú","u");
        return rta;

    }

   }