package model;

import java.util.LinkedList;
import java.util.List;

import interfaces.IFoto;
import interfaces.IHashtag;

public class Foto implements IFoto{

	
	private String path;//Define como el "nombre" de la foto. Es el camino donde se ubica
	private List<IHashtag> etiquetas;//Lista de las etiquetas asociadas a la foto.
	
	
	public Foto() {
		etiquetas=new LinkedList<>();//Creamos la lista vacia.
	}
	
	@Override
	public int compareTo(IFoto otraFoto) {
		return Integer.compare(otraFoto.getNumeroHashtag(),this.getNumeroHashtag());
		//comparamos ambos numeros, para ello utilizamos el compare
		// de Integer, que ya devuelve cero si son iguales, 1, si uno e smayor, y
		//-1 si el otro es mayor.
		//Seria el equivalente a escribir:
		//int resultado=1;
		//if(otraFoto.getNumeroHashtag()==this.getNumeroHashtag())
		//resultado=0
		//if(otraFoto.getNumeroHashtag()<this.getNumeroHashtag())
		//etc
	}

	

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String path) {
		this.path=path;
		
	}

	@Override
	public void addHashtag(IHashtag hashtag) {
		etiquetas.add(hashtag);//Se agrega una etiqueta a la lista de etiquetas.
	}

	

	@Override
	public boolean hasHashtag(IHashtag hashtag) {
		return etiquetas.contains(hashtag);//Devolvemos el resultado de 
		//comprobar si la lista contiene el hashtag. Para que este metodo
		//fucnione la clase hastag tiene que tener definido un equals.
	}

	@Override
	public int getNumeroHashtag() {
		return etiquetas.size();//Devolvemos el numero de elementos de la lista,
		//es decir, su tamaño.
	}

}
