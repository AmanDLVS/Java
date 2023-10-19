/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinesax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Aman
 */
public class CineSAXhandler extends DefaultHandler {

    public CineSAXhandler() {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        if(qName.equals("pelicula")){
            System.out.println("La calificacion es de: "+atts.getValue(atts.getQName(0)));
        }else if (qName.equals("titulo")) {
            System.out.print("Titulo: " );//extrae el primer atributo
        } else if (qName.equals("sala")) {
            System.out.print("\nEl numero de salas es ");//aún no sabemos cúal es el título, eso lo sabremos en el evento characters			

        } else if (qName.equals("precio")) {
            System.out.print("\nEl precio es ");

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("precio")) {
            System.out.println("\n-----------------------");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String car = new String(ch, start, length);
        car = car.replaceAll("\t", "");//quita todos los tabuladores
        car = car.replaceAll("\n", "");
        System.out.print(car);
    }
}
