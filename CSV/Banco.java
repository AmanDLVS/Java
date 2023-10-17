/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejclientesbanco;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author amanc
 */
public class Banco {


    public void clientesVIP(Banco b) {
        String line;
        String[] data;
        double dinero;
        File f = new File("ClientesVIP.txt");

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            Scanner sc = new Scanner(new FileReader("clientesBanco.csv"));
            while (sc.hasNext()) {
                line = sc.nextLine();
                data = line.split(":");
                dinero = Double.parseDouble(data[2]);
                if (dinero > 30000) {
                    pw.println("ID: " + data[0] + "\nNombre: " + data[1] + "\nSaldo: " + data[2] + "\nSalario: " + data[3] + "\nSeguro: " + data[4] + "\n");
                }
            }
            pw.close();
            System.out.println("Creado");
        } catch (IOException e) {
            System.out.println("No se encunetra el archivo");
        }
    }

    public void pedirN() {
        String n;
        String line;
        String data[];
        System.out.println("Introduce un nombre: ");
        Scanner scn = new Scanner(System.in);
        boolean a = false;
        n = scn.nextLine();
        try {
            Scanner sc = new Scanner(new FileReader("clientesBanco.csv"));
            while (sc.hasNext()) {
                line = sc.nextLine();
                data = line.split(":");
                if (data[1].equalsIgnoreCase(n)) {
                    System.out.println("ID: " + data[0] + "\nNombre: " + data[1] + "\nSaldo: " + data[2] + "\nSalario: " + data[3] + "\nSeguro: " + data[4] + "\n");
                    a = true;
                }

            }
            if (a == false) {
                System.out.println("No se encuentra en el archivo a " + n);

            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public void crearClientesActual() {
        String line;
        String data[];
        double saldo;
        File f = new File("clientesActual.csv");
        
        try {

            Scanner sc = new Scanner(new FileReader("clientesBanco.csv"));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            
            while (sc.hasNext()) {
                line = sc.nextLine();
                data = line.split(":");
                
                //me genera un dato double en vez de un entero
                saldo = Double.parseDouble(data[2]);
                 
                System.out.println("Nombre: " + data[1] + "\nIntereses: " + saldo * 0.01);
                 pw.println( data[0] +":"+ data[1] +":"+ data[2]+(saldo*0.01) +":"+ data[3] +":"+  data[4]);
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
        
    }

}
