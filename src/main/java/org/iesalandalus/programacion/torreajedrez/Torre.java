package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	//Atributos
	private Color color;
	private Posicion posicion;
	
	//Constructores
	//Constructor por defecto
	public Torre(){
	setColor(Color.NEGRO);
	setPosicion (new Posicion(8, 'h'));
	}
	
	//Constructor con parámetro Color
	public Torre(Color color){
		setColor(color);
		if (color.equals(color.BLANCO)) {
			setPosicion(new Posicion(1, 'h'));
		}else {
			setPosicion(new Posicion(8, 'h'));
		}
	}
	
	//Getters y Setters
	private void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: No se puede asignar una posicion nula.");
		}
		this.posicion = posicion;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	private void setColor(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}else {
		this.color = color;
		}
	}
	
	public Color getColor() {
		return color;
	}
	

}
