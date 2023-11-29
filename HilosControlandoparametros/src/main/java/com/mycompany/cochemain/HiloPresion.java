/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cochemain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Aman
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class HiloPresion extends Thread {
    String fichero;
    public HiloPresion(String nombre, String ficheropresion){
        super(nombre);
        fichero = ficheropresion;
    }
    
    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(new FileReader(fichero));
            double presion ;
            while(sc.hasNext()){
                presion=Double.parseDouble(sc.next());
                if ((presion<1)||(presion>2)) {
                    System.out.println("AVISO….PRESIÓN INCORRECTA EN"+this.getName());
                }
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

