package interfaces;

/**
 * Interfaz utilizada para representar el comportamiento de un hashtag (o etiqueta).
 * Los hashtag se utilizaran para clasificar el contenido.
 * 
 * @author Raul SG
 *
 */
public interface IHashtag {

	/**
	 * Metodo que devuelve el nombre de la etiqueta (o hashtag), por ejemplo "viajes", "playas", etc.
	 * 
	 * @return String. Cadena que contiene el nombre de la etiqueta
	 */
	String getNombre();
	
	/**
	 * Metodo utilizado para modificar el nombre de la etiqueta. 
	 * 
	 * @param nombre. El nombre pasado por parametro sera el nuevo nombre de
	 * la etiqueta. 
	 * 
	 * nombre nunca va a ser null, por lo que no hay que preocuparse
	 * de si una etiqueta tiene un nombre igual a null.
	 */
	void setNombre(String nombre);
}
