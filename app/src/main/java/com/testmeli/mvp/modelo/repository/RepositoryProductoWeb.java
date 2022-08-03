package com.testmeli.mvp.modelo.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.testmeli.endpoint.Endpoint;
import com.testmeli.mvp.modelo.clases.Atributo;
import com.testmeli.mvp.modelo.clases.Direccion;
import com.testmeli.mvp.modelo.clases.Producto;
import com.testmeli.mvp.presentador.PresentadorProducto;
import com.testmeli.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryProductoWeb {

    final Context context;
    final PresentadorProducto presentadorProducto;

    public RepositoryProductoWeb(Context context, PresentadorProducto presentadorProducto) {
        this.context = context;
        this.presentadorProducto = presentadorProducto;
    }

    public void getProductos(String info) {

        List<Producto> productos=new ArrayList<>();

        if (!verificarConexion()) {
            presentadorProducto.showErrorMessageDialog(R.string.Error,"Sin conexión a internet");
        }
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoint.URL_BASE+info;

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,url,null, response -> {



            try {
                JSONArray obj= response.getJSONArray("results");

                for(int i=0;i<obj.length();i++){
                    JSONObject json= obj.getJSONObject(i);
                    String titulo= json.getString("title");
                    double precio= json.getDouble("price");
                    int cantidadDisp= json.getInt("available_quantity");
                    int cantidadesVendidas=json.getInt("sold_quantity");
                    String urlImagen= json.getString("thumbnail");
                    JSONObject jsonObject=json.getJSONObject("address");
                    String estado= jsonObject.getString("state_name");
                    String ciudad=jsonObject.getString("city_name");
                    Direccion direccion = new Direccion(estado,ciudad);

                    JSONArray jsonArray= json.getJSONArray("attributes");
                    List<Atributo> atributos = new ArrayList<>();

                    for(int j=0;j<jsonArray.length();j++){

                        String nombre= jsonArray.getJSONObject(j).getString("name");
                        String valor= jsonArray.getJSONObject(j).getString("value_name");
                        Atributo atributo= new Atributo(nombre,valor);

                        atributos.add(atributo);
                    }
                    Producto producto= new Producto(titulo,String.valueOf(precio),String.valueOf(cantidadDisp),String.valueOf(cantidadesVendidas),urlImagen,direccion,atributos);
                    productos.add(producto);
                }


           } catch (Exception e) {

               e.printStackTrace();
            }

            presentadorProducto.mostrarProducto(productos);


        }, error -> {
            presentadorProducto.cancelarDialogoCargando();
            presentadorProducto.showErrorMessageDialog(R.string.informacion, R.string.error_servidor);
        }) {
            @Override
            public Map<String, String> getHeaders() {
                return new HashMap<>();
            }
        };
        queue.add(jsonObjectRequest);



    }

    private boolean verificarConexion() {
     ConnectivityManager con = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
     NetworkInfo networkInfo = con.getActiveNetworkInfo();
     return networkInfo != null && networkInfo.isConnected();
    }
}
