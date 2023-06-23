package gui;

import modelo.Carrera;
import modelo.Estudiante;
import modelo.data.GestorArchivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;

public class VentanaRegistoCarrera extends Ventana {

    private JLabel textoNombreCarrera, textoCodigoCarrera, textoCantidadSemestres;
    private JTextField nombreCarrera, codigoCarrera, cantidadSemestres;
    private JButton registrar, cancelar;

    public VentanaRegistoCarrera(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentanaRegistroCarrera();
    }

    public void generarVentanaRegistroCarrera() {
        generarBotonRegistrar();
        generarBotonCancelar();
        generarNombreCarrera();
        generarCodigoCarrera();
        generarCantidadSemestres();
    }

    public void generarCantidadSemestres() {
        String texto = "Cantidad de semestres:";
        super.generarJLabel(this.textoNombreCarrera, texto, 30, 137, 200, 50);
        this.cantidadSemestres = super.generarJTextField(200, 150, 200, 20);
        this.add(this.cantidadSemestres);
    }

    public void generarCodigoCarrera() {
        String texto = "Codigo de carrera:";
        super.generarJLabel(this.textoNombreCarrera, texto, 30, 87, 200, 50);
        this.codigoCarrera = super.generarJTextField(200, 100, 200, 20);
        this.add(this.codigoCarrera);
    }

    public void generarNombreCarrera() {
        String texto = "Nombre de carrera:";
        super.generarJLabel(this.textoNombreCarrera, texto, 30, 37, 200, 50);
        this.nombreCarrera = super.generarJTextField(200, 50, 200, 20);
        this.add(this.nombreCarrera);
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
        if (this.nombreCarrera.getText().length() == 0 || this.codigoCarrera.getText().length() == 0 || this.cantidadSemestres.getText().length() == 0) {
            return false;
        } else {

            return true;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.registrar) {
            if (registrar()) {
                Carrera carrera = new Carrera(nombreCarrera.getText(),codigoCarrera.getText() ,cantidadSemestres.getText() );
                GestorArchivos.registrarDato(carrera, "src/main/java/modelo/data/carreras.txt");
                JOptionPane.showMessageDialog(this, "Carrera registrada correctamente", "Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida("⭐ Menú Intranet ⭐", 500, 520);
            this.dispose();
        }

        if (e.getSource() == this.cancelar) {
            //GestorArchivos.guardar();
            this.dispose();
            System.exit(0);
        }
    }

}