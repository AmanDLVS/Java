/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejer1_coinedom;

import java.io.File;

/**
 *
 * @author amanc
 */
public class Ejer1_CoineDOM {

    public static void main(String[] args) {
        File f = new File("Cine.xml");

        CineDOM c = new CineDOM(f);

        c.muestraDOM();
        System.out.println("\n");
        c.cambiarSala("Superpez", 5);
        System.out.println("\n");
        c.muestraDOM();
        System.out.println("\n");
        c.borrarPelicula("Bohemian Rapsody");
        System.out.println("\n");
        c.averagePrice();
        c.guardarDOMcomoArchivo("apapa");
    }
}
