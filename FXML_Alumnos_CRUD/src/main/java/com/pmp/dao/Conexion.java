package com.pmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion

{
	private static Connection _conexion = null;

	private Conexion() {
	}

	public static Connection getConexion() {
		try {
			if (_conexion == null) {
				Class.forName("org.sqlite.JDBC");
				_conexion = DriverManager.getConnection("jdbc:sqlite:escuela.db");
			}
			return _conexion;
		} catch (Exception err) {
			System.out.println("Error: " + err.getMessage());
			return null;
		}

	}
}
