/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicasaxlibro;

/**
 *
 * @author Aman
 */
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class TitulosSAXhandler extends DefaultHandler {

    private String etiqueta;

    public TitulosSAXhandler() {
        etiqueta = "";//también se puede hacer con int etiqueta 
    }

    @Override
    public void startDocument() {
        System.out.println("LISTADO DE TITULOS");
        System.out.println("==================");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("Libro")) {
            etiqueta = "Libro";

        } else if (qName.equals("Titulo")) {
            etiqueta = "Titulo";

        } else if (qName.equals("Autor")) {
            etiqueta = "Autor";

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (etiqueta.equals("Titulo")) {
            String car = new String(ch, start, length);
            car = car.replaceAll("\t", "");//quita todos los tabuladores
            car = car.replaceAll("\n", "");
            System.out.println(car);
        }
    }
}
