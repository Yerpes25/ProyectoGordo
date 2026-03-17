package com.example.appbandas.vistas.autenticacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbandas.R;
import com.example.appbandas.modelos.institucion.Banda;
import com.example.appbandas.red.ApiService;
import com.example.appbandas.red.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Actividad encargada de mostrar el formulario de registro para una nueva banda.
 * Recoge los datos fundamentales como el nombre, el CIF y el color corporativo,
 * y los envia al servidor mediante Retrofit para su almacenamiento.
 */
public class CrearBandaActivity extends AppCompatActivity {

    private EditText cajaTextoNombreBanda;
    private EditText cajaTextoCif;
    private EditText cajaTextoColor;
    private Button botonPagarRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_banda);

        cajaTextoNombreBanda = findViewById(R.id.cajaTextoNombreBanda);
        cajaTextoCif = findViewById(R.id.cajaTextoCif);
        cajaTextoColor = findViewById(R.id.cajaTextoColor);
        botonPagarRegistrar = findViewById(R.id.botonPagarRegistrar);

        botonPagarRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = cajaTextoNombreBanda.getText().toString();
                String cif = cajaTextoCif.getText().toString();
                String color = cajaTextoColor.getText().toString();

                if (nombre.isEmpty() || cif.isEmpty() || color.isEmpty()) {
                    Toast.makeText(CrearBandaActivity.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Creamos el objeto con los datos introducidos
                Banda nuevaBanda = new Banda(nombre, cif, color);

                // Preparamos la peticion al servidor
                ApiService api = RetrofitCliente.obtenerInstancia().create(ApiService.class);
                Call<Banda> peticion = api.crearBanda(nuevaBanda);

                // Ejecutamos la peticion en segundo plano
                peticion.enqueue(new Callback<Banda>() {
                    @Override
                    public void onResponse(Call<Banda> call, Response<Banda> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(CrearBandaActivity.this, "¡Banda registrada con éxito!", Toast.LENGTH_LONG).show();
                            finish(); // Cierra el formulario y vuelve a la pantalla de bienvenida
                        } else {
                            Toast.makeText(CrearBandaActivity.this, "Error al registrar la banda", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Banda> call, Throwable t) {
                        Toast.makeText(CrearBandaActivity.this, "Fallo de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}