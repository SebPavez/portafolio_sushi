package dao;

import java.util.ArrayList;
import negocio.Clientes;

public interface ClienteDao {
    
    public boolean almacenarCliente(Clientes nuevoCliente);
    public boolean eliminarCliente(String clienteRun);
    public boolean modificarCliente(Clientes clienteModificado);
    public ArrayList<Clientes> listarClientes();
}
