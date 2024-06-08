/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paneles.componentes;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class tablainventario extends JPanel {

    public tablainventario() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        
        

        // Crear el modelo de la tabla
        MyTableModel model = new MyTableModel();
        JTable table = new JTable(model);
        
// Renderizador personalizado para la columna "Slot"
DefaultTableCellRenderer slotRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY)); // Borde inferior
        return label;
    }
};
slotRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Alinear al centro
table.getColumnModel().getColumn(0).setCellRenderer(slotRenderer); // Aplicar renderizador a la columna 0

// Renderizador personalizado para la columna "Ingrediente"
DefaultTableCellRenderer ingredientRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY)); // Borde inferior
        return label;
    }
};
ingredientRenderer.setHorizontalAlignment(SwingConstants.LEFT); // Alinear a la izquierda
table.getColumnModel().getColumn(1).setCellRenderer(ingredientRenderer); // Aplicar renderizador a la columna 1

// Renderizador personalizado para las columnas "Cantidad" y "Unidad"
DefaultTableCellRenderer numericRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY)); // Borde inferior
        return label;
    }
};
numericRenderer.setHorizontalAlignment(SwingConstants.RIGHT); // Alinear a la derecha
table.getColumnModel().getColumn(2).setCellRenderer(numericRenderer); // Aplicar renderizador a la columna 2
table.getColumnModel().getColumn(3).setCellRenderer(numericRenderer); // Aplicar renderizador a la columna 3
table.getColumnModel().getColumn(4).setCellRenderer(numericRenderer); // Aplicar renderizador a la columna 3
table.getColumnModel().getColumn(5).setCellRenderer(numericRenderer); // Aplicar renderizador a la columna 3
table.getColumnModel().getColumn(6).setCellRenderer(numericRenderer); // Aplicar renderizador a la columna 3


// Ancho de la columna "Slot"
table.getColumnModel().getColumn(0).setPreferredWidth(40);


// Ancho de la columna "Ingrediente"
table.getColumnModel().getColumn(1).setPreferredWidth(130);

// Ancho de las columnas "Cantidad" y "Unidad"
table.getColumnModel().getColumn(2).setPreferredWidth(100);
table.getColumnModel().getColumn(3).setPreferredWidth(100);



// Renderer personalizado para los encabezados de columna alineado a la izquierda
class LeftHeaderRenderer extends DefaultTableCellRenderer {
    public LeftHeaderRenderer(JTable table) {
        setOpaque(true);
        setFont(table.getTableHeader().getFont());
        setBackground(table.getTableHeader().getBackground());
        setForeground(table.getTableHeader().getForeground());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(SwingConstants.LEFT); // Alinear a la izquierda
        return label;
    }
}

// Renderer personalizado para los encabezados de columna alineado a la derecha
class RightHeaderRenderer extends DefaultTableCellRenderer {
    public RightHeaderRenderer(JTable table) {
        setOpaque(true);
        setFont(table.getTableHeader().getFont());
        setBackground(table.getTableHeader().getBackground());
        setForeground(table.getTableHeader().getForeground());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(SwingConstants.RIGHT); // Alinear a la derecha
        return label;
    }
}





        // Configurar la fuente y color de fondo de las cabeceras de columna
        JTableHeader header = table.getTableHeader();
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        header.setFont(new Font("Coda", Font.PLAIN, 15));
        header.setBackground(Color.WHITE); // Fondo negro
        header.setForeground(Color.BLACK); // Texto blanco
        // Alineación de los encabezados de columna
 
table.getColumnModel().getColumn(0).setHeaderRenderer(new HeaderRenderer(table)); // Alineado al centro
table.getColumnModel().getColumn(4).setHeaderRenderer(new HeaderRenderer(table)); // Alineado al centro
table.getColumnModel().getColumn(5).setHeaderRenderer(new HeaderRenderer(table)); // Alineado al centro
table.getColumnModel().getColumn(6).setHeaderRenderer(new HeaderRenderer(table)); // Alineado al centro
table.getColumnModel().getColumn(1).setHeaderRenderer(new LeftHeaderRenderer(table)); // Alineado a la izquierda
table.getColumnModel().getColumn(2).setHeaderRenderer(new RightHeaderRenderer(table)); // Alineado a la derecha
table.getColumnModel().getColumn(3).setHeaderRenderer(new RightHeaderRenderer(table)); // Alineado a la derecha

        



        // Configurar la fuente y color de fondo de las celdas
        table.setFont(new Font("Coda", Font.PLAIN, 15));
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setRowHeight(30);
        table.setBorder(null);

        // Quitar bordes excepto el inferior
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY)); // Borde inferior
                return label;
            }
            
            
            
            
        });

        // Configurar el renderer para las columnas de ver, edición y eliminación
        table.getColumnModel().getColumn(4).setCellRenderer(new IconCellRenderer());
        table.getColumnModel().getColumn(5).setCellRenderer(new IconCellRenderer());
        table.getColumnModel().getColumn(6).setCellRenderer(new IconCellRenderer());

        // Configurar el editor para las columnas de ver, edición y eliminación
        table.getColumnModel().getColumn(4).setCellEditor(new IconCellEditor(new JLabel(), model));
        table.getColumnModel().getColumn(5).setCellEditor(new IconCellEditor(new JLabel(), model));
        table.getColumnModel().getColumn(6).setCellEditor(new IconCellEditor(new JLabel(), model));

        // Ajustar el ancho de las columnas de iconos
        table.getColumnModel().getColumn(4).setMaxWidth(50);
        table.getColumnModel().getColumn(5).setMaxWidth(50);
        table.getColumnModel().getColumn(6).setMaxWidth(50);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Eliminar borde del JScrollPane
        scrollPane.setBackground(Color.WHITE);

        add(scrollPane, BorderLayout.CENTER);
        
    }

    // Renderer personalizado para el encabezado de la tabla
    class HeaderRenderer extends DefaultTableCellRenderer {
        public HeaderRenderer(JTable table) {
        setOpaque(true);
        setFont(table.getTableHeader().getFont());
        setBackground(table.getTableHeader().getBackground());
        setForeground(table.getTableHeader().getForeground());
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(SwingConstants.CENTER); // Alinear al centro
        return label;
    }
  
    }
    
}

// Modelo de la tabla
class MyTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Slot", "Ingrediente", "Cantidad", "Unidad", "", "", ""};
    private Object[][] data = {
        {1, "Harina", 500, "g", "view", "edit", "delete"},
        {2, "Azúcar", 200, "g", "view", "edit", "delete"},
        {3, "Leche", 1, "L", "view", "edit", "delete"},
    };

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 4 || columnIndex == 5 || columnIndex == 6;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void removeRow(int row) {
        int numRows = getRowCount();
        if (row >= 0 && row < numRows) {
            Object[][] newData = new Object[numRows - 1][getColumnCount()];
            for (int i = 0, j = 0; i < numRows; i++) {
                if (i != row) {
                    newData[j++] = data[i];
                }
            }
            data = newData;
            fireTableDataChanged();
        }
    }
}

// Renderer para los iconos
class IconCellRenderer extends DefaultTableCellRenderer {
    private final JLabel label;

    public IconCellRenderer() {
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value.equals("edit")) {
            label.setIcon(new ImageIcon("src/images/lapiz.png"));
        } else if (value.equals("delete")) {
            label.setIcon(new ImageIcon("src/images/eliminar.png"));
        } else if (value.equals("view")) {
            label.setIcon(new ImageIcon("src/images/ojo.png"));
        }
        return label;
    }
}

// Editor para los iconos
class IconCellEditor extends AbstractCellEditor implements TableCellEditor {
    private final JLabel label;
    private final MyTableModel model;
    private int row;
    private int column;

    public IconCellEditor(JLabel label, MyTableModel model) {
        this.label = label;
        this.model = model;
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (column == 4) {
                    viewRow();
                } else if (column == 5) {
                    editRow();
                } else if (column == 6) {
                    deleteRow();
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        this.column = column;
        if (value.equals("edit")) {
            label.setIcon(new ImageIcon("path/to/edit_icon.png"));
        } else if (value.equals("delete")) {
            label.setIcon(new ImageIcon("path/to/delete_icon.png"));
        } else if (value.equals("view")) {
            label.setIcon(new ImageIcon("path/to/view_icon.png"));
        }
        return label;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    private void viewRow() {
        // Lógica para ver la fila
        System.out.println("Ver fila: " + row);
    }

    private void editRow() {
        // Lógica para editar la fila
        System.out.println("Editar fila: " + row);
    }

    private void deleteRow() {
        // Lógica para eliminar la fila
        System.out.println("Eliminar fila: " + row);
        model.removeRow(row);
    }
}
