/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.producto_consumidor_examen_amancio;

/**
 *
 * @author Aman
 */
public class Producto_consumidor_Examen_Amancio {

     public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola);
        Consumidor c = new Consumidor(cola);
        p.start();
        c.start();
    }
}
