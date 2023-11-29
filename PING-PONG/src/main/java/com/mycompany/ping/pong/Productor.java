/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ping.pong;

/**
 *
 * @author Aman
 */
public class Productor extends Thread {

    private Cola cola;
    private int n;

    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                cola.put("PING");
                System.out.println("Productor " + n + "\tproduce: PING");
            } else {
                cola.put("PONG");
                System.out.println("Productor " + n + "\tproduce: PONG");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
