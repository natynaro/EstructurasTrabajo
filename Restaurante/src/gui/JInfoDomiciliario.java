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
	private JList list;
	private Administrador administrador;
	private String accion;

	public JInfoDomiciliario(String accion) {
		setTitle("VENTANA INFO DOMICILIARIOS");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		administrador=new Administrador();
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

		list = new JList();
		list.setVisible(true);
		list.setBounds(17, 28, 167, 192);
		list.setListData(administrador.getDomiciliarios());
		contentPane.add(list);

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

		switch (accion) {
		case "ListaDomiciliarios":
			lblTitulo.setText("Lista de domiciliarios");
			list.setVisible(true);
			btnAceptar.setVisible(false);
			break;
		case "EliminarDomiciliario":
			lblTitulo.setText("Eliminar domiciliarios");
			txtNombre.setVisible(true);
			break;
		case "AddDomiciliario":
			lblTitulo.setText("Añadir domiciliarios");
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
					//administrador=new Administrador();
					if(administrador.buscarDomiciliario(nom)>=0) {
						administrador.quitarDomiciliario(nom);
						JOptionPane.showMessageDialog(null,"El domiciliario se eliminó con éxito");
					
					break;
					}
				} catch (EListaVacia | ENoExiste e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					break;
				}
				JDomiciliario jd=new JDomiciliario();
				jd.setVisible(true);
				dispose();

			case "AddDomiciliario":
				String nom2 = txtNombre.getText();
				administrador=new Administrador();
				administrador.addDomiciliario(nom2);
				dispose();
				break;

			case "Completado":
				String nom3 = txtNombre.getText();
				try {
					administrador.setDisponible(nom3, true);
					break;
				} catch (ENoExiste | EListaVacia e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				dispose();

			}

		}
	}
}
