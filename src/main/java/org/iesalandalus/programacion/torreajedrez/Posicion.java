package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
		//Atributos
	private int fila;
	private char columna;
	
	//Constructores
	//Constructores con parámetros de entrada
	public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}

		//Getters y Setters
	private void setFila(int fila) {
		if (fila <1 || fila >8) {
			throw new IllegalArgumentException ("Fila no válida");
		}else {
			this.fila = fila;
		}
		
	}
	
	public int getFila() {
		return fila;
	}
	
	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException ("Columna no válida");
		}else {	
			this.columna = columna;	
		}
		
	}
	
	public char getColumna() {
		return columna;
	}

}
