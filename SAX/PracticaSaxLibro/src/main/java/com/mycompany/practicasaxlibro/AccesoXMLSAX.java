/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicasaxlibro;

/**
 *
 * @author Aman
 */
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class AccesoXMLSAX {
SAXParser parser;

public int parsearXMLconLibrosSAXhandler(File f){

	try{
                System.out.println("LISTADO DE LIBROS");
		SAXParserFactory factory=SAXParserFactory.newInstance();
		parser=factory.newSAXParser();
		LibrosSAXhandler sh=new LibrosSAXhandler();
		parser.parse(f, sh);
		return 0;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
	}


}
public int parsearXMLconTitulosSAXhandler(File f){

	try{
                System.out.println("LISTADO DE TITULOS");
		SAXParserFactory factory=SAXParserFactory.newInstance();
		parser=factory.newSAXParser();
		TitulosSAXhandler sh=new TitulosSAXhandler();
		parser.parse(f, sh);
		return 0;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
	}


}
}
