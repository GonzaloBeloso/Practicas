package Practica_Multimedia;

public class Pelicula extends Multimedia{

	String pais,actor;
	double duracion;
	
	public Pelicula(String titulo,String autor,int ano,int codigo,String pais,String actor,double duracion) {
		super(titulo,autor,ano,codigo);
		this.duracion=duracion;
		this.pais=pais;
		this.actor=actor;
	}

	@Override
	public void mostrarElementos() {
		System.out.println("Pelicula: ");
		super.mostrarElementos();
		System.out.printf("Actor: %s\n",actor);
		System.out.printf("Duracion: %.3f min\n",duracion);
		System.out.printf("Pais: %s\n",pais);
	}
}
