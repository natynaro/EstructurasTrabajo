package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;
import Trabajo.Administrador.*;

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
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JList;
import java.awt.SystemColor;

public class JInfoIngredientes extends JFrame implements ActionListener {
	private String accion;
	private JPanel JInfoIngredientes;
	private JTextField txtNombreIngrediente;
	private JButton btnVolver;
	private JButton btnAceptar;
	private JLabel lblTitulo;
	private JComboBox boxCantidadIngredientes;
	private Administrador administrador;

	public JInfoIngredientes(String accion) {
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("VENTANA INFO INGREDIENTES");
		this.accion = accion;
		iniciarComponentes();
		setLocationRelativeTo(null);
		administrador = new Administrador();
	}

	private void iniciarComponentes() {
		setBounds(100, 100, 450, 300);
		JInfoIngredientes = new JPanel();
		JInfoIngredientes.setBackground(UIManager.getColor("Button.background"));
		JInfoIngredientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JInfoIngredientes);
		JInfoIngredientes.setLayout(null);
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTitulo.setBounds(196, 22, 236, 41);
		JInfoIngredientes.add(lblTitulo);
		txtNombreIngrediente = new JTextField();
		txtNombreIngrediente.setVisible(false);
		txtNombreIngrediente.setBounds(201, 75, 220, 40);
		JInfoIngredientes.add(txtNombreIngrediente);
		txtNombreIngrediente.setColumns(10);
		boxCantidadIngredientes = new JComboBox();
		boxCantidadIngredientes.setVisible(false);
		boxCantidadIngredientes
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
		boxCantidadIngredientes.setMaximumRowCount(9);
		boxCantidadIngredientes.setBounds(211, 127, 197, 28);
		JInfoIngredientes.add(boxCantidadIngredientes);
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnVolver.setBackground(SystemColor.menu);
		btnVolver.setBounds(21, 223, 89, 30);
		btnVolver.addActionListener(this);
		JInfoIngredientes.add(btnVolver);
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnAceptar.setBackground(SystemColor.menu);
		btnAceptar.setBounds(261, 167, 82, 40);
		btnAceptar.addActionListener(this);
		JInfoIngredientes.add(btnAceptar);
		JList list = new JList();
		list.setBounds(192, 206, -169, -183);
		JInfoIngredientes.add(list);
		switch (accion) {
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
		if (btnVolver == e.getSource()) {
			JIngredientes JI = new JIngredientes();
			JI.setVisible(true);
			dispose();
		}
		if (btnAceptar == e.getSource()) {
			switch (accion) {
			case "AddIngrediente":
				String nIngrediente = txtNombreIngrediente.getText();
				int cIng = boxCantidadIngredientes.getSelectedIndex();
				try {
					if (administrador.IngredienteExiste(nIngrediente)) {
						JOptionPane.showMessageDialog(null, "El ingrediente ya existe, ingrese un ingrediente nuevo");
					} else {
						administrador.AddIngrediente(nIngrediente, cIng);
						JOptionPane.showMessageDialog(null, "El ingrediente se añadió con éxito");
					}
					break;
				} catch (EObjetoYaExiste e3) {
// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (IOException e3) {
// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (EListaVacia e3) {
// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				JIngredientes jg = new JIngredientes();
				jg.setVisible(true);
				dispose();
			case "EliminarIngrediente":
				String nIngrediente1 = txtNombreIngrediente.getText();
				try {
					if (administrador.IngredienteExiste(nIngrediente1) == true) {
						administrador.EliminarIngrediente(nIngrediente1);
						JOptionPane.showMessageDialog(null, "El ingrediente se elimin� con �xito");
						break;
					} else {
						JOptionPane.showMessageDialog(null, "El ingrediente no existe");
					}
				} catch (ENoExiste e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					break;
				} catch (EListaVacia e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
					break;
				} catch (IOException e1) {
// TODO Auto-generated catch block
					e1.printStackTrace();
					break;
				}

			case "ListaIngredientes":
//Mostrar lista ingredientes
				break;
			}
		}
	}
}
