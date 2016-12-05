package dao;

import java.util.ArrayList;
import java.util.Date;
import negocio.Pedido;

public interface PedidoDAO {
    public int crearPedido(Pedido nuevoPedido);
    public ArrayList<Pedido> buscarPedido(Date fechaDesde,Date fechaHasta);
    public boolean actualizarPedido(Pedido nuevoPedido);
    public boolean eliminarPedido(int idPedido);
     public ArrayList<Pedido> listarTodo();
}
