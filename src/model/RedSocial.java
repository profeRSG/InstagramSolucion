package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import interfaces.IFoto;
import interfaces.IHashtag;
import interfaces.IRedSocial;
import interfaces.IUsuario;

public class RedSocial implements IRedSocial{

	private List<IUsuario> usuarios;//La red social tiene un listado de los usuarios
	//registrados
	
	public RedSocial() {
		usuarios=new LinkedList<>();//Se crea una lista vacia para inicializar la lista usuarios.
	}
	
	@Override
	public List<IFoto> getContenidoParaMostrarUsuario(IUsuario usuario) {
		List<IFoto> contenidoMostrar=usuario.getContenidoDeLosUsuariosSeguidos();//Obtenemos el contenido 
		//de todos los usuarios a los que sigue usuario.
		Collections.sort(contenidoMostrar);//Ordenamos el contenido. Para que se pueda ordenar, debe
		//estar definido compareTo en la clase Foto
		return contenidoMostrar;
	}

	@Override
	public List<IFoto> getFotosFiltradasPorHashtag(IHashtag tag) {
		List<IFoto> fotosFiltrada=new LinkedList<>();//Lista donde vamos a guardar el resultado
		for(IUsuario usuario:usuarios) {//Por cada usuario de la red
			fotosFiltrada.addAll(usuario.getFotosFiltradasPorHashtag(tag)); //Agregamos al resultado
		}//Las fotos del usuario filtradas por el hashtag pasado como parametro.
		return fotosFiltrada;
	}

	@Override
	public void registrarUsuario(IUsuario usuariosNuevo) {
		usuarios.add(usuariosNuevo);//Se agrega el usuario a la lista de usuarios.
	}

}
