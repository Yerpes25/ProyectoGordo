package com.example.appbandas.vistas.autenticacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appbandas.R;

/**
 * Pantalla inicial de bienvenida a la aplicacion.
 * Permite al usuario elegir entre registrar una nueva agrupacion musical
 * o buscar una existente mediante su CIF para iniciar sesion o registrarse.
 */
public class BienvenidaActivity extends AppCompatActivity {

    private Button botonCrearBanda;
    private Button botonTengoBanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        botonCrearBanda = findViewById(R.id.botonCrearBanda);
        botonTengoBanda = findViewById(R.id.botonTengoBanda);

        // Si el usuario quiere fundar una nueva banda en la app
        botonCrearBanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(BienvenidaActivity.this, CrearBandaActivity.class);
                startActivity(intencion);
            }
        });

        // Si el usuario ya pertenece a una banda y quiere buscarla
        botonTengoBanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(BienvenidaActivity.this, BuscarBandaActivity.class);
                startActivity(intencion);
            }
        });
    }
}