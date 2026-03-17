package com.example.appbandas.red;

import com.example.appbandas.modelos.institucion.Banda;
import com.example.appbandas.modelos.usuarios.Usuario;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Interfaz que define las rutas exactas de nuestra API (Spring Boot).
 * Retrofit leerá estas anotaciones para saber a qué URL tiene que hacer las peticiones HTTP.
 */
public interface ApiService {

    // Llama a http://10.0.2.2:8080/api/usuarios
    @GET("usuarios")
    Call<List<Usuario>> obtenerTodosLosUsuarios();

    @POST("/api/bandas")
    Call<Banda> crearBanda(@Body Banda bandaNueva);

    @GET("/api/bandas/cif/{cif}")
    Call<Banda> buscarBandaPorCif(@Path("cif") String cif);
}