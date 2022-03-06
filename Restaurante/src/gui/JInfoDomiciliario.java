package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class JInfoDomiciliario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblTitulo;
	private JButton btnAceptar;
	private JButton btnvolver;
	private JList list;
	private Administrador administrador;
	private String accion;


	/**
	 * Create the frame.
	 */
	public JInfoDomiciliario(String accion) {
		setTitle("VENTANA INFO DOMICILIARIOS");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.accion=accion;
		iniciarComponentes();
		setLocationRelativeTo(null);
	}
	
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.setVisible(false);
		list.setBounds(17, 28, 152, 192);
		contentPane.add(list);
		
		btnvolver = new JButton("volver");
		btnvolver.setBounds(17, 232, 100, 30);
		btnvolver.addActionListener(this);
		contentPane.add(btnvolver);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitulo.setBounds(181, 50, 246, 41);
		contentPane.add(lblTitulo);
		
		txtNombre = new JTextField();
		txtNombre.setVisible(false);
		txtNombre.setToolTipText("Ingrese el nombre del domiciliario");
		txtNombre.setBounds(204, 103, 210, 50);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAceptar.setBounds(254, 180, 115, 40);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		switch(accion) {
		case "ListaDomiciliarios":
			lblTitulo.setText("Lista de domiciliarios");
			list.setVisible(true);
			
			break;
		case "EliminarDomiciliario":
			lblTitulo.setText("Eliminar domiciliarios");
			txtNombre.setVisible(true);
			break;
		case "AddDomiciliario":
			lblTitulo.setText("Añadir domiciliarios");
			txtNombre.setVisible(true);
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnvolver==e.getSource()) {
			JDomiciliario JD= new JDomiciliario();
			JD.setVisible(true);
			dispose();
		}
		
		if(btnAceptar==e.getSource()) {
			switch(accion) {
			case "ListaDomiciliarios":
				dispose();
				break;
				
			case "EliminarDomiciliario":
				dispose();
				break;
				
			case "AñadirDomiciliario":
				dispose();
				break;
			}
			
		}
	}

}
