/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.producto_consumidor_examen_amancio;

/**
 *
 * @author Aman
 */
public class Cola {

    private String mensaje;
    private boolean disponible = false;

    public synchronized String get() {
        while (!disponible) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false;
        notify();
        return mensaje;
    }

    public synchronized void put(String mensaje) {
        while (disponible) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.mensaje = mensaje;
        disponible = true;
        notify();
    }
}
