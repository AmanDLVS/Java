/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.emisorudpejclase;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Aman
 */
public class EmisorUDPEjclase {

    public static void main(String args[]) {
        boolean isLetra = false;
        try {
            // Crea el socket 
            DatagramSocket sSocket = new DatagramSocket();

            // Construye la dirección del socket del receptor 
            InetAddress maquina = InetAddress.getByName("localhost");
            int Puerto = 1500;

            // Crea el mensaje
            /*for (int i = 0; i < 10; i++) {
                String info = "hola" + i;
                byte[] cadena = info.getBytes();
                DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length, maquina, Puerto);

            // Envía el mensaje 
            sSocket.send(mensaje);
            System.out.println("MENSAJE ENVIADO: " + mensaje);
            }*/
            Scanner tc = new Scanner(System.in);
            String text;
            do {
                    System.out.print("Introduce numeros o * para finalizar: ");
                    text = tc.nextLine();
                    if(esNumber(text) || text.equalsIgnoreCase("*")){
                    byte[] cadena = text.getBytes();
                    DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length, maquina, Puerto);
                    sSocket.send(mensaje);
                    isLetra = true;
                    System.out.println("Mensaje enviado: " + mensaje.toString());
                    }else{
                    byte[] cadena = text.getBytes();
                    DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length, maquina, Puerto);
                    sSocket.send(mensaje); 
                    System.out.println("Mensaje enviado: " + mensaje.toString());
                    }
            } while (isLetra == false);
            System.out.println("Mensaje final enviado. Cerrando emisor.");
     
            sSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }
    }
     public static boolean esNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
