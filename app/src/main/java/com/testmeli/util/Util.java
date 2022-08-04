package com.testmeli.util;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testmeli.mvp.modelo.clases.Producto;


public class Util {

    public static void ocultarTeclado (Context context, EditText editText) {
     editText.clearFocus();
     InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
     imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private  Util() {
    }

    public static String formatoMiles(String cadena) {
        int i;
        int k = 0;
        int j;
        int tam;

        tam = cadena.length();

        byte[] cadenaOrigen = cadena.getBytes();
        byte[] cadenaDestino = new byte[50];

        i = tam / 3;                                                            // Calc�lo la cantidad de puntos de mil que se van a agregar
        if (i * 3 == tam) i--;

        for (j = tam - 1; j >= 0; j--) {
            cadenaDestino[j + i] = cadenaOrigen[j];
            k++;
            if ((k / 3) * 3 == k) {
                i--;

                if ((j + i) > 0)
                    cadenaDestino[j + i] = '.';
            }
        }

        return new String(cadenaDestino, 0,tamanoCadena(cadenaDestino));
    }


    public static int tamanoCadena(byte [] buffer) {
        int i;
        for(i=0; i<buffer.length; i++){
            if(buffer[i] == 0x00)
                break;
        }
        return i;
    }

    public static Producto convertiJson(String datos){
        System.out.println("datos  "+datos);
        Gson gson = new GsonBuilder().create();
        try{
            return gson.fromJson(datos,Producto.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean verificarConexion(Context context) {
        ConnectivityManager con = (ConnectivityManager) context.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = con.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static String remplazarCaracteresEspeciales(String info){

        String rta=info;
        rta=rta.replace(" ","%20");
        rta=rta.replace("?","%20");
        rta=rta.replace("¿","%20");
        rta=rta.replace("¡","%20");
        rta=rta.replace("!","%20");
        rta=rta.replace("ñ","n");
        rta=rta.replace("Ñ","N");
        rta=rta.replace("Á","A");
        rta=rta.replace("É","E");
        rta=rta.replace("Í","I");
        rta=rta.replace("Ó","O");
        rta=rta.replace("Ú","U");
        rta=rta.replace("á","a");
        rta=rta.replace("é","e");
        rta=rta.replace("í","i");
        rta=rta.replace("ó","o");
        rta=rta.replace("ú","u");
        return rta;

    }






}
