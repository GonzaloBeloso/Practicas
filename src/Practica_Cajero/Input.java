package Practica_Cajero;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Cuenta c = new Cuenta();
        Banco b = new Banco();
        Scanner sc = new Scanner(System.in);
        int op = 0, op2 = 0, op3 = 0, opcion;
        String id;
        b.inicializar();
        do {
            System.out.println("Elija un menu");
            System.out.println("Personas Cuentas Cajero Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1: {
                        System.out.println("Bienvenido al menu de personas");
                    do {
                        System.out.println("Agregar persona");
                        System.out.println("Quitar persona");
                        System.out.println("Listar personas");
                        System.out.println("Volver al menu principal");
                        System.out.println("Salir");
                        System.out.println("Elija el opcion");
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op) {
                            case 1: {
                                Persona persona;
                                String nombre, dni, apellido;
                                System.out.print("Introduzca el nombre: ");
                                nombre = sc.nextLine();
                                System.out.print("Introduzca el apellido: ");
                                apellido = sc.nextLine();
                                System.out.print("Introduzca el dni: ");
                                dni = sc.nextLine();
                                persona = new Persona(nombre, apellido, dni);
                                b.crearPersona(persona);
                                break;
                            }
                            case 2: {
                                String dni;
                                System.out.println("Introduzca el dni de la persona");
                                dni = sc.nextLine();
                                b.quitarPersona(dni);
                                break;
                            }
                            case 3: {
                                b.listarPersonas();
                                break;
                            }
                            case 4: {
                                System.out.println("Volviendo al menu anterior");
                                break;
                            }
                            case 5: {
                                System.out.println("Gracias por su visita");
                                break;
                            }
                            default: {
                                System.out.println("Opcion incorrecta");
                                break;
                            }
                        }
                    } while (op != 4 && op != 5);
                    break;
                }
                case 2: {
                    Persona persona = null;
                    System.out.println("Introduzca su dni");
                    id = sc.nextLine();
                    if (b.getPersonas().containsKey(id))
                        persona = b.getPersonas().get(id);
                    else {
                        System.out.println("El dni es incorrecto");
                        break;
                    }
                    System.out.printf("Hola %s, bienvenido al menu de cuenta", b.getPersonas().get(id).getNombre());
                    do {
                        System.out.println("Agregar cuenta");
                        System.out.println("Quitar cuenta");
                        System.out.println("Ver cuentas");
                        System.out.println("Volver al menu principal");
                        System.out.println("Salir");
                        System.out.println("Elija el opcion");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        switch (op2) {
                            case 1: {
                                System.out.println("Introduzca el numero de cuenta");
                                int numero = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Introduzca el pin");
                                int pin = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Introduzca el saldo inicial");
                                int saldo = sc.nextInt();
                                sc.nextLine();
                                Cuenta cuenta = new Cuenta(numero, pin, saldo, id);
                                persona.registrarCuenta(cuenta);
                                break;
                            }
                            case 2: {
                                System.out.println("Introduzca el numero de cuenta");
                                int numero = sc.nextInt();
                                System.out.println("Introduzca el pin");
                                int pin = sc.nextInt();
                                sc.nextLine();
                                persona.quitarCuenta(numero, pin);
                                break;
                            }
                            case 3: {
                                persona.listarCuentas();
                                break;
                            }
                            case 4: {
                                System.out.println("Volviendo al menu anterior");
                                break;
                            }
                            case 5: {
                                System.out.println("Gracias por su visita");
                                break;
                            }
                            default: {
                                System.out.println("Opcion incorrecta");
                                break;
                            }
                        }
                    } while (op2 != 4 && op2 != 5);
                    break;
                }
                case 3: {
                    Persona persona = null;
                    Cuenta cuenta = null;
                    int numero;
                    System.out.println("Introduzca su dni");
                    id = sc.nextLine();
                    if (b.getPersonas().containsKey(id))
                        persona = b.getPersonas().get(id);
                    else {
                        System.out.println("Dni incorrecto");
                        break;
                    }
                    System.out.println("Introduzca un numero de cuenta");
                    numero = sc.nextInt();
                    sc.nextLine();
                    if (persona.getCuentas().containsKey(numero)) {
                        cuenta = persona.getCuentas().get(numero);
                    }
                    else {
                        System.out.println("El numero de cuenta no es valido");
                        break;
                    }
                    System.out.println("Bienvenido al cajero");
                    do {
                        System.out.println("Sacar dinero");
                        System.out.println("Meter dinero");
                        System.out.println("Ver saldo");
                        System.out.println("Volver al menu principal");
                        System.out.println("Salir");
                        System.out.println("Elija el opcion");
                        op3 = sc.nextInt();
                        sc.nextLine();
                        switch (op3) {
                            case 1: {
                                System.out.println("Cuanto dinero quiere sacar?");
                                int retirada = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Introduzca el pin");
                                int pin = sc.nextInt();
                                sc.nextLine();
                                if (cuenta != null)
                                    c.sacarDinero(cuenta, retirada, pin);
                                else
                                    System.out.printf("%s no tiene cuentas", persona.getNombre());
                                break;
                            }
                            case 2: {
                                System.out.println("Cuanto dinero quiere meter?");
                                int ingreso = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Introduzca el pin");
                                int pin = sc.nextInt();
                                sc.nextLine();
                                if (cuenta != null)
                                    c.meterDinero(cuenta, ingreso, pin);
                                else
                                    System.out.printf("%s no tiene cuentas", persona.getNombre());
                                break;
                            }
                            case 3: {
                                if (cuenta != null)
                                    System.out.printf("El saldo de su cuenta es de %d$", cuenta.getSaldo());
                                else
                                    System.out.printf("%s no tiene cuentas", persona.getNombre());
                                break;
                            }
                            case 4: {
                                System.out.println("Volver");
                                break;
                            }
                            case 5: {
                                System.out.println("Gracias");
                                break;
                            }
                            default: {
                                System.out.println("Opción incorrecta");
                                break;
                            }
                        }
                    }while (op3 != 4 && op3 != 5);
                    break;
                }
                case 4: {
                    System.out.println("Gracias");
                    break;
                }
                default: {
                    break;
                }
            }
        }while (opcion != 4 && op != 5 && op2 != 5 && op3 != 5);
    }

}
