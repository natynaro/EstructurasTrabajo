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
			setSize(450, 300);
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
			lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblTitulo.setBounds(98, 19, 226, 52);
			panelPrincipal.add(lblTitulo);
			
			btnVolver = new JButton("Volver");
			btnVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			btnVolver.setBounds(6, 221, 89, 30);
			btnVolver.addActionListener(this);
			panelPrincipal.add(btnVolver);
			
			btnReporte = new JButton("Reporte de Pedidos");
			btnReporte.setFont(new Font("Dialog", Font.PLAIN, 20));
			btnReporte.setBounds(82, 154, 242, 50);
			btnReporte.addActionListener(this);
			panelPrincipal.add(btnReporte);
			
			btnVentas = new JButton("Ventas Acumuladas");
			btnVentas.setFont(new Font("Dialog", Font.PLAIN, 20));
			btnVentas.setBounds(82, 92, 242, 50);
			btnVentas.addActionListener(this);
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
				administrador=new Administrador();
				try {
					JOptionPane.showMessageDialog(null, administrador.reportePedidos());
				} catch (HeadlessException | EListaVacia e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
			if (btnVentas == e.getSource()) {
				administrador=new Administrador();
				try {
					JOptionPane.showMessageDialog(null,"El total facturado es "+ administrador.ventasTotal());
				} catch (HeadlessException | EListaVacia e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		}

	}
