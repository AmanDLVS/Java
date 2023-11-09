/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria.amancio;

/**
 *
 * @author Aman
 */
public class SacarDinero extends Thread {

    private Cuenta c;
    private String persona;

    public SacarDinero(Cuenta c, String persona) {
        this.c = c;
        this.persona = persona;
    }

    public void run() {
        for (int i = 1; i < 4; i++) {
            c.retirarDinero(10, persona + " Hilo: " + getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
