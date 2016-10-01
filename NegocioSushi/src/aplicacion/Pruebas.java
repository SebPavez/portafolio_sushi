package aplicacion;


import java.util.ArrayList;
import negocio.*;
import dao.*;
import utilidades.*;

public class Pruebas {
    public void pruebasCliente(){
        ClienteDaoImplementado testCliente = new ClienteDaoImplementado();
        
        //Objeto Cliente para prueba
        Cliente nuevoCliente = new Cliente();
        
        nuevoCliente.setNombreCompleto("");
        
        if(Utilidades.validarRut("")){
            nuevoCliente.setClienteRun("");
        }        
        if(Utilidades.validarEMail("")){
            nuevoCliente.setCorreoElectronico("");
        }
        nuevoCliente.setNumeroTelefonico("");
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
        
    }
    
    public void pruebasProducto(){
        
        //--------------------------------------------
        
        Producto producto = new Producto();
        Producto productoDos = new Producto();
    }
    
    public void pruebasDetalle(){
        Producto producto = new Producto();
        producto.setCategoriaProducto("");
        producto.setDescripcion("");
        producto.setEn_oferta(Boolean.TRUE);
        producto.setIdProducto(0);
        producto.setNombre("");
        producto.setPrecio_normal(0);
        producto.setPrecio_oferta(0);
        producto.setStock(0);
        
        Producto productoDos = new Producto();
        productoDos.setCategoriaProducto("");
        productoDos.setDescripcion("");
        productoDos.setEn_oferta(Boolean.TRUE);
        productoDos.setIdProducto(0);
        productoDos.setNombre("");
        productoDos.setPrecio_normal(0);
        productoDos.setPrecio_oferta(0);
        productoDos.setStock(0);
        
        
        
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
        
    }
    
    public void pruebasEmpleado(){
        
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
        nuevoEmpleado.setNumeroTelefonico("");
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
        
    }
    
    public void pruebasEstado(){
        
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
    }
    
    public void pruebasPedido(){
        Producto producto = new Producto();
        producto.setCategoriaProducto("");
        producto.setDescripcion("");
        producto.setEn_oferta(Boolean.TRUE);
        producto.setIdProducto(0);
        producto.setNombre("");
        producto.setPrecio_normal(0);
        producto.setPrecio_oferta(0);
        producto.setStock(0);
        
        Producto productoDos = new Producto();
        productoDos.setCategoriaProducto("");
        productoDos.setDescripcion("");
        productoDos.setEn_oferta(Boolean.TRUE);
        productoDos.setIdProducto(0);
        productoDos.setNombre("");
        productoDos.setPrecio_normal(0);
        productoDos.setPrecio_oferta(0);
        productoDos.setStock(0);      
                
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
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setClienteRun("");
        nuevoCliente.setComuna("");
        nuevoCliente.setCorreoElectronico("");
        nuevoCliente.setDireccion("");
        nuevoCliente.setFechaNacimiento("");
        nuevoCliente.setGenero("");
        nuevoCliente.setNombreCompleto("");
        nuevoCliente.setNumeroTelefonico("");
        nuevoCliente.setPassword("");
        nuevoCliente.setProvincia("");
        nuevoCliente.setRegion("");
        
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
    
            
}
