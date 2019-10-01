package Practica_Multimedia;

import java.util.ArrayList;

public class Controlador {
	ArrayList<Multimedia> lista=new ArrayList();
	
	public Controlador(){}

	public ArrayList<Multimedia> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Multimedia> lista) {
		this.lista=lista;
	}
	
	public void añadir(Multimedia multimedia)
	{
		if (lista.contains(multimedia))
			System.out.println("El multimedia ya existe");
		else
		{
			if (lista.add(multimedia))
				System.out.println("Introduccion realizada");
			else
				System.out.println("Error al introducir");
		}

	}
	
	public void eliminar(Multimedia mult)
	{
		if (lista.contains(mult))
		{
			lista.remove(mult);
			System.out.println("El elemento se ha eliminado");
		}
		else
			System.out.println("El codigo no existeo");
	}
	
}
