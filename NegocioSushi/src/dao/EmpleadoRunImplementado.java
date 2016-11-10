package dao;

import java.sql.*;
import java.util.ArrayList;
import negocio.EmpleadoRun;
import oracleSql.Conexion;

public class EmpleadoRunImplementado implements EmpleadoRunDao {

    @Override
    public boolean almacenarEmpleado(EmpleadoRun nuevoEmpleado) {
        boolean almacenado = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO empleado (fecha_contrato,sueldo_liquido,sueldo_bruto,tipo,run,nombre,direccion,comuna,provincia,region,fecha_nacimiento, "
                    + "genero,correo_electronico,numero_telefonico,password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement almacenar = conexion.prepareStatement(query);

            almacenar.setString(1, nuevoEmpleado.getFechaContrato());
            almacenar.setInt(2, nuevoEmpleado.getSueldoLiquido());
            almacenar.setInt(3, nuevoEmpleado.getSueldoBruto());
            almacenar.setString(4, nuevoEmpleado.getTipo());
            almacenar.setString(5, nuevoEmpleado.getRun());
            almacenar.setString(6, nuevoEmpleado.getNombre());
            almacenar.setString(7, nuevoEmpleado.getDireccion());
            almacenar.setString(8, nuevoEmpleado.getComuna());
            almacenar.setString(9, nuevoEmpleado.getProvincia());
            almacenar.setString(10, nuevoEmpleado.getRegion());
            almacenar.setString(11, nuevoEmpleado.getFechaNacimiento());
            almacenar.setString(12, nuevoEmpleado.getGenero());
            almacenar.setString(13, nuevoEmpleado.getCorreoElectronico());
            almacenar.setString(14, nuevoEmpleado.getNumeroTelefonico());
            almacenar.setString(15, nuevoEmpleado.getPassword());

            almacenar.execute();
            almacenar.close();
            conexion.close();
            almacenado = true;
        } catch (SQLException w) {
            System.out.println("Error sql al almacenar empleado: " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al almacenar al empleado" + e.getMessage());
            return false;
        }
        return almacenado;
    }

    @Override
    public boolean eliminarEmpleado(String empleadoRun) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM empleado where run=?";

            PreparedStatement eliminar = conexion.prepareCall(query);

            eliminar.setString(1, empleadoRun);

            eliminar.execute();
            eliminar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error sql al eliminar empleado" + w.getMessage());

            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar al empleado  " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarEmpleado(EmpleadoRun empleadoModificado) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE empleado SET "
                    + "fecha_contrato = TO_DATE(?, 'DD/MM/YYYY' ), "
                    + "sueldo_liquido = ?, "
                    + "sueldo_bruto = ?, "
                    + "tipo = ?, "
                    + "nombre = ?, "
                    + "direccion = ?,"
                    + "comuna = ?, "
                    + "provincia = ?, "
                    + "region = ?, "
                    + "fecha_nacimiento = TO_DATE(?, 'DD/MM/YYYY'), "
                    + "genero = ?, "
                    + "correo_electronico = ?, "
                    + "numero_telefonico = ?, "
                    + "password = ? "
                    + "WHERE run = ? ";

            PreparedStatement modificar = conexion.prepareStatement(query);

            modificar.setString(1, empleadoModificado.getFechaContrato());
            modificar.setInt(2, empleadoModificado.getSueldoLiquido());
            modificar.setInt(3, empleadoModificado.getSueldoBruto());
            modificar.setString(4, empleadoModificado.getTipo());
            modificar.setString(5, empleadoModificado.getNombre());
            modificar.setString(6, empleadoModificado.getDireccion());
            modificar.setString(7, empleadoModificado.getComuna());
            modificar.setString(8, empleadoModificado.getProvincia());
            modificar.setString(9, empleadoModificado.getRegion());
            modificar.setString(10, empleadoModificado.getFechaNacimiento());
            modificar.setString(11, empleadoModificado.getGenero());
            modificar.setString(12, empleadoModificado.getCorreoElectronico());
            modificar.setString(13, empleadoModificado.getNumeroTelefonico());
            modificar.setString(14, empleadoModificado.getPassword());
            modificar.setString(15, empleadoModificado.getRun());

            modificar.execute();

            modificar.close();

            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error sql al modificar empleado" + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al modificar al empleado " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<EmpleadoRun> listarEmpleados() {
        ArrayList<EmpleadoRun> lista = null;

        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM empleado";
            PreparedStatement listar = conexion.prepareCall(query);

            ResultSet rs = listar.executeQuery();

            lista = new ArrayList<EmpleadoRun>();

            while (rs.next()) {

                EmpleadoRun listarEmpleado = new EmpleadoRun();

                listarEmpleado.setFechaContrato(rs.getString("fecha_contrato"));
                listarEmpleado.setSueldoLiquido(rs.getInt("sueldo_liquido"));
                listarEmpleado.setSueldoBruto(rs.getInt("sueldo_bruto"));
                listarEmpleado.setTipo(rs.getString("tipo"));
                listarEmpleado.setRun(rs.getString("run"));
                listarEmpleado.setNombre(rs.getString("nombre"));
                listarEmpleado.setDireccion(rs.getString("direccion"));
                listarEmpleado.setComuna(rs.getString("comuna"));
                listarEmpleado.setProvincia(rs.getString("provincia"));
                listarEmpleado.setRegion(rs.getString("region"));
                listarEmpleado.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                listarEmpleado.setGenero(rs.getString("genero"));
                listarEmpleado.setCorreoElectronico(rs.getString("correo_electronico"));
                listarEmpleado.setNumeroTelefonico(rs.getString("numero_telefonico"));
                listarEmpleado.setPassword(rs.getString("password"));

                lista.add(listarEmpleado);

            }

            listar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error sql al listar empleado " + w.getMessage());
        } catch (Exception e) {

            System.out.println("Error al listar a los empleados " + e.getMessage());
        }

        return lista;
    }

    @Override
    public boolean autenticarEmpleado(String correo, String pass) {
        boolean resultado = false;
        
        try {
            Connection conec = Conexion.getConexion();
            String sql = "select * from empleado where correo_electronico=? and password=?";
            PreparedStatement prepare =  conec.prepareStatement(sql);
            prepare.setString(1, correo);
            prepare.setString(2, pass);
            
            ResultSet rs = prepare.executeQuery();
            if(rs.next())
                resultado = true;
            prepare.close();
            conec.close();
            return resultado;                     
        } catch (Exception e) {
            return resultado;
        }
    }

}
