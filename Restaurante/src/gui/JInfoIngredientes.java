package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;
import Trabajo.Administrador.EIngredienteNoExiste;
import Trabajo.Administrador.EListaIngredientesVacia;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JInfoIngredientes extends JFrame implements ActionListener {
	
	private String accion;
	private JPanel JInfoIngredientes;
	private JTextField txtNombreIngrediente;
	private JButton btnVolver;
	private JButton btnAceptar;
	private JLabel lblTitulo;
	private JComboBox boxCantidadIngredientes;
	private Administrador administrador;


	/**
	 * Create the frame.
	 */

	public JInfoIngredientes(String accion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.accion = accion;
		iniciarComponentes(); 
		
		
		setTitle("VENTANA INFO INGREDIENTES");
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {
		
		setBounds(100, 100, 450, 300);
		JInfoIngredientes = new JPanel();
		JInfoIngredientes.setBackground(Color.LIGHT_GRAY);
		JInfoIngredientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JInfoIngredientes);
		JInfoIngredientes.setLayout(null);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(103, 22, 236, 41);
		JInfoIngredientes.add(lblTitulo);
		
		txtNombreIngrediente = new JTextField();
		txtNombreIngrediente.setVisible(false);
		txtNombreIngrediente.setBounds(117, 73, 220, 40);
		JInfoIngredientes.add(txtNombreIngrediente);
		txtNombreIngrediente.setColumns(10);
		
		boxCantidadIngredientes = new JComboBox();
		boxCantidadIngredientes.setVisible(false);
		boxCantidadIngredientes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		boxCantidadIngredientes.setMaximumRowCount(9);
		boxCantidadIngredientes.setBounds(117, 132, 53, 28);
		JInfoIngredientes.add(boxCantidadIngredientes);
		
		btnVolver = new JButton("Volver");		
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVolver.setBackground(Color.RED);
		btnVolver.setBounds(21, 223, 89, 30);
		btnVolver.addActionListener(this);
		JInfoIngredientes.add(btnVolver);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBackground(Color.RED);
		btnAceptar.setBounds(176, 170, 82, 40);
		btnAceptar.addActionListener(this);
		JInfoIngredientes.add(btnAceptar);
		
		switch(accion) {
		
		case "AddIngrediente":
			lblTitulo.setText("A�adir Ingrediente");
			boxCantidadIngredientes.setVisible(true);
			boxCantidadIngredientes.setToolTipText("Cantidad");
			txtNombreIngrediente.setVisible(true);
			txtNombreIngrediente.setToolTipText("Ingrese el nombre del ingrediente");
			break;
			
		case "EliminarIngrediente":
			lblTitulo.setText("Eliminar Ingrediente");
			txtNombreIngrediente.setVisible(true);
			txtNombreIngrediente.setToolTipText("Ingrese el nombre del ingrediente que desea eliminar");
			break;
			
		case "ListaIngredientes":
			lblTitulo.setText("Lista ingredientes");
			btnAceptar.setVisible(false);
			break;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnVolver == e.getSource()) {
			JIngredientes JI = new JIngredientes();
			JI.setVisible(true);
		}
		
		if(btnAceptar == e.getSource()) {
			
			switch(accion) {
			
			case "AddIngrediente":
				String nIngrediente = txtNombreIngrediente.getText();
				int cIng = boxCantidadIngredientes.getSelectedIndex();
				administrador.AddIngrediente(nIngrediente, cIng);
				JOptionPane.showMessageDialog(null, "El ingrediente se ha a�adido con exito");
				break;
				
			case "EliminarIngrediente":
				String nIngrediente1 = txtNombreIngrediente.getText();
				try{
					administrador.EliminarIngrediente(nIngrediente1);
				}catch(EIngredienteNoExiste e1){
					System.out.println(e1.getMessage());;
				}catch(EListaIngredientesVacia e2) {
					System.out.println(e2.getMessage()); 
				}
				JOptionPane.showMessageDialog(null, "El ingrediente se ha eliminado exitosamente");
				break;
			
			case  "ListaIngredientes":
				//Mostrar lista ingredientes
				break;
			}
		
		}
		
	}
}
