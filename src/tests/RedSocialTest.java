package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.IFoto;
import interfaces.IHashtag;
import interfaces.IRedSocial;
import interfaces.IUsuario;
import model.Foto;
import model.HashTag;
import model.RedSocial;
import model.Usuario;

//TODO Como ya hemos estudiado en Entornos
//Se debe crear una clase de test por cada clase que se quiere probar
//Sin emabrgo, por temas de comodidad para corregir el examen, se han aglutinado todos los
//test en una unica clase

class RedSocialTest {
	private static IRedSocial instagram;
	private static IUsuario pepe;
	private static IUsuario lolo;
	private static IUsuario lale;

	@BeforeEach
	void setUpBeforeEachMethod(){
		instagram=new RedSocial();
		pepe=new Usuario();
		pepe.setNombre("Pepe");
		lolo=new Usuario();
		lolo.setNombre("Lolo");
		lale=new Usuario();
		lale.setNombre("Lale");
		instagram.registrarUsuario(pepe);
		instagram.registrarUsuario(lolo);
		instagram.registrarUsuario(lale);
		
		IHashtag espacioTag=new HashTag();
		espacioTag.setNombre("ESpacio");
		IHashtag locoTag=new HashTag();
		locoTag.setNombre("LoCo");
		
		IFoto foto1=new Foto();
		foto1.setPath("pepe.jpg");
		foto1.addHashtag(espacioTag);
		
		IFoto foto2=new Foto();
		foto2.setPath("pepe2.jpg");
		foto2.addHashtag(locoTag);
		foto2.addHashtag(espacioTag);
		pepe.subirFoto(foto2);
		
		pepe.subirFoto(foto1);
		
		IHashtag e1=new HashTag();
		e1.setNombre("e1");
		IHashtag e2=new HashTag();
		e2.setNombre("e2");
		IFoto foto3=new Foto();
		foto3.setPath("lolo.jpg");
		foto3.addHashtag(locoTag);
		foto3.addHashtag(e1);
		foto3.addHashtag(e2);
		lolo.subirFoto(foto3);
		
		IHashtag e3=new HashTag();
		e3.setNombre("e3");
		IFoto foto4=new Foto();
		foto4.addHashtag(locoTag);
		foto4.addHashtag(e1);
		foto4.addHashtag(e2);
		foto4.addHashtag(e3);
		foto4.setPath("lale.jpg");
		
		lale.subirFoto(foto4);
		
		pepe.seguirUsuario(lale);
		pepe.seguirUsuario(lolo);
		
		lolo.seguirUsuario(pepe);
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	//RED
	
	@Test
	void testFiltrarEspacio() {
		IHashtag tag=new HashTag();
		tag.setNombre("ESpacio");
		List<IFoto> fotosEspacio=instagram.getFotosFiltradasPorHashtag(tag);
		assertEquals(2, fotosEspacio.size());
		String nombreFoto1=fotosEspacio.get(0).getPath();
		String nombreFoto2=fotosEspacio.get(1).getPath();
	
		if((nombreFoto1.equals("pepe.jpg") || nombreFoto1.equals("pepe2.jpg")) && 
		(nombreFoto2.equals("pepe.jpg") || nombreFoto2.equals("pepe2.jpg"))) {
			
		}
		else
			fail();
	}
	
	@Test
	void testFiltrarLoco() {
		IHashtag tag=new HashTag();
		tag.setNombre("LoCo");
		List<IFoto> fotosEspacio=instagram.getFotosFiltradasPorHashtag(tag);
		assertEquals(3, fotosEspacio.size());
		String nombreFoto1=fotosEspacio.get(0).getPath();
		String nombreFoto2=fotosEspacio.get(1).getPath();
		String nombreFoto3=fotosEspacio.get(1).getPath();
	
		if((nombreFoto1.equals("lolo.jpg") || nombreFoto1.equals("lale.jpg") || nombreFoto1.equals("pepe2.jpg")) && 
				(nombreFoto2.equals("lolo.jpg") || nombreFoto2.equals("lale.jpg") || nombreFoto2.equals("pepe2.jpg"))
				&& (nombreFoto3.equals("lolo.jpg") || nombreFoto3.equals("lale.jpg") || nombreFoto3.equals("pepe2.jpg"))
				) {
			
		}
		else
			fail();
	}
	
	@Test
	void testFiltrarVacio() {
		IHashtag tag=new HashTag();
		tag.setNombre("Algo indeterminado");
		List<IFoto> fotosEspacio=instagram.getFotosFiltradasPorHashtag(tag);
		assertEquals(0, fotosEspacio.size());
	}
	
	@Test
	void testContenidoPepe() {
		List<IFoto> contenido=instagram.getContenidoParaMostrarUsuario(pepe);
		assertEquals("lale.jpg", contenido.get(0).getPath());
		assertEquals("lolo.jpg", contenido.get(1).getPath());
	}
	
	@Test
	void testContenidoLolo() {
		List<IFoto> contenido=instagram.getContenidoParaMostrarUsuario(lolo);
		assertEquals("pepe2.jpg", contenido.get(0).getPath());
		assertEquals("pepe.jpg", contenido.get(1).getPath());
	}
	
	
	//USUARIO
	@Test
	void testGetContenidosSeguidosPorPepe() {
		
		List<IFoto> fotos=pepe.getContenidoDeLosUsuariosSeguidos();
		assertEquals(2, fotos.size());
	}
	
	@Test
	void testSeguir() {
		
		List<IFoto> fotos=lale.getContenidoDeLosUsuariosSeguidos();
		assertEquals(0, fotos.size());
		
		lale.seguirUsuario(lolo);
		fotos=lale.getContenidoDeLosUsuariosSeguidos();
		assertEquals(1,fotos.size());
		lale.seguirUsuario(pepe);
		fotos=lale.getContenidoDeLosUsuariosSeguidos();
		assertEquals(3,fotos.size());
	}
	
	@Test
	void testSubirFoto() {
		assertEquals(1, lale.getFotos().size());
		IFoto foto1=new Foto();
		foto1.setPath("qweqweqwe.jpg");
		lale.subirFoto(foto1);
		List<IFoto> fotos=lale.getFotos();
		assertEquals(2, fotos.size());
		assertEquals("qweqweqwe.jpg", fotos.get(fotos.size()-1).getPath());
		lale.getFotos().remove(lale.getFotos().size()-1);
		
	}
	
	@Test
	void testFiltrarHashUsuarioNoExiste() {
		IHashtag espacioTag=new HashTag();
		espacioTag.setNombre("ESpacio");
		assertEquals(0, lale.getFotosFiltradasPorHashtag(espacioTag).size());
		
	}
	
	@Test
	void testFiltrarHashUsuarioEspacio() {
		IHashtag espacioTag=new HashTag();
		espacioTag.setNombre("ESpacio");
		assertEquals(2, pepe.getFotosFiltradasPorHashtag(espacioTag).size());
	}
	
	@Test
	void testFiltrarHashUsuarioE1() {
		IHashtag espacioTag=new HashTag();
		espacioTag.setNombre("e1");
		assertEquals(1, lale.getFotosFiltradasPorHashtag(espacioTag).size());
		assertEquals("lale.jpg", lale.getFotosFiltradasPorHashtag(espacioTag).get(0).getPath());
	}
	
	@Test
	void testSetYGetUsuario() {
		assertEquals("Pepe", pepe.getNombre());
		
	}
	
	//FOTOS
	@Test
	void testNumeroHash4() {
		assertEquals(4,lale.getFotos().get(0).getNumeroHashtag());
	}
	
	@Test
	void testNumeroHash3() {
		assertEquals(3,lolo.getFotos().get(0).getNumeroHashtag());
		
	}
	
	@Test
	void testAddHash() {
		assertEquals(4,lale.getFotos().get(0).getNumeroHashtag());
		IHashtag e1=new HashTag();
		e1.setNombre("e1");
		lale.getFotos().get(0).addHashtag(e1);
		assertEquals(5,lale.getFotos().get(0).getNumeroHashtag());
		
	}
	
	
	@Test
	void testHashTagTrue() {
		IHashtag e1=new HashTag();
		e1.setNombre("e1");
		assertEquals(true, lolo.getFotos().get(0).hasHashtag(e1));
		
	}
	
	@Test
	void testHashTagFalse() {
		IHashtag e123=new HashTag();
		e123.setNombre("e123");
		assertEquals(false, lolo.getFotos().get(0).hasHashtag(e123));
		
	}
	
	
	@Test
	void testCompareTo() {
		IHashtag espacioTag=new HashTag();
		espacioTag.setNombre("ESpacio");
		
		IFoto foto1=new Foto();
		foto1.setPath("pepe.jpg");
		foto1.addHashtag(espacioTag);
		
		IFoto foto2=new Foto();
		foto2.setPath("pepe.jpg");
		foto2.addHashtag(espacioTag);
		
		assertEquals(0, foto1.compareTo(foto2));
		foto1.addHashtag(espacioTag);
		
		assertNotEquals(0, foto1.compareTo(foto2));
		
	}
	
	
	//HASHTAG
	@Test
	void testSetYGetHash() {
		IHashtag tag=new HashTag();
		tag.setNombre("e1");
		assertEquals("e1", tag.getNombre());
	}
	
	
	
}
