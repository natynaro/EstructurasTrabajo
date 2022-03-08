package Trabajo;

import java.io.*;

import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;
import Trabajo.Administrador.EObjetoYaExiste;

public class mainRestaurante implements Serializable{
	public static void main(String[] args) throws IOException, EListaVacia, ENoExiste, EObjetoYaExiste {
		Administrador Admin = new Administrador();
		Admin.presentarVentanaRestaurante();
		Domiciliario dom= new Domiciliario("Pedro");
		Domiciliario[] d= {dom};
		Admin.setDomiciliarios(d);
		Ingredientes ing= new Ingredientes("leche", 2);
		Ingredientes[] i= {ing};
		Platos plato= new Platos("cafe", i, 8000);
		Platos plato2= new Platos("Lecherita", i, 8000);
		Platos plato3= new Platos("leche con crema", i, 8000);
		Platos[] p= {plato, plato2, plato3};
		
		Usuario usu= new Usuario("coco", "t", "z");
		Pedidos pedido= new Pedidos(p, "cod", 100, usu, dom);
		
		Pedidos[] y= {pedido};
		Admin.setPedidosTotal(y);
		
		Admin.setPlatosTotal(p);
		Admin.AddIngrediente("Esparragos", 2);
	}
}
