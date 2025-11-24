package sistema.gui;

import javax.swing.*;
import sistema.services.SistemaLecturas;

public class MainGUI extends JFrame {

    private SistemaLecturas sistema = new SistemaLecturas();

    public MainGUI() {

        setTitle("Sistema de Lecturas");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Registrar Contador", new PanelRegistrarContador(sistema));
        tabs.add("Registrar Lectura", new PanelRegistrarLectura(sistema));
        tabs.add("Listar Lecturas", new PanelListarLecturas(sistema));
        tabs.add("Calcular Costo", new PanelCalcularCosto(sistema));

        add(tabs);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}
