package model;

import java.util.LinkedList;
import java.util.List;

import interfaces.IFoto;
import interfaces.IHashtag;
import interfaces.IUsuario;

public class Usuario implements IUsuario{

	private String nombre;//Nombre del usuario
	private List<IUsuario> seguidos;//Lista de los usuarios a los que sigue el usuario
	private List<IFoto> misFotos;//Listado de las subidas por el usuario
	
	public Usuario() {
		seguidos=new LinkedList<>();//Inicializamos la lista de seguidos con una lista vacia
		misFotos=new LinkedList<>();//Inicializamos la lista de misFotos con una lista vacia
	}
	
	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void subirFoto(IFoto foto) {
		misFotos.add(foto);//Se agrega la foto al listado de fotos del usuario
		
	}

	@Override
	public void seguirUsuario(IUsuario usuarioSeguido) {
		seguidos.add(usuarioSeguido);//Se agrega el usuarioSeguido al listado de usuarios seguidos
		
	}

	@Override
	public List<IFoto> getFotosFiltradasPorHashtag(IHashtag tag) {
		List<IFoto> listaFotosFiltradas=new LinkedList<>();//Lista donde se va a guardar el resultado
		for(IFoto foto:misFotos) {//Por cada una de las fotos del usuario
			if(foto.hasHashtag(tag))//Si la foto tiene el tg
				listaFotosFiltradas.add(foto);//Se añade como resultado
		}
		return listaFotosFiltradas;//Devolvemos las fotos guardadas en listaFotosFiltradas
	}
	
	@Override
	public List<IFoto> getContenidoDeLosUsuariosSeguidos() {
		List<IFoto> contenido=new LinkedList<>();//Lista donde se va a guardar el resultado
		for(IUsuario usuario:seguidos) {//Por cada uno de los usuarios seguidos
			contenido.addAll(usuario.getFotos());//Obtenemos sus fotos y las agregamos todas
		}//a la lista de resultados.
		return contenido;
	}

	@Override
	public List<IFoto> getFotos() {
		return misFotos;//Devolvemos la lista de las fotos del usuario
	}
	
	
	

}
