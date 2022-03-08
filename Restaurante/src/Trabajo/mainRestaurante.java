package Trabajo;

import java.io.*;

import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;

public class mainRestaurante implements Serializable{
	public static void main(String[] args) throws IOException, EListaVacia, ENoExiste {
		Administrador Admin = new Administrador();
		//Admin.presentarVentanaRestaurante();
		Admin.addPlato("Hamburguesa", null, 100);
	}
}
