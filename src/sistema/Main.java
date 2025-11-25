package sistema;

import sistema.gui.MainGUI;

/**
 * Clase principal del sistema.
 * Es el punto de entrada de la aplicación y se encarga de iniciar la interfaz
 * gráfica de usuario (GUI).
 *
 * Su única responsabilidad es arrancar el programa y asegurarse de que
 * la ventana principal se ejecute correctamente en el hilo adecuado.
 */
public class Main {
    public static void main(String[] args) {

    // Mensaje informativo para indicar que el sistema está iniciando la GUI.    
        System.out.println("GUI iniciada...");

    /**
         * SwingUtilities.invokeLater():
         * Este método garantiza que la interfaz gráfica se ejecute
         * en el "Event Dispatch Thread" (EDT), que es el hilo especial
         * donde Java maneja todos los elementos gráficos.
         *
         * Esto evita errores de concurrencia y asegura que la GUI
         * funcione de forma correcta y estable.
         *
         * new MainGUI().setVisible(true):
         * - Crea la ventana principal de la aplicación.
         * - Luego la hace visible para el usuario.
         */    
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }
}
