package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	//Atributos
	private static Torre torre;
	
	public static void main(String[] args) {
		mostrarTorre();
		mostrarMenu();
		elegirOpcion();
		elegirColor();
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
	
	//Método elegirOpcion()
	private static void elegirOpcion() {
		int opcionMenu;
		do {
			System.out.println("Elige una de las opciones mostradas anteriormente del 1 al 5:");
			opcionMenu = Entrada.entero();
		}while (opcionMenu <1 || opcionMenu >5);
		System.out.println("La opción elegida es la " + opcionMenu);
	}
	
	//Método elegirColor()
		private static Color elegirColor() {
			Color color = null;
			int opcionColor = 0;
			do {
				System.out.println("===============");
				System.out.println("Menú elegir color");
				System.out.println("Elige una de las siguientes opciones entre 1 y 2:");
				System.out.println("1. Blanca");
				System.out.println("2. Negra");
				opcionColor = Entrada.entero();
			}while (opcionColor != 1 && opcionColor != 2);
			
			switch (opcionColor) {
			case 1:
				color = color.BLANCO;
				System.out.println("Has elegido blanca.");
			break;
			case 2:
				color = color.NEGRO;
				System.out.println("Has elegido negra.");
			break;
			default:
				break;
			}
			return color;
		}
}
