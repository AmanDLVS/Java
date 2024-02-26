/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.emisornumerosexamenamancio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author Aman
 */
public class EmisorNumerosExamenAmancio {

    public static void main(String[] args) {
        try {
            DatagramSocket sSocket = new DatagramSocket();
            InetAddress maquina = InetAddress.getByName("localhost");
            int Puerto = 1500;
            int n = 0;
            String txt;
            Random rnd = new Random();
            for (int i = 0; i < 20; i++) {
                n = rnd.nextInt(1, 100);
                System.out.println("Numero aleatorio creado: " + n);
                txt = n + "";
                byte[] cadena = txt.getBytes();
                DatagramPacket msg = new DatagramPacket(cadena, cadena.length, maquina, Puerto);
                sSocket.send(msg);
                System.out.println("Mensaje enviado: " + msg.toString());
            }
            txt = 0 + "";
            byte[] cadena = txt.getBytes();
            DatagramPacket msg = new DatagramPacket(cadena, cadena.length, maquina, Puerto);
            sSocket.send(msg);
            System.out.println("Mensaje final enviado: " + msg.toString());
        } catch (UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }
    }
}
