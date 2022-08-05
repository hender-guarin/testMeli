package com.testmeli.mvp.vista;

import static com.testmeli.util.Util.remplazarCaracteresEspeciales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
    private EditText edInfo;


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
        edInfo= findViewById(R.id.ed_informacion);
        ImageView imgBuscar= findViewById(R.id.btn_buscar);
        recyclerView= findViewById(R.id.rv_result);

        Util.ocultarTeclado(getApplicationContext(),edInfo);

        imgBuscar.setOnClickListener(view -> {
             Util.ocultarTeclado(getApplicationContext(),edInfo);
              buscarInfo(edInfo.getText().toString());


        });

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_ENTER){
            Util.ocultarTeclado(getApplicationContext(),edInfo);
            buscarInfo(edInfo.getText().toString());
            return true;
        }
        return super.onKeyUp(keyCode, event);
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

    private void showDialogCargando(int titulo, int mensaje) {
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

    private void getProductos(String info) {
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

    public void buscarInfo(String info){
        if(info.isEmpty()){
            showAlertDialogInf(R.string.informacion,"Ingrese la palabra a buscar");
            recyclerView.setAdapter(null);
        }else {
            getProductos(info);
        }
    }
   }