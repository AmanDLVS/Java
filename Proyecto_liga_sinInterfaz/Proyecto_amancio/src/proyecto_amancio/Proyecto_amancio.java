/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_amancio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amanc
 */
public class Proyecto_amancio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, NumeroImparEquiposException {
        int p, opcion = 0;
        String name;
        Scanner sc = new Scanner(System.in);
        File fj = new File("Jugadores.txt");
        File fn = new File("Nacionalidades.txt");
        File fneq = new File("nombre_equipo.txt");
        File fc = new File("ciudad.txt");
        File fp = new File("pais.txt");
        File fnes = new File("nombre_estadio.txt");
        // el de abajo se debe hacer ocn la clase hora 
        File ff = new File("fecha_fundacion.txt");
       

        while (opcion != 5) {
            System.out.println("--------------------------------------------------");
            System.out.println("  \tMenu Liga: \t \n \t1.Crear Liga\t \n \t2.Mostrar campo de futbol(BETA) \t \n \t3.Mostrar equipos(plantilla sin datos)\t \n \t4.COMING SOON\t \n \t5.Salir");
            System.out.println("--------------------------------------------------");
            opcion = sc.nextInt();
            sc.nextLine();
            Liga nuevaliga = new Liga();
            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Introduzca el nombre de la liga: ");
                        name = sc.nextLine();
                        nuevaliga.setNombrelig(name);

                        System.out.println("Cuantos equipos quieres que participen en la liga: ");
                        int n = sc.nextInt();
                        try {
                            if (n % 2 != 0) {
                                throw new NumeroImparEquiposException();
                            }
                        } catch (NumeroImparEquiposException ni) {
                            System.out.println(ni.toString() + n + ".");
                        }
                        nuevaliga.setNumequip(n);
                        System.out.println("NOMBRE LIGA" + nuevaliga.nombrelig);
                        nuevaliga.crearLiga(fj, fn, fneq, fc, fp, fnes, ff, n);
                        //    FileWriter fichero = new FileWriter(nuevaliga.toString(), true);
                        nuevaliga.toString();
                       
                    } catch (InputMismatchException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                    break;

                case 2:
                    System.out.println("|--------------------------------------------|"
                            + "\n|                                            |\n"
                            + "\n|                ----------                  |\n"
                            + "\n|                -        -                  |\n"
                            + "\n|-----------------   --   -------------------|\n"
                            + "\n|                -        -                  |\n"
                            + "\n|                ----------                  |\n"
                            + "\n|--------------------------------------------|\n");

                    break;
                case 3:
                    System.out.println("");
                    nuevaliga.printClub(nuevaliga);
                case 4:
                    System.out.println("AUN NO ESTÁ");
                    if (true) {

                    }
                    break;
                case 5:
                    System.out.println("EXIT");
                    break;

                default:
                    System.out.println("Introduzca una opcion correcta");
                    break;
                // if (p == 1) {

            }
        }
    }
}
