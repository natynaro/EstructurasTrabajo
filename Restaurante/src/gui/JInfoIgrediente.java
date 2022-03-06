package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;

public class JInfoIgrediente extends JFrame implements ActionListener{

	private JPanel contentPane;
	private String accion;
	private JTextField txtNombreIngrediente;
	private JButton btnVolver;
	private JButton btnAceptar;
	private JLabel lblTitulo;
	private JComboBox boxCantidadIngredientes;
	private Administrador administrador;



	/**
	 * Create the frame.
	 */
	public JInfoIgrediente(String accion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("VENTANA PRINCIPAL INGREDIENTES");
		setLocationRelativeTo(null);
		iniciarComponentes();
		this.accion=accion;
		
	}
	public void iniciarComponentes() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(196, 22, 236, 41);
		contentPane.add(lblTitulo);
		
		txtNombreIngrediente = new JTextField();
		txtNombreIngrediente.setVisible(false);
		txtNombreIngrediente.setBounds(196, 74, 220, 40);
		contentPane.add(txtNombreIngrediente);
		txtNombreIngrediente.setColumns(10);
		
		boxCantidadIngredientes = new JComboBox();
		boxCantidadIngredientes.setVisible(false);
		boxCantidadIngredientes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		boxCantidadIngredientes.setMaximumRowCount(9);
		boxCantidadIngredientes.setBounds(196, 153, 53, 28);
		contentPane.add(boxCantidadIngredientes);
		
		btnVolver = new JButton("Volver");		
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVolver.setBackground(Color.RED);
		btnVolver.setBounds(21, 237, 89, 30);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBackground(Color.RED);
		btnAceptar.setBounds(275, 189, 82, 40);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
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
			JIngrediente JI = new JIngrediente();
			JI.setVisible(true);
		}
		
		if(btnAceptar == e.getSource()) {
			
			switch(accion) {
			
			case "AddIngrediente":
				String nIngrediente = txtNombreIngrediente.getText();
				int cIng = (int) boxCantidadIngredientes.getModel().getSelectedItem();
				administrador.AddIngrediente(nIngrediente, cIng);
				JOptionPane.showMessageDialog(null, "El ingrediente se ha a�adido con exito");
				break;
				
			case "EliminarIngrediente":
				String nIngrediente1 = txtNombreIngrediente.getText();
				/*try{
					administrador.EliminarIngrediente(nIngrediente1);
				}catch(EIngredienteNoExiste e1){
					System.out.println(e1.getMessage());;
				}catch(EListaIngredientesVacia e2) {
					System.out.println(e2.getMessage()); 
				}*/
				JOptionPane.showMessageDialog(null, "El ingrediente se ha eliminado exitosamente");
				break;
			
			case  "ListaIngredientes":
				//Mostrar lista ingredientes
				break;
			}
		
		}
		
	}
		
		
	}


