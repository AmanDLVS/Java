/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer1_coinedom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;//for Document
import org.w3c.dom.Document;
import java.io.*;//clase File
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author amanc
 */
public class CineDOM {

    Document doc;

    public CineDOM(File f) {
        try {
            System.out.println("Abriendo archivo XML file y generando DOM ....");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(f);
            System.out.println("DOM creado con éxito.");

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void muestraDOM() {
        String[] datos = new String[4];//lo usamos para la información de cada libro
        Node nodo = null;
        Node root = doc.getFirstChild();
        NodeList nodelist = root.getChildNodes();
        //recorrer el árbol DOM. El 1er nivel de nodos hijos del raíz
        for (int i = 0; i < nodelist.getLength(); i++) {
            nodo = nodelist.item(i);//node toma el valor de los hijos de raíz
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {//miramos nodos de tipo Element
                Node ntemp = null;
                int contador = 1;
                //sacamos el valor del atributo publicado
                datos[0] = nodo.getAttributes().item(0).getNodeValue();
                //sacamos los valores de los hijos de nodo, Titulo y Autor
                NodeList nl2 = nodo.getChildNodes();//obtenemos lista de hijos (2)

                for (int j = 0; j < nl2.getLength(); j++) {//iteramos en esa lista 
                    ntemp = nl2.item(j);
                    if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
//para conseguir el texto de titulo y autor, se //puedo hacer con getNodeValue(), también con  //getTextContent() si es ELEMENT
                        datos[contador] = ntemp.getTextContent();// también datos[contador]=ntemp.getChildNodes().item(0).getNodeValue();
                        contador++;
                    }
                }
                System.out.println(datos[0] + "--" + datos[2] + "--" + datos[1] + "--" + datos[3]);
            }
        }

    }

    public int insertaPelicula(String titulo, String sala, String calificacion, double precio) {
        try {
            System.out.println("Añadir libro al árbol DOM:" + titulo + ";" + sala + ";" + calificacion + ";" + precio);
            //crea los nodos=>los añade al padre desde las hojas a la raíz
            //CREATE TITULO con el texto en medio
            Node ntitulo = doc.createElement("Titulo");//crea etiquetas <Titulo>...</Titulo>
            Node ntitulo_text = doc.createTextNode(titulo);//crea el nodo texto para el Titulo
            ntitulo.appendChild(ntitulo_text);//añade el titulo a las etiquetas=><Titulo>titulo</Titulo>
            //Node nautor=doc.createElement("Autor").appendChild(doc.createTextNode(autor));//one line doesn't work
            //CREA AUTOR
            Node nsala = doc.createElement("sala");
            Node nsala_text = doc.createTextNode(sala);
            nsala.appendChild(nsala_text);
            Node nprecio = doc.createElement("precio");
            Node nprecio_text = doc.createTextNode(precio + "");
            nsala.appendChild(nprecio_text);
            //CREA LIBRO, con atributo y nodos Título y Autor 
            Node nPelicula = doc.createElement("Pelicula");
            ((Element) nPelicula).setAttribute("calificacion", calificacion);
            nPelicula.appendChild(ntitulo);
            nPelicula.appendChild(nsala);
            nPelicula.appendChild(nprecio);

            //APPEND LIBRO TO THE ROOT
            nPelicula.appendChild(doc.createTextNode("\n"));//para insertar saltos de línea

            Node raiz = doc.getFirstChild();//tb. doc.getChildNodes().item(0)
            raiz.appendChild(nPelicula);
            System.out.println("Pelicula insertado en DOM.");
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public void cambiarSala(String titulo, int nuevaSala) {
        boolean yaAsignada = false;
        Node sala;
        NodeList Isala = doc.getElementsByTagName(titulo);
        for (int i = 0; i < Isala.getLength(); i++) {
            sala = Isala.item(i);
            if (Integer.parseInt(sala.getTextContent()) == nuevaSala) {
                yaAsignada = true;
            }
        }
        if (yaAsignada == true) {
            System.out.println("La sala" + nuevaSala + "ya esta asiganda");
        } else {

            NodeList Ititulos = doc.getElementsByTagName("titulo");
            Node ntitulo;
            boolean peliEncontrada = false;
            for (int i = 0; i < Ititulos.getLength(); i++) {
                ntitulo = Ititulos.item(i);
                if (ntitulo.getTextContent().equals(titulo)) {
                    peliEncontrada = true;
                    ntitulo.getNextSibling().getNextSibling().setTextContent(nuevaSala + "");
                }
            }
            if (peliEncontrada) {
                System.out.println("Se ha cambiado a la sala " + nuevaSala);

            }
        }

    }

    public double averagePrice() {
        double prec=0;
        
        NodeList lPrecios = doc.getElementsByTagName("precio");
        Node nprecio;
        boolean encontrado= false;
        for (int i = 0; i < lPrecios.getLength(); i++) {
            nprecio = lPrecios.item(i);
            prec = prec+Double.parseDouble(nprecio.getTextContent());
        }
        prec = prec /4;
        System.out.println(prec);
        
        return prec;
    }

    public void borrarPelicula(String titulo) {
        NodeList lTitulos = doc.getElementsByTagName("titulo");
        Node ntitulo;
        boolean encontrado = false;
        for (int i = 0; i < lTitulos.getLength(); i++) {
            ntitulo = lTitulos.item(i);
            if (ntitulo.getTextContent().equalsIgnoreCase(titulo)) {
                encontrado = true;
                ntitulo.getParentNode().getParentNode().removeChild(ntitulo.getParentNode());
                System.out.println("Pelicula eliminada");
            }
        }
        if (encontrado = true) {
            System.out.println("La pelicula " + titulo + " se ha encontrado y borrado");
        } else {
            System.out.println("La pelicula " + titulo + " no se ha encontrado");
        }
    }

    public void guardarDOMcomoArchivo(String nuevoArchivo) {
        try {
            Source src = new DOMSource(doc); // Definimos el origen
            StreamResult rst = new StreamResult(new File(nuevoArchivo)); // Definimos el resultado
            // Declaramos el Transformer que tiene el método .transform() que necesitamos.
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            // Opción para indentar el archivo
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(src, (javax.xml.transform.Result) rst);
            System.out.println("Archivo creado del DOM con éxito\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
