/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_amancio;

import java.util.Scanner;

/**
 *
 * @author amanc
 */
public class Arbitraje extends ArbitroAsistente {

    private Arbitro arbitro_principal;
    private ArbitroAsistente linier_dere;
    private ArbitroAsistente linier_izq;

    Arbitraje() {
        this.arbitro_principal = new Arbitro();
        this.linier_dere = new ArbitroAsistente("Linier derecho", this.nomArbitro(), this.nacArbitro());
        this.linier_izq = new ArbitroAsistente("Linier izquierdo", this.nomArbitro(), this.nacArbitro());
    }

    public Arbitro getArbitro_principal() {
        return arbitro_principal;
    }

    public void setArbitro_principal(Arbitro arbitro_principal) {
        this.arbitro_principal = arbitro_principal;
    }

    public ArbitroAsistente getLinier_dere() {
        return linier_dere;
    }

    public void setLinier_dere(ArbitroAsistente linier_dere) {
        this.linier_dere = linier_dere;
    }

    public ArbitroAsistente getLinier_izq() {
        return linier_izq;
    }

    public void setLinier_izq(ArbitroAsistente linier_izq) {
        this.linier_izq = linier_izq;
    }
    
    

}
