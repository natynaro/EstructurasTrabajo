package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInfoDomiciliario frame = new JInfoDomiciliario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JInfoDomiciliario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(17, 28, 186, 192);
		contentPane.add(list);
		
		JButton btnvolver = new JButton("volver");
		btnvolver.setBounds(17, 232, 100, 30);
		contentPane.add(btnvolver);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitulo.setBounds(227, 50, 200, 41);
		contentPane.add(lblTitulo);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Ingrese el nombre del domiciliario");
		txtNombre.setText("nombre:");
		txtNombre.setBounds(237, 103, 177, 50);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAceptar.setBounds(288, 185, 82, 40);
		contentPane.add(btnAceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
