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
import com.testmeli.MVP.modelo.Clases.Producto;
import com.testmeli.MVP.presentador.PresentadorProducto;
import com.testmeli.R;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryProductoWeb implements  RepositoryProducto{

    Context context;
    PresentadorProducto presentadorProducto;
    List<Producto> productos=new ArrayList<>();


    public RepositoryProductoWeb(Context context, PresentadorProducto presentadorProducto) {
        this.context = context;
        this.presentadorProducto = presentadorProducto;
    }

    @Override
    public void getProductos(String info) {

        if (!verificarConexion()) {
            presentadorProducto.showErrorMessageDialog(R.string.Error,"Sin conexión a internet");
        }
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoint.URL_BASE+info;

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,url,null, response -> {
            Log.d("Respuesta servicio POST", response.toString());
            Gson gson = new GsonBuilder().create();

            List<Producto> productos = new ArrayList<>();

            System.out.println("respuesta --> "+response.toString());

            /*

            for (int i =0; i<response.length(); i++){
                try {
                    postUserList.add(gson.fromJson(response.getJSONObject(i).toString(), PostUser.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            */


            //presenterUser.showAllPostWeb(postUserList);



        }, error -> {
            Log.d("Error", error.toString());
            //presenterUser.showErrorMessageDialog(R.string.informacion, R.string.error_servidor);
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
