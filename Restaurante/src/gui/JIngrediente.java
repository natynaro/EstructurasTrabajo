package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JIngrediente extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel principalIngredientes;
	private JButton btnEliminarIngre;
	private JButton btnAddIngre;
	private JButton btnListaIngre;
	private JButton btnvolver;
	private JLabel lblIngredientes;
	private Administrador administrador;

	/**
	 * Create the frame.
	 */
	public JIngrediente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setTitle("VENTANA PRINCIPAL INGREDIENTES");
		setLocationRelativeTo(null);
		iniciarComponentes();
		
		
	}
	public void iniciarComponentes() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredientes.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblIngredientes.setBounds(6, 24, 440, 29);
		contentPane.add(lblIngredientes);
		
		btnAddIngre = new JButton("Añadir ingrediente");
		btnAddIngre.setBounds(31, 79, 187, 50);
		btnAddIngre.addActionListener(this);
		contentPane.add(btnAddIngre);
		
		btnListaIngre = new JButton("Lista ingredientes");
		btnListaIngre.setBounds(230, 79, 187, 50);
		btnListaIngre.addActionListener(this);
		contentPane.add(btnListaIngre);
		
		btnEliminarIngre = new JButton("Eliminar ingredientes");
		btnEliminarIngre.setBounds(132, 141, 187, 50);
		btnEliminarIngre.addActionListener(this);
		contentPane.add(btnEliminarIngre);
		
		btnvolver = new JButton("volver");
		btnvolver.addActionListener(this);
		btnvolver.setBounds(6, 236, 100, 30);
		
		contentPane.add(btnvolver);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(btnvolver==e.getSource()) {
		JRestaurante JR= new JRestaurante();
		JR.setVisible(true);
		}
		if(btnAddIngre==e.getSource()) {
			JInfoIngredientes JII1= new JInfoIngredientes("AddIngrediente");
			JII1.setVisible(true);
		}
		if(btnEliminarIngre==e.getSource()) {
			JInfoIngredientes JII2= new JInfoIngredientes("EliminarIngrediente");
			JII2.setVisible(true);
		}
		if(btnListaIngre==e.getSource()) {
		JInfoIngredientes JII3= new JInfoIngredientes("ListaIngredientes");
		JII3.setVisible(true);
	}
		
	}
	/*final Administrador admin = new Administrador();
	final Ingredientes[] listaIng = admin.getIngredientesTotal();
	final String[] nombreIngs = new String[admin.getIngredientesTotal().length];
	for(int i = 0; i<nombreIngs.length; i++) {
		nombreIngs[i] = listaIng[i].getNombre();
	}*/
}
