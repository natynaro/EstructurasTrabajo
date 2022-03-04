package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEliminarIngrediente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVolver;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminarIngrediente frame = new VentanaEliminarIngrediente();
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
	public VentanaEliminarIngrediente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el nombre del ingrediente que ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(67, 10, 316, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(168, 165, 97, 21);
		contentPane.add(btnNewButton);
		
		final VentanaIngredientes menuPrincipal = new VentanaIngredientes();
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVolver.setBackground(Color.RED);
		btnVolver.setBounds(23, 232, 76, 21);
		contentPane.add(btnVolver);
		
		JLabel lblDeseaEliminar = new JLabel("desea eliminar");
		lblDeseaEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeseaEliminar.setBounds(152, 38, 316, 47);
		contentPane.add(lblDeseaEliminar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(114, 107, 215, 28);
		contentPane.add(textField);
	}
}
