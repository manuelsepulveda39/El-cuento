/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Manuel
 */

public class PDF {
    private static int numRecibo = 0;
    
    public static void crearFactura(Cliente cliente, ArrayList<Auto> autos) throws IOException{
        
        Document documento = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("factura.pdf"));

            documento.open();
            
            // Agregar imagen
            Image logo = Image.getInstance("src\\main\\java\\Imagenes\\logo.jpg");
            logo.scaleToFit(100, 100); // Ajustar tamaño
            documento.add(logo);
            
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("Numero de recibo: " + numRecibo));
            
            // Agregar nombre y número del cliente
            documento.add(new Paragraph("\n\nNombre del cliente: " + cliente.getNombre()));
            documento.add(new Paragraph("Número del cliente: " + cliente.getId()));
            documento.add(new Paragraph("Telefono del cliente: " + cliente.getTelefono()));
            documento.add(new Paragraph("Dirección del cliente: " + cliente.getDireccion()));
            documento.add(new Paragraph("\n"));
            
            // Agregar información del vehículos en una tabla
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.addCell("Codigo");
            tabla.addCell("Marca");
            tabla.addCell("Referencia");
            tabla.addCell("Valor");
            double total = 0;

            for (Auto auto : autos) {
                tabla.addCell(auto.getCodigo());
                tabla.addCell(auto.getMarca());
                tabla.addCell(auto.getReferencia());
                tabla.addCell(auto.getValor());
                total += Integer.parseInt(auto.getValor());
            }
            
            documento.add(tabla);
            
            // Calcular total con IVA
            double iva = Calculos.calcularIVA(total);
            double totalConIVA = total + iva;

            // Agregar espacio entre la tabla de autos y la tabla de totales
            documento.add(new Paragraph("\n"));

            // Agregar tabla de totales
            PdfPTable tablaTotales = new PdfPTable(2);
            tablaTotales.setWidthPercentage(50);
            tablaTotales.addCell("Total:");
            tablaTotales.addCell(String.valueOf(total));
            tablaTotales.addCell("Total con IVA (18%):");
            tablaTotales.addCell(String.valueOf(totalConIVA));

            documento.add(tablaTotales);
            documento.close();

            numRecibo += 1;
        } catch (DocumentException | java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
