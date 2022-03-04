package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaIngredientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngredientes frame = new VentanaIngredientes();
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
	public VentanaIngredientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingredientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(62, 10, 316, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("A\u00F1adir Ingrediente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(39, 89, 141, 21);
		contentPane.add(btnNewButton);
		
		
		JButton btnListaIngrediente = new JButton("Lista de Ingredientes");
		btnListaIngrediente.setBackground(Color.RED);
		btnListaIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				/*final Administrador admin = new Administrador();
				final Ingredientes[] listaIng = admin.getIngredientesTotal();
				final String[] nombreIngs = new String[admin.getIngredientesTotal().length];
				for(int i = 0; i<nombreIngs.length; i++) {
					nombreIngs[i] = listaIng[i].getNombre();
				}*/
			}
			
		});
		btnListaIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListaIngrediente.setBounds(140, 147, 153, 21);
		contentPane.add(btnListaIngrediente);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolver.setBackground(Color.RED);
		btnVolver.setBounds(23, 232, 76, 21);
		contentPane.add(btnVolver);
		
		final VentanaEliminarIngrediente elimIng = new VentanaEliminarIngrediente();
		
		JButton btnEliminarIngrediente = new JButton("Eliminar Ingrediente");
		btnEliminarIngrediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elimIng.setVisible(true);
				dispose();
			}
		});
		btnEliminarIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminarIngrediente.setBackground(Color.RED);
		btnEliminarIngrediente.setBounds(251, 89, 153, 21);
		contentPane.add(btnEliminarIngrediente);
	}
}
