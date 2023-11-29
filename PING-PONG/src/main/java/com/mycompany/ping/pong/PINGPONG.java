/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ping.pong;

/**
 *
 * @author Aman
 */
public class PINGPONG {

    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Consumidor c1 = new Consumidor(cola, 2);
        p.start();
        c1.start();

    }
}
