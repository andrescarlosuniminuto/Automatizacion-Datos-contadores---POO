package sistema;

import sistema.gui.MainGUI;

public class Main {
    public static void main(String[] args) {
        System.out.println("GUI iniciada...");
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }
}
