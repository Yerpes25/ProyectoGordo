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
 *
 * @author Yerpes
 */
public class ProyectoBanda extends Application{

    private static Scene scene;

    public static void main(String[] args) {
       launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("login"));
        //scene.getStylesheets().add(getClass().getResource("assets/css/style.css").toExternalForm());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Metodo que se usa para lanzar la escena por pantalla
     *
     * @param fxml Se recibe el fxml de la escena que va a salir
     * @return Devuelve la escena ya cargada
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProyectoBanda.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /**
     * Metodo para cargar las escenas nuevas
     *
     * @param fxml Se pasa el archivo de la escena
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    /**
     * Metodo para usar las alertas y no tener que declararlas siempre en todas
     * las clases
     *
     * @param title Recibimos el titulo de la alerta
     * @param message Recibimos el mensaje de la alerta
     * @param type Recibimos el tipo de la alerta
     */
    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
