package dao;

import java.util.ArrayList;
import negocio.EstadoPedido;

public interface EstadoDAO {
    public boolean crearEstado(EstadoPedido nuevoEstado);
    public ArrayList<EstadoPedido> listarEstados();
    public boolean modificarEstado(EstadoPedido nuevoEstado);
    public boolean eliminarEstado(int idEstado);
}
