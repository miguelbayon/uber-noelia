/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apliuber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Noelia
 */
public abstract class Empleado {

    /**
     * Clase Empleado formada por los siguientes atributos:
     *
     * @param dni de tipo String
     * @param sueldo de tipo double, 500 euros de tipo fijo
     * @param precio de tipo double se le suma al sueldo por cada min conducido
     * @param minutoCond de tipo entero minutos que conduce el empleado
     */
    String dni;
    protected static double sueldo;
    static final double SUELDO = 500;

    static {
        sueldo = SUELDO;
    }
    protected static double precio;
    static final double PRECIO = 0.02;

    static {
        precio = PRECIO;
    }
    int minutoCond;

    /**
     * Constructor de la clase Empleado,formado por los siguientes
     * atributos:
     *
     * @param dni de tipo String, tiene que tener 9 caracteres, siendo los 8
     * primeros números y una letra el último
     * @param minutoCond de tipo entero
     */
    public Empleado(String dni, int minutoCond) {
        if (isNif(dni)) {
            this.dni = dni;
        } else {
            this.dni = "71422815h";
        }
        this.minutoCond = minutoCond;
    }

    /**
     * Método abstracto,que es heredado por Conductor y Transportista,clases
     * hijas de la clase Elemento,que nos permite obtener el valor del sueldo
     *
     * @return dato de tipo double en euros
     */
    public abstract double getSueldo();

    /**
     * Método abstracto,que es heredado por Conductor y Transportista,clases
     * hijas de la clase Elemento,que nos permite obtener el valor del dni
     *
     * @return dato de tipo String
     */
    public abstract String getDni();

    /**
     * Método abstracto,que es heredado por Conductor y Transportista,clases
     * hijas de la clase Elemento,que nos permite obtener los minutos conducidos
     *
     * @return dato de tipo entero
     */
    public abstract int getMinConducido();

    /**
     * Método abstracto,que es heredado por Conductor y Transportista,clases
     * hijas de la clase Elemento,que nos permite averiguar si un transporte se
     * ha realizado.Para saber cual, se le proporciona un dato de tipo String
     * dni
     *
     * @return dato de tipo boolean TRUE, SI SE HA LLEVADO A CABO.
     */

    public abstract boolean realizarTransporte(String dni);

    /**
     * Método abstracto,que es heredado por Conductor y Transportista,clases
     * hijas de la clase Elemento,que nos permite VER el valor del sueldo y el
     * DNI del empleado
     */
    public abstract void MostrarSueldo();

    /**
     * Método abstracto,que es heredado por Conductor y Transportista,clases
     * hijas de la clase Elemento,que nos permite VER los minutos conducidos y
     * el DNI del empleado
     */
    public abstract void mostarTransporte();

    /**
     * Método toString,que muestra los parámetros del objeto elemento
     *
     */
    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", minutoCond=" + minutoCond + '}';
    }

    /**
     * Método que nos permite validar si un String introducido es un valor
     * aceptable,que se encuentra dentro del formato requerido
     */
    public static boolean isNif(String valor) {
        return validarB("[1-9]{1}[0-9]{6,7}[A-Z]{1}", valor);
    }

    private static boolean validarB(String expReg, String valor) {
        /*Creamos un objeto patrón a partir de la expresión regular que nos llegue, <BR>
        usando el método static compile() de la clase Pattern
         */
        Pattern patron = Pattern.compile(expReg);
        /* match --- se ajusta
         * seguidamente creamos un objeto Matcher generado a partir del patrón creado.
         */
        Matcher encajador = patron.matcher(valor);
        //por último  este objeto Matcher invoca el método matches()
        //y retorna true o false según que lo cumpla o no

        return encajador.matches();
    }

}
