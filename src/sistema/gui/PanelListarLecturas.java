package sistema.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import sistema.services.SistemaLecturas;
import sistema.models.Lectura;

public class PanelListarLecturas extends JPanel {

    private DefaultTableModel modelo;
    private JTable tabla;

    public PanelListarLecturas(SistemaLecturas sistema) {

        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(
                new Object[]{"ID Contador", "Valor", "Fecha"}, 0
        );

        tabla = new JTable(modelo);
        tabla.setAutoCreateRowSorter(true);

        JButton btnActualizar = new JButton("Actualizar");

        btnActualizar.addActionListener(e -> {
            modelo.setRowCount(0);
            for (Lectura l : sistema.listarLecturas()) {
                modelo.addRow(new Object[]{
                        l.getIdContador(),
                        l.getValor(),
                        l.getFecha()
                });
            }
        });

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(btnActualizar, BorderLayout.SOUTH);
    }
}
