package sistema.gui;

import javax.swing.*;
import sistema.services.SistemaLecturas;

/**
 * Panel encargado de registrar una nueva lectura para un contador.
 * Permite que el usuario ingrese el ID del contador y el valor leído.
 */
public class PanelRegistrarLectura extends JPanel {

 /**
     * Constructor del panel.
     * Recibe la instancia del sistema para registrar las lecturas.
     *
     * @param sistema instancia de SistemaLecturas utilizada por toda la aplicación
     */
    public PanelRegistrarLectura(SistemaLecturas sistema) {

// Se utiliza un layout nulo para ubicar los componentes manualmente
        setLayout(null);

 // Etiqueta para identificar el campo del ID del contador
        JLabel lblId = new JLabel("ID del contador:");
        lblId.setBounds(30, 30, 150, 25);
        add(lblId);

 // Campo de texto donde el usuario ingresa el ID del contador
        JTextField txtId = new JTextField();
        txtId.setBounds(180, 30, 200, 25);
        add(txtId);

// Etiqueta para el valor de la lectura
        JLabel lblValor = new JLabel("Valor leído:");
        lblValor.setBounds(30, 70, 150, 25);
        add(lblValor);

 // Campo donde el usuario ingresa el valor leído por el contador
        JTextField txtValor = new JTextField();
        txtValor.setBounds(180, 70, 200, 25);
        add(txtValor);


        // Botón para registrar la lectura
        JButton btn = new JButton("Registrar");
        btn.setBounds(180, 120, 200, 30);
        add(btn);

 // Etiqueta para mostrar mensajes de éxito o error
        JLabel lblMsg = new JLabel("");
        lblMsg.setBounds(30, 170, 400, 25);
        add(lblMsg);

 /**
         * Acción del botón "Registrar":
         * - Captura el ID y el valor ingresado por el usuario.
         * - Convierte el valor a un número decimal.
         * - Llama al sistema para registrar la lectura.
         * - Muestra mensaje de confirmación o error según corresponda.
         */
        btn.addActionListener(e -> {
            try {
             // Convierte el texto ingresado a un número decimal    
                double valor = Double.parseDouble(txtValor.getText());

             // Registra la lectura en el sistema   
                sistema.registrarLectura(txtId.getText(), valor);

            // Muestra mensaje de éxito
                lblMsg.setText("✔ Lectura registrada.");
            } catch (Exception ex) {
             // Muestra cualquier error generado por el sistema o por el parseo    
                lblMsg.setText("Error: " + ex.getMessage());
            }
        });
    }
}
