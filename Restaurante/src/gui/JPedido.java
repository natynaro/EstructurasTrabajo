package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Trabajo.*;
import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.ENoExiste;
import Trabajo.Administrador.ENoIngre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class JPedido extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTel;
	private JTextField txtDirec;
	private JLabel lblNuevoPedido;
	private JLabel lblTituloUsuario;
	private JLabel lblNomb;
	private JLabel lblTel;
	private JLabel lblDireccion;
	private JLabel lblPlatos;
	private JComboBox cbxPlatos;
	private JLabel lblCantidad;
	private JComboBox cbxCantidad;
	private JButton btnVolver;
	private JButton btnAddOtroPlato;
	private JButton btnConfirmarPedido;
	private Administrador admin;
	private String[] platosTotal = new String[0];

	public JPedido() {
		setTitle("VENTANA NUEVO PEDIDO");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void iniciarComponentes() {
		admin = new Administrador();

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNuevoPedido = new JLabel("Nuevo Pedido");
		lblNuevoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoPedido.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNuevoPedido.setBounds(10, 16, 440, 29);
		contentPane.add(lblNuevoPedido);

		lblTituloUsuario = new JLabel("Datos Usuario");
		lblTituloUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTituloUsuario.setBounds(20, 44, 160, 29);
		contentPane.add(lblTituloUsuario);

		lblNomb = new JLabel("Nombre");
		lblNomb.setBounds(52, 76, 61, 16);
		contentPane.add(lblNomb);

		lblTel = new JLabel("Telefono");
		lblTel.setBounds(52, 104, 61, 16);
		contentPane.add(lblTel);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(52, 132, 61, 16);
		contentPane.add(lblDireccion);

		txtNombre = new JTextField();
		txtNombre.setBounds(136, 72, 250, 24);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtTel = new JTextField();
		txtTel.setBounds(136, 100, 250, 24);
		contentPane.add(txtTel);
		txtTel.setColumns(10);

		txtDirec = new JTextField();
		txtDirec.setBounds(136, 132, 250, 24);
		contentPane.add(txtDirec);
		txtDirec.setColumns(10);

		lblPlatos = new JLabel("Platos");
		lblPlatos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPlatos.setBounds(16, 168, 66, 29);
		contentPane.add(lblPlatos);

		cbxPlatos = new JComboBox();
		cbxPlatos.setModel(new DefaultComboBoxModel(admin.getPlatosTotal()));
		cbxPlatos.setBounds(26, 195, 222, 29);
		contentPane.add(cbxPlatos);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCantidad.setBounds(283, 168, 167, 29);
		contentPane.add(lblCantidad);

		cbxCantidad = new JComboBox();
		cbxCantidad.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		cbxCantidad.setMaximumRowCount(5);
		cbxCantidad.setBounds(283, 195, 80, 29);
		contentPane.add(cbxCantidad);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(6, 236, 89, 30);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);

		btnAddOtroPlato = new JButton("A?adir otro Plato");
		btnAddOtroPlato.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnAddOtroPlato.setBackground(Color.WHITE);
		btnAddOtroPlato.setBounds(107, 236, 150, 30);
		btnAddOtroPlato.addActionListener(this);
		contentPane.add(btnAddOtroPlato);

		btnConfirmarPedido = new JButton("Confirmar Pedido");
		btnConfirmarPedido.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnConfirmarPedido.setBackground(Color.WHITE);
		btnConfirmarPedido.setBounds(279, 236, 150, 30);
		btnConfirmarPedido.addActionListener(this);
		contentPane.add(btnConfirmarPedido);
	}

	// String[] nombresPlatos, String nombreUsu, String direccionUsu, String
	// telefonoUsu
	public void actionPerformed(ActionEvent e) {
		if (btnVolver == e.getSource()) {
			JRestaurante JR = new JRestaurante();
			JR.setVisible(true);
			dispose();
		}
		if (btnAddOtroPlato == e.getSource()) {
			int numPlato = cbxCantidad.getSelectedIndex()+1;
			Platos nombPlato = (Platos) cbxPlatos.getSelectedItem();
			for (int i = numPlato; i > 0; i--) {
				platosTotal = Arrays.copyOf(platosTotal, platosTotal.length + 1);
				platosTotal[platosTotal.length - 1] = nombPlato.getNombre();
			}
			JOptionPane.showMessageDialog(null, "A????adido");
		}
		if (btnConfirmarPedido == e.getSource()) {
			String nombU = txtNombre.getText();
			String telU = txtTel.getText();
			String dirU = txtDirec.getText();
			try {
				admin.NuevoPedido(platosTotal, nombU, dirU, telU);
				JOptionPane.showMessageDialog(null, "Pedido exitoso");
				
			} catch (ENoExiste | EListaVacia | ENoIngre e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}

	}
}