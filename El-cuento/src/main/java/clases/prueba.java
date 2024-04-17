/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */

import java.io.IOException;
import java.util.ArrayList;

public class prueba {
    
    static ArrayList<Auto> autos = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        ManejoAutos man = new ManejoAutos();
        
        ArrayList<String> marcas = man.buscarMarcas();
        for(String marca : marcas){
            System.out.print(marca + ", ");
        }
        
        System.out.println("");
        System.out.println("Años:");
        
        ArrayList<String> anos = man.buscarAnos("MERCEDES BENZ", "CAMPERO", "Particular", "G 63 [W463] AMG TP 5500CC V8 T");
        for(String ano : anos){
            System.out.print(ano + ", ");
        }
        
        autos.add(man.buscarAuto("MERCEDES BENZ", "CAMPERO", "Particular", "G 63 [W463] AMG TP 5500CC V8 T", "2017"));
        autos.add(man.buscarPorCodigo("04208084", "2023"));
        
        PDF.crearFactura("Manuel", "1035", autos);
        
        System.out.println("");
        System.out.println(man.buscarAuto("MERCEDES BENZ", "CAMPERO", "Particular", "G 63 [W463] AMG TP 5500CC V8 T", "2017").toString());
    }
}
