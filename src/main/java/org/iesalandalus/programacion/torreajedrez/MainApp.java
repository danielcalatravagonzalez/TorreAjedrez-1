package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	// Atributos
	private static Torre torre;

	public static void main(String[] args) {
		int contador = 1;
		int pulsador;
		
		System.out.println("========================");
		System.out.println("Simulación TorreAjedrez:");
		System.out.println("========================");
		
		do {
			mostrarMenu();
			pulsador = elegirOpcion();
			ejecutarOpcion(pulsador);
			
			if (pulsador != 5) {
				mostrarTorre();
			}
			
			if (pulsador == 5) {
				contador = 0;
			}
		} while (contador != 0);
	}

	// Métodos
	// Método mostrarTorre()
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e) {
			System.out.println("ERROR: La torre no está creada.");
		}
	}

	// Método mostrarMenu()
	private static void mostrarMenu() {
		System.out.println("Bienvenido al menú principal, estas son las opciones que puedes elegir:");
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre eligiendo el color de la misma.");
		System.out.println("3. Crear torre eligiendo el color y la posición inicial de la misma.");
		System.out.println("4. Mover torre.");
		System.out.println("5. Salir.");

	}

	// Método elegirOpcion()
	private static int elegirOpcion() {
		int opcionMenu;
		do {
			System.out.println("Elige una de las opciones mostradas anteriormente del 1 al 5:");
			opcionMenu = Entrada.entero();
		} while (opcionMenu < 1 || opcionMenu > 5);
		System.out.println("La opción elegida es la " + opcionMenu);
		return opcionMenu;
	}

	// Método elegirColor()
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
		} while (opcionColor != 1 && opcionColor != 2);

		switch (opcionColor) {
		case 1:
			color = Color.BLANCO;
			System.out.println("Has elegido blanca.");
			break;
		case 2:
			color = Color.NEGRO;
			System.out.println("Has elegido negra.");
			break;
		default:
			break;
		}
		return color;
	}

	// Método columnaInicial()
	private static char elegirColumnaInicial() {
		char columnaInicial = 0;
		do {
			System.out.println("===============");
			System.out.println("Menú elegir columna inicial");
			System.out.println("Elige una de las siguientes opciones escribiendo a o h:");
			System.out.println("Columna a, Columna h.");
			columnaInicial = Entrada.caracter();
		} while (columnaInicial != 'a' && columnaInicial != 'h');
		System.out.println("Has elegido la columna " + columnaInicial);
		return columnaInicial;
	}

	// Método mostrarMenuDirecciones()
	private static void mostrarMenuDirecciones() {
		System.out.println("===============");
		System.out.println("Menú elegir dirección");
		System.out.println("Elige una de las siguientes opciones para elegir dirección:");
		System.out.println("1. Mover torre hacia arriba.");
		System.out.println("2. Mover torre hacia abajo.");
		System.out.println("3. Mover torre hacia izquierda.");
		System.out.println("4. Mover torre hacia derecha.");
		System.out.println("5. Realizar un enroque corto.");
		System.out.println("6. Realizar un enroque largo.");

	}

	// Método elegirDireccion()
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int opcionDireccion = 0;
		do {
			System.out.println("===============");
			System.out.println("Del menú anterior elige una opción del 1 al 6");
			opcionDireccion = Entrada.entero();
		} while (opcionDireccion < 1 || opcionDireccion > 6);

		switch (opcionDireccion) {
		case 1:
			direccion = Direccion.ARRIBA;
			System.out.println("Has elegido mover la torre hacia arriba.");
			break;
		case 2:
			direccion = Direccion.ABAJO;
			System.out.println("Has elegido mover la torre hacia abajo.");
			break;
		case 3:
			direccion = Direccion.IZQUIERDA;
			System.out.println("Has elegido mover la torre hacia la izquierda.");
			break;
		case 4:
			direccion = Direccion.DERECHA;
			System.out.println("Has elegido mover la torre hacia la derecha.");
			break;
		case 5:
			direccion = Direccion.ENROQUE_CORTO;
			System.out.println("Has elegido utilizar el enroque corto.");
			break;
		case 6:
			direccion = Direccion.ENROQUE_LARGO;
			System.out.println("Has elegido utilizar el enroque largo.");
			break;
		default:
			break;
		}
		return direccion;
	}

	// Método crearTorreDefecto()
	private static void crearTorreDefecto() {
		torre = new Torre();
	}

	// Método crearTorreColor()
	private static void crearTorreColor() {
		torre = new Torre(elegirColor());
	}

	// Método crearTorreColorColumna()
	private static void crearTorreColorColumna() {
		torre = new Torre(elegirColor(), elegirColumnaInicial());
	}
	
	// Método mover()
	private static void mover() {
		Direccion direccion = null;
		int pasos;
		if (torre == null) {
			System.out.println("ERROR: No has creado una torre, para moverla tienes que crearla primero.");
		} else {
			mostrarMenuDirecciones();
			direccion = elegirDireccion();
			
			if (direccion.equals(Direccion.ENROQUE_CORTO) || direccion.equals(Direccion.ENROQUE_LARGO)) {
				try {
					torre.enrocar(direccion);
				} catch (OperationNotSupportedException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("===============");
				System.out.println("Pon el número de pasos que quieres mover la torre:");
				pasos = Entrada.entero();
				
				try {
					torre.mover(direccion, pasos);
				} catch (OperationNotSupportedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	//Método ejecutarOpcion()
		private static void ejecutarOpcion(int opcionEjecucion) {
			switch (opcionEjecucion) {
			case 1:
				crearTorreDefecto();
				break;
			case 2:
				crearTorreColor();
				break;
			case 3:
				crearTorreColorColumna();
				break;
			case 4:
				mover();
				break;
			case 5:
				System.out.println("¡Hasta la próxima!");
				break;
			}
		}
}
