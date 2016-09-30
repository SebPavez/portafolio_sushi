package dao;

import java.util.ArrayList;
import negocio.DetallePedido;

public interface DetallePedidoDAO {
    public boolean crearDetalle(ArrayList<DetallePedido> detalle, int idPedido);
    public ArrayList<DetallePedido> listarDetalle(int idPedido);
    public boolean actualizarDetalle(ArrayList<DetallePedido> detalle, int idPedido);
    public boolean eliminarDetalle(int idPedido);
}
