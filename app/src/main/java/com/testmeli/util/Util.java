package com.testmeli.util;

import static android.content.Context.INPUT_METHOD_SERVICE;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Util {

    public static void ocultarTeclado (Context context, EditText editText) {
        editText.clearFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static String formatoMiles(String cadena) {
        int i, k = 0;
        int j = 0;
        int tam;

        tam = cadena.length();

        byte[] cadena_orig = cadena.getBytes();
        byte[] cad_destino = new byte[50];

        i = tam / 3;                                                            // Calc�lo la cantidad de puntos de mil que se van a agregar
        if (i * 3 == tam) i--;

        for (j = tam - 1; j >= 0; j--) {
            cad_destino[j + i] = cadena_orig[j];
            k++;
            if ((k / 3) * 3 == k) {
                i--;

                if ((j + i) > 0)
                    cad_destino[j + i] = '.';
            }
        }

        return new String(cad_destino, 0,sizeCadena(cad_destino));
    }


    public static int sizeCadena(byte [] Buffer) {
        int i;

        for(i=0; i<Buffer.length; i++){
            if(Buffer[i] == 0x00)
                break;
        }

        return i;
    }






}
