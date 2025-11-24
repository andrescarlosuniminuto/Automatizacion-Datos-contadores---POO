package sistema.gui;

import javax.swing.*;
import sistema.services.SistemaLecturas;

public class PanelCalcularCosto extends JPanel {

    public PanelCalcularCosto(SistemaLecturas sistema) {

        setLayout(null);

        JLabel lblId = new JLabel("ID del contador:");
        lblId.setBounds(30, 30, 150, 25);
        add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(180, 30, 200, 25);
        add(txtId);

        JButton btn = new JButton("Calcular");
        btn.setBounds(180, 80, 200, 30);
        add(btn);

        JLabel lblMsg = new JLabel("");
        lblMsg.setBounds(30, 130, 400, 30);
        add(lblMsg);

        btn.addActionListener(e -> {
            try {
                double costo = sistema.calcularCosto(txtId.getText());
                lblMsg.setText("Costo total: $" + costo);
            } catch (Exception ex) {
                lblMsg.setText("Error: " + ex.getMessage());
            }
        });
    }
}
