package com.mycompany.mavenproject1;
import dao.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	private static Scanner key_option;

	private static ModeloAlumnos modelo = new ModeloAlumnos();

	public static void main(String args[]) {
		key_option = new Scanner(System.in);
		Utilidades.encabezado();
		int choose = 3;
		do {
			switch (choose) {
				case 1:
					AgregarAlumnos();
					break;
				case 2:
					EliminarAlumno();
					break;
				case 3:
					ConsultarAlumnos();
					break;
				case 4:
					ActualizarAlumno();
					break;
				case 5:
					break;
				default:
					System.out.println("Opcion no valida");
			}
			try {
				Utilidades.menu();
				System.out.println("¿que desea hacer?: ");
				choose = key_option.nextInt();
			} catch (Exception error) {
				System.out.println("error al ingresar un dato no valido: " + error.getMessage());
				key_option.nextLine();
			}

		} while (choose != 5);

	}

	public static void ConsultarAlumnos() {
		Utilidades.RowInfo();
		ArrayList<Alumnos> InforAlumnos = modelo.ObtenerAlumnos();
		for (int i = 0; i < InforAlumnos.size(); i++) {
			System.out.println(InforAlumnos.get(i).getRow());
			Utilidades.Separar();
		}

	}

	public static void AgregarAlumnos() {
		Utilidades.Separar();
		System.out.println("sistema de agregado de alumnos");
		Utilidades.Separar();

		Alumnos nuevoAlumnos = new Alumnos();
		key_option = new Scanner(System.in);
		nuevoAlumnos.setNombre(Utilidades.capturarRegistros(key_option, "Nombre", "XYZ"));
		nuevoAlumnos.setApellido(Utilidades.capturarRegistros(key_option, "Apellido", "ABC"));
		nuevoAlumnos.setEdad(Integer.parseInt(Utilidades.capturarRegistros(key_option, "Edad", "10")));
		nuevoAlumnos.setCarrera(Utilidades.capturarRegistros(key_option, "Carrera",
				"Ing. en ciencias de la computacion"));
		nuevoAlumnos.setPromedio(
				Double.parseDouble(Utilidades.capturarRegistros(key_option, "Promedio", "90")));
		nuevoAlumnos.setDireccion(Utilidades.capturarRegistros(key_option, "Direccion", "XYAAS"));
		int afectados = modelo.AgregarAlumnos(nuevoAlumnos);
		if (afectados < 0)
			System.out.println("Error al registrar datos");
		System.out.println("Registros Agregados exitosamente");
	}

	public static void EliminarAlumno() {
		Utilidades.Separar();
		System.out.println("sistema de eliminado de alumnos");
		Utilidades.Separar();

		String resultado = "Alumno eliminado exitosamente";
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese el id del campo a eliminar: ");
		int id = lector.nextInt();
		int registrosAfectados;
		int decision;

		System.out.println("¿esta seguro de eliminar este registro? este no se podra recuperar(1. si 2. no): ");
		decision = lector.nextInt();

		if (decision == 1) {
			registrosAfectados = modelo.EliminarAlumnos(id);
			if (registrosAfectados < 0)
				resultado = "Error al eliminar alumno";
			System.out.println(resultado);
		}
		ConsultarAlumnos();
	}

	public static void ActualizarAlumno() {
		Utilidades.Separar();
		System.out.println("sistema de actualizacion de alumnos");
		Utilidades.Separar();

		Scanner lector = new Scanner(System.in);
		System.out.println("ingrese el id del estudiante a actualizar: ");
		int id = lector.nextInt();

		lector.nextLine();
		Alumnos nuevoAlumnos = new Alumnos();
		String resultado = "Informacion actualizada correctamente";
		Alumnos actuAlumno = new Alumnos();
		actuAlumno = modelo.BuscarAlumnoPorId(id);

		nuevoAlumnos.setNombre(Utilidades.capturarRegistros(lector, "Nombre", actuAlumno.getNombre()));
		System.out.println(nuevoAlumnos.getNombre());
		nuevoAlumnos.setApellido(
				Utilidades.capturarRegistros(lector, "Apellido", actuAlumno.getApellido()));
		nuevoAlumnos.setEdad(Integer.parseInt(Utilidades.capturarRegistros(lector, "Edad",
				Integer.toString(actuAlumno.getEdad()))));
		nuevoAlumnos.setCarrera(Utilidades.capturarRegistros(lector, "Carrera",
				actuAlumno.getCarrera()));
		nuevoAlumnos.setPromedio(
				Double.parseDouble(Utilidades.capturarRegistros(lector, "Promedio",
						Double.toString(actuAlumno.getPromedio()))));
		nuevoAlumnos.setDireccion(
				Utilidades.capturarRegistros(lector, "Direccion", actuAlumno.getDireccion()));
		nuevoAlumnos.setId(id);
		int afectados = modelo.ActualizarInfoAlumnos(nuevoAlumnos);

		if (afectados < 0)
			resultado = "Error al actualizar informacion de alumnos";

		System.out.println(resultado);

		ConsultarAlumnos();

	}

}
