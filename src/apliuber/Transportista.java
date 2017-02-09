/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apliuber;

/**
 *
 * @author Noelia
 */
public class Transportista extends Empleado{
     /**
     * Clase Conductor hija de Transportista formada por los siguientes atributos:
     *Heredados:
     * @param dni de tipo String
     * @param sueldo de tipo double, 500 euros de tipo fijo
     * @param precio de tipo double se le suma al sueldo por cada min conducido
     * @param minutoCond de tipo entero minutos que conduce el empleado
     * y
     * @param personas de tipo entero, que son el número de personas que son
     * transportadas
     */
    private int kilos;
    private static final double EXTRAKILO =0.02;
    protected static double extra;

    static {
        extra =EXTRAKILO;
    }
 /**
     * Constructor  de la clase Transportista,formado por los siguientes
     * atributos:
     *SUPER
     * @param dni de tipo String, tiene que tener 9 caracteres, siendo los 8
     * primeros números y una letra el último
     * @param minutoCond de tipo entero
     * y
     * @param kilos de tipo entero, más de 70 no caben en el coche,y ha de
     * viajar al menos 1kg.
     */
    public Transportista(String dni, int minutoCond,int kilos) {
        super(dni, minutoCond);
        this.kilos=(kilos<1 || kilos>70)? 1:kilos;
    }

    public int getKilos() {
        return kilos;
    }

    @Override
    public double getSueldo() {
       double sueldoTotal=0;
       sueldoTotal=SUELDO+(EXTRAKILO*getKilos());
        return sueldoTotal;
    }

    @Override
    public String getDni() {
       return dni;
    }

    @Override
    public int getMinConducido() {
        return minutoCond;
    }

    @Override
    public boolean realizarTransporte(String dni){
        boolean realizado=false;
        if(getDni().equals(dni)){
            realizado=true;
        }
        
        return realizado;
    }

    @Override
    public void MostrarSueldo() {
        System.out.println("\n DNI Empleado: "+getDni()+ " Sueldo: "+getSueldo());
    }

    @Override
    public void mostarTransporte() {
         System.out.println("\n DNI Empleado: "+getDni()+ " Transporte: "+getMinConducido());
    }
    
   
    
}
