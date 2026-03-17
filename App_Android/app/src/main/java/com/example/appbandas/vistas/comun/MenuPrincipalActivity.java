package com.example.appbandas.vistas.comun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appbandas.R;
import com.example.appbandas.utilidades.GestorSesion;
import com.example.appbandas.vistas.autenticacion.LoginActivity;

/**
 * Pantalla principal del menu de la aplicacion con estilo Material 3 moderno.
 * Muestra las secciones principales (Anuncios, Eventos, Musica) en tarjetas
 * flotantes con iconos azules y permite la navegacion hacia ellas.
 */
public class MenuPrincipalActivity extends AppCompatActivity {

    private TextView textoNombreUsuario;
    private TextView textoInstrumentoUsuario;
    private LinearLayout opcionTablon;
    private LinearLayout opcionEventos;
    private LinearLayout opcionMusica;
    private LinearLayout opcionPerfil;
    private GestorSesion gestorSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        gestorSesion = new GestorSesion(this);

        textoNombreUsuario = findViewById(R.id.textoNombreUsuario);
        textoInstrumentoUsuario = findViewById(R.id.textoInstrumentoUsuario);
        opcionTablon = findViewById(R.id.opcionTablon);
        opcionEventos = findViewById(R.id.opcionEventos);
        opcionMusica = findViewById(R.id.opcionMusica);
        opcionPerfil = findViewById(R.id.opcionPerfil);

        // De momento ponemos datos de ejemplo estilo tu foto
        textoNombreUsuario.setText("Ana Ramos");
        textoInstrumentoUsuario.setText("Clarinete Principal");

        opcionTablon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuPrincipalActivity.this, "Abriendo Tablón de Anuncios...", Toast.LENGTH_SHORT).show();
            }
        });

        opcionEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuPrincipalActivity.this, "Abriendo Eventos...", Toast.LENGTH_SHORT).show();
            }
        });

        opcionMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuPrincipalActivity.this, "Abriendo Mi Repertorio...", Toast.LENGTH_SHORT).show();
            }
        });

        // La opcion de Perfil la usaremos de momento para Cerrar Sesión
        opcionPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gestorSesion.guardarUsuarioLogueado(false);
                Intent intencion = new Intent(MenuPrincipalActivity.this, LoginActivity.class);
                startActivity(intencion);
                finish();
                Toast.makeText(MenuPrincipalActivity.this, "Sesión cerrada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}