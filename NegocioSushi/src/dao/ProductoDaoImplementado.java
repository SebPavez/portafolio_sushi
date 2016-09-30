/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import negocio.Producto;
import oracleSql.Conexion;

public class ProductoDaoImplementado {
    
    public boolean agregarProducto (Producto producto){
        boolean agregado = false;
        try{
          Connection conexion = Conexion.getConexion();
          String query = "insert into producto(stock, nombre, precio_normal, precio_oferta,en_oferta, descripcion, categoriaProducto) values (?,?,?,?,?,?,?)";
          CallableStatement crear = conexion.prepareCall(query);
          crear.setInt(1,producto.getStock());
          crear.setString(2, producto.getNombre());
          crear.setInt(3, producto.getPrecio_normal());
          crear.setInt(4, producto.getPrecio_oferta());
          crear.setBoolean(5, producto.getEn_oferta());
          crear.setString(6, producto.getDescripcion());
          crear.setString(7, producto.getCategoriaProducto());
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
    };
    
    public Producto buscarProducto(int idProducto){
    Producto prod = null;
        try {
            Connection conexion= Conexion.getConexion();
            String query = "Select * from pedido where idProducto = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setInt(1, idProducto);
            ResultSet rs = buscar.executeQuery();
            if(rs.next()){
              prod = new Producto();
              prod.setIdProducto(rs.getInt("idProducto"));
              prod.setNombre(rs.getString("nombre"));
              prod.setPrecio_normal(rs.getInt("precio_normal"));
              prod.setPrecio_oferta(rs.getInt("precio_oferta"));
              prod.setStock(rs.getInt("stock"));
              prod.setEn_oferta(rs.getBoolean("en_oferta"));
              prod.setDescripcion(rs.getString("descripcion"));
              prod.setCategoriaProducto(rs.getString("categoria"));
            }
            buscar.close();
            conexion.close();
       } catch (SQLException sqlExc){
            System.out.println("Error SQL al agregar producto: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al agregar producto: "+exc.getMessage());
        }   
        return prod;
    };
    
    public boolean actualizarProducto (Producto producto){
      boolean actualizado = false;
        try {
            Connection conexion= Conexion.getConexion();
            String query = "update producto set"
                    + "nombre = ?"
                    + "stock=?"
                    + "precio_normal=?"
                    + "precio_oferta=?"
                    + "en_Oferta=?"
                    + "descripcion=?"
                    + "categoria=?"
                    +"where idProducto = ?";
            PreparedStatement update = conexion.prepareStatement(query);
            update.setString(1, producto.getNombre());
            update.setInt(2, producto.getStock());
            update.setInt(3, producto.getPrecio_normal());
            update.setInt(4, producto.getPrecio_oferta());
            update.setBoolean(5, producto.getEn_oferta());
            update.setString(6, producto.getDescripcion());
            update.setString(7, producto.getCategoriaProducto());
            update.setInt(8, producto.getIdProducto());
            update.execute();
            if(update.getUpdateCount()>-1)
                actualizado = true;
            update.close();
            conexion.close();
        } catch (SQLException sqlExc){
            System.out.println("Error SQL al actualizar producto: "+sqlExc.getMessage());
        } catch (Exception exc){
            System.out.println("Error al actualizar producto: "+exc.getMessage());
        }    
        return actualizado;
    };
    
    public boolean eliminarProducto (int idProducto){
        boolean eliminado = false;
        try{
            Connection conexion = Conexion .getConexion();
            String query = "delete from producto where idProducto =?";
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
    
    public List<Producto> listarPeliculas() {
        List<Producto> lista = null;
        try {            
            Connection conexion=Conexion.getConexion();
            String query="SELECT * FROM producto";
            PreparedStatement buscar= conexion.prepareStatement(query);
            ResultSet rs= buscar.executeQuery();
            lista = new ArrayList<Producto>();
            while(rs.next()){                
                Producto instancia = new Producto();
                instancia.setIdProducto(rs.getInt("idProducto"));
                instancia.setNombre(rs.getString("nombre"));
                instancia.setPrecio_normal(rs.getInt("precio_normal"));
                instancia.setPrecio_oferta(rs.getInt("precio_oferta"));
                instancia.setEn_oferta(rs.getBoolean("en_oferta"));
                instancia.setDescripcion(rs.getString("descripcion"));
                instancia.setCategoriaProducto(rs.getString("categoriaProducto"));
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
    
     public List<Producto> listarPorCategoria(String categoria) {
        List<Producto> lista = null;
        try {            
            Connection conexion=Conexion.getConexion();
            String query="select * from producto where categoriaProducto = ?";
            PreparedStatement buscar= conexion.prepareStatement(query);
            buscar.setString(1, categoria);            
            ResultSet rs= buscar.executeQuery();
            lista = new ArrayList<Producto>();
             while(rs.next()){                
                Producto instancia = new Producto();
                instancia.setIdProducto(rs.getInt("idProducto"));
                instancia.setNombre(rs.getString("nombre"));
                instancia.setPrecio_normal(rs.getInt("precio_normal"));
                instancia.setPrecio_oferta(rs.getInt("precio_oferta"));
                instancia.setEn_oferta(rs.getBoolean("en_oferta"));
                instancia.setDescripcion(rs.getString("descripcion"));
                instancia.setCategoriaProducto(rs.getString("categoriaProducto"));
                lista.add(instancia);                
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al listar productos por categoria. " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar productos por categoria " + e.getMessage());
        }
        return lista;
    }

}
