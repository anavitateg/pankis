/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paneles.componentes;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedDatePicker extends JPanel {
    private JCalendar calendar;

    public RoundedDatePicker() {
        super(new BorderLayout());

        setOpaque(false);
        setBorder(new EmptyBorder(5, 10, 5, 10));

        // Configuración del calendario
        calendar = new JCalendar();
        calendar.setOpaque(false);

        // Ocultar el cuadro de entrada del calendario
        calendar.getYearChooser().setVisible(false);
        calendar.getMonthChooser().setVisible(false);
        calendar.getDayChooser().setVisible(false);

        add(calendar, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
