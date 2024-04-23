package clases;

/**
 *
 * @author Usuario
 */

import java.io.IOException;
import java.util.ArrayList;

public class Prueba{
    
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
        Cliente cliente = new Cliente("Manuel", "1035", "311", "cra 71");
        PDF.crearFactura(cliente, autos);
        
        System.out.println("");
        System.out.println(man.buscarAuto("MERCEDES BENZ", "CAMPERO", "Particular", "G 63 [W463] AMG TP 5500CC V8 T", "2017").toString());
    }
}
