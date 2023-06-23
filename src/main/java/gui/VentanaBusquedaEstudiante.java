package gui;

import modelo.Estudiante;
import modelo.data.GestorArchivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.ArrayList;

public class VentanaBusquedaEstudiante extends Ventana {
    private JTextField textoNombre;
    private JLabel nombre, carrera;
    private JComboBox listaCarreras;
    private JButton regresar, buscar;

    protected VentanaBusquedaEstudiante(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentanaBsuquedaEstudiante();
    }

    public void generarVentanaBsuquedaEstudiante() {
        generarBotonRegresar();
        generarBotonBuscar();
        generarCarrera();
        generarNombre();
    }

    public void generarNombre() {
        String texto = "Nombre:";
        super.generarJLabel(this.nombre, texto, 30, 137, 200, 50);
        this.textoNombre = super.generarJTextField(200, 150, 200, 20);
        this.add(this.nombre);
    }

    public void generarCarrera() {
        String texto = "Carrera:";
        super.generarJLabel(this.carrera, texto, 30, 187, 200, 50);
        this.listaCarreras = super.generarListaDesplegable(GestorArchivos.codigoCarreras("src/main/java/modelo/data/carreras.txt"), 200, 200, 200, 20);
        this.add(this.listaCarreras);
    }

    public void generarBotonBuscar() {
        this.buscar = super.generarBoton("Buscar", 130, 425, 100, 30);
        this.add(this.buscar);
        this.buscar.addActionListener(this);
    }

    public void generarBotonRegresar() {
        this.regresar = super.generarBoton("Regresar", 260, 425, 100, 30);
        this.add(this.regresar);
        this.regresar.addActionListener(this);
    }


    private boolean buscar() {
        if (this.textoNombre.getText().length() == 0 ||  this.listaCarreras.getSelectedItem() == null) {
            return false;
        } else {

            return true;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscar) {
            if (buscar()) {
                String[] nombreColumnas={"Modelo","Marca","Año","Color","Precio","Kilómetros Recorridos"};


                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida("⭐ Menú Intranet ⭐", 500, 520);
            this.dispose();
        }

        if (e.getSource() == this.regresar) {
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida("⭐ Menú Intranet ⭐", 500, 520);
            this.dispose();
        }
    }
}