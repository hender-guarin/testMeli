package com.testmeli.MVP.presentador;

public interface PresentadorGeneral {

    void showErrorMessageDialog(int titulo, int mensaje);

    void showErrorMessageDialog(int titulo, String mensaje);

    void cancelarDialogoCargando();
}
