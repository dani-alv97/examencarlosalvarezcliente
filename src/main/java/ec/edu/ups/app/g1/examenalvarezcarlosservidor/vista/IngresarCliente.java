package ec.edu.ups.app.g1.examenalvarezcarlosservidor.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ec.edu.ups.app.g1.examenalvarezcarlosservidor.modelo.Cliente;
import ec.edu.ups.app.g1.examenalvarezcarlosservidor.on.GestionClienteONRemoto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class IngresarCliente extends JFrame{
	private JTextField txtTipoDocumento;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFecha;
	private GestionClienteONRemoto on;

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
		
		setTitle("Interfaz Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 248);
		getContentPane().add(tabbedPane);
		
		JInternalFrame internalFrame = new JInternalFrame("Crear Cliente");
		tabbedPane.addTab("New tab", null, internalFrame, null);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo Documento:");
		lblNewLabel.setBounds(10, 11, 100, 14);
		internalFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setBounds(10, 36, 100, 14);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 61, 100, 14);
		internalFrame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Apellido:");
		lblNewLabel_2_1.setBounds(10, 86, 100, 14);
		internalFrame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Fecha Nacimiento:");
		lblNewLabel_2_1_1.setBounds(10, 111, 100, 14);
		internalFrame.getContentPane().add(lblNewLabel_2_1_1);
		
		txtTipoDocumento = new JTextField();
		txtTipoDocumento.setBounds(120, 8, 86, 20);
		internalFrame.getContentPane().add(txtTipoDocumento);
		txtTipoDocumento.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(120, 33, 86, 20);
		internalFrame.getContentPane().add(txtDni);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(120, 58, 86, 20);
		internalFrame.getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(120, 83, 86, 20);
		internalFrame.getContentPane().add(txtApellido);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(120, 108, 86, 20);
		internalFrame.getContentPane().add(txtFecha);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				c.setTipoDocumento(txtTipoDocumento.getText());
				c.setDni(txtDni.getText());
				c.setNombre(txtNombre.getText());
				c.setApellido(txtApellido.getText());
				SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					c.setFechaNacimiento(smf.parse(txtFecha.getText()));
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					on.registrarCliente(c);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(120, 139, 89, 23);
		internalFrame.getContentPane().add(btnGuardar);
		internalFrame.setVisible(true);

		try {
			this.referenciarONCliente();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}
	
	public void referenciarONCliente() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "examen");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "cuenca");  
            final Context context = new InitialContext(jndiProperties);  
            final String lookupName = "ejb:/examenalvarezcarlosservidor/GestionClienteON!ec.edu.ups.app.g1.examenalvarezcarlosservidor.on.GestionClienteONRemoto";  
            this.on = (GestionClienteONRemoto) context.lookup(lookupName);  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
}
