/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pidenombre;

import java.util.Scanner;

/**
 *
 * @author Aman
 */
public class Pidenombre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nomb;
        System.out.println("Introduce un nombre de 8 caracteres maximo: ");
        nomb = sc.nextLine();
        nvalid(nomb);
        
    }
    public static int nvalid(String e){
        if (e.length()<=8) {
            System.out.println("Bienvenido "+e);
            return 1;
        }else{
            System.out.println("Nombre no valido");
            return -1;
        }
    }
}
