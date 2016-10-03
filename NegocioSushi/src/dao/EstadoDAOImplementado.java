package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            PreparedStatement crear = conexion.prepareStatement(query);
            crear.setInt(1, nuevoEstado.getIdEstado());         
            crear.setString(2, nuevoEstado.getEstado());
            crear.execute();            
            crear.close();
            conexion.close();
            logrado = true;            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al crear estado: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al crear estado: "+exc.getMessage());
        }       
        return logrado;
    }

    @Override
    public ArrayList<EstadoPedido> listarEstados() {
        ArrayList<EstadoPedido> lista = null;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * from estado_pedido";
            PreparedStatement listar = conexion.prepareStatement(query);
            ResultSet resultado = listar.executeQuery();
            //debería verificar antes de inicializar
            lista = new ArrayList<EstadoPedido>();
            while(resultado.next()){
                EstadoPedido estado = new EstadoPedido();
                estado.setIdEstado(resultado.getInt("id_estado"));
                estado.setEstado(resultado.getString("estado"));
                lista.add(estado);
            }
            listar.close();
            conexion.close();            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al listar estados: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al listar estados: "+exc.getMessage());
        }       
        return lista;
    }

    @Override
    public boolean modificarEstado(EstadoPedido nuevoEstado) {
        boolean logrado = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE estado_pedido SET estado = ? where id_estado = ?";
            PreparedStatement actualizar = conexion.prepareStatement(query);
            actualizar.setString(1, nuevoEstado.getEstado());
            actualizar.setInt(2, nuevoEstado.getIdEstado());         
            actualizar.execute();            
            actualizar.close();
            conexion.close();
            logrado = true;            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al modificar estado: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al modificar estado: "+exc.getMessage());
        }       
        return logrado;
    }

    @Override
    public boolean eliminarEstado(int idEstado) {
        boolean logrado = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE from estado_pedido where id_estado = ?";
            PreparedStatement eliminar = conexion.prepareStatement(query);
            eliminar.setInt(1, idEstado);
            eliminar.executeQuery();
            eliminar.close();
            conexion.close();
            logrado = true;            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al eliminar estado: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al eliminar estado: "+exc.getMessage());
        }       
        return logrado;
    }    
    
}
