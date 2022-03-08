package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;
import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JPlatos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel PanelPlatos;
	private JLabel lblNewLabel;
	private JButton btnAddPlato;
	private JButton btnEliminarPlato;
	private JButton btnModificarIPlato;
	private JButton btnModificarPPlato;
	private JButton btnListaPlatos;
	private JButton btnVolver;
	private Administrador administrador;

	public JPlatos() {
		setTitle("VENTANA PLATOS");
		Administrador administrador = new Administrador();
		iniciarComponentes();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void iniciarComponentes() {
		administrador=new Administrador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelPlatos = new JPanel();
		PanelPlatos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelPlatos);
		PanelPlatos.setLayout(null);
		
		lblNewLabel = new JLabel("Platos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(174, 6, 78, 41);
		PanelPlatos.add(lblNewLabel);
		
		btnAddPlato = new JButton("Añadir plato");
		btnAddPlato.setBounds(35, 59, 165, 50);
		btnAddPlato.addActionListener(this);
		PanelPlatos.add(btnAddPlato);
		
		btnEliminarPlato = new JButton("Eliminar plato");
		btnEliminarPlato.setBounds(245, 59, 165, 50);
		btnEliminarPlato.addActionListener(this);
		PanelPlatos.add(btnEliminarPlato);
		
		btnModificarIPlato = new JButton("Modificar ingredientes");
		btnModificarIPlato.setBounds(35, 121, 165, 50);
		btnModificarIPlato.addActionListener(this);
		PanelPlatos.add(btnModificarIPlato);
		
		btnModificarPPlato = new JButton("Modificar precio");
		btnModificarPPlato.setBounds(245, 121, 165, 50);
		btnModificarPPlato.addActionListener(this);
		PanelPlatos.add(btnModificarPPlato);
		
		btnListaPlatos = new JButton("Mostrar lista platos");
		btnListaPlatos.setBounds(142, 183, 150, 50);
		btnListaPlatos.addActionListener(this);
		PanelPlatos.add(btnListaPlatos);
		
		btnVolver = new JButton("volver");
		btnVolver.setBounds(6, 237, 100, 30);
		btnVolver.addActionListener(this);
		PanelPlatos.add(btnVolver);
	}

	public void actionPerformed(ActionEvent e) {
		if (btnVolver == e.getSource()) {
			JRestaurante JR = new JRestaurante();
			JR.setVisible(true);
			dispose();
		}
		if (btnListaPlatos == e.getSource()) {
			JInfoPlatos JIP1;
			JIP1 = new JInfoPlatos("ListaPlatos");
			JIP1.setVisible(true);
			dispose();
		}
		if (btnModificarPPlato == e.getSource()) {
			JInfoPlatos JIP2;
			JIP2 = new JInfoPlatos("ModificarPPlato");
			JIP2.setVisible(true);
			dispose();
		}
		if (btnModificarIPlato == e.getSource()) {
			JInfoPlatos JIP3;
			JIP3 = new JInfoPlatos("ModificarIPlato");
			JIP3.setVisible(true);
			dispose();
		}
		if (btnEliminarPlato == e.getSource()) {
			JInfoPlatos JIP4;
			JIP4 = new JInfoPlatos("EliminarPlato");
			JIP4.setVisible(true);
			dispose();
		}
		if (btnAddPlato == e.getSource()) {
			JInfoPlatos JIP5;
			JIP5 = new JInfoPlatos("AddPlato");
			JIP5.setVisible(true);
			dispose();
		}
	}
}

/*package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;
import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JPlatos extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel PanelPlatos;
	private JLabel lblNewLabel;
	private JButton btnAddPlato;
	private JButton btnEliminarPlato;
	private JButton btnModificarIPlato;
	private JButton btnModificarPPlato;
	private JButton btnListaPlatos;
	private JButton btnVolver;
	private Administrador administrador;

	public JPlatos() {
		setTitle("VENTANA PLATOS");
		Administrador administrador=new Administrador();
		iniciarComponentes();
		setLocationRelativeTo(null);	
	}
	
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelPlatos = new JPanel();
		PanelPlatos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelPlatos);
		PanelPlatos.setLayout(null);
		
		lblNewLabel = new JLabel("Platos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(174, 6, 78, 41);
		PanelPlatos.add(lblNewLabel);
		
		btnAddPlato = new JButton("Aï¿½adir plato");
		btnAddPlato.setBounds(35, 59, 165, 50);
		btnAddPlato.addActionListener(this);
		PanelPlatos.add(btnAddPlato);
		
		btnEliminarPlato = new JButton("Eliminar plato");
		btnEliminarPlato.setBounds(245, 59, 165, 50);
		btnEliminarPlato.addActionListener(this);
		PanelPlatos.add(btnEliminarPlato);
		
		btnModificarIPlato = new JButton("Modificar ingredientes");
		btnModificarIPlato.setBounds(35, 121, 165, 50);
		btnModificarIPlato.addActionListener(this);
		PanelPlatos.add(btnModificarIPlato);
		
		btnModificarPPlato = new JButton("Modificar precio");
		btnModificarPPlato.setBounds(245, 121, 165, 50);
		btnModificarPPlato.addActionListener(this);
		PanelPlatos.add(btnModificarPPlato);
		
		btnListaPlatos = new JButton("Mostrar lista platos");
		btnListaPlatos.setBounds(142, 183, 150, 50);
		btnListaPlatos.addActionListener(this);
		PanelPlatos.add(btnListaPlatos);
		
		btnVolver = new JButton("volver");
		btnVolver.setBounds(6, 237, 100, 30);
		btnVolver.addActionListener(this);
		PanelPlatos.add(btnVolver);
	}
	public void actionPerformed(ActionEvent e) {
		if(btnVolver==e.getSource()) {
			JRestaurante JR= new JRestaurante();
			JR.setVisible(true);
			dispose();
		}
		if(btnListaPlatos==e.getSource()) {
			JInfoPlatos JIP1;
			JIP1 = new JInfoPlatos("ListaPlatos");
			JIP1.setVisible(true);
			
			dispose();
		}
		if(btnModificarPPlato==e.getSource()) {
			JInfoPlatos JIP2;
			JIP2 = new JInfoPlatos("ModificarPPlato");
			JIP2.setVisible(true);
			dispose();
		}
		if(btnModificarIPlato==e.getSource()) {
			JInfoPlatos JIP3;
			JIP3 = new JInfoPlatos("ModificarIPlato");
			JIP3.setVisible(true);
			
			dispose();
		}
		if(btnEliminarPlato==e.getSource()) {
			JInfoPlatos JIP4;
			JIP4 = new JInfoPlatos("EliminarPlato");
			JIP4.setVisible(true);
			
			dispose();
		}
		if(btnAddPlato==e.getSource()) {
			JInfoPlatos JIP5;
			JIP5 = new JInfoPlatos("AddPlato");
			JIP5.setVisible(true);
			dispose();
		}
		
	}
}
*/