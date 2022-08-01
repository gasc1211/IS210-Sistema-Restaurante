/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.is210q12022.is210.sistema.restaurante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Roger Lopez
 */
public class TablaFacturas extends javax.swing.JFrame {
    /**
     * Creates new form TablaFacturas
     */
    
    private dbManager db = new dbManager();
    private Connection connection;
    private Statement request;
    private ResultSet results;
    public static DefaultTableModel model = new DefaultTableModel();
    
    public TablaFacturas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaInvoices = new javax.swing.JTable();
        jButtonActualizarFacturas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserDesde = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButtonFacturasRango = new javax.swing.JButton();
        jDateChooserHasta = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButtonFacturasDiarias = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserDia = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTablaPedido = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButtonActualizarFacturas1 = new javax.swing.JButton();
        jButtonFacturaPrint = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JTablaInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTablaInvoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablaInvoicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTablaInvoices);

        jButtonActualizarFacturas.setText("Mostrar Todas Las Ventas");
        jButtonActualizarFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarFacturasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reportes de Ventas");

        jDateChooserDesde.setDateFormatString("dd-MM-yyyy");

        jLabel2.setText("Fecha desde: ");

        jButtonFacturasRango.setText("Mostrar Ventas Por Rango");
        jButtonFacturasRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFacturasRangoActionPerformed(evt);
            }
        });

        jDateChooserHasta.setDateFormatString("dd-MM-yyyy");

        jLabel3.setText("hasta:");

        jButtonFacturasDiarias.setText("Mostrar Ventas Por Día");
        jButtonFacturasDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFacturasDiariasActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha Exacta: ");

        jDateChooserDia.setDateFormatString("dd-MM-yyyy");

        JTablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(JTablaPedido);

        jLabel5.setText("Detalles de la Factura: ");

        jButtonActualizarFacturas1.setText("Imprimir Reporte de Facturas");
        jButtonActualizarFacturas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarFacturas1ActionPerformed(evt);
            }
        });

        jButtonFacturaPrint.setText("Reimprimir Factura");
        jButtonFacturaPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFacturaPrintActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Pedidos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooserDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jDateChooserDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooserHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButtonFacturasDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonFacturasRango)
                                    .addComponent(jButtonActualizarFacturas)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonActualizarFacturas1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonFacturaPrint, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooserDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonFacturasRango)
                            .addComponent(jDateChooserHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonActualizarFacturas)
                            .addComponent(jButtonFacturasDiarias))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonActualizarFacturas1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFacturaPrint)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarFacturasActionPerformed
        DefaultTableModel table =  new DefaultTableModel();
        ArrayList<invoiceObjectModel> data;
        String[] rowData = new String[5];
        table.addColumn("Factura N°.");
        table.addColumn("Fecha");
        table.addColumn("SubTotal");
        table.addColumn("Impuestos");
        table.addColumn("Total");
        data = db.fetchInvoicesData();
        for(int i = 0; i < data.size(); i++){
            rowData[0] = String.valueOf(data.get(i).getInvoiceId());
            rowData[1] = String.valueOf(data.get(i).getDatetime());
            rowData[2] = String.valueOf(data.get(i).getSubTotal());
            rowData[3] = String.valueOf(data.get(i).getTaxes());
            rowData[4] = String.valueOf(data.get(i).getTotal());
            table.addRow(rowData);
        }
        JTablaInvoices.setModel(table);
    }//GEN-LAST:event_jButtonActualizarFacturasActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        /*System.out.println("Cerrando");
        Login Login = new Login();
        Login.setVisible(true);
        JOptionPane.showMessageDialog(null, "Cerrando");*/
    }//GEN-LAST:event_formWindowClosing

    private void jButtonFacturasRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFacturasRangoActionPerformed
        // Definición de Variables para Fecha
        Date Date1 = this.jDateChooserDesde.getDate();
        long D1 = Date1.getTime();
        java.sql.Date Fecha1 = new java.sql.Date(D1);
        //String Fecha = new java.sql.Date(D1).toString();
        Date Date2 = this.jDateChooserHasta.getDate();
        Calendar C = Calendar.getInstance();
        C.setTime(Date2);
        C.add(Calendar.DATE, 1);
        Date2 = C.getTime();
        long D2 = Date2.getTime();
        java.sql.Date Fecha2 = new java.sql.Date(D2);
        //JOptionPane.showMessageDialog(null, Fecha + "\n" + D1 + "\n" + Date1);
        /*JOptionPane.showMessageDialog(null, "Date 1y2: " + Date1 + " ... " + Date2 + "\n" +
                                            "D1 y D2:  " + D1 + " ... " + D2 + "\n" + 
                                            "" + Fecha1 + " ... " + Fecha2);
        */
        DefaultTableModel table =  new DefaultTableModel();
        ArrayList<invoiceObjectModel> data;
        String[] rowData = new String[5];
        table.addColumn("Factura N°.");
        table.addColumn("Fecha");
        table.addColumn("SubTotal");
        table.addColumn("Impuestos");
        table.addColumn("Total");
        data = db.QueryInvoicesData(Fecha1, Fecha2);
        for(int i = 0; i < data.size(); i++){
            rowData[0] = String.valueOf(data.get(i).getInvoiceId());
            rowData[1] = String.valueOf(data.get(i).getDatetime());
            rowData[2] = String.valueOf(data.get(i).getSubTotal());
            rowData[3] = String.valueOf(data.get(i).getTaxes());
            rowData[4] = String.valueOf(data.get(i).getTotal());
            table.addRow(rowData);
        }
        JTablaInvoices.setModel(table);
    }//GEN-LAST:event_jButtonFacturasRangoActionPerformed

    private void jButtonFacturasDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFacturasDiariasActionPerformed
        // Definición de Variables para Fecha
        Date Date1 = this.jDateChooserDia.getDate();
        long D1 = Date1.getTime();
        java.sql.Date Fecha1 = new java.sql.Date(D1);
        //String Fecha = new java.sql.Date(D1).toString();
        Date Date2 = Date1;
        // En la Fecha2 se le suma un día a la Fecha1
        Calendar C = Calendar.getInstance();
        C.setTime(Date2);
        C.add(Calendar.DATE, 1);
        Date2 = C.getTime();
        long D2 = Date2.getTime();
        java.sql.Date Fecha2 = new java.sql.Date(D2);
        //JOptionPane.showMessageDialog(null, Fecha + "\n" + D1 + "\n" + Date1);
        /*JOptionPane.showMessageDialog(null, "Date 1y2: " + Date1 + " ... " + Date2 + "\n" +
                                            "D1 y D2:  " + D1 + " ... " + D2 + "\n" + 
                                            "" + Fecha1 + " ... " + Fecha2);
        */
        DefaultTableModel table =  new DefaultTableModel();
        ArrayList<invoiceObjectModel> data;
        String[] rowData = new String[5];
        table.addColumn("Factura N°.");
        table.addColumn("Fecha");
        table.addColumn("Sub Total");
        table.addColumn("Impuestos");
        table.addColumn("Total");
        data = db.QueryInvoicesData(Fecha1, Fecha2);
        for(int i = 0; i < data.size(); i++){
            rowData[0] = String.valueOf(data.get(i).getInvoiceId());
            rowData[1] = String.valueOf(data.get(i).getDatetime());
            rowData[2] = String.valueOf(data.get(i).getSubTotal());
            rowData[3] = String.valueOf(data.get(i).getTaxes());
            rowData[4] = String.valueOf(data.get(i).getTotal());
            table.addRow(rowData);
        }
        JTablaInvoices.setModel(table);
    }//GEN-LAST:event_jButtonFacturasDiariasActionPerformed

    private void jButtonActualizarFacturas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarFacturas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizarFacturas1ActionPerformed

    private void jButtonFacturaPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFacturaPrintActionPerformed
        
    }//GEN-LAST:event_jButtonFacturaPrintActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel Modelo = new DefaultTableModel();
        Modelo.addColumn("Pedido Id");
        Modelo.addColumn("Bebida");
        Modelo.addColumn("Precio Bebida");
        Modelo.addColumn("Cant. Bebida");
        Modelo.addColumn("Comida");
        Modelo.addColumn("Precio Comida");
        Modelo.addColumn("Cant. Comida");
        this.JTablaPedido.setModel(Modelo);
        Modelo = db.QueryPedidoData();
        this.JTablaPedido.setModel(Modelo);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTablaInvoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablaInvoicesMouseClicked
        //Mostrar Datos de Factura
        DefaultTableModel Modelo = new DefaultTableModel();
        int Registro = this.JTablaInvoices.getSelectedRow();
        if (Registro >= 0){
            int vPedido = Integer.parseInt(this.JTablaInvoices.getValueAt(Registro, 0).toString());
            Modelo = db.QueryOrderData(vPedido);
            this.JTablaPedido.setModel(Modelo);
        }
    }//GEN-LAST:event_JTablaInvoicesMouseClicked

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
            java.util.logging.Logger.getLogger(TablaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablaInvoices;
    private javax.swing.JTable JTablaPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonActualizarFacturas;
    private javax.swing.JButton jButtonActualizarFacturas1;
    private javax.swing.JButton jButtonFacturaPrint;
    private javax.swing.JButton jButtonFacturasDiarias;
    private javax.swing.JButton jButtonFacturasRango;
    private com.toedter.calendar.JDateChooser jDateChooserDesde;
    private com.toedter.calendar.JDateChooser jDateChooserDia;
    private com.toedter.calendar.JDateChooser jDateChooserHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
