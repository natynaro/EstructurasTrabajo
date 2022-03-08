package Trabajo;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
import gui.JDomiciliario;
import gui.JRestaurante;

//REVISAR EL THROW Y CAMBIARLO DE DEVOLVER-1

public class Administrador implements Serializable {
	private Pedidos[] pedidosTotal;
	private Ingredientes[] ingredientesTotal;
	private Platos[] platosTotal;
	private Domiciliario[] domiciliarios;

	public Administrador() {
		cargarFicheros();

	}

	public void cargarFicheros() {
		try {
			FileInputStream Is = new FileInputStream("Pedidos.txt");
			ObjectInputStream Os = new ObjectInputStream(Is);
			pedidosTotal = (Pedidos[]) Os.readObject();
			Os.close();
			Is.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			FileInputStream Is = new FileInputStream("Domiciliarios.txt");
			ObjectInputStream Os = new ObjectInputStream(Is);
			domiciliarios = (Domiciliario[]) Os.readObject();
			Os.close();
			Is.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			FileInputStream Is = new FileInputStream("Platos.txt");
			ObjectInputStream Os = new ObjectInputStream(Is);
			platosTotal = (Platos[]) Os.readObject();
			Os.close();
			Is.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			FileInputStream Is = new FileInputStream("Ingredientes.txt");
			ObjectInputStream Os = new ObjectInputStream(Is);
			ingredientesTotal = (Ingredientes[]) Os.readObject();
			Os.close();
			Is.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void guardarFicheros() {
		try {
			FileOutputStream File = new FileOutputStream("Pedidos.txt");
			ObjectOutputStream Object = new ObjectOutputStream(File);
			Object.writeObject(pedidosTotal);
			Object.close();
			File.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try {
			FileOutputStream File = new FileOutputStream("Domiciliarios.txt");
			ObjectOutputStream Object = new ObjectOutputStream(File);
			Object.writeObject(domiciliarios);
			Object.close();
			File.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			FileOutputStream File = new FileOutputStream("Platos.txt");
			ObjectOutputStream Object = new ObjectOutputStream(File);
			Object.writeObject(platosTotal);
			Object.close();
			File.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			FileOutputStream File = new FileOutputStream("Ingredientes.txt");
			ObjectOutputStream Object = new ObjectOutputStream(File);
			Object.writeObject(ingredientesTotal);
			Object.close();
			File.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 * public Administrador() { this.pedidosTotal = new Pedidos[0];
	 * this.ingredientesTotal = new Ingredientes[0]; this.platosTotal = new
	 * Platos[0]; this.domiciliarios = new Domiciliario[0]; }
	 */

	public Pedidos[] getPedidosTotal() {
		return pedidosTotal;
	}

	public void setPedidosTotal(Pedidos[] pedidosTotal) {
		this.pedidosTotal = pedidosTotal;
		guardarFicheros();
	}

	public Ingredientes[] getIngredientesTotal() {
		return ingredientesTotal;
	}

	public void setIngredientesTotal(Ingredientes[] ingredientesTotal) {
		this.ingredientesTotal = ingredientesTotal;
		guardarFicheros();
	}

	public Platos[] getPlatosTotal() {
		return platosTotal;
	}

	public void setPlatosTotal(Platos[] platosTotal) {
		this.platosTotal = platosTotal;
		guardarFicheros();
	}

	public Domiciliario[] getDomiciliarios() {
		return domiciliarios;
	}

	public void setDomiciliarios(Domiciliario[] domiciliarios) {
		this.domiciliarios = domiciliarios;
		guardarFicheros();
	}

	// Métodos

	// De acuerdo al nombre del plato, se busca este en el array de todos los platos
// para asignarle el nuevo precio
	public void ModificarPrecioPlato(String plato, double precio) throws ENoExiste, EListaVacia, EPrecioNeg {
		if (precio > 0) {
			int i = buscarPlato(plato);
			platosTotal[i].setPrecio(precio);
			guardarFicheros();
		} else
			throw new EPrecioNeg("Debes ingresar un número mayor a 0");
	}

	// De acuerdo al nombre del plato, se busca este en el array de todos los platos
// para asignarle los nuevos ingredientes
	public void ModificarIngrePlato(String plato, Ingredientes[] nuevosIngre) throws EListaVacia, ENoExiste {
		if (nuevosIngre.length != 0) {
			int i = buscarPlato(plato);
			platosTotal[i].setIngredientes(nuevosIngre);
			guardarFicheros();
		} else
			throw new EListaVacia("No has añadido ningún plato, añade primero un plato");
	}

	// me dan los nombres platos, entonces uso el método buscar plato para crear el
// array de platos y se crea el usuario que va a hacer el pedido
	public void NuevoPedido(String[] nombresPlatos, String nombreUsu, String direccionUsu, String telefonoUsu)
			throws ENoExiste, EListaVacia {

		Platos[] platosPedir = new Platos[0];
		double totalPrecio = 0;

		for (int i = 0; i < nombresPlatos.length; i++) {
			int posicion = buscarPlato(nombresPlatos[i].toLowerCase());
			platosPedir = Arrays.copyOf(platosPedir, platosPedir.length + 1);
			platosPedir[platosPedir.length - 1] = platosTotal[posicion];
			totalPrecio = totalPrecio + platosPedir[platosPedir.length - 1].getPrecio();
		}

		Usuario usuario = new Usuario(nombreUsu.toLowerCase(), direccionUsu.toLowerCase(), telefonoUsu.toLowerCase());

		Domiciliario domiciliario = buscarDomDisponible();
		setDisponible(domiciliario.getNombre(), false);
		domiciliario.setNumPedidos(domiciliario.getNumPedidos() + 1);

		Random random = new Random();
		String codigo = new BigInteger(50, random).toString(32);
		boolean condicion = true;
		int k = 0;

		if (pedidosTotal.length != 0) {
			while (condicion) {
				while (k < pedidosTotal.length && !codigo.equals(pedidosTotal[k].getCodigo())) {
					k++;
				}
				if (k < pedidosTotal.length) {
					codigo = new BigInteger(50, random).toString(32);
					k = 0;
				} else {
					condicion = false;
				}
			}
		}

		Pedidos pedido = new Pedidos(platosPedir, codigo, totalPrecio, usuario, domiciliario);
		pedidosTotal = Arrays.copyOf(pedidosTotal, pedidosTotal.length + 1);
		pedidosTotal[pedidosTotal.length - 1] = pedido;
		guardarFicheros();
	}

	// se crea un nuevo plato con nombre, sus ingredientes y el precio
	public void addPlato(String nombre, Ingredientes[] ingredientesTotal, double precio) throws EPrecioNeg,ENoExiste, EListaVacia {
    if(precio > 0) {
		if (platosTotal == null) {
			platosTotal = new Platos[1];
			platosTotal[0] = new Platos(nombre.toLowerCase(), ingredientesTotal, precio);
			guardarFicheros();
		} else {
			platosTotal = Arrays.copyOf(platosTotal, platosTotal.length + 1);
			platosTotal[platosTotal.length - 1] = new Platos(nombre.toLowerCase(), ingredientesTotal, precio);
			guardarFicheros();
		}
    }else {
    	throw new EPrecioNeg("El precio no puede ser cero o negativo");
    }
    	
	}

	// se borra el plato de acuerdo con el nombre
	public void borrarPlato(String nombre) throws ENoExiste, EListaVacia {
		if (platosTotal.length > 0 && platosTotal != null) {
			int i = buscarPlato(nombre.toLowerCase());
			int j = i + 1;
			while (i < platosTotal.length-1) {
				platosTotal[i] = platosTotal[j];
				i++;
				j++;
				platosTotal = Arrays.copyOf(platosTotal, platosTotal.length - 1);
				guardarFicheros();
			}
		} else
			throw new EListaVacia("La lista de platos está vacía, añada primero un plato");

	}

	// De acuerdo al nombre del plato, se devuelve la posicion del Plato en caso de
// existir
	public int buscarPlato(String Nombre) throws ENoExiste, EListaVacia {
		if (platosTotal.length > 0 && platosTotal != null) {
			String n = Nombre.toLowerCase();
			int i = 0;
			while (i < platosTotal.length && !(platosTotal[i].getNombre().equals(n))) {
				i++;
			}
			if (i < platosTotal.length || platosTotal[0].getNombre().equals(n)) {
				return i;
			} else
				throw new ENoExiste("No existe un plato con ese nombre, inténtelo nuevamente o añada un nuevo plato");
		} else
			throw new EListaVacia("La lista de platos está vacía, añada primero un plato");

	}

	// de acuerdo al nombre, se busca la posicion del domiciliario con ese nombre
	public int buscarDomiciliario(String nombre) throws ENoExiste, EListaVacia {
		if (domiciliarios.length > 0 && domiciliarios != null) {
			String n = nombre.toLowerCase();
			int i = 0;
			while (i < domiciliarios.length && !n.equals(domiciliarios[i].getNombre().toLowerCase())) {
				i++;
			}
			if (i < domiciliarios.length || domiciliarios[0].getNombre().equals(n)) {
				return i;
			} else {
				return -1;
			}
		} else
			throw new EListaVacia("La lista de domiciliarios está vacía, añada primero un domiciliario");

	}

	// se añade un domiciliario con este nombre
	public void addDomiciliario(String nombre) {
		if (domiciliarios == null) {
			domiciliarios = new Domiciliario[1];
			domiciliarios[0] = new Domiciliario(nombre.toLowerCase());
			guardarFicheros();
		} else {
			domiciliarios = Arrays.copyOf(domiciliarios, domiciliarios.length + 1);
			domiciliarios[domiciliarios.length - 1] = new Domiciliario(nombre.toLowerCase());
			guardarFicheros();
		}
	}

	// se elimina el domiciliario con este nombre
	public void quitarDomiciliario(String nombre) throws EListaVacia, ENoExiste {
		try {
			int d;
			d = buscarDomiciliario(nombre.toLowerCase());
			if (domiciliarios != null && domiciliarios.length > 0) {
				for (int i = d; i < domiciliarios.length - 1; i++) {
					domiciliarios[i] = domiciliarios[i + 1];
				}
				domiciliarios = Arrays.copyOf(domiciliarios, domiciliarios.length - 1);
				guardarFicheros();
			} else
				throw new EListaVacia("No hay domiciliarios para eliminar");
		} catch (ENoExiste e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// se busca el domiciliario disponible en el arreglo de domiciliarios
	public Domiciliario buscarDomDisponible() throws ENoExiste {
		int i = 0;

		while (i < domiciliarios.length && domiciliarios[i].isDisponibilidad() != true) {
			i++;
		}
		if (domiciliarios[i].isDisponibilidad() == true) {
			return domiciliarios[i];
		} else
			throw new ENoExiste("No hay domiciliarios disponibles, intente más tarde");

	}

	public void setDisponible(String nombre, boolean bol) throws ENoExiste, EListaVacia {
		int pos = buscarDomiciliario(nombre.toLowerCase());
		domiciliarios[pos].setDisponibilidad(bol);
		guardarFicheros();
	}

	// Me suma todas las ganancias del arreglo de pedidos actual
	public double ventasTotal() throws EListaVacia {
		double v = 0;
		if (pedidosTotal != null) {
			for (int i = 0; i < pedidosTotal.length; i++) {
				v += pedidosTotal[i].getTotalPrecio();
			}
			return v;
		} else
			throw new EListaVacia("La lista de pedidos está vacía, añada primero ingredientes");

	}

	// Me enumera los pedidos y cuánto facturó cada uno, del arreglo de pedidos
// actual
	public String reportePedidos() throws EListaVacia {
		String a = "";
		if (pedidosTotal != null || pedidosTotal.length > 0) {
			for (int i = 0; i < pedidosTotal.length; i++) {
				a += "El pedido " + (i + 1) + " se factur� por un total de: " + pedidosTotal[i].getTotalPrecio() + "\n";
			}
			return a;
		} else
			throw new EListaVacia("La lista de pedidos está vacía, añada primero ingredientes");

	}

	//
	public void AddIngrediente(String nombre, int cantidad) throws EObjetoYaExiste, IOException, EListaVacia {
		if (ingredientesTotal == null) {
			if (IngredienteExiste(nombre) == false) {
				ingredientesTotal = new Ingredientes[1];
				ingredientesTotal[0] = new Ingredientes(nombre.toLowerCase(), cantidad);
				guardarFicheros();
			} else {
				throw new EObjetoYaExiste("Ya hay un ingrediente con este nombre. Por favor intente con otro nombre");
			}
		} else {
			ingredientesTotal = Arrays.copyOf(ingredientesTotal, ingredientesTotal.length + 1);
			ingredientesTotal[ingredientesTotal.length - 1] = new Ingredientes(nombre.toLowerCase(), cantidad);
			guardarFicheros();

		}
	}

	public boolean IngredienteExiste(String nIng) {
		if (ingredientesTotal != null && ingredientesTotal.length > 0) {
			boolean flag = false;
			for (int i = 0; i < ingredientesTotal.length; i++) {
				if (nIng.compareTo(ingredientesTotal[i].getNombre()) == 0) {
					flag = true;
				}
			}
			return flag;
		} else {
			return false;
		}
	}

	public int BuscarIngrediente(String nombre) throws EListaVacia, ENoExiste {
		if (ingredientesTotal.length > 0 && ingredientesTotal != null) {
			String n = nombre.toLowerCase();
			int i = 0;
			while (i < ingredientesTotal.length && !n.equals(ingredientesTotal[i].getNombre().toLowerCase())) {
				i++;
			}
			if (i < ingredientesTotal.length || ingredientesTotal[0].getNombre().equals(n)) {
				return i;
			} else
				throw new ENoExiste(
						"No existe un ingrediente con ese nombre, intentelo nuevamente o añada ingrediente");
		} else
			throw new EListaVacia("La lista de ingredientes está vacía, añada primero un ingrediente");

	}

	public void EliminarIngrediente(String nombre) throws EListaVacia, ENoExiste, IOException {
		try {
			int index;
			index = BuscarIngrediente(nombre);
			if (ingredientesTotal != null && ingredientesTotal.length > 0) {
				for (int i = index; i < ingredientesTotal.length - 1; i++) {
					ingredientesTotal[i] = ingredientesTotal[i + 1];
				}
				ingredientesTotal = Arrays.copyOf(ingredientesTotal, ingredientesTotal.length - 1);
				guardarFicheros();
			} else
				throw new EListaVacia("La lista de ingredientes est� vac�a, a�ada primero ingredientes");
		} catch (ENoExiste e) {
			e.printStackTrace();
		}
	}
	
//INTERFAZ DE USUARIO
	public void presentarVentanaRestaurante() {
		try {
			JRestaurante frame = new JRestaurante();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//EXCEPCIONES

	public class EListaVacia extends Exception {
		public EListaVacia(String mensaje) {
			super(mensaje);
		}
	}

	public class ENoExiste extends Exception {
		public ENoExiste(String mensaje) {
			super(mensaje);
		}
	}

	public class EPrecioNeg extends Exception {
		public EPrecioNeg(String mensaje) {
			super(mensaje);
		}
	}

	public class EObjetoYaExiste extends Exception {
		public EObjetoYaExiste(String mensaje) {
			super(mensaje);
		}
	}

}