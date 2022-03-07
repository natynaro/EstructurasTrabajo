package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JDomiciliario extends JFrame implements ActionListener{

	private JPanel PanelDomiciliario;
	private JLabel lblTitulo;
	private JButton btnvolver;
	private JButton btnListaDomiciliarios;
	private JButton btnEliminarDomiciliario;
	private JButton btnAddDomiciliario;
	private Administrador administrador;
	private JButton btnCompletado;

	public JDomiciliario() {
		setTitle("VENTANA DOMICILIARIO");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();	
		setLocationRelativeTo(null);
	}
	
	public void iniciarComponentes() {
		setBounds(100, 100, 450, 300);
		PanelDomiciliario = new JPanel();
		PanelDomiciliario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelDomiciliario);
		PanelDomiciliario.setLayout(null);
		
		lblTitulo = new JLabel("Domiciliarios");
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblTitulo.setBounds(6, 22, 440, 29);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		PanelDomiciliario.add(lblTitulo);
		
		btnAddDomiciliario = new JButton("Anadir domiciliario");
		btnAddDomiciliario.setBounds(26, 85, 187, 50);
		btnAddDomiciliario.addActionListener(this);
		PanelDomiciliario.add(btnAddDomiciliario);
		
		btnEliminarDomiciliario = new JButton("Eliminar domiciliario");
		btnEliminarDomiciliario.setBounds(253, 85, 164, 50);
		btnEliminarDomiciliario.addActionListener(this);
		PanelDomiciliario.add(btnEliminarDomiciliario);
		
		btnListaDomiciliarios = new JButton("Mostrar lista domiciliario");
		btnListaDomiciliarios.setBounds(26, 158, 202, 50);
		btnListaDomiciliarios.addActionListener(this);
		PanelDomiciliario.add(btnListaDomiciliarios);
		
		btnvolver = new JButton("volver");
		btnvolver.setBounds(5, 238, 100, 30);
		btnvolver.addActionListener(this);
		PanelDomiciliario.add(btnvolver);
		
		btnCompletado = new JButton("Domicilio Completado");
		btnCompletado.setBounds(253, 158, 164, 50);
		btnCompletado.addActionListener(this);
		PanelDomiciliario.add(btnCompletado);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(btnvolver==e.getSource()) {
			JRestaurante JR= new JRestaurante();
			JR.setVisible(true);
			dispose();
		}
		if(btnListaDomiciliarios==e.getSource()) {
			JInfoDomiciliario JID= new JInfoDomiciliario("ListaDomiciliarios");
			JID.setVisible(true);
			dispose();
		}
		if(btnEliminarDomiciliario==e.getSource()) {
			JInfoDomiciliario JID= new JInfoDomiciliario("EliminarDomiciliario");
			JID.setVisible(true);
			dispose();
		}
		if(btnAddDomiciliario==e.getSource()) {
			JInfoDomiciliario JID= new JInfoDomiciliario("AddDomiciliario");
			JID.setVisible(true);
			dispose();
		}
		if(btnCompletado==e.getSource()) {
			JInfoDomiciliario JID= new JInfoDomiciliario("Completado");
			JID.setVisible(true);
			dispose();
		}
		
	}

}
