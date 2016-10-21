package dao;

import negocio.Pedido;

public interface PedidoDAO {
    public int crearPedido(Pedido nuevoPedido);
    public Pedido buscarPedido(int idPedido);
    public boolean actualizarPedido(Pedido nuevoPedido);
    public boolean eliminarPedido(int idPedido);
}
