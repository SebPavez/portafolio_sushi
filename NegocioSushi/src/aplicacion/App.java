package aplicacion;

import dao.*;
import java.util.ArrayList;
import negocio.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    
    public void Main(String[] args){
        
        ClienteDaoImplementado testCliente = new ClienteDaoImplementado();
        
        //Objeto Cliente para prueba
        Cliente nuevoCliente = new Cliente();
        
        nuevoCliente.setNombreCompleto("");
        
        if(validarRut("")){
            nuevoCliente.setClienteRun("");
        }        
        if(validarEMail("")){
            nuevoCliente.setCorreoElectronico("");
        }
        nuevoCliente.setNumeroTelefonico(0);
        if("".length()>7){
            nuevoCliente.setPassword("");        
        }
        
        nuevoCliente.setDireccion("");
        
        //Campo date puede resultar algo complicado de ingresar a la BD
        //nuevoCliente.setFechaNacimiento();
        
        nuevoCliente.setGenero("");
        
        //Existe la posibilidad de que cualquier String se pueda pasar como locación
        nuevoCliente.setComuna("");
        nuevoCliente.setProvincia("");
        nuevoCliente.setRegion("");
               
        //Pruebas ClienteDao
        testCliente.almacenarCliente(nuevoCliente);
        testCliente.eliminarCliente(nuevoCliente);
        testCliente.listarClientes();
        testCliente.modificarCliente(nuevoCliente);
        
        
        //--------------------------------------------
        
        Producto producto = new Producto();
        Producto productoDos = new Producto();
        
        
        //--------------------------------------------
        DetalleDAOImplementado detalleTest = new DetalleDAOImplementado();
        
        DetallePedido nuevoDetalle = new DetallePedido();
        nuevoDetalle.setCantidad(0);
        nuevoDetalle.setProducto(producto);
        nuevoDetalle.setTotalDetalle(0);
        
        DetallePedido nuevoDetalleDos = new DetallePedido();
        nuevoDetalleDos.setCantidad(1);
        nuevoDetalleDos.setProducto(productoDos);
        nuevoDetalle.setTotalDetalle(2);
        
        ArrayList<DetallePedido> listaDetalle = new ArrayList<DetallePedido>();
        listaDetalle.add(nuevoDetalle);
        listaDetalle.add(nuevoDetalleDos);
        
        detalleTest.actualizarDetalle(listaDetalle, 0);
        detalleTest.crearDetalle(listaDetalle, 0);
        detalleTest.eliminarDetalle(0);
        detalleTest.listarDetalle(0);
        
        //-------------------------------------
        EmpleadoRunImplementado testEmpleadoDao = new EmpleadoRunImplementado();
        
        EmpleadoRun nuevoEmpleado = new EmpleadoRun();
        nuevoEmpleado.setComuna("");
        nuevoEmpleado.setCorreoElectronico("");
        nuevoEmpleado.setDireccion("");
        //nuevoEmpleado.setFechaContrato("");
        //nuevoEmpleado.setFechaNacimiento(fechaNacimiento);
        nuevoEmpleado.setGenero("");
        nuevoEmpleado.setNombre("");
        nuevoEmpleado.setNumeroTelefonico(0);
        nuevoEmpleado.setPassword("");
        nuevoEmpleado.setProvincia("");
        nuevoEmpleado.setRegion("");
        nuevoEmpleado.setRun("");
        nuevoEmpleado.setSueldoBruto(0);
        nuevoEmpleado.setSueldoLiquido(0);
        nuevoEmpleado.setTipo("");
        
        //Pruebas DAO Empleado
        testEmpleadoDao.almacenarEmpleado(nuevoEmpleado);
        testEmpleadoDao.eliminarEmpleado(nuevoEmpleado);
        testEmpleadoDao.listarEmpleados();
        testEmpleadoDao.modificarEmpleado(nuevoEmpleado);
        
        //----------------------------------------------
        EstadoDAOImplementado testEstado = new EstadoDAOImplementado();
        
        EstadoPedido nuevoEstado = new EstadoPedido();
        nuevoEstado.setIdEstado(0);
        nuevoEstado.setEstado("");
        
        //Pruebas DAO Estado
        testEstado.crearEstado(nuevoEstado);
        testEstado.eliminarEstado(0);
        testEstado.listarEstados();
        testEstado.modificarEstado(nuevoEstado);
        
        //----------------------------------------------
        PedidoDAOImplementado testPedido = new PedidoDAOImplementado();
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setCliente(nuevoCliente);
        nuevoPedido.setComentario("");
        nuevoPedido.setDetallePedido(listaDetalle);
        nuevoPedido.setFechaHoraPedido("");
        nuevoPedido.setFormaEntrega("");
        nuevoPedido.setId(0);
        nuevoPedido.setIdEstado(0);
        nuevoPedido.setTotalVenta(0);
    }
    
    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            
            char dv = rut.charAt(rut.length() - 1);
            
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }            
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Error en formato");
        } catch (Exception e) {
            System.out.println("Excepción no identificada en validación de rut");
        }
        return validacion;
    }
    
    private static final String PATRON_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    /**
     * Validate given email with regular expression.
     * 
     * @param email
     *            email for validation
     * @return true valid email, otherwise false
     */
    public static boolean validarEMail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATRON_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches(); 
    }
}
