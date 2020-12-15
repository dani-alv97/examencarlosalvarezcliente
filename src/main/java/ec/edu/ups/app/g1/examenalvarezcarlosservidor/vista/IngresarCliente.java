package ec.edu.ups.app.g1.examenalvarezcarlosservidor.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class IngresarCliente extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresarCliente frame = new IngresarCliente();
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
	public IngresarCliente() {
		setBounds(100, 100, 450, 300);

	}

}
