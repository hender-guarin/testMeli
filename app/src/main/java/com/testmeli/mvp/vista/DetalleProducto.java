package com.testmeli.mvp.vista;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.testmeli.mvp.modelo.clases.Atributo;
import com.testmeli.mvp.modelo.clases.Producto;
import com.testmeli.R;
import com.testmeli.util.Util;

import java.util.List;

public class DetalleProducto extends AppCompatActivity {
    private  LinearLayout lyDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        initView();
    }

    private void initView() {
        Producto producto = (Producto) getIntent().getSerializableExtra("producto");
        TextView tvNombre= findViewById(R.id.tv_nombre);
        TextView tvPrecio= findViewById(R.id.tv_precio);
        TextView tvUnidadesDisp= findViewById(R.id.tv_unidades_disp);
        TextView tvUnidadesven= findViewById(R.id.tv_unidades_vend);
        lyDetalles= findViewById(R.id.ly_detalles);
        TextView tvUbicacion= findViewById(R.id.tv_ubicacion);
        ImageView imgProducto= findViewById(R.id.imgproducto);

        if(producto !=null){

            if(producto.getTitulo()!=null){
             tvNombre.setText(producto.getTitulo());
            }

            mostrarImagen(producto.getUrlImagen(),imgProducto);

            if(producto.getPrecio()!=null){
              tvPrecio.setText(getPrecioFormato(producto.getPrecio()));
            }

            if(producto.getUnidadesDisponible()!=null ){
                tvUnidadesDisp.setText(producto.getUnidadesDisponible());
            }

            if(producto.getUnidadesVendida()!=null){
                tvUnidadesven.setText(producto.getUnidadesVendida());
            }

            if(producto.getAtributos()!=null && producto.getAtributos().size()>0){
            llenarPropiedades(producto.getAtributos());
            }

            if(producto.getDireccion()!=null){
                String info = producto.getDireccion().getCiudad() + ", " + producto.getDireccion().getEstado();
                tvUbicacion.setText(info);
            }
        }
    }

    @SuppressLint("RtlHardcoded")
    public void llenarPropiedades(List<Atributo> atributos) {

         for(int i = 0; i< atributos.size(); i++){
           LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);

           LinearLayout linearLy= new LinearLayout(this);
           linearLy.setOrientation(LinearLayout.VERTICAL);
           linearLy.setLayoutParams(params);

           LinearLayout.LayoutParams para = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
           para.setMargins(0,10,0,0);
           LinearLayout linearLayout= new LinearLayout(this);
           linearLayout.setWeightSum(5);
           linearLayout.setPadding(5,0,5,0);
           linearLayout.setOrientation(LinearLayout.HORIZONTAL);
           linearLayout.setLayoutParams(para);

           LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0, WRAP_CONTENT,3);

           TextView tv1 = new TextView(this);
           tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
           tv1.setText(atributos.get(i).getNombre());
           tv1.setLayoutParams(param);
           tv1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
           tv1.setTextColor(Color.parseColor("#333333"));

           LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(0, WRAP_CONTENT,2);

           TextView tv2 = new TextView(this);
           tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
           tv2.setGravity(Gravity.RIGHT);
           tv1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
           tv1.setTextColor(Color.parseColor("#333333"));
           tv2.setText(atributos.get(i).getValor());
           tv2.setLayoutParams(param2);

           LinearLayout.LayoutParams param3 = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);

           TextView tv3 = new TextView(this);
           tv3.setLayoutParams(param3);
           tv3.setBackgroundResource(R.color.azul_oscuro);
           tv3.setHeight(3);

           linearLayout.addView(tv1);
           linearLayout.addView(tv2);
           linearLy.addView(linearLayout);
           linearLy.addView(tv3);

           lyDetalles.addView(linearLy);
        }

    }

    private void mostrarImagen(String url,ImageView img){

        if(url!=null){
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.img_no_disponible)
                    .error(R.drawable.img_no_disponible)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH);

            Glide.with(getApplicationContext())
                    .load(url)
                    .apply(options)
                    .into(img);
        }
    }

    public String getPrecioFormato(String precio){

        String [] precioTotal= precio.split("\\.");
        String resultado;
        if(precioTotal.length==2){
            String entero= precioTotal[0];
            String decimal= precioTotal[1];
            int size= decimal.length();

            if(size==1){
                decimal= precioTotal[1]+"0";
            }

            resultado= "$ "+Util.formatoMiles(entero)+","+decimal;

        }else{
            resultado= "$ "+Util.formatoMiles(precioTotal[0])+",00";
        }

        return resultado;

    }


}