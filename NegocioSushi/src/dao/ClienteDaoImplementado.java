package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import negocio.Cliente;
import oracleSql.Conexion;

public class ClienteDaoImplementado implements ClienteDao {

    @Override
    public boolean almacenarCliente(Cliente nuevoCliente) {
        boolean almacenado = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO cliente (cliente_run,nombre_completo,direccion,comuna,provincia,region,fecha_nacimiento "
                    + "genero,correo_electronico,numero_telefonico,password) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement almacenar = conexion.prepareStatement(query);

            almacenar.setString(1, nuevoCliente.getClienteRun());
            almacenar.setString(2, nuevoCliente.getNombreCompleto());
            almacenar.setString(3, nuevoCliente.getDireccion());
            almacenar.setString(4, nuevoCliente.getComuna());
            almacenar.setString(5, nuevoCliente.getProvincia());
            almacenar.setString(6, nuevoCliente.getRegion());
            almacenar.setDate(7, (Date) nuevoCliente.getFechaNacimiento());
            almacenar.setString(8, nuevoCliente.getGenero());
            almacenar.setString(9, nuevoCliente.getCorreoElectronico());
            almacenar.setInt(10, nuevoCliente.getNumeroTelefonico());
            almacenar.setString(11, nuevoCliente.getPassword());

            almacenar.execute();
            almacenar.close();
            conexion.close();
            almacenado = true;
        } catch (SQLException w) {
            System.out.println("Error en la conexion sql " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al almacenar al cliente" + e.getMessage());
            return false;
        }
        return almacenado;
    }

    @Override
    public boolean eliminarCliente(Cliente clienteRun) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM cliente where cliente_run=?";

            PreparedStatement eliminar = conexion.prepareCall(query);

            eliminar.setString(1, clienteRun.getClienteRun());

            eliminar.execute();
            eliminar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error en la conexion sql " + w.getMessage());

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
            String query = "UDPATE cliente set cliente_run = ? , nombre_completo = ? , direccion = ? , comuna = ? , provincia = ? , region = ? . fecha_nacimiento = ?"
                    + "genero = ? , correo_electronico = ? , numero_telefonico = ? , password = ? WHERE cliente_run = ? ";

            PreparedStatement modificar = conexion.prepareStatement(query);

            modificar.setString(1, clienteModificado.getClienteRun());
            modificar.setString(2, clienteModificado.getNombreCompleto());
            modificar.setString(3, clienteModificado.getDireccion());
            modificar.setString(4, clienteModificado.getComuna());
            modificar.setString(5, clienteModificado.getProvincia());
            modificar.setString(6, clienteModificado.getRegion());
            modificar.setDate(7, (Date) clienteModificado.getFechaNacimiento());
            modificar.setString(8, clienteModificado.getGenero());
            modificar.setString(9, clienteModificado.getCorreoElectronico());
            modificar.setInt(10, clienteModificado.getNumeroTelefonico());
            modificar.setString(11, clienteModificado.getPassword());

            modificar.executeUpdate();

            modificar.close();

            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error en la conexion sql " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al modificar al cliente " + e.getMessage());
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
            PreparedStatement listar = conexion.prepareCall(query);

            ResultSet rs = listar.executeQuery();

            if (rs.next()) {

                lista = new ArrayList<Cliente>();

                while (rs.next()) {

                    Cliente listarCliente = new Cliente();

                    listarCliente.setClienteRun(rs.getString("cliente_run"));
                    listarCliente.setNombreCompleto(rs.getString("nombre_completo"));
                    listarCliente.setDireccion(rs.getString("direccion"));
                    listarCliente.setComuna(rs.getString("comuna"));
                    listarCliente.setProvincia(rs.getString("provincia"));
                    listarCliente.setRegion(rs.getString("region"));
                    listarCliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    listarCliente.setGenero(rs.getString("genero"));
                    listarCliente.setCorreoElectronico(rs.getString("correo_electronico"));
                    listarCliente.setNumeroTelefonico(rs.getInt("numero_telefonico"));
                    listarCliente.setPassword(rs.getString("password"));

                    lista.add(listarCliente);

                }

            }

            listar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error en la conexion sql " + w.getMessage());
        } catch (Exception e) {

            System.out.println("Error en listar a los clientes " + e.getMessage());
        }

        return lista;
    }

}
