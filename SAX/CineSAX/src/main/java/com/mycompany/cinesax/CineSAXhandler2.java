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
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class CineSAXhandler2 extends DefaultHandler {

    String etiqueta;
    boolean esCategoriaTP;

    public CineSAXhandler2() {
        etiqueta = "";
        esCategoriaTP = false;
    }

    public void startDocument() {
        System.out.println("-----LISTADO DEL CINE-----");
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("pelicula")) {
            etiqueta = "pelicula";
            String calificacion = atts.getValue(0);
            esCategoriaTP = "TP".equalsIgnoreCase(calificacion);
        } else if (qName.equals("titulo")) {
            etiqueta = "titulo";
        } else if (qName.equals("sala")) {
            etiqueta = "sala";
        } else if (qName.equals("precio")) {
            etiqueta = "precio";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("pelicula")) {
            System.out.println("\n---------------------------------");
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String car = new String(ch, start, length);
        car = car.replaceAll("\t", "");
        car = car.replaceAll("\n", "");

        if (etiqueta.equals("titulo") && this.esCategoriaTP) {
            System.out.println(car);
        } else if (etiqueta.equals("sala") && this.esCategoriaTP) {
            System.out.println(car);
        }
    }

    public void endDocument() {
        System.out.println("--------F I N--------");
    }

}
