/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producto_consumidor_examen_amancio;

import java.util.Random;

/**
 *
 * @author Aman
 */
public class Productor extends Thread {

    private Cola cola;
    private Random r;

    public Productor(Cola c) {
        cola = c;
        r = new Random();
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            int velocidad = rVelocidad();
            System.out.println("Numero generado: "+ velocidad);
            cola.put("coche nº"+i+";"+velocidad);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int rVelocidad() {
        
        return r.nextInt(90, 151);
        
    }
}
