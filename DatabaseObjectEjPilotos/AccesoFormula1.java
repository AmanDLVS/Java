/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aman
 */
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.util.List;
import com.db4o.ObjectSet;

public class AccesoFormula1 {
	private ObjectContainer db;

	AccesoFormula1() {
		db = Db4oEmbedded.openFile("Formula1.db4o ");
	}

	void closeDB() {
		db.close();
	}

	void insertar(String nombre, String apellido, int puntos) {
		boolean estaPiloto = false;
		try {
			List<Piloto> pilotos = db.query(Piloto.class);
			for (Piloto p : pilotos) {
				if (p.getNombre().equalsIgnoreCase(nombre)) {
					estaPiloto = true;
				}
			}
			if (!estaPiloto) {
				ObjectSet result = db.queryByExample(new Piloto(nombre, apellido, puntos));
				Piloto p1 = new Piloto(nombre, apellido, puntos);
				db.store(p1);
				
			}else {
				System.out.println("El piloto ya se encuentra en la base de datos: " + nombre + "," + apellido + "," + puntos);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void mostrarPilotos() {
		try {
			List<Piloto> pilotos = db.query(Piloto.class);
			for (Piloto p : pilotos) {
			System.out.println(p);
			}
		}catch(Exception e) {
				System.out.println(e);
		}
	}
	
	void mostrarPilotos2() {
		Piloto p = new Piloto(null,null, 0);
		ObjectSet result = db.queryByExample(p);
	    System.out.println(result.size());
	    while(result.hasNext()) {
	    	System.out.println(result.next());
	    }
	}
	
	void actualizarPuntos(String nombre, String apellidos, int puntosASumar) {
		try {
			ObjectSet resul = db.queryByExample(new Piloto(nombre, apellidos, 0));
			Piloto pilotoBuscado = (Piloto) resul.next();
			pilotoBuscado.setPuntos(pilotoBuscado.getPuntos() + puntosASumar);
			db.store(pilotoBuscado);
			System.out.println("Puntos añadidos. Puntos finales: " + pilotoBuscado);
		} catch (Exception e) {
			System.out.println("El piloto no existe en la base de datos");
		}
	}
	
	void borrarPiloto(String nombre, String apellidos) {
		try {
			ObjectSet result = db.queryByExample(new Piloto(nombre, apellidos, 0));
			Piloto encontrado = (Piloto) result.next();
			db.delete(encontrado);
			System.out.println("Piloto borrado " + encontrado);
		} catch (Exception e) {
			System.out.println("El piloto no existe en la base de datos");
		}
	}
	
	

}// class