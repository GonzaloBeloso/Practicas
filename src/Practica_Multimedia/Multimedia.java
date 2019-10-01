package Practica_Multimedia;

import java.io.Serializable;

public abstract class Multimedia implements Serializable{
	String titulo,autor;
	int ano,codigo;
	
	public Multimedia(String titulo,String autor,int ano,int codigo){
		this.titulo=titulo;
		this.autor=autor;
		this.ano=ano;
		this.codigo=codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo=codigo;
	}

	public void mostrarElementos()
	{
		System.out.printf("Titulo: %s\n",titulo);
		System.out.printf("Autor: %s\n",autor);
		System.out.printf("Ano: %d\n",ano);
		System.out.printf("Codigo: %d\n",codigo);
	}
}
