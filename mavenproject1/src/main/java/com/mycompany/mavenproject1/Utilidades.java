package com.mycompany.mavenproject1;

import java.util.Scanner;
public class Utilidades {

	public static void encabezado() {
		Separar();
		System.out.println("\t\thola bienvenidos al sistema de CRUD :D");
		System.out.println(
				"Este sistema te permite hacer las operaciones basicas de una base de datos:\n\t\tCrear, Borrar,Actualizar y Mostrar campos\ndada esta explicacion, ¿que deseas hacer?");

	}

	public static void menu() {
		System.out.println(
				" 1. Agregar un dato \n 2. Eliminar un dato \n 3. Consultar todos los datos \n 4. Actualizar un dato   \n 5. salir \n");
		Separar();

	}

	public static void Separar() {
		System.out.println(new String(new char[80]).replace("\0", "*"));
	}

	public static String capturarRegistros(Scanner entrada, String leyenda, String valorPorDefault) {
		System.out.println(leyenda + "(" + valorPorDefault + ")");
		String opcion = entrada.nextLine();
		if (opcion.isEmpty())
			return valorPorDefault;
		return opcion;
	}

	public static void RowInfo() {
		System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", "id", "nombre", "apellido", "edad",
				"promedio", "carrera", "direccion"));
	}
}
