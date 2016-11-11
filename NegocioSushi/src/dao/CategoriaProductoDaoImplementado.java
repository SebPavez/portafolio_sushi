
package dao;
import java.sql.*;
import java.util.ArrayList;
import negocio.CategoriaProducto;
import oracleSql.Conexion;


public class CategoriaProductoDaoImplementado implements CategoriaDao {
    
    @Override
    public boolean agregarCategoria(String cat){
        boolean agregado = false;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "insert into categoria_producto values ( seq_id_categoria.nextval , ?)";
            CallableStatement add = conexion.prepareCall(query);
            add.setString(1, cat.toLowerCase());
            add.execute();
            add.close();
            conexion.close();
            agregado=true;
       } catch (SQLException sqlExc){
            System.out.println("Error SQL al agregar categoria: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al agregar categoria: "+exc.getMessage());
        }       
        return agregado;
    }
    
//   public CategoriaProducto buscarCategoria(String cat){
//       CategoriaProducto categoria = null;
//       try{
//           Connection conexion = Conexion.getConexion();
//           String query = "select * from categoria where categoria=?";
//           PreparedStatement find = conexion.prepareStatement(query);
//           find.setString(1, cat);
//           ResultSet rs = find.executeQuery();
//           if(rs.next()){
//               categoria = new CategoriaProducto();
//               categoria.setCategoria_producto(rs.getString("categoria"));
//           }
//           find.close();
//           conexion.close();
//       } catch (SQLException sqlExc){
//            System.out.println("Error SQL al crear pedido: "+sqlExc.getMessage());
//        } catch (Exception exc){
//            System.out.println("Error al crear pedido: "+exc.getMessage());
//        }       
//        return categoria;
//   }
   
//   public boolean actualizarCategoria(CategoriaProducto categoria){
//       boolean update = false;
//      try{    
//          Connection conexion = Conexion.getConexion();
//          String query = "update from categoria_producto set categoria = ? where idCategoria =?";
//          PreparedStatement actualizar = conexion.prepareStatement(query);
//          actualizar.setString(1, categoria.getCategoria_producto());
//          actualizar.execute();
//          if(actualizar.getUpdateCount()>-1)
//              update = true;
//          actualizar.close();
//          conexion.close();
//        } catch (SQLException sqlExc){
//            System.out.println("Error SQL al actualizar pedido: "+sqlExc.getMessage());
//        } catch (Exception exc){
//            System.out.println("Error al actualizar pedido: "+exc.getMessage());
//        } 
//      return update;
//   }
    
    @Override
     public boolean eliminarCategoria(String categoria) {
        boolean logrado = false;
        try {
            Connection conexion = Conexion.getConexion();            
            String query = "DELETE FROM categoria_producto WHERE categoria = ?";
            PreparedStatement eliminar = conexion.prepareStatement(query);
            eliminar.setString(1, categoria.toLowerCase());         
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
   
    /**
     *
     * @return
     */
    @Override
    public ArrayList<CategoriaProducto> listarCategoria() {
        ArrayList<CategoriaProducto> lista = null;
        try {            
            Connection conexion=Conexion.getConexion();
            String query="select * from categoria_producto ";
            PreparedStatement buscar= conexion.prepareStatement(query);
            ResultSet rs= buscar.executeQuery();
            lista = new ArrayList<CategoriaProducto>();
            while(rs.next()){
                CategoriaProducto instancia = new CategoriaProducto();
                instancia.setId_categoria(rs.getInt("id_categoria"));
                instancia.setCategoria_producto(rs.getString("categoria"));
                lista.add(instancia);                
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al listar categorias . " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar categorias " + e.getMessage());
        }
        return lista;
    }

    @Override
    public CategoriaProducto buscarCategoria(String cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizaCategoria(CategoriaProducto categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
    

