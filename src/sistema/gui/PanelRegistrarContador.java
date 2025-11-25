package sistema.gui;

import javax.swing.*;
import sistema.services.SistemaLecturas;

/**
 * Panel encargado de registrar un nuevo contador en el sistema.
 * Permite ingresar ID, dirección y tipo de contador (Agua, Luz, Gas).
 */
public class PanelRegistrarContador extends JPanel {

 /**
     * Constructor del panel.
     * Recibe la instancia del sistema para registrar contadores.
     *
     * @param sistema instancia de SistemaLecturas compartida con toda la aplicación
     */
    public PanelRegistrarContador(SistemaLecturas sistema) {

 // Layout nulo: los componentes se posicionan manualmente
        setLayout(null);

 // Etiqueta para el ID del contador
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(30, 30, 150, 25);
        add(lblId);

  // Campo donde el usuario escribirá el ID del nuevo contador
        JTextField txtId = new JTextField();
        txtId.setBounds(180, 30, 200, 25);
        add(txtId);

// Etiqueta para la dirección del contador
        JLabel lblDir = new JLabel("Dirección:");
        lblDir.setBounds(30, 70, 150, 25);
        add(lblDir);

 // Campo para ingresar la dirección donde está ubicado el contador
        JTextField txtDir = new JTextField();
        txtDir.setBounds(180, 70, 200, 25);
        add(txtDir);

// Etiqueta del tipo de contador
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 110, 150, 25);
        add(lblTipo);

// Lista desplegable con los tipos de contadores permitidos
        String[] tipos = { "Agua", "Luz", "Gas" };
        JComboBox<String> cbTipo = new JComboBox<>(tipos);
        cbTipo.setBounds(180, 110, 200, 25);
        add(cbTipo);

 // Botón que registra el contador cuando el usuario hace clic
        JButton btn = new JButton("Registrar");
        btn.setBounds(180, 160, 200, 30);
        add(btn);

 // Etiqueta donde se muestran mensajes de éxito o error
        JLabel lblMsg = new JLabel("");
        lblMsg.setBounds(30, 210, 400, 25);
        add(lblMsg);

 /**
         * Acción del botón "Registrar":
         * - Lee los datos ingresados por el usuario.
         * - Convierte el tipo seleccionado en un número (1 = Agua, 2 = Luz, 3 = Gas).
         * - Llama al método registrarContador del sistema.
         * - Muestra un mensaje de confirmación o error.
         */
        btn.addActionListener(e -> {
            try {
                 // Convierte la selección del JComboBox en un valor entero para el sistema
                int tipo = cbTipo.getSelectedIndex() + 1;

                 // Llama al sistema para registrar el contador con los datos ingresados
                sistema.registrarContador(txtId.getText(), txtDir.getText(), tipo);

                // Mensaje de éxito
                lblMsg.setText("✔ Contador registrado.");
            } catch (Exception ex) {
            // Muestra el error generado por el sistema
                lblMsg.setText("Error: " + ex.getMessage());
            }
        });
    }
}
