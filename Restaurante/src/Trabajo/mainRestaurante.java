package Trabajo;

import java.io.*;

public class mainRestaurante implements Serializable{
	public static void main(String[] args) throws IOException {
		File fl=new File("Domiciliarios.txt");
		if(!fl.exists()) {
			fl.createNewFile();
		}
		File ft=new File("Pedidos.txt");
		if(!ft.exists()) {
			ft.createNewFile();
		}
		File fy=new File("Platos.txt");
		if(!fy.exists()) {
			fy.createNewFile();
		}
		File fu =new File("Ingredientes.txt");
		if(!fu.exists()) {
			fu.createNewFile();
		}
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
		
		Admin.presentarVentanaRestaurante();
		//rrnataliaAAAAAa
	}
}
