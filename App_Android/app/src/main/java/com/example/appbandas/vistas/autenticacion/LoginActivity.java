package com.example.appbandas.vistas.autenticacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.appbandas.R;
import com.example.appbandas.modelosvista.autenticacion.LoginViewModel;
import com.example.appbandas.utilidades.GestorSesion;
import com.example.appbandas.vistas.comun.MenuPrincipalActivity;

/**
 * Pantalla principal de inicio de sesion de la aplicacion.
 * Verifica si el usuario ya tiene sesion guardada para omitir la conexion a la base de datos,
 * o solicita las credenciales para un nuevo acceso.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText cajaTextoEmail;
    private EditText cajaTextoClave;
    private Button botonEntrar;
    private LoginViewModel loginViewModel;
    private GestorSesion gestorSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gestorSesion = new GestorSesion(this);

        if (gestorSesion.estaLogueado()) {
            Intent intencion = new Intent(LoginActivity.this, MenuPrincipalActivity.class);
            startActivity(intencion);
            finish();
            return;
        }

        setContentView(R.layout.activity_login);

        cajaTextoEmail = findViewById(R.id.cajaTextoEmail);
        cajaTextoClave = findViewById(R.id.cajaTextoClave);
        botonEntrar = findViewById(R.id.botonEntrar);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        loginViewModel.getLoginResultado().observe(this, exito -> {
            if (exito) {
                gestorSesion.guardarUsuarioLogueado(true);
                Intent intencion = new Intent(LoginActivity.this, MenuPrincipalActivity.class);
                startActivity(intencion);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Error: Email o contraseña incorrectos", Toast.LENGTH_LONG).show();
            }
        });

        botonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = cajaTextoEmail.getText().toString();
                String clave = cajaTextoClave.getText().toString();

                if (email.isEmpty() || clave.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Comprobando datos...", Toast.LENGTH_SHORT).show();
                    loginViewModel.hacerLogin(email, clave);
                }
            }
        });
    }
}