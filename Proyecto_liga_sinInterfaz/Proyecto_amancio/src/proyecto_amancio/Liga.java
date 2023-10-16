/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_amancio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amanc
 */
public class Liga extends Clubfutbol implements Serializable {

    protected String nombrelig;
    protected int numequip;
    protected ArrayList<Clubfutbol> listae;
    protected Scanner sc = new Scanner(System.in);
    protected String Ganador;
    protected ArrayList<Arbitraje> lista_arbitraje;
    //  protected String primera_ronda_string[];
    //  protected String segunda_ronda_string[];
    //protected String tercera_ronda_string[];

    Liga() {
        super();
        this.nombrelig = "";
        this.numequip = 0;
        this.listae = new ArrayList<Clubfutbol>();
        this.lista_arbitraje = new ArrayList<Arbitraje>();
    }

    Liga(String n, int k) {
        super();
        this.nombrelig = n;
        this.numequip = k;
        this.listae = new ArrayList<Clubfutbol>();
        this.lista_arbitraje = new ArrayList<Arbitraje>();
        //    String primera_ronda_string[]=new String[3];
        //    String segunda_ronda_string[]=new String[1];
        //String tercera_ronda_string[];
    }

    public void parametrosEquipos(int n) {
        for (int i = 1; i < n + 1; i++) {
            System.out.println("Equipo " + i + ": ");
            Clubfutbol club = new Clubfutbol(i);
            System.out.println("Nombre del equipo: ");
            ///,e salta este set por alguna razon que no se
            club.setnombre_equipo(sc.nextLine());
            System.out.println("Ciudad: ");
            club.setCiudad(sc.nextLine());
            System.out.println("Pais: ");
            club.setPais(sc.nextLine());
            System.out.println("Nombre del estadio: ");
            club.setNombre_estadio(sc.nextLine());
            System.out.println("Fecha de fundacion: ");
            club.setFecha_fundacion(sc.nextLine());
            club.printClub(club);
            listae.add(club);
            System.out.println("Equipo " + i + " añadido.");
        }

    }

    public void crearLiga(File fj, File fn, File fneq, File fc, File fp, File fnes, File ff, int k) {
        int aux = 0, option = 0;
        String c = null;
        aux = k;
        long pos = 0;
        File ficheros = new File("arbitros_liga_XXX.txt");
        // sc.nextLine();
        while (option != 3) {
            System.out.println("1.Crear Liga Manual.\n2.Crear Liga Random.\n3.Atras");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    parametrosEquipos(aux);
                    option = 3;
                    break;
                case 2:
                    option = 3;
                    try {
                        //Para jugadores, nombres y nacionalidades
                        RandomAccessFile archivoj = new RandomAccessFile(fj, "r");
                        RandomAccessFile archivon = new RandomAccessFile(fn, "r");
                        //Para ciudades, nombre equipo, ciudad, pais, nombre estadio, fecha fundacion
                        RandomAccessFile archivoneq = new RandomAccessFile(fneq, "r");
                        RandomAccessFile archivoc = new RandomAccessFile(fc, "r");
                        RandomAccessFile archivop = new RandomAccessFile(fp, "r");
                        RandomAccessFile archivones = new RandomAccessFile(fnes, "r");
                        RandomAccessFile archivof = new RandomAccessFile(ff, "r");
                        
                
                        // System.out.println("¿Quiere generar usted los equipos manualmente?: \n S/N");
                        c = sc.nextLine();
                        System.out.println("COMUIENZAN A FICHAR LOS EQUIPOS...");

                        for (int i = 1; i <= aux; i++) {
                            Clubfutbol club = new Clubfutbol();
                            club.creaEquipoRandom(club, archivoneq, archivoc, archivop, archivones, archivof);
                            club.FicharEquip(archivoj, archivon, pos);
                            club.printClub(club);
                            club.printJugadores();
                            listae.add(club);
                            
                        }

                    } catch (FileNotFoundException ex) {
                        System.out.println(ex.getLocalizedMessage());
                    }
                    break;
                case 3:
                    System.out.println("Ha salido.");
                default:

                    System.out.println("Introduzca una opcion especificada porfavor.");
                    break;

            }

        }

        if (option == 3) {
            System.out.println("COMIENZA LA LIGA\n Primer partido: ");
            Partido partid = new Partido();

            Arbitraje arbitr = new Arbitraje();
            int cont = 0;//cont2=0;

            while (cont < aux) {

                System.out.println("Partido nº" + cont + ": \n ");
                if (cont == aux) {
                    System.out.println("Fin partidos");
                } else {
                    System.out.println("(" + this.listae.get(cont).nombre_equipo + "),(" + this.listae.get(cont + 1).nombre_equipo + ")");

                    ///////////////////////////////////////////////////////////////
                    //                                                           //
                    //  AQUI SE APLICA EL METODO comprobarNacionalidad, DONDE SE //
                    //  COMPRUBEBA QUE EL ARBITRO SEA DE DISTINTA NACIONALIDAD   //
                    //  QUE EL CLUB                                              //
                    //                                                           //
                    ///////////////////////////////////////////////////////////////
                    
                    comprobaraNacionalidad(listae, arbitr, cont);
                   
                    partid.jugarPartido(this.listae.get(cont), this.listae.get(cont + 1));
                    if (this.listae.get(cont).partidos_ganados > this.listae.get(cont + 1).partidos_ganados) {
                        System.out.println("Ganador el equipo: " + listae.get(cont).nombre_equipo + " con (" + listae.get(cont).getPartidos_ganados() + ")");
                        // primera_ronda_string[cont2]=listae.get(cont).nombre_equipo.toString()+" con "+listae.get(cont).getPartidos_ganados()+" goles.";
                        // cont2++;
                    }
                    if (this.listae.get(cont).partidos_ganados < this.listae.get(cont + 1).partidos_ganados) {
                        System.out.println("Ganador el equipo: " + listae.get(cont + 1).nombre_equipo + " con (" + listae.get(cont + 1).getPartidos_ganados() + ")");
                        //   primera_ronda_string[cont2]=listae.get(cont+1).nombre_equipo.toString()+" con "+listae.get(cont+1).getPartidos_ganados()+" goles.";
                        //  cont2++;
                    }
                    Partido part = new Partido();
                    part.num_partido = aux;
                    part.n_equiplocal = listae.get(cont).getNombre_equipo();
                    cont += 2;

                }
            }

            cont = 0;

            int count = 0;
            // while(cont < aux){ 
            for (int l = 0; l < aux; l++) {
                if (this.listae.get(l).getPartidos_ganados() > 0) {
                    partid.segunda_ronda.add(this.listae.get(l));
                    //  System.out.println("Lista segunda ronda 2: "+partid.segunda_ronda.get(count).nombre_equipo);
                    count++;
                }
                //  cont+=2;
            }
            //  cont2=0;
            aux = aux / 2;
            count = 0;
            System.out.println("SEMIFINAL: ");
            ///////////////////////////////////////////////////////////////
            //                                                           //
            //  AQUI SE APLICA EL METODO comprobarNacionalidad, DONDE SE //
            //  COMPRUBEBA QUE EL ARBITRO SEA DE DISTINTA NACIONALIDAD   //
            //  QUE EL CLUB                                              //
            //                                                           //
            ///////////////////////////////////////////////////////////////

            comprobaraNacionalidad(partid.segunda_ronda, arbitr, cont);
            while (cont < aux) {
                partid.jugarPartido(partid.segunda_ronda.get(cont), partid.segunda_ronda.get(cont));
                if (partid.segunda_ronda.get(cont).partidos_ganados > partid.segunda_ronda.get(cont + 1).partidos_ganados) {
                    partid.tercera_ronda.add(partid.segunda_ronda.get(cont));
                    System.out.println("----Ganador: " + partid.segunda_ronda.get(count).nombre_equipo + " con " + partid.segunda_ronda.get(count).partidos_ganados);
                    //     segunda_ronda_string[cont2]=partid.segunda_ronda.get(cont).nombre_equipo+" con "+partid.segunda_ronda.get(cont).getPartidos_ganados()+"goles.";
                } else {
                    partid.tercera_ronda.add(partid.segunda_ronda.get(cont));
                    System.out.println("----Ganador: " + partid.tercera_ronda.get(count).nombre_equipo + " con " + partid.segunda_ronda.get(count).partidos_ganados);
                    //     segunda_ronda_string[cont2]=partid.segunda_ronda.get(cont+1).nombre_equipo+" con "+partid.segunda_ronda.get(cont+1).getPartidos_ganados()+"goles.";
                }
                cont += 2;
                count++;
            }
            try {
                    FileWriter fw = new FileWriter(ficheros);
                    fw.write(arbitr.getNombre_arbitro()+arbitr);
                    
                    for (int i = 0; i <7; i++) {
                    fw.write(listae.get(i).getNombre_equipo());
                    
                }
                } catch (IOException ex) {
                    ex.getLocalizedMessage();
                }

            aux = aux / 2;
            cont = 0;
            int cont_fin = 0;
            System.out.println("FINAL: ");
            ///////////////////////////////////////////////////////////////
            //                                                           //
            //  AQUI SE APLICA EL METODO comprobarNacionalidad, DONDE SE //
            //  COMPRUBEBA QUE EL ARBITRO SEA DE DISTINTA NACIONALIDAD   //
            //  QUE EL CLUB                                              //
            //                                                           //
            ///////////////////////////////////////////////////////////////

            comprobaraNacionalidad(partid.tercera_ronda, arbitr, cont);
            while (cont < aux) {
                System.out.println("Partido: " + partid.tercera_ronda.get(cont).getNombre_equipo() + " contra " + partid.tercera_ronda.get(cont + 1).getNombre_equipo());
                partid.jugarPartido(partid.tercera_ronda.get(cont), partid.tercera_ronda.get(cont + 1));
                if (partid.tercera_ronda.get(cont).partidos_ganados > 2) {
                    partid.final_ronda.add(partid.tercera_ronda.get(cont));
                    Ganador = partid.final_ronda.get(0).nombre_equipo;
                    System.out.println("GANADOR DEL TORNEO: " + partid.final_ronda.get(cont_fin).getNombre_equipo());
                } else {
                    partid.final_ronda.add(partid.tercera_ronda.get(cont + 1));
                    Ganador = partid.final_ronda.get(0).nombre_equipo;
                    System.out.println("GANADOR DEL TORNEO: " + partid.final_ronda.get(cont_fin).getNombre_equipo());
                }
                cont_fin++;
                cont += 2;
            }
        }

    }

    /*
        cont=0;
        count = 0;
            partid.jugarPartido(partid.final_ronda.get(cont), partid.final_ronda.get(cont+1));
            if (partid.final_ronda.get(cont).partidos_ganados>partid.final_ronda.get(cont+1).partidos_ganados) {
                System.out.println("GANADOR: "+partid.final_ronda.get(cont).nombre_equipo.toUpperCase()+".");
            }else{
                System.out.println("GANADOR: "+partid.final_ronda.get(cont+1).nombre_equipo.toUpperCase()+".");
            }
     */
    public void comprobaraNacionalidad(ArrayList<Clubfutbol> a, Arbitraje b, int cont)  {
        boolean correcto = false;
        while (correcto == false) {
            if (b.getArbitro_principal().getNacionalidad_arbitro().equals(a.get(cont).getNacionalidad())) {

                try {
                    Arbitro nuevo = new Arbitro();
                    b.setArbitro_principal(nuevo);
                    throw new ArbitroException();
                } catch (ArbitroException ex) {
                    System.out.println(ex.toString());
                }

            } else if (b.getArbitro_principal().getNacionalidad_arbitro().equals(a.get(cont + 1).getNacionalidad())) {
                try {
                    System.out.println("La nacionalidad del equipo y la del arbitro coinciden. Se cambiará el arbitro.");
                    Arbitro nuevo = new Arbitro();
                    b.setArbitro_principal(nuevo);
                    throw new ArbitroException();
                } catch (ArbitroException ex) {
                    System.out.println(ex.toString());
                }

            } else {
                System.out.println("Nacionalidades correctas, se procede al partido.");
                correcto = true;
            }
        }
        System.out.println("TODO CORRECTO");
    }

    public String getNombrelig() {
        return nombrelig;
    }

    public void setNombrelig(String nombrelig) {
        this.nombrelig = nombrelig;
    }

    public int getNumequip() {
        return numequip;
    }

    public void setNumequip(int numequip) {
        this.numequip = numequip;
    }

    public ArrayList<Clubfutbol> getListae() {
        return listae;
    }

    public void setLista_equip(ArrayList<Clubfutbol> listae) {
        this.listae = listae;
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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    /*
    public String toString(){
        if (!"".equals(Ganador)) {
        return "Nombre liga: "+this.nombrelig+"\nTotal equipos: "+this.numequip+"\nGanador de la liga: "+this.Ganador+"\n-------------------------\nRondas\nPrimera ronda ganadores: \n"
                + primera_ronda_string[0]+","+primera_ronda_string[1]+","+primera_ronda_string[2]+","+primera_ronda_string[3]+"\nSegunda ronda ganadores: \n"+segunda_ronda_string[0]+","+segunda_ronda_string[1]+".\n";    
        }else{
            return "Denbe crear y jugar una liga primero.";
        }
        
    }
     */

}
