/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cinesax;

import java.io.File;

/**
 *
 * @author Aman
 */
public class CineSAX {

    public static void main(String[] args) {
       File f = new File("Cine.xml");
       AccesoXMLSAX a = new AccesoXMLSAX();
       //a.parsearXMLconCineSAXhandler(f);
       a.parsearXMLconCineSAXhandlerSoloTP(f);
       
    }
}
