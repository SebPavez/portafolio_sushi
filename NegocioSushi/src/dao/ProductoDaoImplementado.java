package dao;

import java.sql.*;
import java.util.ArrayList;
import negocio.Producto;
import oracleSql.Conexion;

public class ProductoDaoImplementado {
    
    public boolean agregarProducto (Producto producto){
        boolean agregado = false;
        try{
          Connection conexion = Conexion.getConexion();
          String query = "insert into producto(id_producto, stock, nombre, precio_normal, precio_oferta,en_oferta, descripcion, categoria, link_internet) values (seq_id_producto.NEXTVAL,?,?,?,?,?,?,?,?)";
          CallableStatement crear = conexion.prepareCall(query);
          crear.setInt(1,producto.getStock());
          crear.setString(2, producto.getNombre());
          crear.setInt(3, producto.getPrecio_normal());
          crear.setInt(4, producto.getPrecio_oferta());
          crear.setBoolean(5, producto.getEn_oferta());
          crear.setString(6, producto.getDescripcion());
          crear.setInt(7, producto.getIdCategoriaProducto());
          crear.setString(8, "no disponible");
          crear.execute();
          crear.close();
          conexion.close();
          agregado= true;
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al crear producto: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al crear producto: "+exc.getMessage());
        }       
        return agregado;
    }
    
    public Producto buscarProducto(int idProducto){
    Producto prod = null;
        try {
            Connection conexion= Conexion.getConexion();
            String query = "Select * from producto where id_Producto = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, idProducto);             
            ResultSet resultado = buscar.executeQuery();
            if(resultado.next()){
              prod = new Producto();
              prod.setIdProducto(resultado.getInt("id_Producto"));
              prod.setNombre(resultado.getString("nombre"));
              prod.setPrecio_normal(resultado.getInt("precio_normal"));
              prod.setPrecio_oferta(resultado.getInt("precio_oferta"));
              prod.setStock(resultado.getInt("stock"));
              prod.setEn_oferta(resultado.getBoolean("en_oferta"));
              prod.setDescripcion(resultado.getString("descripcion"));
              prod.setIdCategoriaProducto(resultado.getInt("categoria"));              
            }
            buscar.close();
            conexion.close();
       } catch (SQLException sqlExc){
            System.out.println("Error SQL al buscar producto: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al buscar producto: "+exc.getMessage());
        }   
        return prod;
    }
    
    public boolean actualizarProducto (Producto producto){
      boolean logrado = false;
        try {
            Connection conexion = Conexion.getConexion();            
             String query = "update producto  set "
                    + "nombre = ?,"
                    + "stock=?,"
                    + "precio_normal=?,"
                    + "precio_oferta=?,"
                    + "en_Oferta=? ,"
                    + "descripcion=?,"
                    + "categoria=? "
                    + "where id_producto = ?";
            PreparedStatement actualizar = conexion.prepareStatement(query);
            actualizar.setString(1, producto.getNombre());         
            actualizar.setInt(2, producto.getStock());
            actualizar.setInt(3, producto.getPrecio_normal());
            actualizar.setInt(4, producto.getPrecio_oferta());            
            actualizar.setBoolean(5, producto.getEn_oferta());
            actualizar.setString(6, producto.getDescripcion());
            actualizar.setString(7, producto.getCategoriaProducto());
            actualizar.setInt(8, producto.getIdProducto());            
            actualizar.execute();            
            if (actualizar.getUpdateCount()>-1)
                logrado = true;                            
            actualizar.close();
            conexion.close();            
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al actualizar producto: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al actualizar producto: "+exc.getMessage());
        }       
        return logrado;
    }
    
    public boolean eliminarProducto (int idProducto){
        boolean eliminado = false;
        try{
            Connection conexion = Conexion .getConexion();
            String query = "delete from producto where id_producto =?";
            PreparedStatement delete = conexion.prepareStatement(query);
            delete.setInt(1, idProducto);
            delete.execute();
            if(delete.getUpdateCount()>-1)
                eliminado = true;
            delete.close();
            conexion.close();
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al eliminar producto: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al eliminar producto: "+exc.getMessage());
        } 
        return eliminado;
    }
    
    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> lista = null;
        try {            
            Connection conexion=Conexion.getConexion();
            String query="SELECT * FROM producto";
            PreparedStatement buscar= conexion.prepareStatement(query);
            ResultSet rs= buscar.executeQuery();
            lista = new ArrayList<Producto>();
            while(rs.next()){                
                Producto instancia = new Producto();
                instancia.setIdProducto(rs.getInt("id_producto"));
                instancia.setStock(rs.getInt("stock"));                
                instancia.setNombre(rs.getString("nombre"));
                instancia.setPrecio_normal(rs.getInt("precio_normal"));
                instancia.setPrecio_oferta(rs.getInt("precio_oferta"));
                if(rs.getByte("en_oferta")==1)
                    instancia.setEn_oferta(true);
                else
                    instancia.setEn_oferta(false);
                instancia.setDescripcion(rs.getString("descripcion"));
                instancia.setCategoriaProducto(rs.getString("categoria"));
                lista.add(instancia);                
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al listar Productos. " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar Productos " + e.getMessage());
        }
        return lista;
    }

}
