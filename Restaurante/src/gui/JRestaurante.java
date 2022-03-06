package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JRestaurante extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnPlatos;
	private JLabel lblRestaurante;
	private JButton btnDomiciliarios;
	private JButton btnPedidos;
	private JButton btnIngredientes;
	private JButton btnContabilidad;
	private Administrador administrador;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRestaurante frame = new JRestaurante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JRestaurante() {
		setTitle("VENTANA RESTAURANTE");setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		
	}
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnPlatos = new JButton("Platos");
		btnPlatos.setBounds(235, 63, 187, 50);
		btnPlatos.addActionListener(this);
		contentPane.add(btnPlatos);
		
		lblRestaurante = new JLabel("Restaurante");
		lblRestaurante.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurante.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblRestaurante.setBounds(6, 17, 440, 29);
		contentPane.add(lblRestaurante);
		
		btnDomiciliarios = new JButton("Domiciliarios");
		btnDomiciliarios.setBounds(31, 138, 164, 50);
		btnDomiciliarios.addActionListener(this);
		contentPane.add(btnDomiciliarios);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(31, 63, 164, 50);
		btnPedidos.addActionListener(this);
		contentPane.add(btnPedidos);
		
		btnIngredientes = new JButton("Ingredientes");
		btnIngredientes.setBounds(235, 128, 187, 50);
		btnIngredientes.addActionListener(this);
		contentPane.add(btnIngredientes);
		
		btnContabilidad = new JButton("Contabilidad");
		btnContabilidad.setBounds(130, 194, 187, 50);
		btnContabilidad.addActionListener(this);
		contentPane.add(btnContabilidad);
	}

	public void actionPerformed(ActionEvent e) {
	
		 if(btnPlatos==e.getSource()) {
			JPlatos JP= new JPlatos();
			JP.setVisible(true);
		}
		if(btnDomiciliarios==e.getSource()) {
			JDomiciliario JD= new JDomiciliario();
			JD.setVisible(true);
		}
		/*if(btnPedidos==e.getSource()) {
			JInfoDomiciliario JID= new JInfoDomiciliario("EliminarDomiciliario");
			JID.setVisible(true);
		}*/
		
		if(btnIngredientes==e.getSource()) {
			JIngrediente JI= new JIngrediente();
			JI.setVisible(true);
		}
		/*
		if(btnContabilidad==e.getSource()) {
			VentanaIngredientes JI= new VentanaIngredientes();
			JI.setVisible(true);
			}*/
		
	}
}
