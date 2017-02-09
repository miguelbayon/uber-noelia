/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apliuber;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author Noelia
 */
public class Uber {

    private ArrayList<Empleado> empleados;
    Empleado emple;
    private int min;
    Scanner teclado = new Scanner(System.in);

    public Uber() {
        this.empleados = new ArrayList<>();
    }

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

    public boolean agregarEmpleado(String dni) {
        //validar
        boolean agregado = false;
        if (isNif(dni)) {
            agregado = true;
            System.out.println("Introduzca minutos conducidos: ");
            min = teclado.nextInt();

            emple = new Empleado(dni, min) {
                @Override
                public double getSueldo() {
                    throw new UnsupportedOperationException("Not supported yet."); //To chaed methods, choose Tools | Templates.
                }

                @Override
                public String getDni() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int getMinConducido() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean realizarTransporte(String dni) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void MostrarSueldo() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mostarTransporte() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            empleados.add(emple);
        }
        return agregado;
    }

    public boolean realizarTransporte(String dni) {
        boolean realizado = false;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(dni)) {
                realizado = true;
            }
        }
        return realizado;
    }

    public String sueldoDni() {
        String dni = "";
        ArrayList<Empleado> copia = new ArrayList<Empleado>();
        for (int i = 0; i < empleados.size(); i++) {
            copia.add(empleados.get(i));
        }
        Empleado aux;
        for (int j = 0; j < copia.size() - 1; j++) {
            for (int k = 0; k < copia.size() - j - 1; k++) {
                if (copia.get(k + 1).getSueldo() > copia.get(k).getSueldo()) {
                    aux = copia.get(k + 1);
                    copia.set(k + 1, copia.get(k));
                    copia.set(k, aux);
                }
            }
        }
        dni = copia.get(0).getDni();
        return dni;
    }

    public void mostrarSueldos() {
        for (int i = 0; i < empleados.size(); i++) {
            empleados.get(i).MostrarSueldo();
        }
    }

    public void mostrarTransporteConductor() {
       ArrayList<Empleado> copia = new ArrayList<Empleado>();
        for (int i = 0; i < empleados.size(); i++) {
            copia.add(empleados.get(i));
        }
        Empleado aux;
        for (int j = 0; j < copia.size() - 1; j++) {
            for (int k = 0; k < copia.size() - j - 1; k++) {
                if (copia.get(k + 1).getSueldo() > copia.get(k).getSueldo()) {
                    aux = copia.get(k + 1);
                    copia.set(k + 1, copia.get(k));
                    copia.set(k, aux);
                }
            }
        }
        for(int j=0;j<copia.size();j++){
            copia.get(j).toString();
        }
    }
    public double costeTransporteMinuto(){
      double  MinTotal=0;
      double SueldoTotal=0;
      double costeMinTotal=0;
      for(int i=0;i<empleados.size();i++){
          MinTotal+=empleados.get(i).getMinConducido();
      }
      for(int i=0;i<empleados.size();i++){
          SueldoTotal+=empleados.get(i).getSueldo();
      }
      costeMinTotal=SueldoTotal/MinTotal;
      return costeMinTotal;
    }

}
