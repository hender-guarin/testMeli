package com.testmeli.MVP.vista.adaptadores;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.testmeli.MVP.modelo.Clases.Atributo;
import com.testmeli.MVP.modelo.Clases.Producto;
import com.testmeli.R;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoHolder> {

    List<Producto> productos;
    Context context;

    @NonNull
    @Override
    public ProductoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_list, parent, false));

    }

    public ProductoAdapter(List<Producto> productos,Context ctx) {
        this.productos = productos;
        this.context=ctx;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoHolder holder, int position) {

        Producto producto= productos.get(position);
        String ubicacionProducto="";
        StringBuilder attrib= new StringBuilder();

        StringBuilder aux= new StringBuilder();

        if(producto.getTitulo()!=null && !producto.getTitulo().isEmpty()){
            holder.tvNombre.setText(producto.getTitulo());
        }

        if(producto.getPrecio()!=null && !producto.getPrecio().isEmpty()){
            holder.tvPrecio.setText(producto.getPrecio());
        }

        if(producto.getCantidadesDisponibles()!=null && !producto.getCantidadesDisponibles().isEmpty()){
            holder.tvUnidadesDisp.setText(producto.getCantidadesDisponibles());
        }

        if(producto.getCantidadesVendidas()!=null && !producto.getCantidadesVendidas().isEmpty()){
            holder.tvUnidadesVendidas.setText(producto.getCantidadesVendidas());
        }

        if(producto.getAtributos()!=null && producto.getAtributos().size()>0){

            List <Atributo> atributos= producto.getAtributos();

            for(int i=0;i<atributos.size();i++){

                if(atributos.get(i).getNombre()!=null && !atributos.get(i).getNombre().isEmpty()){
                    aux.append(atributos.get(i).getNombre());
                }

                if(atributos.get(i).getValor()!=null && !atributos.get(i).getValor().isEmpty()){
                   aux.append(":  ").append(atributos.get(i).getValor());
                }

                if(i!=(atributos.size()-1)){
                    aux.append("\n");
                }

                attrib.append(aux);
                aux = new StringBuilder();
            }

            holder.tvAtributo.setText(attrib.toString());

        }

        if(producto.getDireccion()!=null){

            if(producto.getDireccion().getCity_name()!=null && producto.getDireccion().getCity_name()!=null){
                ubicacionProducto+=producto.getDireccion().getCity_name()+ ", ";
            }
            if(producto.getDireccion().getState_name()!=null && producto.getDireccion().getState_name()!=null){
                ubicacionProducto+=producto.getDireccion().getState_name();
            }

            holder.tvCiudad.setText(ubicacionProducto);

        }


       holder.imgVerMenos.setOnClickListener(view -> {
           holder.ly_mas.setVisibility(View.GONE);
           holder.lyverMas.setVisibility(View.VISIBLE);
       });


       holder.imgVerMas.setOnClickListener(view -> {
           holder.lyverMas.setVisibility(View.GONE);
           holder.ly_mas.setVisibility(View.VISIBLE);
       });

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
        private final LinearLayout lyverMas;
        private final ImageView imgVerMas;
        private final LinearLayout ly_mas;
        private final TextView tvUnidadesVendidas;
        private final TextView tvAtributo;
        private final TextView tvCiudad;
        private final ImageView imgVerMenos;
        private final ImageView imgProducto;


        public ProductoHolder(View itemView) {
            super(itemView);
            tvNombre= itemView.findViewById(R.id.tv_nombre);
            tvPrecio=itemView.findViewById(R.id.tv_precio);
            tvUnidadesDisp=itemView.findViewById(R.id.tv_unidades_disp);
            lyverMas= itemView.findViewById(R.id.ly_ver_mas);
            imgVerMas=itemView.findViewById(R.id.img_ver_mas);
            ly_mas= itemView.findViewById(R.id.ly_mas);
            tvUnidadesVendidas=itemView.findViewById(R.id.tv_unidades_vendidas);
            tvAtributo=itemView.findViewById(R.id.tv_atributo);
            tvCiudad=itemView.findViewById(R.id.tv_ubicacion);
            imgVerMenos= itemView.findViewById(R.id.img_ver_menos);
            imgProducto= itemView.findViewById(R.id.img_producto);

        }


    }

}
