package modelo;

import modelo.data.GestorArchivos;

import java.util.ArrayList;

public class Carrera {
    private String nombre;
    private String id;
    private String nSemestres;
    private final ArrayList<Estudiante> listaEstudiantes = new java.util.ArrayList<Estudiante>();


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNSemestres() {
        return this.nSemestres;
    }

    public void setNSemestres(String nSemestres) {
        this.nSemestres = nSemestres;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
        GestorArchivos.registrarDato(estudiante, "src/main/java/modelo/data/estudiantes.txt");
    }

    public Carrera(String nombre, String id, String nSemestres) {
        this.nombre = nombre;
        this.id = id;
        this.nSemestres = nSemestres;
    }
    public Carrera(){}
    @Override
    public String toString() {
        return nombre+ ", " +id+ ", " +nSemestres;
    }
}