package com.is210q12022.is210.sistema.restaurante;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Factura {
    
    public void pdf(Integer idp) throws BadElementException, IOException{
        try{
            // Inicializa variables
            dbManager db = new dbManager();
            invoiceObjectModel iom = new invoiceObjectModel();
            ArrayList<productObjectModel> data;
            data = db.PedidosData(idp);
            Date date = new Date();
            String fechaf = new SimpleDateFormat("yyyy-MM-dd").format(date);

            // Inicia la creacion del PDF
            FileOutputStream archivo;
            File file = new File("src/main/java/pdf/factura-" + fechaf + "-" + idp + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            
            doc.open();
            
            // Datos del Encabezado
            Image img = Image.getInstance("src/main/java/images/logopdf.png");
            Paragraph fecha = new Paragraph();
            
            Font fboldtable = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.WHITE);
            Font ftitulo = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Factura: #" + fechaf + "-" + idp +"\nFecha: "+ new SimpleDateFormat("dd/MM/yyyy").format(date)+"\n\n");
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{25f, 10f, 80f, 50f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            String cai = "031900815480";
            String tel = "2771-5700";
            String dir = "Carretera salida a Tegucigalpa, contiguo a Ferromax";
            Encabezado.addCell(img);
            Encabezado.addCell("");
            Encabezado.addCell("\nRestaurante IS210-CURC\nCAI: "+ cai +"\nTelefono: "+ tel +"\nDireccion: "+ dir);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            // Titulo de "Factura"
            PdfPTable Titulo = new PdfPTable(3);
            Titulo.setWidthPercentage(100);
            Titulo.getDefaultCell().setBorder(0);
            float[] ColumnaTitulo = new float[]{100f, 40f, 100f};
            Titulo.setWidths(ColumnaTitulo);
            Titulo.setHorizontalAlignment(Element.ALIGN_MIDDLE);
            PdfPCell titulo1 = new PdfPCell(new Phrase("\nFACTURA\n\n", ftitulo));
            titulo1.setBorder(0);
            Titulo.addCell("");
            Titulo.addCell(titulo1);
            Titulo.addCell("");
            doc.add(Titulo);
            
            // Lista de los productos comprados
            PdfPTable tablapro = new PdfPTable(4);
            tablapro.setWidthPercentage(100);
            tablapro.getDefaultCell().setBorder(0);
            float[] Columnapro = new float[]{15f, 45f, 20f, 20f};
            tablapro.setWidths(Columnapro);
            tablapro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("Cantidad",fboldtable));
            PdfPCell pro2 = new PdfPCell(new Phrase("Descripción",fboldtable));
            PdfPCell pro3 = new PdfPCell(new Phrase("Precio Unitario",fboldtable));
            PdfPCell pro4 = new PdfPCell(new Phrase("Precio Total",fboldtable));
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);
            pro1.setBackgroundColor(BaseColor.DARK_GRAY);
            pro2.setBackgroundColor(BaseColor.DARK_GRAY);
            pro3.setBackgroundColor(BaseColor.DARK_GRAY);
            pro4.setBackgroundColor(BaseColor.DARK_GRAY);
            tablapro.addCell(pro1);
            tablapro.addCell(pro2);
            tablapro.addCell(pro3);
            tablapro.addCell(pro4);
            
            Float subtotal;
            Float impuestos;
            Float totalpagar = Float.parseFloat("0");
            
            for(int i = 0; i < data.size(); i++){
                
                Integer cantidadb = data.get(i).getCantb();
                String productob = data.get(i).getBebida();
                Float preciob = data.get(i).getPriceb();
                Integer cantidadc = data.get(i).getCantc();
                String productoc = data.get(i).getComida();
                Float precioc = data.get(i).getPricec();
                Float totalb = cantidadb * preciob;
                Float totalc = cantidadc * precioc;
                
                tablapro.addCell(String.valueOf(cantidadc));
                tablapro.addCell(String.valueOf(productoc));
                tablapro.addCell(String.valueOf(precioc));
                tablapro.addCell(String.valueOf(totalc));
                
                tablapro.addCell(String.valueOf(cantidadb));
                tablapro.addCell(String.valueOf(productob));
                tablapro.addCell(String.valueOf(preciob));
                tablapro.addCell(String.valueOf(totalb));

                totalpagar = totalpagar + totalb + totalc;
            }
            doc.add(tablapro);
            
            impuestos = (totalpagar/115)*15;
            subtotal = (totalpagar/115)*85;
            
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Subtotal:  " + Math.round(subtotal*100.0)/100.0 + "\n");
            info.add("Impuestos:  " + Math.round(impuestos*100.0)/100.0 + "\n");
            info.add("Total a Pagar:  " + totalpagar);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("\n\n_____________________\n");
            firma.add("Sello y Firma\n");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("\n\n¡Gracias por su compra!\nEsperamos que regrese Pronto!");
            mensaje.add("\nLa factura es beneficio de todos\n¡¡¡EXIJALA!!!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            
        // Termina la edicion del documento  
            doc.close();
            archivo.close();
        
        // Guarda los Datos como ser SubTotal, Impuestos y Total en la Base de Datos
            iom.setSubTotal((float) (Math.round(subtotal*100.0)/100.0));
            iom.setTaxes((float) (Math.round(impuestos*100.0)/100.0));
            iom.setTotal(totalpagar);
            if(db.registerInvoices(iom)){
                System.out.println("Se guardo los Datos de la Factura, correctamente");
            } else{
                System.out.println("Error al guardar los datos de la factura");
            }
            
        // Abre el documento al terminar de crearlo
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println("Error: " +e);
        }
        
    } 
}
