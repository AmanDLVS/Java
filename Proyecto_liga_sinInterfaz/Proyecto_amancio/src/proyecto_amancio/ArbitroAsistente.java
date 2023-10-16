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
public class ArbitroAsistente extends Arbitro{
    private String posicion;

    
    public ArbitroAsistente() {
        this.posicion = linier();
    }

    public ArbitroAsistente(String posicion, String nombre_arbitro, String nacionalidad_arbitro) {
        super(nombre_arbitro, nacionalidad_arbitro);
        this.posicion = posicion;
    }
    
    public String linier(){
        int n = (int) (Math.random() * (1 + 1) );
        if (n==1) {
            return "linier izquierdo";
        }else{
            return "linier derecho";
        }
    }
    
    
    
}
