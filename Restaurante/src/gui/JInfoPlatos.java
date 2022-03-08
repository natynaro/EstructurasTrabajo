package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;
import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;
import Trabajo.Administrador.EPrecioNeg;
import Trabajo.*;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class JInfoPlatos extends JFrame implements ActionListener {
	private String accion;
	private JPanel contentPane;
	private JTextField txtNombrePlato;
	private JTextField txtPrecio;
	private JLabel lblTitulo;
	private JButton btnAceptar;
	private JButton btnAceptar_1;
	private JButton btnVolver;
	private Administrador administrador;
	private JLabel IbReq1;
	private JLabel lbReq2;
	private JComboBox comboBox;
	private Ingredientes[] ingre;
	private JComboBox cbxCantidad;
	

	public JInfoPlatos(String accion) {
		setTitle("VENTANA INFO PLATOS");
		Administrador administrador = new Administrador();
		ingre= new Ingredientes[0];
		this.accion = accion;
		iniciarComponentes();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void iniciarComponentes() {
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		administrador=new Administrador();
		setBounds(100, 100, 483, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAceptar = new JButton("Nuevo Plato");
		btnAceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAceptar.setBounds(133, 213, 127, 40);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(21, 237, 89, 30);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		txtNombrePlato = new JTextField();
		txtNombrePlato.setToolTipText("");
		txtNombrePlato.setBounds(146, 109, 274, 40);
		contentPane.add(txtNombrePlato);
		txtNombrePlato.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setToolTipText("");
		txtPrecio.setVisible(false);
		txtPrecio.setBounds(146, 161, 274, 40);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitulo.setBounds(102, 22, 294, 41);
		contentPane.add(lblTitulo);
		
		IbReq1 = new JLabel("Nombre");
		IbReq1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		IbReq1.setBounds(68, 122, 56, 13);
		contentPane.add(IbReq1);
		
		lbReq2 = new JLabel("Precio");
		lbReq2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lbReq2.setBounds(68, 174, 45, 13);
		contentPane.add(lbReq2);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(administrador.getIngredientesTotal()));
		comboBox.setBounds(102, 72, 271, 27);
		contentPane.add(comboBox);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblIngredientes.setBounds(21, 80, 78, 13);
		contentPane.add(lblIngredientes);
		
		cbxCantidad = new JComboBox();
		cbxCantidad.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5","6","7","8","9"}));
		cbxCantidad.setMaximumRowCount(5);
		cbxCantidad.setBounds(379, 70, 80, 29);
		contentPane.add(cbxCantidad);
		
		btnAceptar_1 = new JButton("Add Ingrediente");
	    btnAceptar_1.addActionListener(this);
		btnAceptar_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnAceptar_1.setBounds(292, 213, 143, 40);
		contentPane.add(btnAceptar_1);
		
		switch (accion) {
		case "ListaPlatos":
			lblTitulo.setText("Lista platos");
			btnAceptar.setVisible(false);
			lbReq2.setVisible(false);
			IbReq1.setVisible(false);
			txtNombrePlato.setVisible(false);
			btnAceptar_1.setVisible(false);
			cbxCantidad.setVisible(false);
			comboBox.setModel(new DefaultComboBoxModel(administrador.getPlatosTotal()));
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
			lbReq2.setVisible(false);
			txtNombrePlato.setToolTipText("Ingrese el nombre del plato");
			break;
		case "AddPlato":
			lblTitulo.setText("A�adir Plato");
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
		if (btnVolver == e.getSource()) {
			JPlatos JP = new JPlatos();
			JP.setVisible(true);
			dispose();
		}
		if(btnAceptar_1 == e.getSource()) {
			ingre = Arrays.copyOf(ingre, ingre.length+1);
		    Ingredientes h=(Ingredientes)comboBox.getSelectedItem();
			Ingredientes ingreBox=new Ingredientes(h.getNombre(),cbxCantidad.getSelectedIndex());
			ingre[ingre.length-1]=ingreBox;
			JOptionPane.showMessageDialog(null,"El Ingediente ha sido agregado exitosamente");
		}
		if (btnAceptar == e.getSource()) {
			switch (accion) {
			case "ListaPlatos":
				break;
//mostrar lista platos
			case "ModificarPPlato":
				String plato1 = txtNombrePlato.getText();
				double precio1 = Double.parseDouble(txtPrecio.getText());
				try {
					administrador.ModificarPrecioPlato(plato1, precio1);
					break;
				} catch (ENoExiste | EListaVacia | EPrecioNeg e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					break;
				}

			case "EliminarPlato":
				String plato4 = txtNombrePlato.getText();
				try {
					administrador.borrarPlato(plato4);
					break;
				} catch (ENoExiste | EListaVacia e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					break;
				}

			case "AddPlato":
				String plato2 = txtNombrePlato.getText();
				double precio2 = Double.parseDouble(txtPrecio.getText());
//mostrar la lista de ingredientes para que seleccione y le asigne la cantidad
				try {
					administrador.addPlato(plato2, ingre, precio2);
					JOptionPane.showMessageDialog(null,"El plato se ha agregado exitosamente");
					JPlatos jp=new JPlatos();
					jp.setVisible(true);
					dispose();
					break;
				} catch (ENoExiste | EListaVacia e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					break;
				}

			case "ModificarIPlato":
				String plato3 = txtNombrePlato.getText();
				try {
					administrador.ModificarIngrePlato(plato3, null);
					JOptionPane.showMessageDialog(null, "La información fue guardada con éxito");
					break;
				} catch (EListaVacia | ENoExiste e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					break;
				}

			}

		}
	}
}

/*package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;
import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;
import Trabajo.Administrador.EPrecioNeg;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class JInfoPlatos extends JFrame implements ActionListener{
	
	private String accion;
	private JPanel contentPane;
	private JTextField txtNombrePlato;
	private JTextField txtPrecio;
	private JLabel lblTitulo;
	private JButton btnAceptar;
	private JButton btnVolver;
	private Administrador administrador;
	private JLabel IbReq1;
	private JLabel lbReq2;
	private JComboBox comboBox;

	public JInfoPlatos(String accion) {
		setTitle("VENTANA INFO PLATOS");
		Administrador administrador=new Administrador();
		this.accion=accion;
		iniciarComponentes();
		setLocationRelativeTo(null);
	}
	
	public void iniciarComponentes() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAceptar.setBounds(185, 213, 99, 40);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(21, 237, 89, 30);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		txtNombrePlato = new JTextField();
		txtNombrePlato.setToolTipText("");
		txtNombrePlato.setBounds(146, 109, 274, 40);
		contentPane.add(txtNombrePlato);
		txtNombrePlato.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setToolTipText("");
		txtPrecio.setVisible(false);
		txtPrecio.setBounds(146, 161, 274, 40);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitulo.setBounds(102, 22, 294, 41);
		contentPane.add(lblTitulo);
		
		IbReq1 = new JLabel("Nombre");
		IbReq1.setFont(new Font("Lucida Grande",Font.PLAIN,14));
		IbReq1.setBounds(68, 122, 56, 13);
		contentPane.add(IbReq1);
		
		lbReq2 = new JLabel("Precio");
		lbReq2.setFont(new Font("Lucida Grande",Font.PLAIN,14));
		lbReq2.setBounds(68, 174, 45, 13);
		contentPane.add(lbReq2);
		
		comboBox = new JComboBox();
		comboBox.setBounds(55, 75, 362, 27);
		contentPane.add(comboBox);
		
		switch(accion) {
		
		case "ListaPlatos": 
			lblTitulo.setText("Lista platos"); 
			btnAceptar.setVisible(false);
			lbReq2.setVisible(false);
			IbReq1.setVisible(false);
			txtNombrePlato.setVisible(false);
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
			lbReq2.setVisible(false);
			txtNombrePlato.setToolTipText("Ingrese el nombre del plato");
			break;
		
		case "AddPlato":
			lblTitulo.setText("Aï¿½adir Plato");
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
			dispose();
		}
		
		if(btnAceptar==e.getSource()) {
			
			switch(accion) {
			
			case "ListaPlatos": 
				break;
				//mostrar lista platos
			
			case "ModificarPPlato":
				String plato1=txtNombrePlato.getText(); 
				double precio1=Double.parseDouble(txtPrecio.getText());
				try {
					administrador.ModificarPrecioPlato(plato1, precio1);
					break;
				} catch (ENoExiste | EListaVacia | EPrecioNeg e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage()); 
					break;
				}
				
			
			case "EliminarPlato":
				String plato4=txtNombrePlato.getText();
				try {
					administrador.borrarPlato(plato4);
					break;
				} catch (ENoExiste | EListaVacia e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage()); 
					break;
				}
				
			
			case "AddPlato":
				String plato2=txtNombrePlato.getText(); 
				double precio2=Double.parseDouble(txtPrecio.getText());
				//mostrar la lista de ingredientes para que seleccione y le asigne la cantidad
				try {
					administrador.addPlato(plato2, administrador.getIngredientesTotal(), precio2);
					break;
				} catch (ENoExiste | EListaVacia e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					break;
				}
				
			
			case "ModificarIPlato":	
				String plato3=txtNombrePlato.getText();
				try {
					administrador.ModificarIngrePlato(plato3, null);
					JOptionPane.showMessageDialog(null, "La informaciÃ³n fue guardada con Ã©xito");
					break;
				} catch (EListaVacia | ENoExiste e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage()); 
					break;
				}
				
				
			}
			
			
		}
		
	}
}
*/