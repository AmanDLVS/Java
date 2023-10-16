 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_amancio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author amanc
 */
public class Clubfutbol extends Jugador {

    protected int num;
    protected String nombre_equipo;
    protected String ciudad;
    protected String pais;
    protected String nombre_estadio;
    protected String fecha_fundacion;
    protected int num_goles;
    protected int partidos_ganados;
    protected ArrayList<Jugador> j;

    Clubfutbol() {
        super();
        this.nombre_equipo = "";
        this.ciudad = "";
        this.pais = "";
        this.num_goles = 0;
        this.nombre_estadio = "";
        this.fecha_fundacion = "";
        this.partidos_ganados = 0;
        this.j = new ArrayList<Jugador>();
    }

    Clubfutbol(int n) {
        this.num = n;
        this.partidos_ganados = 0;
        this.j = new ArrayList<Jugador>();
        
    }

    Clubfutbol(String n, String c, String p, String ne, String ff, int pg) {
        super();
        this.nombre_equipo = n;
        this.ciudad = c;
        this.pais = p;
        this.nombre_estadio = ne;
        this.fecha_fundacion = ff;
        this.partidos_ganados = 0;
        this.j = new ArrayList<Jugador>();
    }

    public long FicharEquip(RandomAccessFile fj, RandomAccessFile fn, long pos) {
        int n=0,aux2=0,aux3=0;
        long aux=0;
        String lineaj;
        String linean;
        String lista_jugadores[] = new String[100];
        String lista_nacionalidades[] = new String[100];

        try {
            fj.seek(pos);
            fn.seek(0);
            
            for (int i = 0; i <= 59; i++) {
                lista_jugadores[i]=fj.readLine();
            }
            for (int i = 1; i <= 11; i++) {
                aux2 = Random(1,60);
                lineaj = lista_jugadores[aux2]; 
                Jugador a = new Jugador(lineaj,n = (int) (Math.random() * (30 - 20 + 1) + 30),"a" );
                j.add(a);
            }
  
            aux = fn.length();
            
            for (int i = 1; i <= 5; i++) {
                lista_nacionalidades[i]=fn.readLine();
            }
            for (int i = 1; i <= 11; i++) {
                aux3 = Random(1,4);
                linean = lista_nacionalidades[aux3];
                j.get(i).setNacionalidad(linean);
            }
            
            return fj.getFilePointer();

        } catch (IOException ex2) {
            System.out.println("Mensaje 2: " + ex2.getMessage());
            return -1;
        }

    }

    public void creaEquipoRandom(Clubfutbol a, RandomAccessFile neq, RandomAccessFile c, RandomAccessFile p, RandomAccessFile nes, RandomAccessFile f) {
        String linea_neq;
        String linea_c;
        String linea_p;
        String linea_nes;
        String linea_f;
        long aux = 0;

        try {

            System.out.println("Leyendo contenido....");
            linea_neq = neq.readLine();
            linea_c = c.readLine();
            linea_p = p.readLine();
            linea_nes = nes.readLine();
            linea_f = f.readLine();

            a.setnombre_equipo(linea_neq);
            a.setCiudad(linea_c);
            a.setPais(linea_p);
            a.setNombre_estadio(linea_nes);
            a.setFecha_fundacion(linea_f);
            j.add(a);

            if (neq.getFilePointer() == aux) {
                neq.seek(0);
            }
            if (c.getFilePointer() == aux) {
                c.seek(0);
            }
            if (p.getFilePointer() == aux) {
                p.seek(0);
            }
            if (nes.getFilePointer() == aux) {
                nes.seek(0);
            }
            if (f.getFilePointer() == aux) {
                f.seek(0);
            }

            if (neq.read() == -1 || c.read() == -1 || p.read() == -1 || nes.read() == -1 || f.read() == -1) {
                neq.close();
                c.close();
                p.close();
                nes.close();
                f.close();
            }
            // }

        } catch (IOException e) {
            System.out.println("Problemas con la lectura del archivo.");
        }
    }

    public void printClub(Clubfutbol clb) {
        System.out.println("----------------------------------");
        System.out.println("EQUIPO " + this.nombre_equipo + ".\n"
                + "Ciudad: " + this.ciudad + ".\nPais: " + this.pais + ".\nNombre de su estadio: "
                + this.nombre_estadio + ".\nFecha creacion: " + this.fecha_fundacion + ".");
        System.out.println("----------------------------------");
    }

    public String getnombre_equipo() {
        return nombre_equipo;
    }

    public void setnombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre_estadio() {
        return nombre_estadio;
    }

    public void setNombre_estadio(String nombre_estadio) {
        this.nombre_estadio = nombre_estadio;
    }

    public String getFecha_fundacion() {
        return fecha_fundacion;
    }

    public void setFecha_fundacion(String fecha_fundacion) {
        this.fecha_fundacion = fecha_fundacion;
    }

    public ArrayList<Jugador> getJ() {
        return j;
    }

    public void setJ(ArrayList<Jugador> j) {
        this.j = j;

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public String getNombre_jug() {
        return nombre_jug;
    }

    public void setNombre_jug(String nombre_jug) {
        this.nombre_jug = nombre_jug;
    }

    public int getEdad() {
        return edad;
    }

    public int getNum_goles() {
        return num_goles;
    }

    public void setNum_goles(int num_goles) {
        this.num_goles = num_goles;
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
    
    
    

    public void printJugadores() {

        System.out.println(".\n-----------------\nJugadores:\n-----------------\n"
                + "[------------------------------]");
        for (int i = 1; i < 11; i++) {
            System.out.println("Jugador: " + j.get(i).nombre_jug + "\nEdad: " + j.get(i).edad + "\nNacionalidad: " + j.get(i).nacionalidad);
        }
        System.out.println("[------------------------------]");
    }

    public int Random(int min,int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /*
    @Override
    public String toString(){
        printJugadores();
        return "EQUIPO "+this.nombre.toUpperCase()+".\n"
                + "Ciudad: "+this.ciudad+".\nPais: "+this.pais+".\nNombre de su estadio: "
                +this.nombre_estadio+".\nFecha creacion: "+this.fecha_fundacion+".\nJugadores:\n-----------------\n";
    }
     */

}
