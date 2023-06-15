package main;

import modelo.Carrera;
import modelo.data.GestorArchivos;

public class Main {
    public static void main(String[] args) {
        GestorArchivos.carreraAObjeto("src/main/java/modelo/data/carreras.txt");
    }
}