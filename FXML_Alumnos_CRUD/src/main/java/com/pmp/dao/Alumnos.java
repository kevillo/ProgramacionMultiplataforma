package com.pmp.dao;

public class Alumnos {
	 public String getRow() {
		return String.format("%d\t%s\t%s\t%d\t%f\t%s\t%s", this._id, this._nombre, this._apellido, this._edad,
				this._promedio, this._carrera, this._direccion);
	}

	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String _nombre) {
		this._nombre = _nombre;
	}

	public String getApellido() {
		return _apellido;
	}

	public void setApellido(String _apellido) {
		this._apellido = _apellido;
	}

	public int getEdad() {
		return _edad;
	}

	public void setEdad(int _edad) {
		this._edad = _edad;
	}

	public String getCarrera() {
		return _carrera;
	}

	public void setCarrera(String _carrera) {
		this._carrera = _carrera;
	}

	public double getPromedio() {
		return _promedio;
	}

	public void setPromedio(double _promedio) {
		this._promedio = _promedio;
	}

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String _direccion) {
		this._direccion = _direccion;
	}

	private int _id;
	private String _nombre;
	private String _apellido;
	private int _edad;
	private String _carrera;
	private double _promedio;
	private String _direccion;

}
