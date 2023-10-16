/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dom.menu;

/**
 *
 * @author Aman
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
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

public class MenuDOM {

    Document doc;

    public MenuDOM(File f) {

        try {
            System.out.println("Abriendo archivo XML file y generando DOM ....");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(f);
            System.out.println("DOM creado con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Eroor al inicializar el DOM");
        }
    }

    public int recorrerMenuMostrar() {
        String datos[] = new String[4];
        NodeList platos = doc.getElementsByTagName("plato");

        System.out.println("MENU DESAYUNO:");

        for (int i = 0; i < platos.getLength(); i++) {
            Element plato = (Element) platos.item(i);

            datos[0] = plato.getElementsByTagName("nombre").item(0).getTextContent();
            datos[1] = plato.getElementsByTagName("precio").item(0).getTextContent();
            datos[2] = plato.getElementsByTagName("descripcion").item(0).getTextContent();
            datos[3] = plato.getElementsByTagName("calorias").item(0).getTextContent();

            System.out.println("\nPlato nº" + i + ": " + datos[0] + "\nDescripción: " + datos[1] + "\nPrecio: " + datos[2] + "\nCalorías: " + datos[3]);

        }

        return 1;
    }

    public int borrarPlato(String nombrePlato) {
        NodeList lTitulos = doc.getElementsByTagName("nombre");
        Node ntitulo;
        boolean encontrado = false;
        for (int i = 0; i < lTitulos.getLength(); i++) {
            ntitulo = lTitulos.item(i);
            if (ntitulo.getTextContent().equalsIgnoreCase(nombrePlato)) {
                encontrado = true;
                ntitulo.getParentNode().getParentNode().removeChild(ntitulo.getParentNode());
                System.out.println("Plato eliminado");
            }
        }
        if (encontrado = true) {
            System.out.println("El plato " + nombrePlato + " se ha encontrado y borrado");
            return 1;
        } else {
            System.out.println("El plato" + nombrePlato + " no se ha encontrado");
            return -1;
        }

    }

    public int insertarPlato(String nombre, String precio, String descripcion, int calorias) {
        try {
            System.out.println("Añadir Plato al árbol DOM:" + nombre + ";" + descripcion + ";" + calorias + ";" + precio);

            Node nPlato = doc.createElement("plato");

            Node nnombre = doc.createElement("nombre");
            Node nnombre_text = doc.createTextNode(nombre);
            nnombre.appendChild(nnombre_text);
            nPlato.appendChild(nnombre);

            Node ndescripcion = doc.createElement("descripcion");
            Node ndescripcion_text = doc.createTextNode(descripcion);
            ndescripcion.appendChild(ndescripcion_text);
            nPlato.appendChild(ndescripcion);

            Node nprecio = doc.createElement("precio");
            Node nprecio_text = doc.createTextNode(precio + "");
            nprecio.appendChild(nprecio_text);
            nPlato.appendChild(nprecio);

            Node ncalorias = doc.createElement("calorias");
            Node ncalorias_text = doc.createTextNode(String.valueOf(calorias));
            ncalorias.appendChild(ncalorias_text);
            nPlato.appendChild(ncalorias);

            nPlato.appendChild(doc.createTextNode("\n"));//para insertar saltos de línea

            Node raiz = doc.getFirstChild();

            raiz.appendChild(nPlato);
            System.out.println("Plato insertado en DOM.");
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public void crearArchivoMenuDOM(String nuevoArchivo) {
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

    public int buscarPlatoContiene(String buscado) {
        NodeList nnombreList = doc.getElementsByTagName("nombre");
        NodeList ndescripcionList = doc.getElementsByTagName("descripcion");
        Node nnombre;
        Node ndescripcion;
        int cont = 0;

        for (int i = 0; i < nnombreList.getLength(); i++) {
            nnombre = nnombreList.item(i);
            if (nnombre.getTextContent().contains(buscado)) {
                ndescripcion = ndescripcionList.item(i);
                System.out.println("Nombre: " + nnombre.getTextContent() + "\nDescripcion: " + ndescripcion.getTextContent());
                cont++;
            }
            System.out.println("Coinciden: " + cont);
        }

        return 0;
    }

    public void incrementarPrecios(int incremento) {
        NodeList nprec = doc.getElementsByTagName("precio");
        Node nprecio;
        float a;
        String p = null;
        for (int i = 0; i < nprec.getLength(); i++) {
            nprecio = nprec.item(i);
            a = Float.parseFloat(nprecio.getTextContent().replaceAll("[^0-9.]+", ""));
            a = (float) (a + (a * incremento));
            nprecio.setTextContent("$" + a);
        }
    }

    public void platosMenosCalorias(int limiteCalorias) {
        NodeList ncal = doc.getElementsByTagName("calorias");
        Node ncalorias;
        Node nnombre;
        NodeList nalm = doc.getElementsByTagName("nombre");

        for (int i = 0; i < ncal.getLength(); i++) {
            ncalorias = ncal.item(i);

            if (limiteCalorias > Integer.parseInt(ncalorias.getTextContent())) {
                nnombre = nalm.item(i);
                System.out.println("Plato encontrado:\n" + "\nPlato:" + nnombre.getTextContent() + "\nCalorias: " + ncalorias.getTextContent());
            } else {
                System.out.println("\nNo se ha encontrado ningun plato");
            }

        }
    }

}
