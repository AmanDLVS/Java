/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_amancio;

/**
 *
 * @author amanc
 */

public class Jugador {
    protected String nombre_jug;
    protected int edad;
    protected String nacionalidad;
    
    Jugador(){
        
    }
    Jugador (String n, int e, String nac){
        this.nombre_jug= n;
        this.edad = e;
        this.nacionalidad = nac;
    }

    public String getNombre_jug() {
        return nombre_jug;
    }

    public void setNombre_jug(String nombre) {
        this.nombre_jug = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
   
    
}

