package dao;

import java.util.ArrayList;
import negocio.Cliente;

public interface ClienteDao {
    
    public boolean almacenarCliente(Cliente nuevoCliente);
    public boolean eliminarCliente(String clienteRun);
    public boolean modificarCliente(Cliente clienteModificado);
    public ArrayList<Cliente> listarClientes();
    public Cliente buscarCliente(String runCliente);
}
