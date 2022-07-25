package com.is210q12022.is210.sistema.restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class Cocina extends javax.swing.JFrame {
   
    ColorRenderer CR = new ColorRenderer();
    
    DefaultTableModel model1;
    DefaultTableModel model2;


    
    public Connection Conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://is210-sistema-restaurante.database.windows.net:1433;databaseName=dbo;database=Restaurante;user=MasterChief@is210-sistema-restaurante;password={};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;","devLogin","is210-2022-student!");
        } catch (SQLException e) {
            System.err.print(e.toString());
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
        }
        return con;
    }
    
    public Cocina() {
        
        initComponents();  
        this.setLocationRelativeTo(null);
        Cargar();  
        jTable1.setDefaultRenderer(Object.class, CR);
    }
    
    

    public void Cargar() {
        
        Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
                con1 = Conectar();
                pst = con1.prepareStatement("select * from orders");
                rs = pst.executeQuery();
                
                Object[] orders = new Object[6];
                model1 = (DefaultTableModel) jTable1.getModel();
                
                while (rs.next()) {
                orders[0] = rs.getInt("orderId");
                orders[1] = rs.getString("bebida");
                orders[2] = rs.getInt("cantidadB");
                orders[3] = rs.getString("comida");
                orders[4] = rs.getInt("cantidadC");
                orders[5] = ("Pendiente");
                model1.addRow(orders);              
                }
                jTable1.setModel(model1);
                model1.addRow(new Object[]{"","","","","",""});
                      
            } catch (SQLException e) {
                System.err.print(e.toString());
                JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
            
            }  
    }
    
    
        public void Actualizar() {
        
        Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
                con1 = Conectar();
                pst = con1.prepareStatement("select * from orders");
                rs = pst.executeQuery();
                
                Object[] orders = new Object[6];

                  int nf = 0;
                   
                    while (rs.next()) {
                        
                    orders[0] = rs.getInt("orderId");
                    orders[1] = rs.getString("bebida");
                    orders[2] = rs.getInt("cantidadB");
                    orders[3] = rs.getString("comida");
                    orders[4] = rs.getInt("cantidadC");
                    orders[5] = ("Pendiente");
                    
                    for (int i = 0; i < 5; i++) {
                  
                if(jTable1.getValueAt(nf, i).equals(orders[i])){
                //System.out.println(orders[i]);
                }else{
                model1.removeRow(model1.getRowCount()-1);
                model1.addRow(orders);
                i = 5;
                model1.addRow(new Object[]{"","","","","",""});
                }
                    }
                  nf++;
                    }

            } catch (SQLException e) {
                System.err.print(e.toString());
                JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
            
            }  
    }
    
    
    public void Comparar(){    
        
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if(jTable1.getValueAt(i, 0).toString().equals(jTextField1.getText())){
            model1.removeRow(i);
            i = i - 1;
            }
        }
        
    }
          
    
    
    
    public void limpiar1() {
       for (int i = 0; i < jTable1.getRowCount(); i++) {
            model1.removeRow(i);
            i = i - 1;
        }
            
    }
    
        public void limpiar2() {
            for (int i = 0; i < jTable2.getRowCount(); i++) {
            model2.removeRow(i);
            i = i - 1;
        }
    }       
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        BTNActualizar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        BTNElegirPedido = new javax.swing.JButton();
        BTNEnviar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden ID", "Bebida", "Cantidad Bebida", "Comida", "Cantidad Comida", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 650, 310));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden ID", "Bebida", "Cantidad Bebida", "Comida", "Cantidad Comida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 570, 160));

        BTNActualizar.setText("Actualizar");
        BTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 50, -1));

        BTNElegirPedido.setText("Elegir Pedido");
        BTNElegirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNElegirPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(BTNElegirPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, -1, -1));

        BTNEnviar.setText("Enviar Pedido");
        BTNEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Pedido Actual");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Pedidos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNActualizarActionPerformed
      // limpiar1();
        Actualizar();
    }//GEN-LAST:event_BTNActualizarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void BTNElegirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNElegirPedidoActionPerformed
    
        String cant = jTextField1.getText();
        if(cant.equals("")){
            JOptionPane.showMessageDialog(this, "Favor elija un pedido primero");
            jTextField1.setText("");
            this.jTextField1.requestFocus();
        
        }else{
            int count = 0;
            model2 = (DefaultTableModel) jTable2.getModel();
        
           for (int i = 0; i < jTable1.getRowCount(); i++) {
            if(jTable1.getValueAt(i, 0).toString().equals(jTextField1.getText()) && 
               jTable1.getValueAt(i, 5).toString().equals("Pendiente")){

                       model2.addRow(new Object[]{jTable1.getValueAt(i, 0),
                                                    jTable1.getValueAt(i, 1),
                                                    jTable1.getValueAt(i, 2),
                                                    jTable1.getValueAt(i, 3),
                                                    jTable1.getValueAt(i, 4)});                      
            }else{
                count = count + 1;
            }
        }
           if(jTable1.getRowCount()==count){
                JOptionPane.showMessageDialog(null, "No existe el Pedido o Ya Entregado");
            }
        }
    }//GEN-LAST:event_BTNElegirPedidoActionPerformed

    private void BTNEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEnviarActionPerformed
        
        if (jTable2.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Favor elija un pedido primero");
            jTextField1.setText("");
            this.jTextField1.requestFocus();
        }else{

        limpiar2();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if(jTable1.getValueAt(i, 0).toString().equals(jTextField1.getText())){
                model1.setValueAt("Entregado", i, 5);                         
            }
        }
       model1.fireTableDataChanged();
        }
    }//GEN-LAST:event_BTNEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cocina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cocina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNActualizar;
    private javax.swing.JButton BTNElegirPedido;
    private javax.swing.JButton BTNEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
