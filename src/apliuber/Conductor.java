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
public abstract class Conductor extends Empleado{
     /**
     * Clase Conductor hija de Empleado formada por los siguientes atributos:
     *Heredados:
     * @param dni de tipo String
     * @param sueldo de tipo double, 500 euros de tipo fijo
     * @param precio de tipo double se le suma al sueldo por cada min conducido
     * @param minutoCond de tipo entero minutos que conduce el empleado
     * y
     * @param personas de tipo entero, que son el número de personas que son
     * transportadas
     */

  int personas;
  
 /**
     * Constructor  de la clase Conductor,formado por los siguientes
     * atributos:
     *SUPER
     * @param dni de tipo String, tiene que tener 9 caracteres, siendo los 8
     * primeros números y una letra el último
     * @param minutoCond de tipo entero
     * y
     * @param personas de tipo entero, más de 7 no caben en el coche,y ha de
     * viajar al menos 1.
     */
    public Conductor(String dni, int minutoCond,int personas) {
        super(dni, minutoCond);
        this.personas= (personas<1 || personas>7)? 1:personas;
    }
/**
     * Método abstracto,que nos permite averiguar el número de personas
     * @return dato de tipo entero
     */
    public  abstract int getPersonas();
   

    @Override
    public double getSueldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDNI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return   "Conductor{" + "personas=" + personas + '}';
    }

    
   
    
}
