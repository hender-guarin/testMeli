package com.testmeli.MVP.modelo.Repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testmeli.Endpoint.Endpoint;
import com.testmeli.MVP.modelo.Clases.Atributo;
import com.testmeli.MVP.modelo.Clases.Direccion;
import com.testmeli.MVP.modelo.Clases.Producto;
import com.testmeli.MVP.presentador.PresentadorProducto;
import com.testmeli.R;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryProductoWeb implements  RepositoryProducto{

    Context context;
    PresentadorProducto presentadorProducto;

    public RepositoryProductoWeb(Context context, PresentadorProducto presentadorProducto) {
        this.context = context;
        this.presentadorProducto = presentadorProducto;
    }

    @Override
    public void getProductos(String info) {

        List<Producto> productos=new ArrayList<>();

        if (!verificarConexion()) {
            presentadorProducto.showErrorMessageDialog(R.string.Error,"Sin conexión a internet");
        }
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoint.URL_BASE+info;

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,url,null, response -> {


            Gson gson = new GsonBuilder().create();

            try {
                JSONArray obj= response.getJSONArray("results");

                for(int i=0;i<obj.length();i++){
                    JSONObject json= obj.getJSONObject(i);
                    String titulo= json.getString("title");
                    double precio= json.getDouble("price");
                    int cantidadDisp= json.getInt("available_quantity");
                    int cantidadesVendidas=json.getInt("sold_quantity");
                    String urlImagen= json.getString("thumbnail");
                    Direccion direccion = gson.fromJson(json.getString("address"), Direccion.class);

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
            public Map<String, String> getHeaders() throws AuthFailureError {
                return new HashMap<>();
            }
        };
        queue.add(jsonObjectRequest);



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
