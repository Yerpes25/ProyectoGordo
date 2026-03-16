package com.example.appbandas.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appbandas.R;
import com.example.appbandas.utilidades.GestorSesion;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

/**
 * Pantalla del menu principal de la aplicacion con diseno moderno.
 * Incorpora una barra de navegacion inferior para cambiar secciones
 * y permite cerrar la sesion desde el perfil.
 */
public class MenuPrincipalActivity extends AppCompatActivity {

    private BottomNavigationView barraNavegacion;
    private GestorSesion gestorSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        gestorSesion = new GestorSesion(this);
        barraNavegacion = findViewById(R.id.barraNavegacionInferior);

        barraNavegacion.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_inicio) {
                    Toast.makeText(MenuPrincipalActivity.this, "Cargando Inicio...", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.nav_eventos) {
                    Toast.makeText(MenuPrincipalActivity.this, "Cargando Eventos...", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.nav_musica) {
                    Toast.makeText(MenuPrincipalActivity.this, "Cargando Música...", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.nav_perfil) {
                    gestorSesion.guardarUsuarioLogueado(false);
                    Intent intencion = new Intent(MenuPrincipalActivity.this, LoginActivity.class);
                    startActivity(intencion);
                    finish();
                    return true;
                }

                return false;
            }
        });
    }
}