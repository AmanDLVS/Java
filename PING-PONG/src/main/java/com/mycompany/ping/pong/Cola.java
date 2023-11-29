/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ping.pong;

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
                wait();
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
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.mensaje = mensaje;
        disponible = true;
        notify();
    }
}


/*
    
    
    private String mensaje;
    private boolean disponible = false;

    public synchronized String get() {
        while (!disponible) {
            try {
                wait();
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
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.mensaje = mensaje;
        disponible = true;
        notify();
    }
}

    /*
    public synchronized int get(){
        if (disponible) {
            disponible = false;
            return numero;
        }else{
            return -1;
        }
    }
 */

 /*
    public synchronized void put(int valor){
        numero = valor;
        disponible = true;
    }
 */
