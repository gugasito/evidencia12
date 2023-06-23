package gui;

import modelo.data.GestorArchivos;

import javax.swing.*;
import java.awt.event.*;

public class VentanaBienvenida extends Ventana {

    private JButton botonRegistrarCarrera, botonBuscarEstudiante, botonRegistrarEstudiante, botonSalida;

    public VentanaBienvenida(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentana();
    }

    public void generarVentana() {
        generarBotonRegistrarCarrera();
        generarBotonRegistrarEstudiante();
        generarBotonBuscarEstudiante();
        generarBotonSalida();
    }

    public void generarBotonBuscarEstudiante() {
        this.botonBuscarEstudiante = super.generarBoton("Buscar Estudiante", 150, 150, 200, 40);
        this.add(this.botonBuscarEstudiante);
        this.botonBuscarEstudiante.addActionListener(this);
    }

    public void generarBotonRegistrarEstudiante() {
        this.botonRegistrarEstudiante = super.generarBoton("Registrar Estudiante", 150, 200, 200, 40);
        this.add(this.botonRegistrarEstudiante);
        this.botonRegistrarEstudiante.addActionListener(this);
    }


    public void generarBotonRegistrarCarrera() {
        this.botonRegistrarCarrera = super.generarBoton("Registrar Carrera", 150, 100, 200, 40);
        this.add(this.botonRegistrarCarrera);
        this.botonRegistrarCarrera.addActionListener(this);
    }

    public void generarBotonSalida() {
        this.botonSalida = super.generarBoton("Salir", 150, 425, 200, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarCarrera) {
            VentanaRegistoCarrera ventanaRegistoCarrera = new VentanaRegistoCarrera("⭐ Registro Carrera ⭐", 500, 520);
            this.dispose();
        }
        if (e.getSource() == this.botonRegistrarEstudiante) {
            VentanaRegistroEstudiante ventanaRegistroEstudiante = new VentanaRegistroEstudiante("⭐ Registro Estudiante ⭐",500,520);
            this.dispose();
        }
        if (e.getSource() == this.botonBuscarEstudiante) {
            VentanaBusquedaEstudiante ventanaBusquedaEstudiante = new VentanaBusquedaEstudiante("⭐ Búsqueda Estudiante ⭐",500,520);
            this.dispose();
        }

        if (e.getSource() == this.botonSalida) {
            //GestorArchivos.guardar();
            this.dispose();
            System.exit(0);
        }

    }
}