package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import negocio.EmpleadoRun;
import oracleSql.Conexion;

public class EmpleadoRunImplementado implements EmpleadoRunDao {

    @Override
    public boolean almacenarEmpleado(EmpleadoRun nuevoEmpleado) {
        boolean almacenado = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO empleado_run (fecha_contrato,sueldo_liquido,sueldo_bruto,tipo,run,nombre,direccion,comuna,provincia,region,fecha_nacimiento "
                    + "genero,correo_electronico,numero_telefonico,password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement almacenar = conexion.prepareStatement(query);

            almacenar.setDate(1, (Date) nuevoEmpleado.getFechaContrato());
            almacenar.setInt(2, nuevoEmpleado.getSueldoLiquido());
            almacenar.setInt(3, nuevoEmpleado.getSueldoBruto());
            almacenar.setString(4, nuevoEmpleado.getTipo());
            almacenar.setString(5, nuevoEmpleado.getRun());
            almacenar.setString(6, nuevoEmpleado.getNombre());
            almacenar.setString(7, nuevoEmpleado.getDireccion());
            almacenar.setString(8, nuevoEmpleado.getComuna());
            almacenar.setString(9, nuevoEmpleado.getProvincia());
            almacenar.setString(10, nuevoEmpleado.getRegion());
            almacenar.setDate(11, (Date) nuevoEmpleado.getFechaNacimiento());
            almacenar.setString(12, nuevoEmpleado.getGenero());
            almacenar.setString(13, nuevoEmpleado.getCorreoElectronico());
            almacenar.setInt(14, nuevoEmpleado.getNumeroTelefonico());
            almacenar.setString(15, nuevoEmpleado.getPassword());

            almacenar.execute();
            almacenar.close();
            conexion.close();
            almacenado = true;
        } catch (SQLException w) {
            System.out.println("Error en la conexion sql " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al almacenar al empleado" + e.getMessage());
            return false;
        }
        return almacenado;
    }

    @Override
    public boolean eliminarEmpleado(EmpleadoRun empleadoRun) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM empleado_run where run=?";

            PreparedStatement eliminar = conexion.prepareCall(query);

            eliminar.setString(1, empleadoRun.getRun());

            eliminar.execute();
            eliminar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error en la conexion sql " + w.getMessage());

            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar al empleado  " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarCliente(EmpleadoRun empleadoModificado) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UDPATE empleado_run set fecha_contrato = ? , sueldo_liquido = ? , sueldo_bruto = ? , tipo = ? , run = ? , nombre = ? , direccion = ?"
                    + "comuna = ? , provincia = ? , region = ? , fecha_nacimiento = ? , genero = ? , correo_electronico = ? , numero_telefonico = ? , password = ? WHERE run = ? ";

            PreparedStatement modificar = conexion.prepareStatement(query);

            modificar.setDate(1, (Date) empleadoModificado.getFechaContrato());
            modificar.setInt(2, empleadoModificado.getSueldoLiquido());
            modificar.setInt(3, empleadoModificado.getSueldoBruto());
            modificar.setString(4, empleadoModificado.getTipo());
            modificar.setString(5, empleadoModificado.getRun());
            modificar.setString(6, empleadoModificado.getNombre());
            modificar.setString(7, empleadoModificado.getDireccion());
            modificar.setString(8, empleadoModificado.getComuna());
            modificar.setString(9, empleadoModificado.getProvincia());
            modificar.setString(10, empleadoModificado.getRegion());
            modificar.setDate(11, (Date) empleadoModificado.getFechaNacimiento());
            modificar.setString(12, empleadoModificado.getGenero());
            modificar.setString(13, empleadoModificado.getCorreoElectronico());
            modificar.setInt(14, empleadoModificado.getNumeroTelefonico());
            modificar.setString(15, empleadoModificado.getPassword());

            modificar.executeUpdate();

            modificar.close();

            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error en la conexion sql " + w.getMessage());
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
            String query = "SELECT * FROM empleado_run";
            PreparedStatement listar = conexion.prepareCall(query);

            ResultSet rs = listar.executeQuery();

            if (rs.next()) {

                lista = new ArrayList<EmpleadoRun>();

                while (rs.next()) {

                    EmpleadoRun listarEmpleado = new EmpleadoRun();

                    listarEmpleado.setFechaContrato(rs.getDate("fecha_contrato"));
                    listarEmpleado.setSueldoLiquido(rs.getInt("sueldo_liquido"));
                    listarEmpleado.setSueldoBruto(rs.getInt("sueldo_bruto"));
                    listarEmpleado.setTipo(rs.getString("tipo"));
                    listarEmpleado.setRun(rs.getString("run"));
                    listarEmpleado.setNombre(rs.getString("nombre"));
                    listarEmpleado.setDireccion(rs.getString("direccion"));
                    listarEmpleado.setComuna(rs.getString("comuna"));
                    listarEmpleado.setProvincia(rs.getString("provincia"));
                    listarEmpleado.setRegion(rs.getString("region"));
                    listarEmpleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    listarEmpleado.setGenero(rs.getString("genero"));
                    listarEmpleado.setCorreoElectronico(rs.getString("correo_electronico"));
                    listarEmpleado.setNumeroTelefonico(rs.getInt("numero_telefonico"));
                    listarEmpleado.setPassword(rs.getString("password"));

                    lista.add(listarEmpleado);

                }

            }

            listar.close();
            conexion.close();

        } catch (SQLException w) {
            System.out.println("Error en la conexion sql " + w.getMessage());
        } catch (Exception e) {

            System.out.println("Error al listar a los empleados " + e.getMessage());
        }

        return lista;
    }

}
