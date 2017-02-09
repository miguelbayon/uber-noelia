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
public class Chofer extends Conductor {
      /**
     * Clase Chofer nieta de Empleado e hija de Conductor formada por los
     * siguientes atributos:
     *Heredados:
     * @param dni de tipo String
     * @param sueldo de tipo double, 500 euros de tipo fijo
     * @param precio de tipo double se le suma al sueldo por cada min conducido
     * @param minutoCond de tipo entero minutos que conduce el empleado
     * y
     * @param extraPersona de tipo double, que es el extra que se le computa
    
     */


    protected static double extraPersona;
    private static final double EXTRAPERSONA = 0.01;

    static {
        extraPersona = EXTRAPERSONA;
    }
    /**
     * Constructor  de la clase Conductor,formado por los siguientes
     * atributos:
     *SUPER
     * @param dni de tipo String, tiene que tener 9 caracteres, siendo los 8
     * primeros números y una letra el último
     * @param minutoCond de tipo entero
     * y SUPER
     * @param personas de tipo entero, más de 7 no caben en el coche,y ha de
     * viajar al menos 1.
     */

    public Chofer(String dni, int minutoCond, int personas) {
        super(dni, minutoCond, personas);
    }

    public static double getExtraPersona() {
        return extraPersona;
    }

    public static double getEXTRAPERSONA() {
        return EXTRAPERSONA;
    }

    @Override
    public double getSueldo() {
        double sueldoTotal = 0;
        if (getPersonas() == 1) {
            sueldoTotal = getMinConducido() + SUELDO;
        } else if (getPersonas() > 1 && getPersonas() <= 3) {
            sueldoTotal = (getMinConducido() * 2) + SUELDO;
        }else if(getPersonas()>4){
            sueldoTotal=(getMinConducido()*4)+SUELDO;
        }
        return sueldoTotal;
    }

    @Override
    public int getPersonas() {
        return personas;
    }

    @Override
    public int getMinConducido() {
        return minutoCond;
    }

    @Override
    public String getDni() {
      return dni;
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
