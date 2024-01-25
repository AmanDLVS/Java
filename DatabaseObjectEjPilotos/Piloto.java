/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aman
 */
public class Piloto {
	String nombre;
	String apellidos;
	int puntos;
	
	
	public Piloto(String nombre, String apellidos, int puntos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.puntos = puntos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public String toString() {
		return nombre + "-" + apellidos + "/" + puntos;
	}

}
