package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	//Atributos
	private static Torre torre;
	int eleccion;
	
	public static void main(String[] args) {
		mostrarTorre();
		mostrarMenu();
	}
	//Métodos
	//Método mostrarTorre() 
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		}catch (NullPointerException e){
			System.out.println("ERROR: La torre no está creada.");
		}
	}
	
	//Método mostrarMenu()
	private static void mostrarMenu() {
		System.out.println("Bienvenido al menú principal, estas son las opciones que puedes elegir:");
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre eligiendo el color de la misma.");
		System.out.println("3. Crear torre eligiendo el color y la posición inicial de la misma.");
		System.out.println("4. Mover torre.");
		System.out.println("5. Salir.");
		
	}

}
