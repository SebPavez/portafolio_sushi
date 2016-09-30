package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.EstadoPedido;
import oracleSql.Conexion;

public class EstadoDAOImplementado implements EstadoDAO{

    @Override
    public boolean crearEstado(EstadoPedido nuevoEstado) {
        boolean logrado = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO estado_pedido VALUES (?,?)";
            CallableStatement crear = conexion.prepareStatement(query);
            crear.setString(1, nuevoPedido.getFormaEntrega());         
            crear.setString(2, nuevoPedido.getComentario());
                        
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
    public ArrayList<EstadoPedido> listarEstados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarEstado(EstadoPedido nuevoEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarEstado(int idEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
