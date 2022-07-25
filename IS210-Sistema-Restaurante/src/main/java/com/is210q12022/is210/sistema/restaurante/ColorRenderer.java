package com.is210q12022.is210.sistema.restaurante;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                 
       String col5 = table.getValueAt(row, 5).toString();
      
        if (col5.equals("Pendiente")){
        setBackground(Color.red);
        setForeground(Color.white);
        }else if (col5.equals("Entregado")){
        setBackground(Color.green);
        setForeground(Color.black);
        }else if (col5.equals("")){
        Color c = new Color(242, 242, 242);
        setBackground(c);

        }
       

       
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}


