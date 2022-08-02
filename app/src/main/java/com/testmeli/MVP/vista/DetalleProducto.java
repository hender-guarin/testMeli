package com.testmeli.MVP.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.testmeli.MVP.modelo.Clases.Producto;
import com.testmeli.R;

public class DetalleProducto extends AppCompatActivity {

    private Producto producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        initView();
    }

    private void initView() {
        producto= (Producto) getIntent().getSerializableExtra("producto");
        System.out.println("nombre del producto --> "+ producto.getTitulo());
    }
}