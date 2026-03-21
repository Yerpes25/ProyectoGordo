package appbandas.proyectobanda.vistas.autenticacion;

import appbandas.proyectobanda.ProyectoBanda;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * Controlador de la vista de inicio de sesion. Gestiona la captura de datos del
 * formulario y la conexion manual con el servidor.
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

    private static final String URL_API = "http://localhost:8080/api/usuarios/login";

    /**
     * Metodo principal que se activa al pulsar el boton de inicio de sesion.
     *
     * @param evento Representa la accion del clic del usuario.
     */
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

        /**
         * Se crea un hilo manual tradicional para que la pantalla no se quede
         * congelada mientras espera al servidor.
         */
        Thread hiloConexion = new Thread(new Runnable() {
            @Override
            public void run() {
                realizarPeticionHttp(correo, clave);
            }
        });
        hiloConexion.start();
    }

    /**
     * Se encarga de construir la peticion, enviarla a Spring Boot y procesar la
     * respuesta.
     *
     * @param correo El correo escrito por el usuario.
     * @param clave La contrasena escrita por el usuario.
     */
    private void realizarPeticionHttp(String correo, String clave) {
        try {
            HttpClient cliente = HttpClient.newHttpClient();

            /**
             * Se crea el cuerpo de la peticion en formato JSON de forma manual.
             * Esto es necesario porque las contrasenas deben ir en el cuerpo
             * (body) y no en la URL.
             */
            String cuerpoPeticionJson = "{\"correo\":\"" + correo + "\",\"clave\":\"" + clave + "\"}";
            /**
             * Se construye la peticion indicando en la cabecera que enviamos un
             * JSON.
             */
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(cuerpoPeticionJson))
                    .build();

            // Peticion tradicional que espera la respuesta
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            /**
             * Imprimimos por consola la respuesta del servidor para facilitar
             * la depuracion. Nos indicara el codigo de estado (ej: 200, 401,
             * 403, 500) y el texto que envia Spring Boot.
             */
            System.out.println("--- RESPUESTA DEL SERVIDOR ---");
            System.out.println("Codigo de estado: " + respuesta.statusCode());
            System.out.println("Cuerpo de la respuesta: " + respuesta.body());
            System.out.println("------------------------------");

            /**
             * Platform.runLater es obligatorio para cambiar textos o pantallas
             * en JavaFX cuando estamos dentro de un hilo secundario.
             */
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    botonIniciarSesion.setDisable(false);

                    if (respuesta.statusCode() == 200) {
                        String cuerpoRespuesta = respuesta.body();

                        if (cuerpoRespuesta.contains("\"rolApp\":\"Dueño\"") || cuerpoRespuesta.contains("\"rolApp\":\"Administrador\"")) {
                            try {
                                /**
                                 * Se cambia el punto por una barra en la ruta
                                 * para que JavaFX encuentre correctamente el
                                 * directorio de la vista.
                                 */
                                ProyectoBanda.setRoot("/vistas.principal/dashboard", 1100, 700, "Dashboard - Dueño de Banda");
                            } catch (Exception excepcion) {
                                excepcion.printStackTrace();
                                mostrarMensaje("Error cargando el panel principal.", true);
                            }
                        } else {
                            mostrarMensaje("Error: Acceso denegado por nivel de permisos.", true);
                        }
                    } else {
                        mostrarMensaje("Credenciales incorrectas.", true);
                    }
                }
            });

        } catch (Exception excepcion) {
            /**
             * Manejo de errores de conexion de forma clasica.
             */
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    botonIniciarSesion.setDisable(false);
                    mostrarMensaje("Error de conexion con el servidor.", true);
                    excepcion.printStackTrace();
                }
            });
        }
    }

    /**
     * Muestra mensajes en la pantalla cambiando el color segun si es un error o
     * no.
     *
     * @param mensaje El texto que va a ver el usuario.
     * @param esError Verdadero para pintar el texto de rojo, falso para
     * pintarlo de verde.
     */
    private void mostrarMensaje(String mensaje, boolean esError) {
        textoMensaje.setText(mensaje);
        if (esError) {
            textoMensaje.setTextFill(Color.web("#D32F2F"));
        } else {
            textoMensaje.setTextFill(Color.web("#4CAF50"));
        }
    }
}
