	package gui;
	
	
	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.border.EmptyBorder;
	
	import Trabajo.Administrador;
import Trabajo.Administrador.EListaVacia;
import Trabajo.Administrador.*;

import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JButton;
	import javax.swing.SwingConstants;
	import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.FlowLayout;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	
	public class JContabilidad extends JFrame implements ActionListener {

		private JPanel contentPane;
		JScrollPane scrollVentana;
		private Administrador administrador;
		private JLabel lblTitulo;
		private JButton btnVolver;
		private JButton btnReporte;
		private JButton btnVentas;

		public JContabilidad() {
			setTitle("VENTANA CONTABILIDAD");
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Administrador administrador=new Administrador();
			setSize(500, 450);
			setLocationRelativeTo(null);
			scrollVentana = new JScrollPane();
			inicializarComponentes();
			setResizable(false);
		}

		private void inicializarComponentes() {
			administrador =new Administrador();
			getContentPane().setLayout(new BorderLayout(0, 0));
			
			JPanel panelPrincipal = new JPanel();
			panelPrincipal.setLayout(null);
			
			lblTitulo = new JLabel("Contabilidad");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 40));
			lblTitulo.setBounds(77, 10, 226, 52);
			panelPrincipal.add(lblTitulo);
			
			btnVolver = new JButton("Volver");
			btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
			btnVolver.setFont(new Font("Dialog", Font.PLAIN, 20));
			btnVolver.setBounds(10, 255, 89, 35);
			panelPrincipal.add(btnVolver);
			
			btnReporte = new JButton("Reporte");
			btnReporte.setFont(new Font("Dialog", Font.PLAIN, 20));
			btnReporte.setBounds(255, 118, 134, 46);
			panelPrincipal.add(btnReporte);
			
			btnVentas = new JButton("Ventas");
			btnVentas.setFont(new Font("Dialog", Font.PLAIN, 20));
			btnVentas.setBounds(41, 114, 141, 52);
			panelPrincipal.add(btnVentas);
			scrollVentana.setViewportView(panelPrincipal);
			getContentPane().add(scrollVentana, BorderLayout.CENTER);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (btnVolver == e.getSource()) {
				JRestaurante JR = new JRestaurante();
				JR.setVisible(true);
				dispose();
			}
			if (btnReporte == e.getSource()) {
				try {
					JOptionPane.showMessageDialog(null, administrador.reportePedidos());
				} catch (HeadlessException | EListaVacia e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
			if (btnVentas == e.getSource()) {
				try {
					JOptionPane.showMessageDialog(null,"El total facturado es "+ administrador.ventasTotal());
				} catch (HeadlessException | EListaVacia e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		}

	}
