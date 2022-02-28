package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JPlatos extends JFrame {

	private JPanel PanelPlatos;
	private JLabel lblNewLabel;
	private JButton btnAñadirPlato;
	private JButton btnEliminarPlato;
	private JButton btnModificarIPlato;
	private JButton btnModificarPPlato;
	private JButton btnListaPlatos;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPlatos frame = new JPlatos();
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
	public JPlatos() {
		
		setTitle("VENTANA PLATOS");setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		
	}
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelPlatos = new JPanel();
		PanelPlatos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelPlatos);
		PanelPlatos.setLayout(null);
		
		lblNewLabel = new JLabel("Platos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(174, 6, 78, 41);
		PanelPlatos.add(lblNewLabel);
		
		btnAñadirPlato = new JButton("Añadir plato");
		btnAñadirPlato.setBounds(35, 59, 165, 50);
		PanelPlatos.add(btnAñadirPlato);
		
		btnEliminarPlato = new JButton("Eliminar plato");
		btnEliminarPlato.setBounds(245, 59, 165, 50);
		PanelPlatos.add(btnEliminarPlato);
		
		btnModificarIPlato = new JButton("Modificar ingredientes");
		btnModificarIPlato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificarIPlato.setBounds(35, 121, 165, 50);
		PanelPlatos.add(btnModificarIPlato);
		
		btnModificarPPlato = new JButton("Modificar precio");
		btnModificarPPlato.setBounds(245, 121, 165, 50);
		PanelPlatos.add(btnModificarPPlato);
		
		btnListaPlatos = new JButton("Mostrar lista platos");
		btnListaPlatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListaPlatos.setBounds(142, 183, 150, 50);
		PanelPlatos.add(btnListaPlatos);
		
		btnVolver = new JButton("volver");
		btnVolver.setBounds(6, 237, 100, 30);
	//	btnVolver.addActionListener((ActionListener) this);
		PanelPlatos.add(btnVolver);
	}
	public void actionPerformed(ActionEvent e) {
		if(btnVolver==e.getSource()) {
			
		}
		if(btnListaPlatos==e.getSource()) {
			
		}
		if(btnModificarPPlato==e.getSource()) {
			
		}
		if(btnModificarIPlato==e.getSource()) {
	
		}
		if(btnEliminarPlato==e.getSource()) {
			
		}
		if(btnAñadirPlato==e.getSource()) {
	
		}
		
	}
}
