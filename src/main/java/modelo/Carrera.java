package modelo;

import modelo.data.GestorArchivos;

import java.util.ArrayList;

public class Carrera {
    private String nombre;
    private int id;
    private int nSemestres;
    private final ArrayList<Estudiante> listaEstudiantes = new java.util.ArrayList<Estudiante>();

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNSemestres() {
        return this.nSemestres;
    }

    public void setNSemestres(int nSemestres) {
        this.nSemestres = nSemestres;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
        GestorArchivos.registrarDato(estudiante, "src/main/java/modelo/data/estudiantes.txt");
    }
}