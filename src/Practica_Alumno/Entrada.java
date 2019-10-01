package Practica_Alumno;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<String, Alumno> alumnos = new Hashtable();
        ArrayList<Integer> matriculasUsadas = new ArrayList<>();
        int op;
        int m;
        String dni;

        do {
            System.out.println("Agregar alumno ");
            System.out.println("Buscar alumno ");
            System.out.println("Borrar alumno ");
            System.out.println("Listar alumnos ");
            System.out.println("Listar dnis ");
            System.out.println("Salir ");
            System.out.println("Introduce una opción: ");
            op = sc.nextInt();
            sc.nextLine();



            switch (op) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = sc.next();
                    sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = sc.next();
                    sc.nextLine();
                    do {
                        System.out.println("DNI: ");
                        dni = sc.next();
                        sc.nextLine();


                    } while (alumnos.containsKey(dni));

                    do {
                        m = (int) (Math.random() * 1000);
                    }
                    while (matriculasUsadas.contains(m));
                    System.out.println("Tu matricula es: \n" + m);
                    matriculasUsadas.add(m);
                    alumnos.put(dni, new Alumno(nombre, apellido, dni, m));


                    break;
                case 2:
                    System.out.println("Introduce el dni: ");
                    dni = sc.next();
                    if (alumnos.containsKey(dni)) {
                        Alumno aEncontrado = alumnos.get(dni);
                        System.out.printf("El alumno es %s %s con DNI %s y matricula %d \n",aEncontrado.getNombre(),aEncontrado.getApellido(),aEncontrado.getDni(),aEncontrado.getMatricula());
                    } else {
                        System.out.println("No está.");
                    }
                    break;
                case 3:
                    System.out.println("Introduce el dni: ");
                    String borrar = new Scanner(System.in).next();
                    alumnos.remove(borrar);
                    break;
                case 4:
                    Enumeration<Alumno> elementos = alumnos.elements();
                    while (elementos.hasMoreElements()) {
                        Alumno siguiente = elementos.nextElement();
                        System.out.printf(" %s %s %s %d \n",siguiente.getNombre(),siguiente.getApellido(),siguiente.getDni(),siguiente.getMatricula());
                    }
                    break;

            }
        } while (op != 6);
    }


}
