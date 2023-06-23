package modelo;

import java.math.BigInteger;

public class Estudiante {
	private String nombre;
	private BigInteger rut;
	private BigInteger nMatricula;
	public Carrera carrera;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigInteger getRut() {
		return this.rut;
	}

	public void setRut(BigInteger rut) {
		this.rut = rut;
	}

	public BigInteger getNMatricula() {
		return this.nMatricula;
	}

	public void setNMatricula(BigInteger nMatricula) {
		this.nMatricula = nMatricula;
	}

	public Estudiante() {
		throw new UnsupportedOperationException();
	}

	public Estudiante(String nombre, BigInteger rut, BigInteger nMatricula, Carrera carrera) {
		this.nombre = nombre;
		this.rut = rut;
		this.nMatricula = nMatricula;
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return nombre+ ", " +rut+ ", " +nMatricula+ ", " +carrera.getNombre();
	}
}