/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dom.menu;

import java.io.File;

/**
 *
 * @author Aman
 */
public class DOMMenu {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\Aman\\Documents\\NetBeansProjects\\DOM-Menu\\src\\main\\java\\com\\mycompany\\dom\\menu\\Menu.xml");
        MenuDOM md = new MenuDOM(f);
        md.recorrerMenuMostrar();
       /* System.out.println("\n");
        md.borrarPlato("Gofres de nata");
        System.out.println("\n");
        md.recorrerMenuMostrar();
        System.out.println("\n");
        md.insertarPlato("Patatas a lo pobre", "7.00", "Patatas con huevo y ajo", 800);
        System.out.println("\n");
        md.recorrerMenuMostrar();
        md.buscarPlatoContiene("T");*/
        md.incrementarPrecios(3);
        md.recorrerMenuMostrar();
        md.platosMenosCalorias(700);
    }
}
