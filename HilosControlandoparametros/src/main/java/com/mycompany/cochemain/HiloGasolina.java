/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cochemain;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Aman
 */
public class HiloGasolina extends Thread{

    @Override
    public void run(){
        double gasolina;
        try {
            Scanner sc = new Scanner(new FileReader("Gasolina.txt"));
            while(sc.hasNext()){
                gasolina=Double.parseDouble(sc.next());
                if (gasolina<5) {
                    System.out.println("AVISO…..EL COCHE VA EN RESERVA");
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
