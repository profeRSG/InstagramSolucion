package interfaces;

/**
 * Interfaz utilizada para representar el comportamiento de una foto. En la red
 * los usuarios van a  subir como contenido fotos.
 * 
 * @author Raul SG
 *
 */
public interface IFoto extends Comparable<IFoto>{
	
	/**
	 * Metodo que devuelve el path de la foto dentro del servidor.
	 * Por ejemplo "pepe.jpg" o "/img/ana.jpg"
	 * 
	 * @return String. Cadena que contiene el path de la imagen
	 */
	String getPath();
	
	/**
	 * Metodo utilizado para modificar el path de la foto. 
	 * 
	 * @param path. El path pasado por parametro sera el nuevo path de
	 * la foto. 
	 * 
	 * path nunca va a ser null, por lo que no hay que preocuparse
	 * de si una foto tiene un path igual a null.
	 * 
	 * Los path pasados por parametro siempre van a ser validos, por lo que no
	 * hay que preocuparse si estan bien formados, con las barras, y representan un camino
	 * correcto.
	 */
	void setPath(String path);
	
	/**
	 * Cada foto va a tener un registro de los hashtag que tiene asociados.
	 * El siguiente metodo se utiliza para asociar un nuevo hastag a la foto.
	 * 
	 * @param hashtag. Hashtag que vamos a añadir al registro de etiquetas asociadas a 
	 * la foto.
	 * 
	 * hashtag nunca va a ser null, por lo que no hay que preocuparse
	 * de si una foto tiene un hastag igual a null
	 * 
	 * Tampoco se va a pasar un hashtag que ya esta asociado, por lo que no hay
	 * que preocuparse de si el hashtag esta repetido o no
	 */
	void addHashtag(IHashtag hashtag);
	
	/**
	 * Metodo que comprueba si la foto tiene el hashtag pasado como parametro o no.
	 * 
	 * Un Hashtag se considera igual a otro, si tienen el mismo nombre.
	 * 
	 * @param hashtag. Hastag que se quiere comprobar si esta asociado.
	 * 
	 * @return boolean. Sera true, si la foto contiene el hashtag, y false
	 * si no lo contiene.
	 * 
	 * hashtag nunca va a ser null, por lo que no hay que preocuparse
	 * de si se quiere comprobar si una foto tiene el hashtag null
	 */
	boolean hasHashtag(IHashtag hashtag);

	/**
	 * Metodo que devuelve el numero de hashtag que tiene asociada la foto. Devolvera 
	 * cero, si la foto no tiene asociado ningun hashtag
	 * 
	 * @return int. Numero de etiquetas que estan asociadas a la foto.
	 */
	int getNumeroHashtag();

}
