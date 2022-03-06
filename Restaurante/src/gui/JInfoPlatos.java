package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JInfoPlatos extends JFrame implements ActionListener{
	
	private String accion;
	private JPanel contentPane;
	private JTextField txtNombrePlato;
	private JTextField txtPrecio;
	private JList list;
	private JLabel lblTitulo;
	private JButton btnAceptar;
	private JButton btnVolver;
	private Administrador administrador;

	/**
	 * Create the frame.
	 */
	public JInfoPlatos(String accion) {
		setTitle("VENTANA INFO PLATOS");setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.accion=accion;
		iniciarComponentes();
	}
	public void iniciarComponentes() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAceptar.setBounds(275, 189, 82, 40);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(21, 237, 89, 30);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		txtNombrePlato = new JTextField();
		txtNombrePlato.setVisible(false);
		txtNombrePlato.setBounds(200, 85, 220, 40);
		contentPane.add(txtNombrePlato);
		txtNombrePlato.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setVisible(false);
		txtPrecio.setBounds(200, 137, 220, 40);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		list = new JList();
		list.setVisible(false);
		list.setBounds(21, 18, 157, 210);
		contentPane.add(list);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitulo.setBounds(196, 22, 236, 41);
		contentPane.add(lblTitulo);
		
		switch(accion) {
		
		case "ListaPlatos": 
			lblTitulo.setText("Lista platos"); 
			btnAceptar.setVisible(false);
			break;
			//mostrar lista platos
		
		case "ModificarPPlato":
			lblTitulo.setText("Modificar precio plato");
			txtNombrePlato.setVisible(true);
			txtNombrePlato.setToolTipText("Ingrese el nombre del plato");
			txtPrecio.setVisible(true);
			txtPrecio.setToolTipText("Ingrese el precio del plato");
			break;
		
		case "EliminarPlato":
			lblTitulo.setText("Eliminar Plato");
			txtNombrePlato.setVisible(true);
			txtNombrePlato.setToolTipText("Ingrese el nombre del plato");
			break;
		
		case "AñadirPlat":
			lblTitulo.setText("Añadir Plato");
			txtNombrePlato.setVisible(true);
			txtNombrePlato.setToolTipText("Ingrese el nombre del plato");
			txtPrecio.setVisible(true);
			txtPrecio.setToolTipText("Precio");
			//mostrar la lista de ingredientes para que seleccione y le asigne la cantidad
			break;
		
		case "ModificarIPlato":	
			lblTitulo.setText("Modificar Ingredientes");
			txtNombrePlato.setVisible(true);
			txtNombrePlato.setToolTipText("Ingrese el nombre del plato");
			txtPrecio.setVisible(true);
			//mostrar la lista de ingredientes para que seleccione y le asigne la cantidad
			txtPrecio.setToolTipText("Cantidad ingrediente");
			break;
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnVolver==e.getSource()) {
			JPlatos JP= new JPlatos();
			JP.setVisible(true);	
		}
		
		if(btnAceptar==e.getSource()) {
			
			switch(accion) {
			
			case "ListaPlatos": 
				break;
				//mostrar lista platos
			
			case "ModificarPPlato":
				String plato1=txtNombrePlato.getText(); 
				double precio1=Double.parseDouble(txtPrecio.getText());
				administrador.ModificarPrecioPlato(plato1, precio1);
				break;
			
			case "EliminarPlato":
				String plato4=txtNombrePlato.getText();
				administrador.borrarPlato(plato4);
				break;
			
			case "AñadirPlato":
				String plato2=txtNombrePlato.getText(); 
				double precio2=Double.parseDouble(txtPrecio.getText());
				//mostrar la lista de ingredientes para que seleccione y le asigne la cantidad
				administrador.addPlato(plato2, null, precio2);
				break;
			
			case "ModificarIPlato":	
				String plato3=txtNombrePlato.getText();
				administrador.ModificarIngrePlato(plato3, null);
				break;
				
			}
			
			JOptionPane.showMessageDialog(null, "La información fue guardada con éxito");
		}
		
	}
}
