package ec.edu.ups.app.g1.examenalvarezcarlosservidor.on;

import java.util.List;

import ec.edu.ups.app.g1.examenalvarezcarlosservidor.modelo.Cliente;

public interface GestionClienteONRemoto {
	public boolean registrarCliente(Cliente cliente) throws Exception;
	public List<Cliente> buscarCliente(String dni);
}
