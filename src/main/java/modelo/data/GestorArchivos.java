package modelo.data;

import modelo.Carrera;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {
    public static Carrera leerVentas(Carrera carrera, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                System.out.println("encontré el archivo");
                String[] data = textoArchivo.split(",");
                System.out.println(textoArchivo);

            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return carrera;
    }

    public static boolean registrarDato(Object objeto, String direccionArchivo) {
        boolean lineaVacia = false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (lineaVacia == false) {
                bw.newLine();
            }
            bw.write(objeto.toString());
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error");
            return false;
        }
    }

    public static ArrayList<Carrera> carreraAObjeto(String direccionArchivo) {
        String textoArchivo = "";
        ArrayList<Carrera> carreras = new ArrayList<Carrera>();
        try {
            File archivo = new File(direccionArchivo);
            System.out.println("encontré el archivo");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                System.out.println(textoArchivo);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return carreras;
    }
}
