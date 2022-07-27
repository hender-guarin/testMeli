package com.testmeli.MVP.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.testmeli.MVP.presentador.PresentadorProducto;
import com.testmeli.R;

public class ActivityBuscador extends AppCompatActivity {

    private PresentadorProducto presentadorProducto;
   private RecyclerView recyclerView;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}