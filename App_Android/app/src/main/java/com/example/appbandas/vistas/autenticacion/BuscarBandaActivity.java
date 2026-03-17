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
 * Actividad encargada de buscar una banda en el servidor mediante su CIF.
 * Si la banda existe, permitira al usuario continuar hacia la pantalla
 * de inicio de sesion o registro vinculandose a dicha institucion.
 */
public class BuscarBandaActivity extends AppCompatActivity {

    private EditText cajaTextoBuscadorCif;
    private Button botonBuscarCif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_banda);

        cajaTextoBuscadorCif = findViewById(R.id.cajaTextoBuscadorCif);
        botonBuscarCif = findViewById(R.id.botonBuscarCif);

        botonBuscarCif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cif = cajaTextoBuscadorCif.getText().toString().trim();

                if (cif.isEmpty()) {
                    Toast.makeText(BuscarBandaActivity.this, "Por favor, introduce el CIF", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Preparamos la peticion al servidor para buscar por CIF
                ApiService api = RetrofitCliente.obtenerInstancia().create(ApiService.class);
                Call<Banda> peticion = api.buscarBandaPorCif(cif);

                // Ejecutamos la busqueda en segundo plano
                peticion.enqueue(new Callback<Banda>() {
                    @Override
                    public void onResponse(Call<Banda> call, Response<Banda> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Banda bandaEncontrada = response.body();
                            Toast.makeText(BuscarBandaActivity.this,
                                    "¡Banda encontrada!: " + bandaEncontrada.getNombre(),
                                    Toast.LENGTH_LONG).show();

                            // AQUI IRIA EL CODIGO PARA PASAR A LA PANTALLA DE LOGIN/REGISTRO

                        } else {
                            // Si el servidor devuelve un error 404 (No encontrado)
                            Toast.makeText(BuscarBandaActivity.this,
                                    "No se ha encontrado ninguna banda con ese CIF",
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Banda> call, Throwable t) {
                        Toast.makeText(BuscarBandaActivity.this,
                                "Error de conexión: " + t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}