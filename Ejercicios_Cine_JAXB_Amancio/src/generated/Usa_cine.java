package generated;

import java.io.File;

public class Usa_cine {
	
	public static void main(String[] args) {
	try {
		File f = new File("Cine.xml");
		CineJAXB c = new CineJAXB(f);
		c.MostrarCine(f);
               // c.verPelisCal();
                //c.buscarSala("Animales fantasticos");
                //c.borrarPelicula();
                //c.insertarPelicula();
                c.modificarPelicula();
                c.MostrarCine(f);
                
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
