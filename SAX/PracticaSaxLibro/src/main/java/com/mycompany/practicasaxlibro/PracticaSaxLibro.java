/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicasaxlibro;

import java.io.File;

/**
 *
 * @author Aman
 */
public class PracticaSaxLibro {

    public static void main(String[] args) {
		File f=new File("Libros.xml");
		AccesoXMLSAX a =new AccesoXMLSAX();
	//	a.parsearXMLconLibrosSAXhandler(f);
                a.parsearXMLconTitulosSAXhandler(f);
	



	}
}
