package com.pmp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloAlumnos {

	private Connection _conexion = null;

	public ModeloAlumnos() {
		_conexion = Conexion.getConexion();
		String CreateTable = "CREATE TABLE IF NOT EXISTS Alumnos"
				+ "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
				+ "nombre TEXT NOT NULL,"
				+ "apellido TEXT NOT NULL,"
				+ "edad INTEGER NOT NULL,"
				+ "Carrera TEXT NOT NULL,"
				+ "Promedio DECIMAL(10,2) NOT NULL,"
				+ "direccion TEXT NULL);";
		try {

			Statement comandoSQL = _conexion.createStatement();
			comandoSQL.execute(CreateTable);
		} catch (Exception err) {
			System.out.println("erorr: " + err.getMessage());
		}
	}

	public int AgregarAlumnos(Alumnos nuevoAlumnos) {
		try {
			String insercionSQL = "INSERT INTO Alumnos(nombre,apellido,edad,Carrera,Promedio,direccion) VALUES(?,?,?,?,?,?);";
			PreparedStatement comandoSQL = _conexion.prepareStatement(insercionSQL);
			comandoSQL.setString(1, nuevoAlumnos.getNombre());
			comandoSQL.setString(2, nuevoAlumnos.getApellido());
			comandoSQL.setInt(3, nuevoAlumnos.getEdad());
			comandoSQL.setString(4, nuevoAlumnos.getCarrera());
			comandoSQL.setDouble(5, nuevoAlumnos.getPromedio());
			comandoSQL.setString(6, nuevoAlumnos.getDireccion());

			int registrosAfectado = comandoSQL.executeUpdate();
			comandoSQL.close();
			return registrosAfectado;

		} catch (Exception err) {
			System.out.println("Error en la insercion: " + err.getMessage());
			return 0;
		}

	}

	public ArrayList<Alumnos> ObtenerAlumnos() {
		try {
			ArrayList<Alumnos> nuevoAlumno = new ArrayList<Alumnos>();
			Statement comandoSQL = _conexion.createStatement();
			ResultSet registro = comandoSQL.executeQuery("SELECT * FROM Alumnos");
			while (registro.next()) {
				Alumnos nuevoAlumnos = new Alumnos();
				nuevoAlumnos.setId(registro.getInt("id"));
				nuevoAlumnos.setNombre(registro.getString("nombre"));
				nuevoAlumnos.setApellido(registro.getString("apellido"));
				nuevoAlumnos.setEdad(registro.getInt("edad"));
				nuevoAlumnos.setCarrera(registro.getString("Carrera"));
				nuevoAlumnos.setPromedio(registro.getDouble("Promedio"));
				nuevoAlumnos.setDireccion(registro.getString("direccion"));
				nuevoAlumno.add(nuevoAlumnos);
			}
			return nuevoAlumno;

		} catch (Exception err) {
			System.out.println("Error: " + err.getMessage());
			return new ArrayList<Alumnos>();
		}

	}

	public int EliminarAlumnos(int id) {
		try {
			String comandoSQL = "DELETE FROM Alumnos WHERE id = ?";
			PreparedStatement comando = _conexion.prepareStatement(comandoSQL);
			comando.setInt(1, id);
			int registroAfectado = comando.executeUpdate();
			comando.close();
			return registroAfectado;
		} catch (Exception err) {
			System.out.println("err: " + err.getMessage());
			return 0;
		}
	}

	public int ActualizarInfoAlumnos(Alumnos nuevoAlumnos) {

		try {
			String actualizarSQL = "UPDATE Alumnos SET nombre = ?, apellido = ?, edad = ?, Carrera = ?, Promedio = ?, direccion = ? WHERE id = ?;";
			PreparedStatement comandoSQL = _conexion.prepareStatement(actualizarSQL);
			comandoSQL.setString(1, nuevoAlumnos.getNombre());
			comandoSQL.setString(2, nuevoAlumnos.getApellido());
			comandoSQL.setInt(3, nuevoAlumnos.getEdad());
			comandoSQL.setString(4, nuevoAlumnos.getCarrera());
			comandoSQL.setDouble(5, nuevoAlumnos.getPromedio());
			comandoSQL.setString(6, nuevoAlumnos.getDireccion());
			comandoSQL.setInt(7, nuevoAlumnos.getId());

			int registrosAfectado = comandoSQL.executeUpdate();
			comandoSQL.close();
			return registrosAfectado;
		} catch (Exception err) {
			System.out.println("error " + err.getMessage());
			return 0;
		}
	}

	public Alumnos BuscarAlumnoPorId(int id) {

		try {
			Alumnos actualizarAlumno = new Alumnos();
			String buscar = "SELECT * FROM Alumnos WHERE id = ?";
			PreparedStatement comando = _conexion.prepareStatement(buscar);
			comando.setInt(1, id);
			ResultSet registro = comando.executeQuery();
			while (registro.next()) {
				actualizarAlumno.setId(registro.getInt("id"));
				actualizarAlumno.setNombre(registro.getString("nombre"));
				actualizarAlumno.setApellido(registro.getString("apellido"));
				actualizarAlumno.setEdad(registro.getInt("edad"));
				actualizarAlumno.setCarrera(registro.getString("Carrera"));
				actualizarAlumno.setPromedio(registro.getDouble("Promedio"));
				actualizarAlumno.setDireccion(registro.getString("direccion"));
				break;
			}
			return actualizarAlumno;

		} catch (Exception err) {
			System.out.println("error " + err.getMessage());
			return null;
		}
	}
}
