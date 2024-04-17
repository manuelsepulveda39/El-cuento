/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Calculos {
    
    private static double IVA = 0.18;
    
    public static double calcularIVA(double valor){
        return valor * IVA;
    }

    /**
     * @return the IVA
     */
    public double getIVA() {
        return IVA;
    }

    /**
     * @param IVA the IVA to set
     */
    public void setIVA(double IVA) {
        this.IVA = IVA;
    }
}
