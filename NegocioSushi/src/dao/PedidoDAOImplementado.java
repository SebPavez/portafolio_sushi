package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import negocio.Cliente;
import negocio.Pedido;
import oracleSql.Conexion;

public class PedidoDAOImplementado implements PedidoDAO{
    @Override
    public int crearPedido(Pedido nuevoPedido) {        
        int id = 0;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "{CALL insertarPedido(?,?,?,?,?,?)}";
            CallableStatement crear = conexion.prepareCall(query);
            crear.setString(1, nuevoPedido.getFormaEntrega());         
            crear.setString(2, nuevoPedido.getComentario());
            crear.setDouble(3, nuevoPedido.getTotalVenta());
            crear.setString(4, nuevoPedido.getCliente().getClienteRun()); 
            crear.setInt(5,nuevoPedido.getIdEstado());
            crear.registerOutParameter(6, Types.INTEGER);            
            crear.execute();            
            id = crear.getInt(6);
            crear.close();
            conexion.close();
                      
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al crear pedido: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al crear pedido: "+exc.getMessage());
        }       
        return id;
    }

    @Override
    public ArrayList<Pedido> buscarPedido(java.util.Date fechaDesde, java.util.Date fechaHasta) {
        ArrayList<Pedido> lista = new ArrayList<>();
        try {  
             
            Connection conexion = Conexion.getConexion();            
            
            String query = "select * from pedido where fecha_hora between ? and ? order by Id_pedido asc";
            
            PreparedStatement sel= conexion.prepareStatement(query);
            
            sel.setDate(1, new java.sql.Date(fechaDesde.getTime()));    
            sel.setDate(2, new java.sql.Date(fechaHasta.getTime()));    
            
            ResultSet r = sel.executeQuery();
            while(r.next()){
                Pedido pedido = new Pedido();
                pedido.setId(r.getInt("Id_pedido"));
                pedido.setFormaEntrega(r.getString("Forma_entrega"));
                pedido.setComentario(r.getString("comentario"));
                pedido.setTotalVenta(r.getInt("total_venta"));
                pedido.setFechaHoraPedido(r.getTimestamp("fecha_hora"));                
                pedido.setRun_cliente(r.getString("run_cliente"));
                pedido.setIdEstado(r.getInt("id_estado"));
                lista.add(pedido);
            }                 
            sel.close();
            conexion.close();            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al buscar pedido: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al buscar pedido: "+exc.getMessage());
        }
        return lista;
    }
//    public Pedido buscarPedido(int idPedido) {
//        Pedido pedido = null;
//        String idCliente = new String();
//        try {
//            Connection conexion = Conexion.getConexion();            
//            String query = "SELECT * FROM pedido WHERE id_pedido = ?";
//            PreparedStatement buscar = conexion.prepareStatement(query);
//            buscar.setInt(1, idPedido);             
//            ResultSet resultado = buscar.executeQuery();
//            if(resultado.next()){
//                pedido = new Pedido();
//                pedido.setId(resultado.getInt("id_pedido"));
//                pedido.setFormaEntrega(resultado.getString("forma_entrega"));
//                pedido.setComentario(resultado.getString("comentario"));
//                pedido.setTotalVenta(resultado.getInt("total_venta"));
//                pedido.setFechaHoraPedido(resultado.getString("fecha_hora"));                
//                idCliente = resultado.getString("run_cliente");
//                pedido.setIdEstado(resultado.getInt("id_estado"));                
//            }                
//            buscar.close();
//            conexion.close();     
//            pedido.setCliente(new ClienteDaoImplementado().buscarCliente(idCliente));
//        } catch (SQLException sqlExc){
//            System.out.println("Error SQL al buscar pedido: "+sqlExc.getMessage());
//        } catch (Exception exc){
//            System.out.println("Error al buscar pedido: "+exc.getMessage());
//        }
//        return pedido;
//    }

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
            actualizar.setString(5, nuevoPedido.getCliente().getClienteRun()); 
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

    @Override
    public ArrayList<Pedido> listarTodo() {
       ArrayList<Pedido> lista = new ArrayList<>();
        try{
       
            Connection conexion = Conexion.getConexion();
            
            String query="select * from pedido order by Id_pedido asc";
            
            PreparedStatement sel=conexion.prepareStatement(query);
            
            ResultSet rs = sel.executeQuery();
            
            while(rs.next()){
                
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("Id_pedido"));
                pedido.setFormaEntrega(rs.getString("Forma_entrega"));
                pedido.setComentario(rs.getString("comentario"));
                pedido.setTotalVenta(rs.getInt("total_venta"));
                pedido.setFechaHoraPedido(rs.getTimestamp("fecha_hora"));                
                pedido.setRun_cliente(rs.getString("run_cliente"));
                pedido.setIdEstado(rs.getInt("id_estado"));
                lista.add(pedido);
            }
            sel.close();
            conexion.close();
        }catch (SQLException sqlExc){
            System.out.println("Error SQL al listar todo pedido: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al listar todo pedido: "+exc.getMessage());
        }
        
        return lista;
    }
    
    }
