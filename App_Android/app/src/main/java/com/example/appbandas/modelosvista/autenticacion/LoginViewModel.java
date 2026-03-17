package com.example.appbandas.modelosvista.autenticacion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.appbandas.repositorios.usuarios.UsuarioRepositorio;

/**
 * El cerebro de la pantalla de Login.
 * Se comunica con el Repositorio y guarda el estado para que no se pierda si giramos el móvil.
 */
public class LoginViewModel extends ViewModel {

    private UsuarioRepositorio repositorio;
    // LiveData es como un altavoz: la pantalla se suscribirá a él para escuchar cuándo el login termina.
    private MutableLiveData<Boolean> loginResultado;

    public LoginViewModel() {
        repositorio = new UsuarioRepositorio();
        loginResultado = new MutableLiveData<>();
    }

    // Método que la pantalla usará para quedarse "escuchando"
    public LiveData<Boolean> getLoginResultado() {
        return loginResultado;
    }

    // Método que la pantalla llamará cuando el usuario pulse el botón "Entrar"
    public void hacerLogin(String email, String password) {
        repositorio.comprobarLogin(email, password, loginResultado);
    }
}