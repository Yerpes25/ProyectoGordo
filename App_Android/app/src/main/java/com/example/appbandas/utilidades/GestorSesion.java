package com.example.appbandas.utilidades;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Clase encargada de gestionar la sesion del usuario de forma local.
 * Utiliza SharedPreferences para guardar y recuperar el estado de acceso,
 * permitiendo entrar a la aplicacion sin consultar a la base de datos cada vez.
 */
public class GestorSesion {

    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;

    public GestorSesion(Context contexto) {
        preferencias = contexto.getSharedPreferences("SesionAppBandas", Context.MODE_PRIVATE);
        editor = preferencias.edit();
    }

    public void guardarUsuarioLogueado(boolean estado) {
        editor.putBoolean("estaLogueado", estado);
        editor.apply();
    }

    public boolean estaLogueado() {
        return preferencias.getBoolean("estaLogueado", false);
    }
}