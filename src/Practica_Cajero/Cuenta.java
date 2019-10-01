package Practica_Cajero;

public class Cuenta {
    private int numero, pin, saldo;
    private String dni;

    public Cuenta(){
        this.numero = 0;
        this.pin = 0;
        this.saldo = 0;
        this.dni = "0";
    }
    public Cuenta(int numero, int pin, int saldo, String dni){
        this.numero = numero;
        this.pin = pin;
        this.saldo = saldo;
        this.dni = dni;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getPin() {
        return pin;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String toString() {
        return "Numero de cuenta: " + getNumero() +
                "Saldo: " + getSaldo() +
                "Dni asociado: " + getDni();
    }

    public void sacarDinero(Cuenta cuenta, int retirada, int pin) {
        if (cuenta.getPin() == pin){
            if (cuenta.getSaldo() - retirada >= 0) {
                cuenta.setSaldo(cuenta.getSaldo() - retirada);
                System.out.printf("Has sacado %d€ de la cuenta", retirada);
            }
            else
                System.out.println("No hay suficiente saldo");
        }
        else
            System.out.println("El pin es incorrecto");
    }

    public void meterDinero(Cuenta cuenta, int ingreso, int pin) {
        if (cuenta.getPin() == pin){
            cuenta.setSaldo(cuenta.getSaldo() + ingreso);
            System.out.printf("Has ingresado %d€ en la cuenta", ingreso);
        }
        else
            System.out.println("El pin es incorrecto");
    }
}
