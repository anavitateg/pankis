/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paneles.componentes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModernTablePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    public ModernTablePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Crear el modelo de la tabla con datos de ejemplo
        tableModel = new DefaultTableModel(
            new Object[][] {
                {"John", "Doe", "john@example.com", "Editar", "Borrar"},
                {"Jane", "Smith", "jane@example.com", "Editar", "Borrar"},
                {"Mike", "Brown", "mike@example.com", "Editar", "Borrar"},
            },
            new String[] {"First Name", "Last Name", "Email", "Edit", "Delete"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No permitir edición directamente en las celdas
            }
        };

        // Crear la tabla con el modelo de datos
        table = new JTable(tableModel);

        // Estilo minimalista y moderno
        table.setShowGrid(false);
        table.setRowHeight(30);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFillsViewportHeight(true);
        table.setSelectionBackground(new Color(102, 178, 255));
        table.setSelectionForeground(Color.WHITE);

        // Personalizar las columnas para los botones
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);

        // Renderizar botones
        table.getColumn("Edit").setCellRenderer(new ButtonRenderer());
        table.getColumn("Delete").setCellRenderer(new ButtonRenderer());

        table.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox(), tableModel, this));
        table.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox(), tableModel, this));

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para añadir una nueva fila
    public void addNewRow() {
        tableModel.addRow(new Object[]{"", "", "", "Editar", "Borrar"});
    }

    // Método para editar una fila
    public void editRow(int row) {
        // Lógica de edición (para implementar)
        JOptionPane.showMessageDialog(this, "Editar fila: " + row);
    }

    // Método para borrar una fila
    public void deleteRow(int row) {
        tableModel.removeRow(row);
    }

    // Método main para probar el panel
    public static void main(String[] args) {
        JFrame frame = new JFrame("Modern Table Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ModernTablePanel());
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Clase para renderizar botones en la tabla
    private class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setCursor(Cursor.getDefaultCursor());
                }
            });
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Clase para manejar eventos de botones en la tabla
    private class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;
        private DefaultTableModel tableModel;
        private ModernTablePanel panel;
        private int row;

        public ButtonEditor(JCheckBox checkBox, DefaultTableModel tableModel, ModernTablePanel panel) {
            super(checkBox);
            this.tableModel = tableModel;
            this.panel = panel;
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setCursor(Cursor.getDefaultCursor());
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                if (label.equals("Editar")) {
                    panel.editRow(row);
                } else if (label.equals("Borrar")) {
                    panel.deleteRow(row);
                }
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
