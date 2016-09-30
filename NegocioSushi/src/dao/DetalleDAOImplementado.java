package dao;

import java.sql.*;
import java.util.ArrayList;
import negocio.DetallePedido;
import oracleSql.Conexion;

public class DetalleDAOImplementado implements DetallePedidoDAO {

    //Se necesita verificar si en verdad se ha logrado obtener un buen resultado en 
    //CADA ejecución, podría ser a través del int[] entregado por executeBatch()
    @Override
    public boolean crearDetalle(ArrayList<DetallePedido> detalle, int idPedido) {
        boolean logrado = false;
        try{
            Connection conexion = Conexion.getConexion();            
            String query = "INSERT INTO detalle_pedido VALUES (?, ?, ?)";
                PreparedStatement crear = conexion.prepareStatement(query);
            for (DetallePedido detallePedido : detalle) {                
                crear.setInt(1, idPedido);
                //crear.setInt(2, detallePedido.getProducto().getId());         
                crear.setInt(3, detallePedido.getCantidad());
                crear.addBatch();
            }          
            crear.executeBatch();                        
            logrado = true;                            
            crear.close();
            conexion.close();  
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al agregar detalle: "+sqlExc.getMessage());    
        } catch (Exception exc){
            System.out.println("Error al agregar detalle: "+exc.getMessage());
        }
        return logrado;
    }

    @Override
    public ArrayList<DetallePedido> listarDetalle(int idPedido) {
        ArrayList<DetallePedido> listadoDetalle = null;
        try{
            Connection conexion = Conexion.getConexion();            
            String query = "SELECT * FROM detalle_pedido WHERE id_pedido = ?";
                PreparedStatement listar = conexion.prepareStatement(query);
                ResultSet rs = listar.executeQuery();
                while(rs.next()){
                    DetallePedido detalle = new DetallePedido();
                    //detalle.setProducto(producto);
                    detalle.setCantidad(rs.getInt("cantidad"));
                    detalle.setTotalDetalle(detalle.getCantidad()*detalle.getProducto().getValor());
                }
                listar.close();
                conexion.close();  
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al agregar detalle: "+sqlExc.getMessage());    
        } catch (Exception exc){
            System.out.println("Error al agregar detalle: "+exc.getMessage());
        }
        return listadoDetalle;
    }

    @Override
    public boolean actualizarDetalle(ArrayList<DetallePedido> detalle, int idPedido) {
        if(this.eliminarDetalle(idPedido))
            return this.crearDetalle(detalle, idPedido);
        else
            return false;
    }

    @Override
    public boolean eliminarDetalle(int idPedido) {
        boolean logrado = false;
        try{
            Connection conexion = Conexion.getConexion();            
            String query = "DELETE FROM detalle_pedido WHERE id_pedido = ?";
            PreparedStatement eliminar = conexion.prepareStatement(query);            
            eliminar.execute();
            if(eliminar.getUpdateCount()>-1)
                logrado = true;                            
            eliminar.close();
            conexion.close();  
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al agregar detalle: "+sqlExc.getMessage());    
        } catch (Exception exc){
            System.out.println("Error al agregar detalle: "+exc.getMessage());
        }
        return logrado;
    }
    
}
