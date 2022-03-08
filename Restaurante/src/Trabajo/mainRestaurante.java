package Trabajo;

import java.io.File;
import java.io.IOException;

public class mainRestaurante {
	public static void main(String[] args) throws IOException {
		
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
		Pedidos[] s= {pedido};
		Administrador Admin= new Administrador(s, i, p, x);
		
		Admin.guardarFicheros();
		Platos plator= new Platos("Ensalada", i, 15000);
		Platos[] z= {plato,plator};

		Admin.setPlatosTotal(p);
		Admin.guardarFicheros();
		Admin.presentarVentanaRestaurante();
	}
}