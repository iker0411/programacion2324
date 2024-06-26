package Tema5.ExamenColecciones21.ejercicio1;
import java.util.HashMap;

public class NetPlease {

	//Hashmap donde por cada tema, podemos acceder a las películas de ese tema
	private HashMap<String, PeliculasDeUnTema> mapPeliculas;
	
	
	public NetPlease() {
		mapPeliculas=new HashMap<String, PeliculasDeUnTema>();
		
	}
	
	public void annadirTema( String tema) throws NetPleaseException {
	
		tema= tema.toUpperCase();
		if (mapPeliculas.containsKey(tema)) {
			throw new NetPleaseException("Ya existe ese tema");
		}
		
		mapPeliculas.put(tema, new PeliculasDeUnTema(tema));
	}
	

	
	public void addPelicula(String tema, Pelicula pelicula) throws NetPleaseException {
		PeliculasDeUnTema listaPeliculasDeUnTema = mapPeliculas.get(tema);
		
		if (listaPeliculasDeUnTema == null) {
			throw new NetPleaseException("No existe el tema " + tema);
		}
		listaPeliculasDeUnTema.addPelicula(pelicula);
	}
	
	public void listadoDeTodasPeliculasDeTodosLosTemas() {
		
		for ( PeliculasDeUnTema listaPelisTema: mapPeliculas.values()) {
			System.out.println(listaPelisTema);
		}
	}
	
	public void borrarPeliculaDeUnTema( String tema, String titulo) throws NetPleaseException{
			if (!mapPeliculas.containsKey(tema)){
				throw new NetPleaseException("No existe ese tema");
			}
			if (!mapPeliculas.get(tema).borrar(titulo)){
				throw new NetPleaseException("No existe la pelicula");
			}
	}
	
	
	
	public String temaDePelicula( String titulo) throws NetPleaseException {
		for (String tema : mapPeliculas.keySet()){
			if (mapPeliculas.get(tema).buscarPeliculaPorTitulo(titulo) != null){
				return tema;
			}
		}
		return null;
	}
	


	
	
}
