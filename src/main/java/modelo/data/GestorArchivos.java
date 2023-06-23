package modelo.data;

import modelo.Carrera;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {

    public static boolean registrarDato(Object objeto, String direccionArchivo) {
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.newLine() ;
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error");
            return false;
        }
    }

    public static String[] codigoCarreras(String direccionArchivo) {
        String textoArchivo = "";
        ArrayList<String> codigos = new ArrayList<String>();
        try {
            File archivo = new File(direccionArchivo);
            System.out.println("encontré el archivo");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                System.out.println(textoArchivo);
                Carrera carreraAgregar = new Carrera(data[0], data[1],data[2]);
                codigos.add(carreraAgregar.getId());
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        String[] codigosArray = codigos.toArray(new String[codigos.size()]);
        return codigosArray;
    }

    public static Carrera buscarCarrera(String id, String direccionArchivo) {
        String textoArchivo = "";
        Carrera carrera = new Carrera();
        try {
            File archivo = new File(direccionArchivo);
            System.out.println("encontré el archivo");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                if (data[1].equals(id)){
                    carrera = new Carrera(data[0],data[1],data[2]);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println("Documento no disponible, favor contactar con administrador");
        }

        return carrera;
    }
}
