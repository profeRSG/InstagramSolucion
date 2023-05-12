package interfaces;

import java.util.List;

/**
 * Interfaz que representa el comportamiento de una red social basica .
 * En la red social, los usuarios podran subir fotos, las cuales estaran clasificadas por hashtags (etiquetas).
 * 
 * 
 * @author Raul SG
 *
 */
public interface IRedSocial {

	/**
	 * Metodo que va a devolver el contenido que la red muestra a un usuario en concreto
	 * cuando la visita.
	 * 
	 * En la red, un contenido es mas importante que otro, si tiene mas etiquetas.
	 * 
	 * Teniendo en cuenta esto, el metodo va a devolver del usuario pasado como parametro, 
	 * el contenido de los usuarios que sigue, ordenado por el numero de 
	 * etiquetas, es decir, en primer lugar apareceran las fotos con mas eqtiuetas
	 * y en ultimo lugar las fotos con menos etiquetas.
	 * 
	 *  Por lo tanto, el siguiente metodo devuelve el contenido de los usuarios a los que sigue usuario,
	 *  ordenado por el numero de etiquetas, de mayor numero de etiquetas a menor numero de etiquetas.
	 *  
	 *  Por ejemplo, si usuario sigue a pepe, y a juan. pepe, tiene la foto 1, con dos etiquetas, y juan
	 *  tiene la foto 2, con 1 etiqueta, y la foto 3, con 3 etiquetas. El orden
	 *  de la lista seria [foto3, foto1, foto2]
	 *  
	 *  usuario nunca va a ser igual a null, por lo que no hay que contemplar dicho caso.
	 * 
	 * @param usuario. Usuario de cuyo seguidores se va a extraer la informacion a ordenar.
	 * 
	 * @return List<IFoto>. Listado de fotos de los seguidores de usuario, ordenado por el 
	 * numero de etiquetas, de mas a menos etiquetas.
	 */
	List<IFoto> getContenidoParaMostrarUsuario(IUsuario usuario);
	
	/**
	 * El siguiente metodo devuelve el listado de todas las fotos de la red, filtrado
	 * por el tag pasado como parametro. Es decir, se devuelve una lista que contiene, las fotos
	 * subidas por los usuarios de la red, pero de todas ellas, solo las que tienen asociado como hashtag
	 * el tag pasado como parametro. 
	 * 
	 *  Nota: Un hashtag es igual a otro, si tienen el mismo nombre.
	 *  
	 * @param tag. Hashtag por el que se desea filtrar el contenido de la red. 
	 * tag nunca va a ser igual a null, por lo que no hay que contemplar dicho caso.
	 * 
	 * 
	 * @return List<IFoto>. Listado de las fotos de todos los usuarios de la red, filstradas 
	 * por el hashtag tag.
	 */
	List<IFoto> getFotosFiltradasPorHashtag(IHashtag tag);
	
	/**
	 * Metodo utilizado para añadir al registro de usuarios de la red, el usuarioNuevo.
	 * 
	 * @param usuarioNuevo. Usuario que se desea añadir al registro de usuarios de la red.
	 */
	 void registrarUsuario(IUsuario usuarioNuevo);
	
}
