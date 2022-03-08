package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabajo.Administrador;
import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JInfoDomiciliario extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblTitulo;
	private JButton btnAceptar;
	private JButton btnvolver;
	private Administrador administrador;
	private String accion;

	public JInfoDomiciliario(String accion) {
		setTitle("VENTANA INFO DOMICILIARIOS");
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.administrador = new Administrador();
		this.accion = accion;
		iniciarComponentes();
		setLocationRelativeTo(null);
	}

	public void iniciarComponentes() {
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnvolver = new JButton("volver");
		btnvolver.setBounds(17, 232, 100, 30);
		btnvolver.addActionListener(this);
		contentPane.add(btnvolver);

		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitulo.setBounds(204, 50, 246, 41);
		contentPane.add(lblTitulo);

		txtNombre = new JTextField();
		txtNombre.setVisible(false);
		txtNombre.setToolTipText("Ingrese el nombre del domiciliario");
		txtNombre.setBounds(224, 81, 210, 50);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAceptar.setBounds(262, 199, 115, 40);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Disponible", "No Disponible" }));
		comboBox.setBounds(263, 156, 96, 21);
		comboBox.setVisible(false);
		contentPane.add(comboBox);
		
		JComboBox boxDom = new JComboBox();
		boxDom.setToolTipText("ListaDomiciliarios");
		boxDom.setModel(new DefaultComboBoxModel(administrador.getDomiciliarios()));
		boxDom.setBounds(6, 34, 202, 21);
		contentPane.add(boxDom);

		switch (accion) {
		case "ListaDomiciliarios":
			lblTitulo.setText("Lista de domiciliarios");
			
			btnAceptar.setVisible(false);
			break;
		case "EliminarDomiciliario":
			lblTitulo.setText("Eliminar domiciliarios");
			txtNombre.setVisible(true);
			break;
		case "AddDomiciliario":
			lblTitulo.setText("A�adir domiciliarios");
			txtNombre.setVisible(true);
			break;
		case "Completado":
			lblTitulo.setText("Disponibilidad");
			comboBox.setVisible(true);
			txtNombre.setVisible(true);
			dispose();
			break;
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (btnvolver == e.getSource()) {
			JDomiciliario JD = new JDomiciliario();
			JD.setVisible(true);
			dispose();
		}

		if (btnAceptar == e.getSource()) {
			switch (accion) {
			case "ListaDomiciliarios":
				// mostrar la lista
				dispose();
				break;

			case "EliminarDomiciliario":
				String nom = txtNombre.getText();
				try {
					if (administrador.buscarDomiciliario(nom) >= 0) {
						administrador.quitarDomiciliario(nom);
						JOptionPane.showMessageDialog(null, "El domiciliario se elimin� con �xito");
						JDomiciliario jd = new JDomiciliario();
						jd.setVisible(true);
						dispose();
						break;
					} else {
						JOptionPane.showMessageDialog(null, "El domiciliario que intenta eliminar no existe");
						JDomiciliario jd = new JDomiciliario();
						jd.setVisible(true);
						dispose();
						break;
					}
				} catch (EListaVacia | ENoExiste e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					break;
				}
				

			case "AddDomiciliario":
				String nom2 = txtNombre.getText();
				try {
					if (administrador.buscarDomiciliario(nom2) >= 0) {
						JOptionPane.showMessageDialog(null, "El domiciliario que intenta añadir ya existe");
						JDomiciliario jg = new JDomiciliario();
						jg.setVisible(true);
						dispose();
						break;
					} else {
						administrador.addDomiciliario(nom2);
						JOptionPane.showMessageDialog(null, "El domiciliario se añadió con éxito");
						JDomiciliario jg = new JDomiciliario();
						jg.setVisible(true);
						dispose();
						break;
					}
					
				} catch (ENoExiste | EListaVacia e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
					break;
				}
				
			case "Completado":
				String nom3 = txtNombre.getText();
				try {
					if (administrador.buscarDomiciliario(nom3) >= 0) {
						administrador.setDisponible(nom3, true);
						JOptionPane.showMessageDialog(null, "Disponibilidad cambiada con éxito");
						JDomiciliario ji = new JDomiciliario();
						ji.setVisible(true);
						dispose();
						break;
					} else {
						JOptionPane.showMessageDialog(null, "El domiciliario que intenta usar no existe");
						JDomiciliario ji = new JDomiciliario();
						ji.setVisible(true);
						dispose();
						break;
					}
				} catch (ENoExiste | EListaVacia e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					break;
				}
			}

		}
	}
}
