package com.example.appbandas.repositorios;

import androidx.lifecycle.MutableLiveData;
import com.example.appbandas.modelos.Usuario;
import com.example.appbandas.red.ApiService;
import com.example.appbandas.red.RetrofitCliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Clase encargada de gestionar los datos de los usuarios.
 * Hace la petición a Retrofit y procesa la respuesta antes de enviarla a la pantalla.
 */
public class UsuarioRepositorio {

    private ApiService apiService;

    public UsuarioRepositorio() {
        // Inicializamos la conexión a nuestra API
        apiService = RetrofitCliente.obtenerCliente().create(ApiService.class);
    }

    /**
     * Descarga la lista de usuarios y comprueba si hay coincidencia de email y contraseña.
     */
    public void comprobarLogin(String email, String password, MutableLiveData<Boolean> loginExitoso) {

        // Hacemos la llamada en segundo plano (para no bloquear el móvil)
        apiService.obtenerTodosLosUsuarios().enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    boolean encontrado = false;

                    // Buscamos si el usuario existe en la base de datos
                    for (Usuario u : response.body()) {
                        if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                            encontrado = true;
                            break;
                        }
                    }

                    // Avisamos del resultado (true si acierta, false si falla)
                    loginExitoso.postValue(encontrado);
                } else {
                    loginExitoso.postValue(false);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                // Si el servidor está apagado o no hay internet
                loginExitoso.postValue(false);
            }
        });
    }
}