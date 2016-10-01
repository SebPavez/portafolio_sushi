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
        
        nuevoCliente.setNombreCompleto("Sebastián");
        
        if(Utilidades.validarRut("17706258-8")){
            nuevoCliente.setClienteRun("17706258-8");
        }        
        if(Utilidades.validarEMail("seb.pavez@alumnos.duoc.cl")){
            nuevoCliente.setCorreoElectronico("seb.pavez@alumnos.duoc.cl");
        }
        nuevoCliente.setNumeroTelefonico("+56956669308");
        if("pecopeco".length()>7){
            nuevoCliente.setPassword("pecopeco");        
        }
        
        nuevoCliente.setDireccion("Cassiopeia #5390");
        
        //Campo date puede resultar algo complicado de ingresar a la BD
        nuevoCliente.setFechaNacimiento("16/11/1990");
        
        nuevoCliente.setGenero("Másculino");
        
        //Existe la posibilidad de que cualquier String se pueda pasar como locación
        nuevoCliente.setComuna("Pudahuel");
        nuevoCliente.setProvincia("Santiago");
        nuevoCliente.setRegion("Metropolitana");
               
        //Pruebas ClienteDao
        if(testCliente.almacenarCliente(nuevoCliente)){
            System.out.println("Ingresado con éxito");
        }
        ArrayList<Cliente> lista = testCliente.listarClientes();
        for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
            
        }
        
        nuevoCliente.setNombreCompleto("Juanito");
        
        if(testCliente.modificarCliente(nuevoCliente))
            System.out.println("Modificado");
        
        if(testCliente.eliminarCliente(nuevoCliente))
            System.out.println("Eliminado");
        
        
        
    }
    
    public void pruebasProducto(){
        
        Producto producto = new Producto();
        producto.setCategoriaProducto("roll");
        producto.setDescripcion("descripcion del producto :D");
        producto.setEn_oferta(Boolean.TRUE);        
        producto.setNombre("california roll");
        producto.setPrecio_normal(10000);
        producto.setPrecio_oferta(7000);
        producto.setStock(50);
        
        Producto productoDos = new Producto();
        productoDos.setCategoriaProducto("Promo");
        productoDos.setDescripcion("descripcion del producto :D");
        productoDos.setEn_oferta(Boolean.TRUE);        
        productoDos.setNombre("california roll");
        productoDos.setPrecio_normal(10000);
        productoDos.setPrecio_oferta(7000);
        productoDos.setStock(50);
        
        ProductoDaoImplementado testProducto = new ProductoDaoImplementado();
        
        if(testProducto.agregarProducto(producto))
            System.out.println("Agregado");
        
        ArrayList<Producto> listado = testProducto.listarProductos();
        for (Producto producto1 : listado) {
            System.out.println(producto1.toString());
        }
        
        if(testProducto.actualizarProducto(producto))
            System.out.println("Actualizado");
        
        testProducto.buscarProducto(1).toString();
        
        listado = testProducto.listarPorCategoria("roll");
        for (Producto producto1 : listado) {
            System.out.println(producto1.toString());
        }
        
        testProducto.eliminarProducto(1);
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
        nuevoEmpleado.setComuna("La Cisterna");
        if(Utilidades.validarEMail("empleado@sushi.cl"))
            nuevoEmpleado.setCorreoElectronico("empleado@sushi.cl");
        nuevoEmpleado.setDireccion("Pedro Prado #431");
        nuevoEmpleado.setFechaContrato("21/09/2016");
        nuevoEmpleado.setFechaNacimiento("09/10/1995");
        nuevoEmpleado.setGenero("Femenino");
        nuevoEmpleado.setNombre("Davida");
        nuevoEmpleado.setNumeroTelefonico("555-5555rriente");
        nuevoEmpleado.setPassword("alfilareina4");
        nuevoEmpleado.setProvincia("Santiago");
        nuevoEmpleado.setRegion("Metropolitana");
        if(Utilidades.validarRut("17.706.258-8"))
            nuevoEmpleado.setRun("5.555.555-5");
        nuevoEmpleado.setSueldoBruto(222222);
        nuevoEmpleado.setSueldoLiquido(200000);
        nuevoEmpleado.setTipo("Practicante");
        
        //Pruebas DAO 
        if(testEmpleadoDao.almacenarEmpleado(nuevoEmpleado))
            System.out.println("Almacenado");
        
        nuevoEmpleado.setNombre("NombreNuevo");
        
        ArrayList<EmpleadoRun> listaEmpleado = testEmpleadoDao.listarEmpleados();
        for (EmpleadoRun empleadoRun : listaEmpleado) {
            System.out.println(empleadoRun.toString());
        }
        
        if(testEmpleadoDao.modificarEmpleado(nuevoEmpleado))
            System.out.println("Modificado");
        
        listaEmpleado = testEmpleadoDao.listarEmpleados();
        for (EmpleadoRun empleadoRun : listaEmpleado) {
            System.out.println(empleadoRun.toString());
        }
        
        if(testEmpleadoDao.eliminarEmpleado(nuevoEmpleado))
            System.out.println("Eliminado");
        
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
