/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ManejoCliente {
    private static ManejoCliente instancia = null;
    private ArrayList<Auto> autos = new ArrayList<>();
    private Cliente cliente;
    
    public static ManejoCliente obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejoCliente();
        }
        return instancia;
    }
    
    public void guardarCliente(String nombre, String id, String telefono, String direccion){
        cliente = new Cliente(nombre, id, telefono, direccion);
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public ArrayList<Auto> getAutos(){
        return autos;
    }
    
    public void agregarAuto(Auto auto){
        autos.add(auto);
    }
    
    public int cantAutos(){
        return autos.size();
    }
}
