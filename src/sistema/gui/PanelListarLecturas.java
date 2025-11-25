package sistema.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import sistema.services.SistemaLecturas;
import sistema.models.Lectura;

/**
 * Panel encargado de mostrar todas las lecturas registradas en el sistema.
 * Utiliza una tabla (JTable) junto con un botón que permite actualizar los datos.
 */
public class PanelListarLecturas extends JPanel {

// Modelo de la tabla: define las columnas y permite agregar filas dinámicamente
    private DefaultTableModel modelo;

  // Componente visual que mostrará las lecturas en forma tabular    
    private JTable tabla;

/**
     * Constructor del panel.
     * Recibe una instancia compartida de SistemaLecturas para acceder
     * a la información almacenada en el sistema.
     *
     * @param sistema instancia del sistema que administra contadores y lecturas
     */
    public PanelListarLecturas(SistemaLecturas sistema) {

 // Layout que permite organizar la tabla en el centro y el botón abajo
        setLayout(new BorderLayout());

// Se inicializa el modelo con las columnas correspondientes
        modelo = new DefaultTableModel(
                new Object[]{"ID Contador", "Valor", "Fecha"}, 0
        );

 // Se crea la tabla a partir del modelo
        tabla = new JTable(modelo);

 // Permite ordenar las columnas al hacer clic en los encabezados        
        tabla.setAutoCreateRowSorter(true);

// Botón que recarga la información desde el sistema
        JButton btnActualizar = new JButton("Actualizar");


/**
         * Acción del botón "Actualizar":
         * - Limpia las filas existentes en la tabla.
         * - Obtiene la lista de lecturas desde el sistema.
         * - Agrega una fila por cada lectura registrada.
         */
        btnActualizar.addActionListener(e -> {

         // Borra todas las filas para evitar duplicados
            modelo.setRowCount(0);

            // Recorre cada lectura almacenada en el sistema
            for (Lectura l : sistema.listarLecturas()) {

             // Agrega una nueva fila con los datos de la lectura    
                modelo.addRow(new Object[]{
                        l.getIdContador(),
                        l.getValor(),
                        l.getFecha()
                });
            }
        });

 // Se añade la tabla dentro de un ScrollPane para permitir desplazamiento
        add(new JScrollPane(tabla), BorderLayout.CENTER);

// El botón se coloca en la parte inferior del panel        
        add(btnActualizar, BorderLayout.SOUTH);
    }
}
