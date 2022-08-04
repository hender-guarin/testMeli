package com.testmeli.mvp.vista.adaptadores;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.testmeli.mvp.vista.ProductoSeleccionado;
import com.testmeli.mvp.modelo.clases.Producto;
import com.testmeli.R;
import com.testmeli.util.Util;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoHolder> {

    final List<Producto> productos;
    final Context context;
    final ProductoSeleccionado productoSel;

    @NonNull
    @Override
    public ProductoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_list, parent, false));

    }

    public ProductoAdapter(List<Producto> productos, Context ctx, ProductoSeleccionado productoSeleccionado) {
        this.productos = productos;
        this.context=ctx;
        productoSel= productoSeleccionado;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoHolder holder, int position) {

        Producto producto= productos.get(position);

        if(producto.getTitulo()!=null && !producto.getTitulo().isEmpty()){
            holder.tvNombre.setText(producto.getTitulo());
        }

        if(producto.getPrecio()!=null && !producto.getPrecio().isEmpty()){

            String [] precioTotal= producto.getPrecio().split("\\.");
            String resultado;
            if(precioTotal.length==2){
                String entero= precioTotal[0];
                String decimal= precioTotal[1];
                int size= decimal.length();

                if(size==1){
                    decimal= precioTotal[1]+"0";
                }

                resultado= "$ "+ Util.formatoMiles(entero)+","+decimal;

            }else{
                resultado= "$ "+Util.formatoMiles(precioTotal[0])+",00";
            }

            holder.tvPrecio.setText(resultado);

        }

        if(producto.getUnidadesDisponible()!=null && !producto.getUnidadesDisponible().isEmpty()){
            holder.tvUnidadesDisp.setText(producto.getUnidadesDisponible());
        }


       holder.cardDetalle.setOnClickListener(view -> productoSel.getProducto(producto));

       if(producto.getUrlImagen()!=null && !producto.getUrlImagen().isEmpty()){
        RequestOptions options = new RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.img_no_disponible)
        .error(R.drawable.img_no_disponible)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH);

        Glide.with(context)
        .load(producto.getUrlImagen())
        .apply(options)
        .into(holder.imgProducto);

       }



    }

    @Override
    public int getItemCount() {
        return productos.size();
    }


    public static class ProductoHolder extends RecyclerView.ViewHolder {

        private final TextView tvNombre;
        private final TextView tvPrecio;
        private final TextView tvUnidadesDisp;
        private final ImageView imgProducto;
        private final CardView cardDetalle;


        public ProductoHolder(View itemView) {
            super(itemView);
            tvNombre= itemView.findViewById(R.id.tv_nombre);
            tvPrecio=itemView.findViewById(R.id.tv_precio);
            tvUnidadesDisp=itemView.findViewById(R.id.tv_unidades_disp);
            imgProducto= itemView.findViewById(R.id.img_producto);
            cardDetalle=itemView.findViewById(R.id.cardDetalle);

        }


    }

}
