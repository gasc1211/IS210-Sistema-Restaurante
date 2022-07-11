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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    public void pdf() throws BadElementException, IOException{
        try{
            FileOutputStream archivo;
            File file = new File("src/main/java/pdf/factura.pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            
            doc.open();
            
        //Datos del Encabezado
            Image img = Image.getInstance("src/main/java/images/logopdf.png");
            Paragraph fecha = new Paragraph();
            
            Font fboldtable = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            Font ftitulo = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Factura: 1\n"+ "Fecha: "+ new SimpleDateFormat("dd/MM/yyyy").format(date)+"\n\n");
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);
            String rtn = "21371238123122";
            String nom = "IS CURC";
            String tel = "2772-0000";
            String dir = "Comayagua, Comayagua";
            Encabezado.addCell("");
            Encabezado.addCell("RTN: "+ rtn +"\nNombre: "+ nom +"\nTelefono: "+ tel +"\nDireccion: "+ dir);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
        //Titulo de "Factura"
            PdfPTable Titulo = new PdfPTable(3);
            Titulo.setWidthPercentage(100);
            Titulo.getDefaultCell().setBorder(0);
            float[] ColumnaTitulo = new float[]{100f, 40f, 100f};
            Titulo.setWidths(ColumnaTitulo);
            Titulo.setHorizontalAlignment(Element.ALIGN_MIDDLE);
            PdfPCell titulo1 = new PdfPCell(new Phrase("FACTURA", ftitulo));
            titulo1.setBorder(0);
            Titulo.addCell("");
            Titulo.addCell(titulo1);
            Titulo.addCell("");
            doc.add(Titulo);
            
        //Termina la edicion del documento  
            doc.close();
            archivo.close();
            
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Error: " +e);
        }
    }
}
