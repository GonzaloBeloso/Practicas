package Practica_Temperatura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> temperaturas = new ArrayList();
        int opcion;
        double temp;
        do {
            System.out.println("Introducir temperaturas");
            System.out.println("Mostrar temperaturas");
            System.out.println("Ordenar temperaturas");
            System.out.println("Mostrar extremos");
            System.out.println("Mostrar medias");
            System.out.println("Salir");
            System.out.println("Introduce una opción: ");
            System.out.println("__________________________");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Introduce una temperatura:");
                    System.out.println("-----------------------------");
                    temp = sc.nextDouble();
                    sc.nextLine();
                    temperaturas.add(temp);
                    System.out.println("-----------------------------");
                    break;
                case 2:
                    if(!temperaturas.isEmpty())
                    {
                        System.out.println("-----------------------------");
                        System.out.println("Lista de temperaturas:");
                        System.out.println("-----------------------------");
                        int i=1;
                        for (double item:temperaturas)
                        {
                            System.out.printf("%d. %f \n",i,item);
                            i++;
                        }
                    }
                    else
                    {
                        System.out.println("Tienes que introducir las  temperaturas para poder listarlas.");
                    }

                    System.out.println("-----------------------------");
                    break;
                case 3:
                    if (!temperaturas.isEmpty())
                    {
                        System.out.println("-----------------------------");
                        System.out.println("Lista de temperaturas ordenadas ");
                        System.out.println("-----------------------------");
                        Collections.sort(temperaturas);
                        int i=1;
                        for (double item:temperaturas)
                        {
                            System.out.printf("%d. %f \n",i,item);
                            i++;
                        }
                    }
                    else
                    {
                        System.out.println("Tienes que introducir las temperaturas para poder ordenarlas.");
                    }

                    System.out.println("-----------------------------");
                    break;
                case 4:
                    if (!temperaturas.isEmpty())
                    {
                        System.out.println("-----------------------------");
                        System.out.println("Temperatura más baja");
                        System.out.println(temperaturas.get(0));
                        System.out.println("Temperatura mas alta");
                        System.out.println(temperaturas.get(temperaturas.size()-1));
                        System.out.println("-----------------------------");
                    }
                    else
                    {
                        System.out.println("Tienes que introducir temperaturas y ordenarlas para poder ver las más altas y las más bajas.");
                    }


                    break;
                case 5:
                    if (!temperaturas.isEmpty())
                    {
                        double  media = 0;
                        for (int i = 0;i < temperaturas.size(); i++)
                        {
                            media = media + temperaturas.get(i);
                        }
                        double total= 0.0;
                        total = (double) media/temperaturas.size();
                        System.out.println("La media es:"+total);

                    }
                    else
                    {
                        System.out.println("Tienes que introducir temperaturas para poder ver la media.");
                    }
                    break;
            }

        }while (opcion!=5);
    }


}
