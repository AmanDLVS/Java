/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria.amancio;

/**
 *
 * @author Aman
 */
public class Cuenta {

    private int saldo;

    public Cuenta(int c) {
        this.saldo = c;
    }

    public int devolverSaldo() {
        return saldo;
    }

    public void restarSaldo(int resta) {
        this.saldo -= resta;
    }

    public synchronized void retirarDinero(int cantidad, String persona) {
        if (this.saldo >= cantidad) {
            System.out.println(persona + " VA A RETIRAR" + cantidad + " euros (" + this.saldo + " euros)");
            restarSaldo(cantidad);
            System.out.println(persona + "=> " + persona + " retira " + cantidad + ". Saldo final " + this.saldo);
        } else {
            System.out.println("No se puede retirar cantidad.");
            if (this.saldo < 0) {
                System.out.println("Saldo negativo.");
            }
        }
    }

}
