package gui;

import modelo.Carrera;
import modelo.Estudiante;
import modelo.data.GestorArchivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;

public class VentanaRegistroEstudiante extends Ventana {
    private JLabel textoNombre, textoRut, textoNMatricula, textoCarrera;
    private JTextField nombre, rut, nMatricula;
    private JButton registrar, cancelar;
    private JComboBox listaCarreras;

    protected VentanaRegistroEstudiante(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentanaRegistroEstudiante();
    }

    public void generarVentanaRegistroEstudiante() {
        generarCarrera();
        generarNombre();
        generarNMatricula();
        generarRut();
        generarBotonCancelar();
        generarBotonRegistrar();
    }

    public void generarNombre() {
        String texto = "Nombre:";
        super.generarJLabel(this.textoNombre, texto, 30, 137, 200, 50);
        this.nombre = super.generarJTextField(200, 150, 200, 20);
        this.add(this.nombre);
    }

    public void generarRut() {
        String texto = "Rut:";
        super.generarJLabel(this.textoRut, texto, 30, 87, 200, 50);
        this.rut = super.generarJTextField(200, 100, 200, 20);
        this.add(this.rut);
    }

    public void generarNMatricula() {
        String texto = "N° de matricula:";
        super.generarJLabel(this.textoNMatricula, texto, 30, 37, 200, 50);
        this.nMatricula = super.generarJTextField(200, 50, 200, 20);
        this.add(this.nMatricula);
    }

    public void generarCarrera() {
        String texto = "Carrera:";
        super.generarJLabel(this.textoCarrera, texto, 30, 187, 200, 50);
        this.listaCarreras = super.generarListaDesplegable(GestorArchivos.codigoCarreras("src/main/java/modelo/data/carreras.txt"), 200, 200, 200, 20);
        this.add(this.listaCarreras);
    }

    public void generarBotonRegistrar() {
        this.registrar = super.generarBoton("Registrar", 130, 425, 100, 30);
        this.add(this.registrar);
        this.registrar.addActionListener(this);
    }

    public void generarBotonCancelar() {
        this.cancelar = super.generarBoton("Cancelar", 260, 425, 100, 30);
        this.add(this.cancelar);
        this.cancelar.addActionListener(this);
    }

    private boolean registrar() {
        if (this.nombre.getText().length() == 0 || this.rut.getText().length() == 0 ||
                this.nMatricula.getText().length() == 0 || this.listaCarreras.getSelectedItem() == null) {
            return false;
        } else {

            return true;
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.registrar) {
            if (registrar()) {
                Estudiante estudiante = new Estudiante(nombre.getText(), BigInteger.valueOf(Long.parseLong(rut.getText())), BigInteger.valueOf(Long.parseLong(nMatricula.getText())), GestorArchivos.buscarCarrera(String.valueOf(listaCarreras.getSelectedItem()), "src/main/java/modelo/data/carreras.txt"));
                GestorArchivos.registrarDato(estudiante, "src/main/java/modelo/data/estudiantes.txt");
                JOptionPane.showMessageDialog(this, "Estudiante registrado correctamente", "Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida("⭐ Menú Intranet ⭐", 500, 520);
            this.dispose();
        }

        if (e.getSource() == this.cancelar) {
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida("⭐ Menú Intranet ⭐", 500, 520);
            this.dispose();
        }
    }
}