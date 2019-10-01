package Practica_Multimedia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
	public static void main(String[] args){
		int opcion=0;
		Controlador controlador=new Controlador();
		Scanner sc=new Scanner(System.in);
		do
			{
			System.out.println("1.- Añadir multimedia");
			System.out.println("2.- Borrar multimedia");
			System.out.println("3.- Listar elementos");
			System.out.println("4.- Importar");
			System.out.println("5.- Exportar");
			System.out.println("6.- Salir");
			opcion=sc.nextInt();
			sc.nextLine();
			switch(opcion)
			{
				case 1:
				{
					System.out.println("1.- Libro");
					System.out.println("2.- Musica");
			 		System.out.println("3.- Pelicula");
			 		int opcion2=sc.nextInt();
			 		sc.nextLine();
					if (opcion2==1)
					{
						String titulo,autor;
						int ano,codigo,edicion,paginas;
						boolean digital;
						System.out.println("Titulo: ");
						titulo=sc.nextLine();
						System.out.println("Autor: ");
						autor=sc.nextLine();
						System.out.println("Año: ");
						ano=sc.nextInt();
						sc.nextLine();
						System.out.println("Codigo: ");
						codigo=sc.nextInt();
						sc.nextLine();
						System.out.println("Edicion: ");
						edicion=sc.nextInt();
						sc.nextLine();
						System.out.println("Soporte (true/false): ");
						digital=sc.nextBoolean();
						sc.nextLine();
						System.out.println("Paginas: ");
						paginas=sc.nextInt();
						sc.nextLine();
						controlador.añadir(new Libros(titulo,autor,ano,codigo,edicion,digital,paginas));
					}
					if (opcion2==2)
					{
						String titulo,autor,formato;
						int ano,codigo;
						boolean esDirecto;
						double duracion;
						System.out.println("Titulo: ");
						titulo=sc.nextLine();
						System.out.println("Autor: ");
						autor=sc.nextLine();
						System.out.println("Ano: ");
						ano=sc.nextInt();
						sc.nextLine();
						System.out.println("Codigo: ");
						codigo=sc.nextInt();
						sc.nextLine();
						System.out.println("Formato: ");
						formato=sc.nextLine();
						System.out.println("Directo (true/false): ");
						esDirecto=sc.nextBoolean();
						sc.nextLine();
						System.out.println("Duracion: ");
						duracion=sc.nextDouble();
						sc.nextLine();
						controlador.añadir(new Musica(titulo,autor,ano,codigo,formato,esDirecto,duracion));
					}
					if (opcion2==3)
					{
						String titulo,autor,pais,actor;
						int ano,codigo;
						double duracion;
							System.out.println("Titulo: ");
							titulo=sc.nextLine();
							System.out.println("Autor: ");
							autor=sc.nextLine();
							System.out.println("Año: ");
							ano=sc.nextInt();
							sc.nextLine();
							System.out.println("Codigo: ");
							codigo=sc.nextInt();
							sc.nextLine();
							System.out.println("Pais: ");
							pais=sc.nextLine();
							System.out.println("Actor:");
							actor=sc.nextLine();
							System.out.println("Duracion: ");
							duracion=sc.nextDouble();
							sc.nextLine();
							controlador.añadir(new Pelicula(titulo,autor,ano,codigo,pais,actor,duracion));
					}
					break;
				}
				case 2:
				{
					int codigo;
					System.out.println("Codigo");
					codigo=sc.nextInt();
					sc.nextLine();
					ArrayList<Multimedia> lista=controlador.getLista();
							for (Multimedia mult : lista)
							{
								if (mult.getCodigo() ==codigo);
									controlador.eliminar(mult);
							}
					break;
				}
				case 3:
				{
					ArrayList<Multimedia> lista=controlador.getLista();
					System.out.println("1.- Libros");
					System.out.println("2.- Musicas");
			 		System.out.println("3.- Peliculas");
			 		System.out.println("4.- Todo");
			 		int opcion2=sc.nextInt();
			 		sc.nextLine();
					for (Multimedia media : lista)
					{
						if (opcion2==1)
						{
							if (media instanceof Libros)
								media.mostrarElementos();
						}
						if (opcion2==2)
						{
							if (media instanceof Musica)
								media.mostrarElementos();
						}
						if (opcion2==3)
						{
							if (media instanceof Pelicula)
								media.mostrarElementos();
						}
						if (opcion2==4)
						{
							media.mostrarElementos();
						}
	 				}
					break;
				}
				case 4:
				{
					ArrayList<Multimedia> lista=controlador.getLista();
					System.out.println("Importando elementos...");
					File ficheroObjeto=new File("src/documentos/objeto.obj");
			        ObjectInputStream ois=null;
			        try 
					{
			            ois=new ObjectInputStream(new FileInputStream(ficheroObjeto));
			            controlador.setLista((ArrayList<Multimedia>) ois.readObject());
			        }
			        catch (IOException e) 
					{
			            e.printStackTrace();
			        } 
			        catch (ClassNotFoundException e) 
					{
			            e.printStackTrace();
			        } 
			        finally 
					{
			            try 
						{
			                ois.close();
			            } 
			            catch (IOException e) {
			                e.printStackTrace();
			            }
			        }
					break;
				}
				case 5:
				{
			        File ficheroObjeto=new File("src/documentos/objeto.obj");
			        ObjectOutputStream oos=null;
			        try {
			            oos=new ObjectOutputStream(new FileOutputStream(ficheroObjeto));
			            oos.writeObject(controlador.getLista());
			        } catch (IOException e) 
					{
			            e.printStackTrace();
			        } finally 
					{
			            try 
						{
			                oos.close();
			            } catch (IOException e) 
						{
			                e.printStackTrace();
			            }
			        }
					break;
				}
				case 6:
				{
					System.out.println("Saliendo");
					break;
				}
				default: 
				{
		 			System.out.println("Opcion incorrecta");
					break;
				}
			}
		} while (opcion !=6);
	}	
}
