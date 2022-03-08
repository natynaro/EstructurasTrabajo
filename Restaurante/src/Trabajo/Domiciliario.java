package Trabajo;

import java.io.Serializable;

public class Domiciliario implements Serializable{
	private String nombre;
	
	private int numPedidos;
	private boolean disponibilidad;
	
	

	@Override
	public String toString() {
		return "Domiciliario [nombre=" + nombre + ", numPedidos=" + numPedidos + ", disponibilidad=" + disponibilidad
				+ "]";
	}

	public Domiciliario(String nombre) {
		super();
		this.nombre = nombre;
		this.numPedidos = 0;
		this.disponibilidad = true;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumPedidos() {
		return numPedidos;
	}
	public void setNumPedidos(int numPedidos) {
		this.numPedidos = numPedidos;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
}
