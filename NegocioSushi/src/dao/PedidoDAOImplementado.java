package dao;

import java.sql.*;
import negocio.Clientes;
import negocio.Pedido;
import oracleSql.Conexion;

public class PedidoDAOImplementado implements PedidoDAO{
    @Override
    public boolean crearPedido(Pedido nuevoPedido) {        
        boolean logrado = false;
        try {
            Connection conexion = Conexion.getConexion();
            //insertarPedido(forma de entrega,comentario,totalVenta,runCliente);
            String query = "{CALL insertarPedido(?,?,?,?,?)}";
            CallableStatement crear = conexion.prepareCall(query);
            crear.setString(1, nuevoPedido.getFormaEntrega());         
            crear.setString(2, nuevoPedido.getComentario());
            crear.setDouble(3, nuevoPedido.getTotalVenta());
            crear.setString(4, nuevoPedido.getClientes().getClienteRun()); 
            crear.setInt(5,nuevoPedido.getIdEstado());
            crear.execute();            
            crear.close();
            conexion.close();
            logrado = true;            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al crear pedido: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al crear pedido: "+exc.getMessage());
        }       
        return logrado;
    }

    @Override
    public Pedido buscarPedido(int idPedido) {
        Pedido pedido = null;
        try {
            Connection conexion = Conexion.getConexion();            
            String query = "SELECT * FROM pedido WHERE id_pedido = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, idPedido);             
            ResultSet resultado = buscar.executeQuery();
            if(resultado.next()){
                pedido = new Pedido();
                pedido.setId(resultado.getInt("id_pedido"));
                pedido.setFormaEntrega(resultado.getString("forma_entrega"));
                pedido.setComentario(resultado.getString("comentario"));
                pedido.setTotalVenta(resultado.getInt("total_venta"));
                pedido.setFechaHoraPedido(resultado.getString("fecha_hora"));                
                //pedido.setCliente(new Cliente()); //resultado.getString("run_cliente")
                pedido.setIdEstado(resultado.getInt("id_estado"));                
            }                
            buscar.close();
            conexion.close();            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al buscar pedido: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al buscar pedido: "+exc.getMessage());
        }
        return pedido;
    }

    @Override
    public boolean actualizarPedido(Pedido nuevoPedido) {
        boolean logrado = false;
        try {
            Connection conexion = Conexion.getConexion();            
            String query = "UPDATE pedido SET "
                    + "forma_entrega = ?,"
                    + "comentario = ?,"
                    + "total_venta = ?,"
                    + "id_estado = ?,"
                    + "run_cliente=?"
                    + "WHERE id_pedido = ?";
            PreparedStatement actualizar = conexion.prepareStatement(query);
            actualizar.setString(1, nuevoPedido.getFormaEntrega());         
            actualizar.setString(2, nuevoPedido.getComentario());
            actualizar.setDouble(3, nuevoPedido.getTotalVenta());
            actualizar.setInt(4, nuevoPedido.getIdEstado());            
            actualizar.setString(5, nuevoPedido.getClientes().getClienteRun()); 
            actualizar.setInt(6, nuevoPedido.getId());
            actualizar.execute();            
            if (actualizar.getUpdateCount()>-1)
                logrado = true;                            
            actualizar.close();
            conexion.close();            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al actualizar pedido: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al actualizar pedido: "+exc.getMessage());
        }       
        return logrado;
    }

    @Override
    public boolean eliminarPedido(int idPedido) {
        boolean logrado = false;
        try {
            Connection conexion = Conexion.getConexion();            
            String query = "DELETE FROM pedido WHERE id_pedido = ?";
            PreparedStatement eliminar = conexion.prepareStatement(query);
            eliminar.setInt(1, idPedido);         
            eliminar.execute();         
            if (eliminar.getUpdateCount()>-1)
                logrado = true;                            
            eliminar.close();
            conexion.close();
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al eliminar pedido: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al eliminar pedido: "+exc.getMessage());
        }       
        return logrado;
    }    
}