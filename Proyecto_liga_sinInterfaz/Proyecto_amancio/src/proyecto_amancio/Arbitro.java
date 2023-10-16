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
public class Arbitro {
    private String nombre_arbitro;
    private String nacionalidad_arbitro;

    public Arbitro() {
        this.nacionalidad_arbitro = nacArbitro();
        this.nombre_arbitro = nomArbitro();
    }

    public Arbitro(String nombre_arbitro, String nacionalidad_arbitro) {
        this.nombre_arbitro = nombre_arbitro;
        this.nacionalidad_arbitro = nacionalidad_arbitro;
    }

    public String nacArbitro() {
        int n = (int) (Math.random() * (6 + 1));
        String nacionalidades[] = {"Egipto", "PORTUGAL", "FRANCIA", "ITALIA","Congo","Ruso","Chino"};
        return nacionalidades[n];

    }

    public String nomArbitro() {
        int p = (int) (Math.random() * (8 + 1));
        String nombres[] = {"Mateo", "Leo", "Daniel", "Alejandro", "Pablo", "Manuel", "Alvaro", "Adrian", "David"};
        return nombres[8];
    }

    public String getNombre_arbitro() {
        return nombre_arbitro;
    }

    public void setNombre_arbitro(String nombre_arbitro) {
        this.nombre_arbitro = nombre_arbitro;
    }

    public String getNacionalidad_arbitro() {
        return nacionalidad_arbitro;
    }

    public void setNacionalidad_arbitro(String nacionalidad_arbitro) {
        this.nacionalidad_arbitro = nacionalidad_arbitro;
    }
    
}
