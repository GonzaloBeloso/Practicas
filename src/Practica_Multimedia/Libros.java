package Practica_Multimedia;

public class Libros extends Multimedia{

	boolean soporte;
	int paginas,edicion;
	
	public Libros(String titulo,String autor,int ano,int codigo,int edicion,boolean soporte,int paginas) {
		super(titulo,autor,ano,codigo);
		this.edicion=edicion;
		this.soporte=soporte;
		this.paginas=paginas;
	}

	@Override
	public void mostrarElementos() 
	{
		System.out.println("Libro: ");
		super.mostrarElementos();
		System.out.printf("Edicion: %s\n",edicion);
		System.out.printf("Soporte: %b\n",soporte);
		System.out.printf("Paginas: %d\n",paginas);
	}
	
}
