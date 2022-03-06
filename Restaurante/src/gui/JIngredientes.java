package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class JIngredientes extends JFrame implements ActionListener{

	private JPanel principalIngredientes;
	private JButton btnEliminarIngrediente;
	private JButton btnAddIngrediente;
	private JButton btnListaIngredientes;
	private JButton btnVolver;
	private JLabel lblTitulo;
	private Administrador administrador;

	/**
	 * Create the frame.
	 */
	public JIngredientes() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setTitle("VENTANA PRINCIPAL INGREDIENTES");
		setLocationRelativeTo(null);
		
	}

	private void iniciarComponentes() {
		
		setBounds(100, 100, 450, 300);
		principalIngredientes = new JPanel();
		principalIngredientes.setBackground(UIManager.getColor("Button.background"));
		principalIngredientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(principalIngredientes);
		principalIngredientes.setLayout(null);
		
		lblTitulo = new JLabel("Ingredientes");
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(62, 10, 316, 47);
		principalIngredientes.add(lblTitulo);
		
		btnAddIngrediente = new JButton("A\u00F1adir Ingrediente");
		
		btnAddIngrediente.setBackground(SystemColor.inactiveCaption);
		btnAddIngrediente.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnAddIngrediente.setBounds(39, 89, 165, 50);
		btnAddIngrediente.addActionListener(this);
		principalIngredientes.add(btnAddIngrediente);
		
		btnListaIngredientes = new JButton("Lista de Ingredientes");
		
		btnListaIngredientes.setBackground(SystemColor.inactiveCaption);
		btnListaIngredientes.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnListaIngredientes.setBounds(140, 147, 165, 50);
		btnListaIngredientes.addActionListener(this);
		principalIngredientes.add(btnListaIngredientes);
		
		btnVolver = new JButton("Volver");
		
		btnVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnVolver.setBackground(SystemColor.inactiveCaption);
		btnVolver.setBounds(23, 232, 100, 30);
		btnVolver.addActionListener(this);
		principalIngredientes.add(btnVolver);
		
		btnEliminarIngrediente = new JButton("Eliminar Ingrediente");
		
		btnEliminarIngrediente.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnEliminarIngrediente.setBackground(SystemColor.inactiveCaption);
		btnEliminarIngrediente.setBounds(251, 89, 165, 50);
		btnEliminarIngrediente.addActionListener(this);
		principalIngredientes.add(btnEliminarIngrediente);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnVolver==e.getSource()) {
			JRestaurante JR= new JRestaurante();
			JR.setVisible(true);
			dispose();
		}
		if(btnAddIngrediente==e.getSource()) {
			JInfoIngredientes JII1= new JInfoIngredientes("AddIngrediente");
			JII1.setVisible(true);
			dispose();
		}
		if(btnEliminarIngrediente==e.getSource()) {
			JInfoIngredientes JII2= new JInfoIngredientes("EliminarIngrediente");
			JII2.setVisible(true);
			dispose();
		}
		if(btnListaIngredientes==e.getSource()) {
			JInfoIngredientes JII3= new JInfoIngredientes("ListaIngredientes");
			JII3.setVisible(true);
			dispose();
		}
}
}



		/*final Administrador admin = new Administrador();
				final Ingredientes[] listaIng = admin.getIngredientesTotal();
				final String[] nombreIngs = new String[admin.getIngredientesTotal().length];
				for(int i = 0; i<nombreIngs.length; i++) {
					nombreIngs[i] = listaIng[i].getNombre();
				}*/