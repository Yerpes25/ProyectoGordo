package appbandas.proyectobanda.vistas.principal;

import appbandas.proyectobanda.ProyectoBanda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Controlador principal del panel de administracion (Dashboard).
 * Gestiona el menu lateral y la navegacion entre las diferentes
 * secciones de gestion de la banda (usuarios, inventario, eventos).
 */
public class DashboardControlador {

    @FXML
    private BorderPane panelPrincipal;
    
    @FXML
    private Label textoBienvenida;

    /**
     * Metodo que se ejecuta automaticamente al cargar la pantalla.
     * Sirve para inicializar los textos o cargar datos previos.
     */
    @FXML
    public void initialize() {
        textoBienvenida.setText("Bienvenido al Panel de Control de tu Banda");
    }

    /**
     * Accion que se lanza al pulsar el boton de Cerrar Sesion.
     * Devuelve al usuario a la pantalla de Login y ajusta el tamano de la ventana.
     * * @param evento Representa el clic del usuario en el boton.
     */
    @FXML
    public void manejarCerrarSesion(ActionEvent evento) {
        try {
            // Usamos el metodo de la clase principal para cambiar de vista de forma sencilla
            ProyectoBanda.setRoot("/vistas.autenticacion/login", 800, 600, "Panel de Control - App Bandas");
        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
    }
}