package com.testmeli.mvp.modelo.repository;
import static com.testmeli.util.Util.convertiJson;
import static com.testmeli.util.Util.verificarConexion;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.testmeli.endpoint.Endpoint;
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

        if (!verificarConexion(context)) {
            presentadorProducto.showErrorMessageDialog(R.string.Error,"Sin conexión a internet");
            return;
        }
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = Endpoint.URL_BASE+info;

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,url,
                null, response -> {
            try {
                JSONArray obj= response.getJSONArray("results");
                for(int i=0;i<obj.length();i++){
                    JSONObject json= obj.getJSONObject(i);
                    Producto producto= convertiJson(String.valueOf(json));
                    if(producto!=null){
                        productos.add(producto);
                    }
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

}
