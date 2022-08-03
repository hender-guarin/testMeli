package com.testmeli.util;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


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

        return new String(cadenaDestino, 0,sizeCadena(cadenaDestino));
    }


    public static int sizeCadena(byte [] buffer) {
        int i;

        for(i=0; i<buffer.length; i++){
            if(buffer[i] == 0x00)
                break;
        }

        return i;
    }






}
