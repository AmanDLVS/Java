/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cochemain;

/**
 *
 * @author Aman
 */
public class CocheMain {

    public static void main(String[] args) {
        System.out.println("Coche arrancado");
        System.out.println("Comenzamos un viaje de 30 kilómetros");
        HiloGasolina hg1 = new HiloGasolina();
        HiloPresion h1 = new HiloPresion("Rueda delantera-izquierda","presionNeumaticos.txt");
        HiloPresion h2 = new HiloPresion("Rueda delantera-derecha","presionNeumaticos.txt");
        HiloPresion h3 = new HiloPresion("Rueda trasera-izquierda","presionNeumaticos.txt");
        HiloPresion h4 = new HiloPresion("Rueda trasera-derecha","presionNeumaticos.txt");
        hg1.start();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(500); 
                System.out.println("Kilómetro " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Hemos llegado. Fin del viaje");
    
   
    }
}

    

