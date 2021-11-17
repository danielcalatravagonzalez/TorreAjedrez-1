package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class Torre {
	// Atributos
	private Color color;
	private Posicion posicion;

	// Constructores
	// Constructor por defecto
	public Torre() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8, 'h'));
	}

	// Constructor con parámetro Color
	public Torre(Color color) {
		setColor(color);
		if (color.equals(color.BLANCO)) {
			setPosicion(new Posicion(1, 'h'));
		} else {
			setPosicion(new Posicion(8, 'h'));
		}
	}

	// Constructor con parámetros Color y Columna
	public Torre(Color color, char columna) {
		setColor(color);
		if (columna != 'a' || columna != 'h') {
			throw new IllegalArgumentException("La posición no es la esperada");
		} else {
			if (color.equals(color.NEGRO)) {
				setPosicion(new Posicion(8, columna));
			} else {
				setPosicion(new Posicion(1, columna));
			}
		}
	}

	// Getters y Setters
	private void setPosicion(Posicion posicion) {
		if (posicion.equals(null)) {
			throw new NullPointerException("La posición no es la esperada");
		}
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setColor(Color color) {
		if (color.equals(null)) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		} else {
			this.color = color;
		}
	}

	public Color getColor() {
		return color;
	}

	// Métodos
	// Método mover con parámetro Direccion y pasos (int)
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (pasos < 1) {
			throw new IllegalArgumentException("ERROR: los pasos deben ser positivos");
		} else if (direccion.equals(null)) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		} else {
			switch (direccion) {
			case ARRIBA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
				break;
			case ABAJO:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
				break;
			case IZQUIERDA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
				break;
			case DERECHA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
				break;
			default:
				throw new NullPointerException("ERROR: La dirección no puede ser nula");
			}
		}
	}

}
