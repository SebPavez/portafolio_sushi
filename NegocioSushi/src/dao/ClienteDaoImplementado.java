package dao;

import java.sql.*;
import java.util.ArrayList;
import negocio.Cliente;
import oracleSql.Conexion;

public class ClienteDaoImplementado implements ClienteDao {

    @Override
    public boolean almacenarCliente(Cliente nuevoCliente) {
        boolean almacenado = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO cliente (cliente_run, nombre_completo, direccion, comuna, provincia, region, fecha_nacimiento, "
                    + "genero, correo_electronico, numero_telefonico, password) VALUES (?,?,?,?,?,?,TO_DATE(?,'DD-MM-YYYY'),?,?,?,?)";

            PreparedStatement almacenar = conexion.prepareStatement(query);

            almacenar.setString(1, nuevoCliente.getClienteRun());
            almacenar.setString(2, nuevoCliente.getNombreCompleto());
            almacenar.setString(3, nuevoCliente.getDireccion());
            almacenar.setString(4, nuevoCliente.getComuna());
            almacenar.setString(5, nuevoCliente.getProvincia());
            almacenar.setString(6, nuevoCliente.getRegion());
            almacenar.setString(7, nuevoCliente.getFechaNacimiento());
            almacenar.setString(8, nuevoCliente.getGenero());
            almacenar.setString(9, nuevoCliente.getCorreoElectronico());
            almacenar.setString(10, nuevoCliente.getNumeroTelefonico());
            almacenar.setString(11, nuevoCliente.getPassword());

            almacenar.execute();
            almacenar.close();
            conexion.close();
            almacenado = true;
        } catch (SQLException w) {
            System.out.println("Error en sql en almacenar cliente " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al almacenar al cliente" + e.getMessage());
            return false;
        }
        return almacenado;
    }

    @Override
    public boolean eliminarCliente(String clienteRun) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM cliente where cliente_run=?";

            PreparedStatement eliminar = conexion.prepareCall(query);

            eliminar.setString(1, clienteRun);

            eliminar.execute();
            eliminar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error sql al eliminar " + w.getMessage());

            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar al cliente  " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarCliente(Cliente clienteModificado) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE cliente set "
                    + "nombre_completo = ? , "
                    + "direccion = ? , "
                    + "comuna = ? , "
                    + "provincia = ? , "
                    + "region = ? , "
                    + "fecha_nacimiento = ?,"
                    + "genero = ? , "
                    + "correo_electronico = ? , "
                    + "numero_telefonico = ? , "
                    + "password = ? "
                    + "WHERE cliente_run = ? ";

            PreparedStatement modificar = conexion.prepareStatement(query);
            
            modificar.setString(1, clienteModificado.getNombreCompleto());
            modificar.setString(2, clienteModificado.getDireccion());
            modificar.setString(3, clienteModificado.getComuna());
            modificar.setString(4, clienteModificado.getProvincia());
            modificar.setString(5, clienteModificado.getRegion());
            modificar.setString(6, clienteModificado.getFechaNacimiento());
            modificar.setString(7, clienteModificado.getGenero());
            modificar.setString(8, clienteModificado.getCorreoElectronico());
            modificar.setString(9, clienteModificado.getNumeroTelefonico());
            modificar.setString(10, clienteModificado.getPassword());
            modificar.setString(11, clienteModificado.getClienteRun());

            modificar.execute();

            modificar.close();

            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error sql al modificar cliente: " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al modificar al cliente: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> lista = null;

        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM cliente";
            PreparedStatement listar = conexion.prepareStatement(query);

            ResultSet rs = listar.executeQuery();            
            
            lista = new ArrayList<Cliente>();
            
            while (rs.next()) {
                    Cliente listarCliente = new Cliente();
                    listarCliente.setClienteRun(rs.getString("cliente_run"));
                    listarCliente.setNombreCompleto(rs.getString("nombre_completo"));
                    listarCliente.setDireccion(rs.getString("direccion"));
                    listarCliente.setComuna(rs.getString("comuna"));
                    listarCliente.setProvincia(rs.getString("provincia"));
                    listarCliente.setRegion(rs.getString("region"));
                    listarCliente.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    listarCliente.setGenero(rs.getString("genero"));
                    listarCliente.setCorreoElectronico(rs.getString("correo_electronico"));
                    listarCliente.setNumeroTelefonico(rs.getString("numero_telefonico"));
                    listarCliente.setPassword(rs.getString("password"));
                    lista.add(listarCliente);
            }
            listar.close();
            conexion.close(); 
            
        } catch (SQLException w) {
            System.out.println("Error sql en listar cliente" + w.getMessage());
        } catch (Exception e) {

            System.out.println("Error en listar a los Cliente " + e.getMessage());
        }

        return lista;
    }

    @Override
    public Cliente buscarCliente(String runCliente) {
        
        Cliente nuevoCliente =  new Cliente();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM cliente WHERE cliente_run = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(0, runCliente);
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {                    
                    nuevoCliente.setClienteRun(runCliente);
                    nuevoCliente.setNombreCompleto(rs.getString("nombre_completo"));
                    nuevoCliente.setDireccion(rs.getString("direccion"));
                    nuevoCliente.setComuna(rs.getString("comuna"));
                    nuevoCliente.setProvincia(rs.getString("provincia"));
                    nuevoCliente.setRegion(rs.getString("region"));
                    nuevoCliente.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    nuevoCliente.setGenero(rs.getString("genero"));
                    nuevoCliente.setCorreoElectronico(rs.getString("correo_electronico"));
                    nuevoCliente.setNumeroTelefonico(rs.getString("numero_telefonico"));
                    nuevoCliente.setPassword(rs.getString("password"));
            }
            buscar.close();
            conexion.close();             
        } catch (SQLException w) {
            System.out.println("Error sql en listar cliente" + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error en listar a los clientes " + e.getMessage());
        }
        return nuevoCliente;
    }

}
