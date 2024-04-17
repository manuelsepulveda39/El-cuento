/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Auto {
    
    private final String marca;
    private final String referencia;
    private final String codigo;
    private final String peso;
    private final String valor;
    private final String potencia;
    private final String cilindraje;
    private final String nacionalidad;
    private final String capaPasa;
    private final String capaCarga;
    private final String puertas;
    private final String aireAco;
    private final String combustible;
    private final String transmicion;

    public Auto(String marca, String referencia, String codigo, String peso, String valor, String potencia, String cilindraje, String nacionalidad, String capaPasa, String capaCarga, String puertas, String aireAco, String combustible, String transmicion) {
        this.marca = marca;
        this.referencia = referencia;
        this.codigo = codigo;
        this.peso = peso;
        this.valor = valor;
        this.potencia = potencia;
        this.cilindraje = cilindraje;
        this.nacionalidad = nacionalidad;
        this.capaPasa = capaPasa;
        this.capaCarga = capaCarga;
        this.puertas = puertas;
        this.aireAco = aireAco;
        this.combustible = combustible;
        this.transmicion = transmicion;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return the peso
     */
    public String getPeso() {
        return peso;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @return the potencia
     */
    public String getPotencia() {
        return potencia;
    }

    /**
     * @return the cilindraje
     */
    public String getCilindraje() {
        return cilindraje;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @return the capaPasa
     */
    public String getCapaPasa() {
        return capaPasa;
    }

    /**
     * @return the capaCarga
     */
    public String getCapaCarga() {
        return capaCarga;
    }

    /**
     * @return the puertas
     */
    public String getPuertas() {
        return puertas;
    }

    /**
     * @return the aireAco
     */
    public String getAireAco() {
        return aireAco;
    }

    /**
     * @return the combustible
     */
    public String getCombustible() {
        return combustible;
    }

    /**
     * @return the transmicion
     */
    public String getTransmicion() {
        return transmicion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Auto{");
        sb.append("codigo=").append(codigo);
        sb.append(", peso=").append(peso);
        sb.append(", valor=").append(valor);
        sb.append(", potencia=").append(potencia);
        sb.append(", cilindraje=").append(cilindraje);
        sb.append(", nacionalidad=").append(nacionalidad);
        sb.append(", capaPasa=").append(capaPasa);
        sb.append(", capaCarga=").append(capaCarga);
        sb.append(", puertas=").append(puertas);
        sb.append(", aireAco=").append(aireAco);
        sb.append(", combustible=").append(combustible);
        sb.append(", transmicion=").append(transmicion);
        sb.append('}');
        return sb.toString();
    }
}
