package Trabajo;

import java.io.Serializable;
public class Pedidos implements Serializable {
	private Platos[] Platos;
	private String codigo;
	private double totalPrecio;
	private Usuario Usuario;
	private Domiciliario Domiciliario;
	
	public Pedidos(Platos[] platos, String codigo, double totalPrecio, Usuario usuario,
			Domiciliario domiciliario) {
		super();
		Platos = platos;
		this.codigo = codigo;
		this.totalPrecio = totalPrecio;
		Usuario = usuario;
		Domiciliario = domiciliario;
	}

	
	public Platos[] getPlatos() {
		return Platos;
	}

	public void setPlatos(Platos[] platos) {
		Platos = platos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getTotalPrecio() {
		return totalPrecio;
	}

	public void setTotalPrecio(double totalPrecio) {
		this.totalPrecio = totalPrecio;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Domiciliario getDomiciliario() {
		return Domiciliario;
	}

	public void setDomiciliario(Domiciliario domiciliario) {
		Domiciliario = domiciliario;
	}
}
