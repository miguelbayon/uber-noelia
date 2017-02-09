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
public class Taxista extends Conductor{

  
    private int equipaje;
    private static final double EXTRAMALETA = 0.02;
    protected static double extra;

    static {
        extra =EXTRAMALETA;
    }
  /**
     * Constructor  de la clase taxista,formado por los siguientes
     * atributos:
     *SUPER
     * @param dni de tipo String, tiene que tener 9 caracteres, siendo los 8
     * primeros números y una letra el último
     * @param minutoCond de tipo entero
     * y SUPER
     * @param personas de tipo entero, más de 7 no caben en el coche,y ha de
     * viajar al menos 1.
     * Y
     * @param equipaje
     */

    public Taxista(String dni, int minutoCond, int personas,int equipaje) {
        super(dni, minutoCond, personas);
        this.equipaje=equipaje;
    }

    public int getEquipaje() {
        return equipaje;
    }

      @Override
    public double getSueldo() {
      double sueldoTotal = 0;
        if (getPersonas() == 1) {
            sueldoTotal = getMinConducido() + SUELDO+(EXTRAMALETA*getEquipaje());
        } else if (getPersonas() > 1 && getPersonas() <= 3) {
            sueldoTotal = (getMinConducido() * 2) + SUELDO+(EXTRAMALETA*getEquipaje());
        }else if(getPersonas()>4){
            sueldoTotal=(getMinConducido()*4)+SUELDO+(EXTRAMALETA*getEquipaje());
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
