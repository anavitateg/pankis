/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package paneles.funciones.inventario;

import conexionSQL.conexionSQL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class addslot extends javax.swing.JFrame {
private conexionSQL conexion;
    /**
     * Creates new form add
     */
    public addslot() {
        initComponents();
        setSize(477, 371);
        setLocationRelativeTo(null);
        
        
        
        conexion = new conexionSQL();

        // Obtener categorías y llenar el JComboBox
        List<String> categorias = conexion.obtenerCategorias();
        for (String categoria : categorias) {
            
            combo_categoria.addItem(categoria);
        }
        
        // Obtener categorías y llenar el JComboBox
        List<String> unidades = conexion.obtenerUnidades();
        for (String unidad : unidades) {
            combo_unidad.addItem(unidad);
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        proovedor_slot = new paneles.componentes.RoundedTextField();
        jLabel3 = new javax.swing.JLabel();
        combo_unidad = new paneles.componentes.RoundedComboBox();
        combo_categoria = new paneles.componentes.RoundedComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombre_slot = new paneles.componentes.RoundedTextField();
        cantidad_slot = new paneles.componentes.RoundedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fecha_caducidad = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Caducidad:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 330, 170, 20);

        proovedor_slot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proovedor_slot.setText("Origen");
        proovedor_slot.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        proovedor_slot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                proovedor_slotFocusLost(evt);
            }
        });
        proovedor_slot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proovedor_slotMouseClicked(evt);
            }
        });
        jPanel1.add(proovedor_slot);
        proovedor_slot.setBounds(150, 270, 300, 40);

        jLabel3.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 80, 140, 20);

        combo_unidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_unidadActionPerformed(evt);
            }
        });
        jPanel1.add(combo_unidad);
        combo_unidad.setBounds(150, 170, 300, 40);

        combo_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_categoriaActionPerformed(evt);
            }
        });
        jPanel1.add(combo_categoria);
        combo_categoria.setBounds(150, 120, 300, 40);

        jLabel4.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Categoría:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 130, 90, 20);

        jLabel5.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Unidad:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 180, 90, 20);

        nombre_slot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre_slot.setText("Nombre de ingrediente");
        nombre_slot.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        nombre_slot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombre_slotFocusLost(evt);
            }
        });
        nombre_slot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombre_slotMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nombre_slotMouseExited(evt);
            }
        });
        jPanel1.add(nombre_slot);
        nombre_slot.setBounds(150, 70, 300, 40);

        cantidad_slot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidad_slot.setText("Cantidad de unidad");
        cantidad_slot.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        cantidad_slot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantidad_slotFocusLost(evt);
            }
        });
        cantidad_slot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cantidad_slotMouseClicked(evt);
            }
        });
        cantidad_slot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_slotActionPerformed(evt);
            }
        });
        jPanel1.add(cantidad_slot);
        cantidad_slot.setBounds(150, 220, 300, 40);

        jLabel6.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cantidad:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 230, 100, 20);

        jLabel7.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Proovedor:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 280, 120, 20);

        fecha_caducidad.setFont(new java.awt.Font("Coda", 0, 18)); // NOI18N
        jPanel1.add(fecha_caducidad);
        fecha_caducidad.setBounds(160, 320, 290, 30);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Coda", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AGREGAR SLOT");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 210, 50);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cancelar-32(1).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cancelar-32_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(420, 10, 40, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-añadir-32.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-añadir-32(2).png"))); // NOI18N
        jPanel2.add(jButton2);
        jButton2.setBounds(390, 0, 32, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 480, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_categoriaActionPerformed

    private void combo_unidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_unidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_unidadActionPerformed

    private void cantidad_slotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_slotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_slotActionPerformed

    private void nombre_slotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombre_slotMouseClicked
        
        if("Nombre de ingrediente".equals(nombre_slot.getText())){
            nombre_slot.setText("");
        }else if (nombre_slot.getText().isEmpty()) {
    nombre_slot.setText("Nombre de ingrediente");
}
    }//GEN-LAST:event_nombre_slotMouseClicked

    private void nombre_slotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombre_slotMouseExited
        
    }//GEN-LAST:event_nombre_slotMouseExited

    private void nombre_slotFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombre_slotFocusLost
        if(nombre_slot.getText().isEmpty()){
        nombre_slot.setText("Nombre de ingrediente");
        
        }
    }//GEN-LAST:event_nombre_slotFocusLost

    private void cantidad_slotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidad_slotMouseClicked
        if("Cantidad de unidad".equals(cantidad_slot.getText())){
            cantidad_slot.setText("");
        }else if (cantidad_slot.getText().isEmpty()) {
    cantidad_slot.setText("Cantidad de unidad");
}
    }//GEN-LAST:event_cantidad_slotMouseClicked

    private void cantidad_slotFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidad_slotFocusLost
        if(cantidad_slot.getText().isEmpty()){
        cantidad_slot.setText("Cantidad de unidad");
        
        }
    }//GEN-LAST:event_cantidad_slotFocusLost

    private void proovedor_slotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proovedor_slotMouseClicked
        if("Origen".equals(proovedor_slot.getText())){
            proovedor_slot.setText("");
        }else if (proovedor_slot.getText().isEmpty()) {
    proovedor_slot.setText("Origen");
}
    }//GEN-LAST:event_proovedor_slotMouseClicked

    private void proovedor_slotFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_proovedor_slotFocusLost
          if(proovedor_slot.getText().isEmpty()){
        proovedor_slot.setText("Origen");
        
        }
    }//GEN-LAST:event_proovedor_slotFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addslot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private paneles.componentes.RoundedTextField cantidad_slot;
    private paneles.componentes.RoundedComboBox combo_categoria;
    private paneles.componentes.RoundedComboBox combo_unidad;
    private com.toedter.calendar.JDateChooser fecha_caducidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private paneles.componentes.RoundedTextField nombre_slot;
    private paneles.componentes.RoundedTextField proovedor_slot;
    // End of variables declaration//GEN-END:variables
}
