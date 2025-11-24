package sistema.gui;

import javax.swing.*;
import sistema.services.SistemaLecturas;

public class PanelRegistrarLectura extends JPanel {

    public PanelRegistrarLectura(SistemaLecturas sistema) {

        setLayout(null);

        JLabel lblId = new JLabel("ID del contador:");
        lblId.setBounds(30, 30, 150, 25);
        add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(180, 30, 200, 25);
        add(txtId);

        JLabel lblValor = new JLabel("Valor leído:");
        lblValor.setBounds(30, 70, 150, 25);
        add(lblValor);

        JTextField txtValor = new JTextField();
        txtValor.setBounds(180, 70, 200, 25);
        add(txtValor);

        JButton btn = new JButton("Registrar");
        btn.setBounds(180, 120, 200, 30);
        add(btn);

        JLabel lblMsg = new JLabel("");
        lblMsg.setBounds(30, 170, 400, 25);
        add(lblMsg);

        btn.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(txtValor.getText());
                sistema.registrarLectura(txtId.getText(), valor);
                lblMsg.setText("✔ Lectura registrada.");
            } catch (Exception ex) {
                lblMsg.setText("Error: " + ex.getMessage());
            }
        });
    }
}
