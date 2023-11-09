/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cuentabancaria.amancio;

/**
 *
 * @author Aman
 */
public class CuentaBancariaAmancio {

    public static void main(String[] args) {
        Cuenta cu = new Cuenta(40);
        SacarDinero sc1 = new SacarDinero(cu, "Pepe");
        SacarDinero sc2 = new SacarDinero(cu, "Ana");

        sc1.start();
        sc2.start();
    }
}
