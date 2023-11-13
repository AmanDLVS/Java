package generated;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class CineJAXB {

    private JAXBContext contexto;
    private Unmarshaller u;
    private Cine cines;// hace referencia a la "raíz" del archivo XML
    private List<Cine.Pelicula> lCine_Pelicula;// es una lista de los objetos "hijos" del elemento raiz, que son de tipo
    // Libro

    public CineJAXB(File f) {
        try {

            contexto = JAXBContext.newInstance(Cine.class);

            u = contexto.createUnmarshaller();

            cines = (Cine) u.unmarshal(f);
            lCine_Pelicula = cines.getPelicula();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void MostrarCine(File f) {
        try {
            System.out.println("Numero de Peliculas:" + lCine_Pelicula.size() + "\n");

            Cine.Pelicula cin;
            for (int i = 0; i < lCine_Pelicula.size(); i++) {
                cin = lCine_Pelicula.get(i);
                System.out.println("Titulo: " + cin.getTitulo());
                System.out.println("Sala: " + cin.getSala());
                System.out.println("Precio: " + cin.getPrecio());
                System.out.println("Calificacion " + cin.getCalificacion() + "\n-------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verPelisCal() {
        try {
            System.out.println("Introducer la calificacion: ");
            Scanner sc = new Scanner(System.in);
            String cali = sc.nextLine();
            for (int i = 0; i < lCine_Pelicula.size(); i++) {
                if (lCine_Pelicula.get(i).getCalificacion().equalsIgnoreCase(cali)) {
                    System.out.println("Titulo:" + lCine_Pelicula.get(i).getTitulo() + "\nCalificacion: " + lCine_Pelicula.get(i).getCalificacion());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarSala(String peli) {
        try {
            for (int i = 0; i < lCine_Pelicula.size(); i++) {
                if (lCine_Pelicula.get(i).getTitulo().equalsIgnoreCase(peli)) {
                    System.out.println("Pelicula: " + lCine_Pelicula.get(i).getTitulo() + "\n Sala: "
                            + lCine_Pelicula.get(i).getSala());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void borrarPelicula() {
        try {
            System.out.println("Introduce la sala: ");
            Scanner sc = new Scanner(System.in);
            Byte sa = sc.nextByte();
            for (int i = 0; i < lCine_Pelicula.size(); i++) {
                if (lCine_Pelicula.get(i).getSala() == sa) {
                    System.out.println("Pelicula: " + lCine_Pelicula.get(i).getTitulo() + " borrada");
                    lCine_Pelicula.remove(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertarPelicula() {
        Scanner sc = new Scanner(System.in);
        try {
            Cine.Pelicula peli = new Cine.Pelicula();
            System.out.println("Introduzca un titulo: ");
            peli.setTitulo(sc.nextLine());
            System.out.println("Introduzca una calificacion: ");
            peli.setCalificacion(sc.nextLine());
            System.out.println("Introduzca un precio; ");
            peli.setPrecio(sc.nextFloat());
            System.out.println("Introduzca la sala: ");
            peli.setSala(sc.nextByte());
            ;

            lCine_Pelicula.add(peli);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //te permite saber si el stribng es parseable o no, para saber si es sala o titulo
    public boolean isNumeric(String n) {
        try {
            Byte.parseByte(n);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    //utiliza el isnumeric para poder saber si utiilizar un if u otro 
    public void modificarPelicula() {
        try {
            System.out.println("Introduce el nombre o la sala de la pelicula: ");
            Scanner sc = new Scanner(System.in);
            String nos = sc.nextLine();
            boolean esString = false;

            esString = isNumeric(nos);

            for (int i = 0; i < lCine_Pelicula.size(); i++) {
                if (esString == true) {
                    //Es un string por lo que se utiliza este camino y no hace falta parseo 
                    if (lCine_Pelicula.get(i).getTitulo().equalsIgnoreCase(nos)) {
                        System.out.println("\n  Titulo: " + lCine_Pelicula.get(i).getTitulo() + "\n Sala: " + lCine_Pelicula.get(i).getSala() + "\n Precio: " + lCine_Pelicula.get(i).getPrecio() + "\n Calificacion: " + lCine_Pelicula.get(i).getCalificacion() + "\nIntroduce la nueva sala: ");
                        lCine_Pelicula.get(i).setSala(sc.nextByte());
                        System.out.println("Introduce el nuevo precio: ");
                        lCine_Pelicula.get(i).setPrecio(sc.nextFloat());
                        sc.nextLine();
                        System.out.println("Introduce la nueva calificacion: ");
                        lCine_Pelicula.get(i).setCalificacion(sc.nextLine());

                    } else {
                        System.out.println("No encontrado");
                    }
                } else if (esString == false) {
                    //Es un numero por lo que se parsea
                    if (lCine_Pelicula.get(i).getSala() == Byte.parseByte(nos)) {
                        System.out.println("\n Titulo: " + lCine_Pelicula.get(i).getTitulo() + "\n Sala: " + lCine_Pelicula.get(i).getSala() + "\n Precio: " + lCine_Pelicula.get(i).getPrecio() + "\n Calificacion: " + lCine_Pelicula.get(i).getCalificacion() + "\n Introduce el nuevo titulo: ");
                        lCine_Pelicula.get(i).setTitulo(sc.nextLine());
                        System.out.println("Introduce el nuevo precio: ");
                        lCine_Pelicula.get(i).setPrecio(sc.nextFloat());
                        sc.nextLine();
                        System.out.println("Introduce la nueva calificacion: ");
                        lCine_Pelicula.get(i).setCalificacion(sc.nextLine());

                    } else {
                        System.out.println("No encontrado");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
