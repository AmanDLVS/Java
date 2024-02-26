/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.receptornumerosexamenamancio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;

/**
 *
 * @author Aman
 */
public class ReceptorNumerosExamenAmancio {

    public static void main(String[] args) {
        int[] par = new int[100];
        int[] impar = new int[100];
        int numero = 0;
        int i = 0, j = 0;
        try {
            DatagramSocket sSocket = new DatagramSocket(1500);
            byte[] cadena = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);
            String datos = null;
            System.out.println("Esperando mensajes...");
            do {
                sSocket.receive(mensaje);
                datos = new String(mensaje.getData(), 0, mensaje.getLength());
                System.out.println("Mensaje recibido: " + datos);
                numero = Integer.parseInt(datos);
                if (ispar(numero)) {
                    par[i] = numero;
                    i++;
                } else {
                    impar[j] = numero;
                    j++;
                }
            } while (numero != 0);
            System.out.println("\nNumeros pares: ");
            for (int k = 0; k < par.length; k++) {
                if (par[k] != 0) {
                    System.out.print(par[k] + " ");
                }
            }
            System.out.println("\nNumeros impares: ");
            for (int k = 0; k < par.length; k++) {
                if (impar[k] != 0) {
                    System.out.print(impar[k] + " ");
                }
            }
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }
    }

    public static boolean ispar(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
