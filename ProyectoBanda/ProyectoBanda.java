/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package appbandas.proyectobanda;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * @author Yerpes
 */
public class ProyectoBanda extends Application {

    private static Scene scene;
    private static Stage escenarioPrincipal; // Guardamos el stage para poder redimensionar la ventana luego

    public static void main(String[] args) {
       launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        escenarioPrincipal = stage;
        // Ponemos la ruta exacta a la carpeta de resources
        scene = new Scene(loadFXML("/vistas.autenticacion/login"));
        
        stage.setTitle("Panel de Control - App Bandas");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Metodo que se usa para lanzar la escena por pantalla
     */
    public static Parent loadFXML(String fxml) throws IOException {
        // El '/' inicial le dice que busque directamente en la carpeta resources
        FXMLLoader fxmlLoader = new FXMLLoader(ProyectoBanda.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /**
     * Metodo para cambiar la escena actual (Útil para ir al Dashboard)
     */
    public static void setRoot(String fxml, int ancho, int alto, String titulo) throws IOException {
        scene.setRoot(loadFXML(fxml));
        escenarioPrincipal.setWidth(ancho);
        escenarioPrincipal.setHeight(alto);
        escenarioPrincipal.setTitle(titulo);
        escenarioPrincipal.centerOnScreen();
    }
    
    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}