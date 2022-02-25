package Trabajo;
import java.util.*;

public class AdminRest {
	//Atributos
		private Ingredientes[] ingredientesTotal;
		private Domiciliario[] domiciliarios;
		private int cantIngredientes;
		private int cantDomiciliarios;
		
		//Constructor
		public AdminRest() {
			
		}
		
		
		//A�adir ingrediente
		
		public void AddIngrediente(String nombre, int cantidad) {
			if(ingredientesTotal == null) {
				cantIngredientes = 1;
				ingredientesTotal = new Ingredientes[1];
				ingredientesTotal[0] = new Ingredientes(nombre,cantidad);
			}else {
				cantIngredientes++;
				ingredientesTotal = Arrays.copyOf(ingredientesTotal, cantIngredientes);
				ingredientesTotal[ingredientesTotal.length - 1] = new Ingredientes(nombre,cantidad);
			}
		}
		
		//Borrar ingrediente
		
		public void EliminarIngrediente(String nombre) throws EListaIngredientesNull, EListaIngredientesVacia, EIngredienteNoExiste {
			boolean seEncontroElIngrediente = false;
			if(ingredientesTotal != null) {
				if(ingredientesTotal.length > 0) {
					for(int i = 0; i<ingredientesTotal.length; i++) {
						if(nombre.compareTo(ingredientesTotal[i].getNombre()) == 0) {
							seEncontroElIngrediente = true;
							for(int u = i; u<ingredientesTotal.length - 1; u++) {
								ingredientesTotal[u] = ingredientesTotal[u+1];
							}
							cantIngredientes--;
							ingredientesTotal = Arrays.copyOf(ingredientesTotal, cantIngredientes);
							}
						}
					if(seEncontroElIngrediente == false) {
						throw new EIngredienteNoExiste();
					}
				}else {
					throw new EListaIngredientesVacia();
				}
			}else {
				throw new EListaIngredientesNull();
			}
		}
		
		//A�adir domiciliario
		
		public void addDomiciliario(String nombre) {
			if(domiciliarios == null) {
				cantDomiciliarios = 1;
				domiciliarios = new Domiciliario[1];
				domiciliarios[0] = new Domiciliario(nombre);
			}else {
				cantDomiciliarios++;
				domiciliarios = Arrays.copyOf(domiciliarios, cantDomiciliarios);
				domiciliarios[domiciliarios.length - 1] = new Domiciliario(nombre);
			}
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
