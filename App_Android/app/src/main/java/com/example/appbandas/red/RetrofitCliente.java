package com.example.appbandas.red;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Clase encargada de configurar y proporcionar la conexión a internet
 * con nuestro servidor local (Spring Boot) utilizando la librería Retrofit.
 * Utiliza el patrón Singleton para no saturar la memoria creando múltiples conexiones.
 */
public class RetrofitCliente {
    private static final String URL_BASE = "http://192.168.1.76:8080/api/";
    private static Retrofit retrofit = null;

    public static Retrofit obtenerCliente() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit obtenerInstancia() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}