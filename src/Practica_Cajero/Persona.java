package Practica_Cajero;

import java.util.Enumeration;
import java.util.Hashtable;

public class Persona {
    private String dni, nombre, apellido;
    private Hashtable<Integer, Cuenta> cuentas = new Hashtable();


    public Persona(){
        this.nombre = "";
        this.apellido = "";
        this.dni = "0";
        this.cuentas = new Hashtable();
    }
    public Persona(String nombre, String apellido, String dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cuentas = new Hashtable();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Hashtable<Integer, Cuenta> getCuentas() {
        return cuentas;
    }
    public void setCuentas(Hashtable<Integer, Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    @Override
    public String toString() {
        String perTS, cueStr = "";
        Enumeration<Cuenta> enumCuenta = null;
        int cont = 0;
        perTS =  "Dni: " + getDni() +
                "Nombre: " + getNombre() +
                "Apellido: " + getApellido();
           enumCuenta = this.cuentas.elements();
        if (!this.cuentas.isEmpty())
        while (enumCuenta.hasMoreElements()){
            cont++;
            Cuenta cuenta = enumCuenta.nextElement();
            cueStr += "Cuenta" + cont + ".:" + cuenta.toString() + "";
        }
        return perTS + cueStr;
    }
    public void registrarCuenta(Cuenta cuenta){
        this.getCuentas().put(cuenta.getNumero(), cuenta);
        System.out.printf("Se ha agregado la cuenta %d", cuenta.getNumero());
    }

    public void quitarCuenta(int numero, int pin){
        if (this.getCuentas().containsKey(numero)){
            if (this.getCuentas().get(numero).getPin() == pin) {
                System.out.printf("Se ha eliminado la cuenta %d", this.getCuentas().remove(numero).getNumero());
            }
            else
                System.out.println("El pin introducido es incorrecto");
        }
        else
            System.out.println("No se ha encontrado la cuenta");
    }

}
