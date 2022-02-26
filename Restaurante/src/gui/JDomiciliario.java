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

public class JDomiciliario extends JFrame {

	private JPanel PanelDomiciliario;
	private JLabel lblTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDomiciliario frame = new JDomiciliario();
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
	public JDomiciliario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		PanelDomiciliario = new JPanel();
		PanelDomiciliario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelDomiciliario);
		PanelDomiciliario.setLayout(null);
		
		lblTitulo = new JLabel("Domiciliarios");
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblTitulo.setBounds(6, 22, 440, 29);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		PanelDomiciliario.add(lblTitulo);
		
		JButton btnAñadirDomiciliario = new JButton("Añadir domiciliario");
		btnAñadirDomiciliario.setBounds(26, 85, 187, 50);
		btnAñadirDomiciliario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PanelDomiciliario.add(btnAñadirDomiciliario);
		
		JButton btnEliminarDomiciliario = new JButton("Eliminar domiciliario");
		btnEliminarDomiciliario.setBounds(253, 85, 164, 50);
		PanelDomiciliario.add(btnEliminarDomiciliario);
		
		JButton btnListaDomiciliarios = new JButton("Mostrar lista domiciliario");
		btnListaDomiciliarios.setBounds(130, 157, 202, 50);
		PanelDomiciliario.add(btnListaDomiciliarios);
		
		JButton btnvolver = new JButton("volver");
		btnvolver.setBounds(5, 238, 112, 29);
		PanelDomiciliario.add(btnvolver);
	}

}
