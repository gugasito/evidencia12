package modelo;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int rut;
	private int nMatricula;
	public Carrera carrera;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getRut() {
		return this.rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public int getNMatricula() {
		return this.nMatricula;
	}

	public void setNMatricula(int nMatricula) {
		this.nMatricula = nMatricula;
	}

	public Estudiante() {
		throw new UnsupportedOperationException();
	}

	public Estudiante(String nombre, String apellido, int rut, int nMatricula) {
		throw new UnsupportedOperationException();
	}
}