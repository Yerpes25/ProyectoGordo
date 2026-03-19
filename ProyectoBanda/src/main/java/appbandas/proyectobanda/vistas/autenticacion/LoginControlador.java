/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbandas.proyectobanda.vistas.autenticacion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author Usuario
 */
public class LoginControlador {

    @FXML
    private TextField cajaTextoEmail;
    @FXML
    private PasswordField cajaTextoClave;
    @FXML
    private Button botonIniciarSesion;
    @FXML
    private Label textoMensaje;

    private static final String URL_API = "http://localhost:8080/usuarios/login";

    @FXML
    public void manejarLogin(ActionEvent evento) {
        String correo = cajaTextoEmail.getText().trim();
        String clave = cajaTextoClave.getText().trim();

        if (correo.isEmpty() || clave.isEmpty()) {
            mostrarMensaje("Por favor, rellena todos los campos.", true);
            return;
        }

        mostrarMensaje("Conectando con el servidor...", false);
        botonIniciarSesion.setDisable(true);

        HttpClient cliente = HttpClient.newHttpClient();
        String urlPeticion = URL_API + "?email=" + correo + "&password=" + clave;

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(urlPeticion))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        cliente.sendAsync(peticion, HttpResponse.BodyHandlers.ofString())
                .thenAccept(respuesta -> {
                    javafx.application.Platform.runLater(() -> {
                        botonIniciarSesion.setDisable(false);
                        if (respuesta.statusCode() == 200) {
                            String cuerpoRespuesta = respuesta.body();
                            if (cuerpoRespuesta.contains("\"rolApp\":\"Dueño\"") || cuerpoRespuesta.contains("\"rolApp\":\"Administrador\"")) {
                                mostrarMensaje("¡Acceso concedido!", false);
                            } else {
                                mostrarMensaje("Error: Acceso denegado por nivel de permisos.", true);
                            }
                        } else {
                            mostrarMensaje("Credenciales incorrectas.", true);
                        }
                    });
                })
                .exceptionally(error -> {
                    javafx.application.Platform.runLater(() -> {
                        botonIniciarSesion.setDisable(false);
                        mostrarMensaje("Error de conexion.", true);
                    });
                    return null;
                });
    }

    private void mostrarMensaje(String mensaje, boolean esError) {
        textoMensaje.setText(mensaje);
        if (esError) {
            textoMensaje.setTextFill(Color.web("#D32F2F"));
        } else {
            textoMensaje.setTextFill(Color.web("#4CAF50"));
        }
    }
}
