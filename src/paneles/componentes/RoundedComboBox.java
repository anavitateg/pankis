package paneles.componentes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedComboBox<E> extends JComboBox<E> {
    private int arcWidth;
    private int arcHeight;

    public RoundedComboBox() {
        this(50, 50); // Valores por defecto más redondeados
    }

    public RoundedComboBox(int arcWidth, int arcHeight) {
        super();
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);
        setBorder(new EmptyBorder(5, 10, 5, 10));
        setUI(new RoundedComboBoxUI());
        setFont(new Font("Coda", Font.PLAIN, 18)); // Establecer la fuente aquí
        setRenderer(new CenteredListCellRenderer()); // Establecer el renderizador de celdas personalizado
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
        repaint();
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
        repaint();
    }

    private class RoundedComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            return new ArrowButton();
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dibujar el fondo redondeado
            g2.setColor(c.getBackground());
            g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), arcWidth, arcHeight);

            // Ajustar el área de recorte para que el texto no sobresalga del fondo redondeado
            g2.setClip(new RoundRectangle2D.Float(0, 0, c.getWidth(), c.getHeight(), arcWidth, arcHeight));

            super.paint(g2, c);
            g2.dispose();
        }

        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            // No pintar el fondo predeterminado
        }

        @Override
        public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setFont(comboBox.getFont()); // Usar la fuente establecida en el JComboBox
            FontMetrics fm = g.getFontMetrics();
            int x = (bounds.width - fm.stringWidth(getDisplayString(comboBox.getSelectedItem()))) / 2;
            int y = (bounds.height + fm.getAscent()) / 2 - 2; // Ajustar para centrar verticalmente

            g2.setColor(comboBox.getForeground());
            g2.drawString(getDisplayString(comboBox.getSelectedItem()), bounds.x + x, bounds.y + y);

            g2.dispose();
        }

        private String getDisplayString(Object value) {
            return (value == null) ? "" : value.toString();
        }
    }

    private class ArrowButton extends JButton {
        public ArrowButton() {
            setOpaque(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setBackground(Color.WHITE);
            setBorder(new EmptyBorder(0, 0, 0, 0));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dibujar la flecha
            int w = getWidth();
            int h = getHeight();
            int size = Math.min(w, h) / 2;
            int x = (w - size) / 2;
            int y = (h - size) / 2;
            g2.setColor(getForeground());

            int[] xPoints = { x, x + size, x + size / 2 };
            int[] yPoints = { y, y, y + size };
            g2.fillPolygon(xPoints, yPoints, 3);

            g2.dispose();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        return shape.contains(x, y);
    }

    private class CenteredListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto
        label.setFont(new Font("Coda", Font.PLAIN, 18)); // Establecer la fuente
        label.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY)); // Establecer el borde inferior

        // Añadir MouseListener al componente del ítem
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                list.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor a HAND_CURSOR cuando el mouse entra
            }

            @Override
            public void mouseExited(MouseEvent e) {
                list.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Cambiar el cursor a DEFAULT_CURSOR cuando el mouse sale
            }
        });

        if (isSelected) {
            label.setBackground(Color.LIGHT_GRAY); // Color de fondo cuando está seleccionado
            label.setForeground(list.getSelectionForeground());
        } else if (index == list.getSelectedIndex()) {
            label.setBackground(Color.LIGHT_GRAY); // Color de fondo cuando el mouse está sobre el ítem
        } else {
            label.setBackground(list.getBackground());
            label.setForeground(list.getForeground());
        }
        return label;
    }
}

}
