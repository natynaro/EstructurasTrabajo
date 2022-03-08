	package gui;
	
	
	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.border.EmptyBorder;
	
	import Trabajo.Administrador;
import Trabajo.Administrador.EListaVacia;

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
		JButton btnVentas, btnReporte, btnVolver;
		JScrollPane scrollVentana;
		private Administrador administrador;

		public JContabilidad() {
			setTitle("VENTANA CONTABILIDAD");
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1000, 500);
			setLocationRelativeTo(null);
			scrollVentana = new JScrollPane();
			inicializarComponentes();
		}

		private void inicializarComponentes() {
			getContentPane().setLayout(new BorderLayout(0, 0));
			JPanel panelPrincipal = new JPanel();
			panelPrincipal.setLayout(new BorderLayout(0, 0));
			JPanel panelSupeior = new JPanel();
			panelPrincipal.add(panelSupeior, BorderLayout.NORTH);
			JLabel lblTitulo = new JLabel("Contabilidad");
			lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			panelSupeior.add(lblTitulo);
			JPanel panelInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelInferior.getLayout();
			flowLayout.setVgap(10);
			flowLayout.setHgap(20);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
			btnVolver = new JButton("Volver");
			btnVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
			btnVolver.addActionListener(this);
			panelInferior.add(btnVolver);
			JPanel panelCentral = new JPanel();
			panelPrincipal.add(panelCentral, BorderLayout.CENTER);
			btnVentas = new JButton("Ventas");
			btnVentas.setBounds(162, 69, 95, 35);
			btnVentas.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnVentas.addActionListener(this);
			panelCentral.setLayout(null);
			panelCentral.add(btnVentas);
			btnReporte = new JButton("Reporte");
			btnReporte.setBounds(418, 69, 103, 35);
			btnReporte.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnReporte.addActionListener(this);
			panelCentral.add(btnReporte);
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
					JOptionPane.showMessageDialog(null, administrador.reporteDiario());
				} catch (HeadlessException | EListaVacia e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
			if (btnVentas == e.getSource()) {
				try {
					JOptionPane.showMessageDialog(null, administrador.ventasDelDia());
				} catch (HeadlessException | EListaVacia e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		}

	}
