package Practica_Multimedia;

public class Musica extends Multimedia{

	String formato;
	boolean directo;
	double duracion;
	
	public Musica(String titulo,String autor,int ano,int codigo,String formato,boolean directo,double duracion) {
		super(titulo,autor,ano,codigo);
		this.directo=directo;
		this.formato=formato;
		this.duracion=duracion;
	}

	@Override
	public void mostrarElementos() {
		System.out.println("Cancion: ");
		super.mostrarElementos();
		System.out.printf("Formato: %s\n",formato);
		System.out.printf("Duracion: %.3f min\n",duracion);
		System.out.printf("Directo: %b\n",directo);
	}
}
