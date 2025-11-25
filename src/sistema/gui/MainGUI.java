package sistema.gui;

import javax.swing.*;
import sistema.services.SistemaLecturas;

/**
 * Clase principal de la interfaz gráfica del sistema.
 * Extiende JFrame para crear la ventana principal de la aplicación.
 */
public class MainGUI extends JFrame {

/**
     * Objeto del sistema encargado de gestionar contadores, lecturas y cálculos.
     * Se crea una única instancia para compartirla entre todos los paneles.
     */
    private SistemaLecturas sistema = new SistemaLecturas();
/**
     * Constructor de la ventana principal.
     * Configura las características básicas de la interfaz y carga los paneles.
     */

    public MainGUI() {

 // Título de la ventana principal
        setTitle("Sistema de Lecturas");

         // Dimensiones de la ventana
        setSize(700, 500);

           // Finaliza la ejecución al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

  // Configura el estilo visual del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
 // Si ocurre un error al aplicar el estilo, se ignora para evitar bloquear la app

 // Crea un contenedor de pestañas para organizar las funcionalidades
        JTabbedPane tabs = new JTabbedPane();

 /**
         * Se agregan las diferentes vistas de la aplicación.
         * Cada panel recibe la misma instancia del sistema para compartir la información.
         */       
        tabs.add("Registrar Contador", new PanelRegistrarContador(sistema));
        tabs.add("Registrar Lectura", new PanelRegistrarLectura(sistema));
        tabs.add("Listar Lecturas", new PanelListarLecturas(sistema));
        tabs.add("Calcular Costo", new PanelCalcularCosto(sistema));


        // Añade las pestañas a la ventana principal
        add(tabs);
    }

 /**
     * Método principal.
     * Encargado de iniciar la interfaz gráfica de forma segura para Swing.
     */
    public static void main(String[] args) {
                // Asegura que la creación de la interfaz ocurra en el hilo adecuado

        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}
