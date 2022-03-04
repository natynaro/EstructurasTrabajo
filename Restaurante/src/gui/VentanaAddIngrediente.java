package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAddIngrediente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblCantidadDelIngrediente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAddIngrediente frame = new VentanaAddIngrediente();
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
	public VentanaAddIngrediente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirIngrediente = new JLabel("A\u00F1adir Ingrediente");
		lblAadirIngrediente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAadirIngrediente.setBounds(65, 10, 316, 47);
		contentPane.add(lblAadirIngrediente);
		
		textField = new JTextField();
		textField.setBounds(189, 67, 215, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre del ingrediente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(14, 70, 165, 17);
		contentPane.add(lblNewLabel);
		
		lblCantidadDelIngrediente = new JLabel("Cantidad del ingrediente:");
		lblCantidadDelIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadDelIngrediente.setBounds(14, 123, 165, 17);
		contentPane.add(lblCantidadDelIngrediente);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setMaximumRowCount(9);
		comboBox.setBounds(189, 119, 53, 28);
		contentPane.add(comboBox);
		
		final VentanaIngredientes volverPrincip = new VentanaIngredientes();
		
		JButton btnVolver = new JButton("Volver");		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverPrincip.setVisible(true);
				dispose();
			}		
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVolver.setBackground(Color.RED);
		btnVolver.setBounds(14, 232, 76, 21);
		contentPane.add(btnVolver);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAadir.setBackground(Color.RED);
		btnAadir.setBounds(169, 179, 97, 21);
		contentPane.add(btnAadir);
	}
}
