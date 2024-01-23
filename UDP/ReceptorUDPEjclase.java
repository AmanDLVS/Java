/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.receptorudpejclase;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Aman
 */
public class ReceptorUDPEjclase {

    public static void main(String args[]) {
    int resultado = 0;
        try {
            // Crea el  socket 
            DatagramSocket sSocket = new DatagramSocket(1500);

            // Crea el espacio para los mensajes 
            byte[] cadena = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
            String datos;
            System.out.println("Esperando mensajes...");
            
            do {
                sSocket.receive(mensaje);
                datos = new String(mensaje.getData(), 0, mensaje.getLength());
                if(!datos.equalsIgnoreCase("*")){
                    resultado += Integer.parseInt(datos);
                    System.out.println("Mensaje recibido: " + datos);
                }
            } while(datos.toUpperCase().contains("*")==false);
            System.out.println("Mensaje de fin recibido. Cerrando receptor.");
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }
        System.out.println("El resultado es: "+resultado);
   
    }
  
}