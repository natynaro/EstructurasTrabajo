package Trabajo;

import java.math.BigInteger;
import java.util.*;

import gui.JDomiciliario;

//REVISAR, que entonces elnombre se haga con to.Lowercase para que dé la búsqueda del plato
//REVISAR EL THROW Y CAMBIARLO DE DEVOLVER-1

public class Administrador {
	private Pedidos[] pedidosTotal;
	private Ingredientes[] ingredientesTotal;
	private Platos[] platosTotal;
	private Domiciliario[] domiciliarios;
	
	public Administrador() {
		this.pedidosTotal = new Pedidos[0];
		this.ingredientesTotal = new Ingredientes[0];
		this.platosTotal = new Platos[0];
		this.domiciliarios = new Domiciliario[0];
	}

	public Pedidos[] getPedidosTotal() {
		return pedidosTotal;
	}

	public void setPedidosTotal(Pedidos[] pedidosTotal) {
		this.pedidosTotal = pedidosTotal;
	}

	public Ingredientes[] getIngredientesTotal() {
		return ingredientesTotal;
	}

	public void setIngredientesTotal(Ingredientes[] ingredientesTotal) {
		this.ingredientesTotal = ingredientesTotal;
	}

	public Platos[] getPlatosTotal() {
		return platosTotal;
	}

	public void setPlatosTotal(Platos[] platosTotal) {
		this.platosTotal = platosTotal;
	}

	public Domiciliario[] getDomiciliarios() {
		return domiciliarios;
	}

	public void setDomiciliarios(Domiciliario[] domiciliarios) {
		this.domiciliarios = domiciliarios;
	}
	
	//Métodos
	
	
	//De acuerdo al nombre del plato, se busca este en el array de todos los platos para asignarle el nuevo precio
	public void ModificarPrecioPlato(String plato, double precio){
		 int i=0;
		 while(i<platosTotal.length && !platosTotal[i].getNombre().equals(plato))i++;
		 if(i<platosTotal.length){
			 if(precio>=0) {
				 platosTotal[i].setPrecio(precio);
			 }else {
				 //otro throw?? de que el precio es negativo y no sería posible dar un precio así
			 }
			 
		 }else {//un throw? de que no se encontró un plato con este nombre
		 }
	}
	
	//De acuerdo al nombre del plato, se busca este en el array de todos los platos para asignarle los nuevos ingredientes
	public void ModificarIngrePlato(String plato, Ingredientes[] nuevosIngre){
		//estoy cambiando cosas
		int i=0;
		while(i<platosTotal.length && !platosTotal[i].getNombre().equals(plato))i++;
		 if(i<platosTotal.length && nuevosIngre.length!=0){
			 platosTotal[i].setIngredientes(nuevosIngre);
		 }else {//un throw? de que no se encontró un plato con este nombre}
		 }
	}

	//me dan los nombres platos, entonces uso el método buscar plato para crear el array de platos y se crea el usuario que va a hacer el pedido
	public void NuevoPedido(String[] nombresPlatos, String nombreUsu, String direccionUsu, String telefonoUsu){
		
		Platos[] platosPedir= new Platos[0];
		double totalPrecio= 0; //calcular el precio
		
		for(int i=0; i<nombresPlatos.length; i++) {
			
			int posicion= buscarPlato(nombresPlatos[i]); //debería haber un try catch para que cuando en el buscar plato salga la excepción, se imprimael mensaje
			platosPedir= Arrays.copyOf(platosPedir, platosPedir.length+1);
			platosPedir[platosPedir.length-1]=platosTotal[posicion];
			totalPrecio=totalPrecio+platosPedir[platosPedir.length-1].getPrecio();
		}
		
		Usuario usuario= new Usuario(nombreUsu, direccionUsu, telefonoUsu);
		
		//Acá iría el método buscarDomiDisponible para poder ya crear el pedido
		
		Domiciliario domiciliario= buscarDomDisponible(); //borrar esto y asignarleel domiciliario disponible
		
		//setear la disponibilidad del domiciliario a false
		domiciliario.setDisponibilidad(false);
		//aumentarle el numero de pedidos
		
		//generar un nuevo codigo BORRAR
		Random random = new Random();
		String codigo=new BigInteger(50, random).toString(32);
		boolean condicion=true;
		int k=0;
		
		if(pedidosTotal.length!=0) {
			while(condicion) {
				while(k<pedidosTotal.length && !codigo.equals(pedidosTotal[k].getCodigo())) {
					k++;
				}if(k<pedidosTotal.length) {
					codigo=new BigInteger(50, random).toString(32);
					k=0;
				}else {
					condicion=false;
				}
			}
		}
		
		
		Pedidos pedido= new Pedidos(platosPedir, codigo, totalPrecio, usuario, domiciliario);
		
		
		
	}
	
	//se crea un nuevo plato con nombre, sus ingredientes y el precio
	public void addPlato(String nombre,Ingredientes[] ingredientesTotal, double precio) {
		if(buscarPlato(nombre) == -1) {
			platosTotal= Arrays.copyOf(platosTotal,platosTotal.length+1);
			platosTotal[platosTotal.length-1]= new Platos(nombre,ingredientesTotal,precio);
		}
	}
	
	//se borra el plato de acuerdo con el nombre
	public void borrarPlato(String nombre) {
		if(buscarPlato(nombre) != -1) {
			int i=buscarPlato(nombre);
			int j=buscarPlato(nombre)+1;
			while(i<platosTotal.length) {
			platosTotal[i]= platosTotal[j];
			i++;j++;
		}
			platosTotal= Arrays.copyOf(platosTotal, platosTotal.length-1);
			}
	}
	
	//Deacuerdo al nombre del plato, se devuelve la posicion del Plato en caso de existir
	public int buscarPlato(String Nombre) {
		String n= Nombre.toLowerCase();
		int i=0;
		while(i<platosTotal.length && !(platosTotal[i].getNombre().equals(n))) {
			i++;
		}
		if(i<platosTotal.length) {
			return i;
		}else {
			return -1; //debería ser un throw, sólo que aún no s
		}
	}
	
	//de acuerdo al nombre, se busca la posicion del domiciliario con ese nombre
	public int buscarDomiciliario(String nombre) {
			String n= nombre.toLowerCase();
			int i =0;
			while(i<domiciliarios.length && !n.equals(domiciliarios[i].getNombre())) {
				i++;
			}
			if(i<domiciliarios.length) {
				return i;
			}else {
				return -1;
			}
		}
	
	//seañade un domiciliario con este nombre
	public void addDomiciliario(String nombre) {
		if(domiciliarios == null) {
			domiciliarios = new Domiciliario[1];
			domiciliarios[0] = new Domiciliario(nombre);
		}else {
			domiciliarios = Arrays.copyOf(domiciliarios, domiciliarios.length + 1);
			domiciliarios[domiciliarios.length - 1] = new Domiciliario(nombre);
		}
	}
	
	//se elimina el domiciliario con este nombre
	public void quitarDomiciliario(String nombre) {
		int d = buscarDomiciliario(nombre);
		if(domiciliarios!=null && domiciliarios.length>0) {
		for(int i = d; i<domiciliarios.length;i++) {
			domiciliarios[i]=domiciliarios[i+1];
			}	
		domiciliarios= Arrays.copyOf(domiciliarios, domiciliarios.length-1);
		}
	}
	
	//se busca el domiciliario disponible en el arreglo de domiciliarios
	public Domiciliario buscarDomDisponible() {
		int i=0;
		
		while(i<domiciliarios.length && domiciliarios[i].isDisponibilidad()!=true) {
			i++;
		}
		return (i<domiciliarios.length)?domiciliarios[i]:null;
	}
	
	//
	public double ventasDelDia() {
		double v=0;
		if(pedidosTotal!=null) {
		for(int i=0;i<pedidosTotal.length;i++) {
			v+=pedidosTotal[i].getTotalPrecio();
			}
		}
		return v;
	}
	
	//
	public String reporteDiario() {
		String a="";
		if(pedidosTotal!=null) {
			for(int i=0;i<pedidosTotal.length;i++) {
				a+="El pedido "+ (i+1) + "se factur� por un total de: "+pedidosTotal[i].getTotalPrecio() + "\n";
			}
		}
		return a;
	}

	//
	public void AddIngrediente(String nombre, int cantidad) {
		if(ingredientesTotal == null) {
			ingredientesTotal = new Ingredientes[1];
			ingredientesTotal[0] = new Ingredientes(nombre,cantidad);
		}else {
			ingredientesTotal = Arrays.copyOf(ingredientesTotal, ingredientesTotal.length + 1);
			ingredientesTotal[ingredientesTotal.length - 1] = new Ingredientes(nombre,cantidad);
		}
	}
	
	//
	public void EliminarIngrediente(String nombre) throws EListaIngredientesVacia, EIngredienteNoExiste {
		boolean seEncontroElIngrediente = false;
		if(ingredientesTotal != null && ingredientesTotal.length > 0) {
			for(int i = 0; i<ingredientesTotal.length; i++) {
				if(nombre.compareTo(ingredientesTotal[i].getNombre()) == 0) {
					seEncontroElIngrediente = true;
					for(int u = i; u<ingredientesTotal.length - 1; u++) {
						ingredientesTotal[u] = ingredientesTotal[u+1];
					}
					ingredientesTotal = Arrays.copyOf(ingredientesTotal, ingredientesTotal.length + 1);
					}
				}
				if(seEncontroElIngrediente == false) {
					throw new EIngredienteNoExiste();
				}
			}else {
				throw new EListaIngredientesVacia();
		}
	}
	

	//Métodos para la interfaz
	
	public void presentarVentanaDomiciliario() {
		try {
			JDomiciliario frame = new JDomiciliario();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class EListaIngredientesNull extends Exception{
		public EListaIngredientesNull() {
			super("A�n no se ha a�adido ning�n ingrediente");
		}
		
	}

	class EListaIngredientesVacia extends Exception{
		public EListaIngredientesVacia() {
			super("No hay ingredientes para eliminar");
		}
		
	}

	class EIngredienteNoExiste extends Exception{
		public EIngredienteNoExiste() {
			super("No se encontro un ingrediente con ese nombre");
		}
		
	}
}