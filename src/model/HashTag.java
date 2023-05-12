package model;

import java.util.Objects;

import interfaces.IHashtag;

public class HashTag implements IHashtag{

	private String nombre;//Nombre de la etiqueta.
	
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) { //Sobreescribimos el equals de Object, definiendo
		//que dos hashtag son iguales si tienen el mismo nombre.
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashTag other = (HashTag) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	

}
