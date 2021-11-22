package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

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
	
	//Constructor copia
	public Posicion (Posicion e) {
		if (e == null) {
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		} else {
			setFila(e.getFila());
			setColumna(e.getColumna());
		}
	}

		//Getters y Setters
	private void setFila(int fila) {
		if (fila <1 || fila >8) {
			throw new IllegalArgumentException ("ERROR: Fila no válida.");
		}else {
			this.fila = fila;
		}
		
	}
	
	public int getFila() {
		return fila;
	}
	
	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException ("ERROR: Columna no válida.");
		}else {	
			this.columna = columna;	
		}
		
	}
	
	public char getColumna() {
		return columna;
	}
	
	//hashcode y equals
	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}
	
	//Método toString
	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}

	

}
