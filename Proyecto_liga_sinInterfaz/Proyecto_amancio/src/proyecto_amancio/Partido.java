/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_amancio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author amanc
 */
public class Partido extends Liga {

    protected int num_partido;
    protected String n_equiplocal;
    protected String n_equipvisit;
    protected LocalDate fecha;
    protected LocalTime hora;
    // protected ArrayList<Partido> primera_ronda;
    protected ArrayList<Clubfutbol> segunda_ronda;
    protected ArrayList<Clubfutbol> tercera_ronda;
    protected ArrayList<Clubfutbol> final_ronda;

    Partido() {
        this.num_partido = 0;
        this.n_equiplocal = "";
        this.n_equipvisit = "";
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        // primera_ronda = new ArrayList<Partido>();
        segunda_ronda = new ArrayList<Clubfutbol>();
        tercera_ronda = new ArrayList<Clubfutbol>();
        final_ronda = new ArrayList<Clubfutbol>();
    }

    Partido(String local, String visit) {
        super();
        this.num_partido = 0;
        this.n_equiplocal = local;
        this.n_equipvisit = visit;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public void jugarPartido(Clubfutbol a, Clubfutbol b) {
        int rand = (int) (Math.random() * 2);
        if (rand == 1) {
            a.setPartidos_ganados(this.partidos_ganados + 1);
            a.setNum_goles((int) (Math.random() * 9));
            System.out.println("Ha ganado el partido el equipo " + a.getnombre_equipo() + " con " + a.num_goles + " goles.");
            
        // System.out.println("Equipo 1: "+a.getnombre_equipo()+" con "+a.getPartidos_ganados()+" ganados.");
        } else {
            b.setPartidos_ganados(this.partidos_ganados + 1);
            b.setNum_goles((int) (Math.random() * 9));
            System.out.println("Ha ganado el partido el equipo " + b.getnombre_equipo() + " con " + b.num_goles + " goles.");
//  System.out.println("Equipo 2: "+b.getnombre_equipo()+" con "+b.getPartidos_ganados()+" ganados.");
        }
    }

    public String getN_equiplocal() {
        return n_equiplocal;
    }

    public void setN_equiplocal(String n_equiplocal) {
        this.n_equiplocal = n_equiplocal;
    }

    public String getN_equipvisit() {
        return n_equipvisit;
    }

    public void setN_equipvisit(String n_equipvisit) {
        this.n_equipvisit = n_equipvisit;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    
}
