package Trabajo;

import java.io.*;

public class mainRestaurante implements Serializable{
	public static void main(String[] args) throws IOException {

		Administrador Admin= new Administrador();
		
		
		Ingredientes ingrediente= new Ingredientes("pepino", 5);
		Ingredientes ingrediente2= new Ingredientes("tomate", 5);
		Ingredientes ingrediente3= new Ingredientes("lechuga", 5);
		Domiciliario dom=  new Domiciliario("Pedro");
		Domiciliario[] x= {dom};
		Ingredientes[] i= {ingrediente, ingrediente2, ingrediente3};
		Platos plato= new Platos("Ensalada", i, 15000);
		Platos[] p= {plato};
		Usuario usu= new Usuario("Natalia", "Calle", "591839193");
		
		Pedidos pedido= new Pedidos(p, "5000", 60000, usu, dom);
		Pedidos[] r= {pedido};
		
		Admin.setDomiciliarios(x);
		Admin.setIngredientesTotal(i);
		Admin.setPlatosTotal(p);
		Admin.setPedidosTotal(r);
		
		Admin.guardarFicheros();
		Admin.cargarFicheros();
		System.out.println(Admin.getPlatosTotal());
		
		Platos plator= new Platos("Ensalada", i, 15000);
		Platos[] z= {plato,plator};

		Admin.setPlatosTotal(p);
		Admin.guardarFicheros();
		Admin.cargarFicheros();
		System.out.println(Admin.getPlatosTotal());
		
		
		Admin.presentarVentanaRestaurante();
	}
}
