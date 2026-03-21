package appbandas.proyectobanda;

/**
 * Clase puente para esquivar el error de modulos de JavaFX.
 * Como esta clase NO usa "extends Application", Java arranca sin problemas,
 * carga las librerias en memoria y luego lanza nuestra clase principal real.
 */
public class Launcher {
    
    public static void main(String[] args) {
        // Llamamos al main de nuestra aplicacion real
        ProyectoBanda.main(args);
    }
}