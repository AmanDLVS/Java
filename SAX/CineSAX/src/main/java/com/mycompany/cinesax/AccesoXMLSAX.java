/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinesax;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Aman
 */
public class AccesoXMLSAX {

    SAXParser parser;

    public int parsearXMLconCineSAXhandler(File f) {

        try {
            System.out.println("LISTADO DE PELICULAS");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            CineSAXhandler sh = new CineSAXhandler();
            parser.parse(f, sh);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }
    public int parsearXMLconCineSAXhandlerSoloTP(File f) {

        try {
            System.out.println("LISTADO DE PELICULAS");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            CineSAXhandler sh = new CineSAXhandler();
            parser.parse(f, sh);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }
}
