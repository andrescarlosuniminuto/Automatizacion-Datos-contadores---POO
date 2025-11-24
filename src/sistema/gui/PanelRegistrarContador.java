package sistema.gui;

import javax.swing.*;
import sistema.services.SistemaLecturas;

public class PanelRegistrarContador extends JPanel {

    public PanelRegistrarContador(SistemaLecturas sistema) {

        setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 30, 150, 25);
        add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(180, 30, 200, 25);
        add(txtId);

        JLabel lblDir = new JLabel("Dirección:");
        lblDir.setBounds(30, 70, 150, 25);
        add(lblDir);

        JTextField txtDir = new JTextField();
        txtDir.setBounds(180, 70, 200, 25);
        add(txtDir);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 110, 150, 25);
        add(lblTipo);

        String[] tipos = { "Agua", "Luz", "Gas" };
        JComboBox<String> cbTipo = new JComboBox<>(tipos);
        cbTipo.setBounds(180, 110, 200, 25);
        add(cbTipo);

        JButton btn = new JButton("Registrar");
        btn.setBounds(180, 160, 200, 30);
        add(btn);

        JLabel lblMsg = new JLabel("");
        lblMsg.setBounds(30, 210, 400, 25);
        add(lblMsg);

        btn.addActionListener(e -> {
            try {
                int tipo = cbTipo.getSelectedIndex() + 1;
                sistema.registrarContador(txtId.getText(), txtDir.getText(), tipo);
                lblMsg.setText("✔ Contador registrado.");
            } catch (Exception ex) {
                lblMsg.setText("Error: " + ex.getMessage());
            }
        });
    }
}
