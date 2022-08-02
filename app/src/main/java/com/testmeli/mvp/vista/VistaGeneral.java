package com.testmeli.mvp.vista;

public interface VistaGeneral {

    void showAlertDialogInf(int titulo, int mensaje);

    void showAlertDialogInf(int titulo, String mensaje);

    void showDialogCargando(int titulo, int mensaje);

    void cancelDialogCargando();
}
