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

public class JIngredientes extends JFrame implements ActionListener{

	private JPanel principalIngredientes;
	private JButton btnEliminarIngrediente;
	private JButton btnAddIngrediente;
	private JButton btnListaIngredientes;
	private JButton btnVolver;
	private JLabel lblTitulo;
	private Administrador administrador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIngredientes frame = new JIngredientes();
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
	public JIngredientes() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		
		
		setTitle("VENTANA PRINCIPAL INGREDIENTES");
		setLocationRelativeTo(null);
		
	}

	private void iniciarComponentes() {
		
		setBounds(100, 100, 450, 300);
		principalIngredientes = new JPanel();
		principalIngredientes.setBackground(Color.LIGHT_GRAY);
		principalIngredientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(principalIngredientes);
		principalIngredientes.setLayout(null);
		
		lblTitulo = new JLabel("Ingredientes");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(62, 10, 316, 47);
		principalIngredientes.add(lblTitulo);
		
		btnAddIngrediente = new JButton("A\u00F1adir Ingrediente");
		
		btnAddIngrediente.setBackground(Color.RED);
		btnAddIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddIngrediente.setBounds(39, 89, 141, 21);
		btnAddIngrediente.addActionListener(this);
		principalIngredientes.add(btnAddIngrediente);
		
		btnListaIngredientes = new JButton("Lista de Ingredientes");
		
		btnListaIngredientes.setBackground(Color.RED);
		btnListaIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListaIngredientes.setBounds(140, 147, 153, 21);
		btnListaIngredientes.addActionListener(this);
		principalIngredientes.add(btnListaIngredientes);
		
		btnVolver = new JButton("Volver");
		
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolver.setBackground(Color.RED);
		btnVolver.setBounds(23, 232, 76, 21);
		btnVolver.addActionListener(this);
		principalIngredientes.add(btnVolver);
		
		btnEliminarIngrediente = new JButton("Eliminar Ingrediente");
		
		btnEliminarIngrediente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminarIngrediente.setBackground(Color.RED);
		btnEliminarIngrediente.setBounds(251, 89, 153, 21);
		btnEliminarIngrediente.addActionListener(this);
		principalIngredientes.add(btnEliminarIngrediente);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnVolver==e.getSource()) {
			//JRestaurante JR= new JRestaurante();
			//JR.setVisible(true);
		}
		if(btnAddIngrediente==e.getSource()) {
			JInfoIngredientes JII1= new JInfoIngredientes("AddIngrediente");
			JII1.setVisible(true);
		}
		if(btnEliminarIngrediente==e.getSource()) {
			JInfoIngredientes JII2= new JInfoIngredientes("EliminarIngrediente");
			JII2.setVisible(true);
		}
		if(btnListaIngredientes==e.getSource()) {
			JInfoIngredientes JII3= new JInfoIngredientes("ListaIngredientes");
			JII3.setVisible(true);
		}
}
}



		/*final Administrador admin = new Administrador();
				final Ingredientes[] listaIng = admin.getIngredientesTotal();
				final String[] nombreIngs = new String[admin.getIngredientesTotal().length];
				for(int i = 0; i<nombreIngs.length; i++) {
					nombreIngs[i] = listaIng[i].getNombre();
				}*/