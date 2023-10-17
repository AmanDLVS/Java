/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lanzarprimernombre;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Aman
 */
public class LanzarPrimerNombre {

    public static void main(String[] args) {
        try {
            File f = new File("C:\\Users\\Aman\\Documents\\NetBeansProjects\\pidenombre\\src\\main\\java\\com\\mycompany\\pidenombre");
            ProcessBuilder pb = new ProcessBuilder("java", "Pidenombre.java");
            pb.directory(f);
            Process p = pb.start();
            OutputStream os = p.getOutputStream();
            os.write("Paco\n".getBytes());
            os.flush();
            InputStream is = p.getInputStream();
            int e,c;
            while ((e = is.read()) != -1) {
                System.out.print((char) e);
            }
            InputStream er = p.getErrorStream();
            while((c = er.read()) != -1){
                System.out.print((char)c);
            }
            er.close();

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
