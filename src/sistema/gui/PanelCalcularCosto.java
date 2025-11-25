package sistema.gui;

import javax.swing.*;
import sistema.services.SistemaLecturas;


/**
 * Panel encargado de calcular el costo total de consumo
 * asociado a un contador registrado en el sistema.
 * 
 * Permite al usuario ingresar el ID del contador y obtener
 * el costo acumulado de sus lecturas.
 */
public class PanelCalcularCosto extends JPanel {

/**
     * Constructor del panel.
     * Recibe una instancia compartida de SistemaLecturas
     * para acceder a los datos y cálculos del sistema.
     *
     * @param sistema instancia del sistema que gestiona las lecturas
     */
    public PanelCalcularCosto(SistemaLecturas sistema) {

// Se utiliza un layout nulo para posicionar manualmente los componentes
        setLayout(null);

 // Etiqueta para indicar dónde ingresar el ID del contador
        JLabel lblId = new JLabel("ID del contador:");
        lblId.setBounds(30, 30, 150, 25);
        add(lblId);

  // Campo de texto donde el usuario escribe el ID del contador
        JTextField txtId = new JTextField();
        txtId.setBounds(180, 30, 200, 25);
        add(txtId);

// Botón que ejecutará el cálculo del costo
        JButton btn = new JButton("Calcular");
        btn.setBounds(180, 80, 200, 30);
        add(btn);

// Etiqueta donde se mostrará el resultado o mensajes de error
        JLabel lblMsg = new JLabel("");
        lblMsg.setBounds(30, 130, 400, 30);
        add(lblMsg);


 /**
         * Acción del botón:
         * - Captura el ID escrito por el usuario.
         * - Llama al método calcularCosto del sistema.
         * - Muestra el total calculado o un error si ocurre un problema.
         */
        btn.addActionListener(e -> {
            try {
                 // Invoca el cálculo del costo usando el ID proporcionado
                double costo = sistema.calcularCosto(txtId.getText());
                // Muestra el costo formateado en la etiqueta
                lblMsg.setText("Costo total: $" + costo);
            } catch (Exception ex) {
                // En caso de error, se notifica al usuario
                lblMsg.setText("Error: " + ex.getMessage());
            }
        });
    }
}
