/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producto_consumidor_examen_amancio;

/**
 *
 * @author Aman
 */
public class Consumidor extends Thread {

    private Cola cola;

    public Consumidor(Cola c) {
        cola = c;
    }

    public synchronized void run() {
        for (int i = 0; i < 20; i++) {
            String colita = cola.get();
            System.out.println(colita); 
            String[] msg = colita.split(";");
            String c = msg[0];
            double v = Double.parseDouble(msg[1]);
            if (v > 120) {
                System.out.println("MULTA PARA EL COCHE " + c + " POR VELOCIDAD " + v + " SUPERIOR A 120.");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
