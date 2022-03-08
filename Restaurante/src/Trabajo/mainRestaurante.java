package Trabajo;

import java.io.*;

import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;

public class mainRestaurante implements Serializable{
	public static void main(String[] args) throws IOException, EListaVacia, ENoExiste {
		Administrador Admin = new Administrador();
		Admin.presentarVentanaRestaurante();
		Domiciliario dom= new Domiciliario("Pedro");
		Domiciliario[] d= {dom};
		Admin.setDomiciliarios(d);
		Ingredientes ing= new Ingredientes("leche", 2);
		Ingredientes[] i= {ing};
		Platos plato= new Platos("cafe", i, 8000);
		Platos[] p= {plato};
		
		Admin.setPlatosTotal(p);
	}
}
