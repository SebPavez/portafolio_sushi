package aplicacion;

import java.util.ArrayList;
import negocio.*;
import dao.*;
import utilidades.*;

public class Pruebas {

    public void pruebasCliente() {
        ClienteDaoImplementado testCliente = new ClienteDaoImplementado();

        //Objeto Cliente para prueba
        Cliente nuevoCliente = new Cliente();

        nuevoCliente.setNombreCompleto("Sebastián");

        if (Utilidades.validarRut("17706258-8")) {
            nuevoCliente.setClienteRun("17706258-8");
        }
        if (Utilidades.validarEMail("seb.pavez@alumnos.duoc.cl")) {
            nuevoCliente.setCorreoElectronico("seb.pavez@alumnos.duoc.cl");
        }
        nuevoCliente.setNumeroTelefonico("+56956669308");
        if ("pecopeco".length() > 7) {
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
        if (testCliente.almacenarCliente(nuevoCliente)) {
            System.out.println("Ingresado con éxito");
        }
        ArrayList<Cliente> lista = testCliente.listarClientes();
        for (Cliente cliente : lista) {
            System.out.println(cliente.toString());

        }

        nuevoCliente.setNombreCompleto("Juanito");

        if (testCliente.modificarCliente(nuevoCliente)) {
            System.out.println("Modificado");
        }

        if (testCliente.eliminarCliente(nuevoCliente.getClienteRun())) {
            System.out.println("Eliminado");
        }

    }

    public void pruebasProducto() {

        Producto producto = new Producto();
        producto.setCategoriaProducto("roll");
        producto.setDescripcion("descripcion del producto :D");
        producto.setEn_oferta(Boolean.TRUE);
        producto.setNombre("california roll");
        producto.setPrecio_normal(10000);
        producto.setPrecio_oferta(7000);
        producto.setStock(50);

        Producto productoDos = new Producto();
        productoDos.setCategoriaProducto("promo");
        productoDos.setDescripcion("descripcion");
        productoDos.setEn_oferta(Boolean.FALSE);
        productoDos.setNombre("california");
        productoDos.setPrecio_normal(10000);
        productoDos.setPrecio_oferta(7000);
        productoDos.setStock(50);
        productoDos.setIdProducto(22);

        ProductoDaoImplementado testProducto = new ProductoDaoImplementado();

        if (testProducto.agregarProducto(producto)) {
            System.out.println("Agregado");
        }

        if (testProducto.actualizarProducto(productoDos)) {
            System.out.println("Actualizado");
        }
        
        System.out.println(testProducto.buscarProducto(22).toString());
        if(testProducto.eliminarProducto(24))
            System.out.println("Eliminado");
        else
            System.out.println("No eliminado");
        
        ArrayList<Producto> listado = testProducto.listarProductos();
        for (Producto producto1 : listado) {
            System.out.println(producto1.toString());
        }

    }

    public void pruebasDetalle() {
        Producto producto = new Producto();
        producto.setCategoriaProducto("");
        producto.setDescripcion("");
        producto.setEn_oferta(Boolean.TRUE);
        producto.setIdProducto(0);
        producto.setNombre("");
        producto.setPrecio_normal(0);
        producto.setPrecio_oferta(0);
        producto.setStock(0);
        producto.setIdProducto(27);

        Producto productoDos = new Producto();
        productoDos.setCategoriaProducto("");
        productoDos.setDescripcion("");
        productoDos.setEn_oferta(Boolean.TRUE);
        productoDos.setIdProducto(0);
        productoDos.setNombre("");
        productoDos.setPrecio_normal(0);
        productoDos.setPrecio_oferta(0);
        productoDos.setStock(0);
        productoDos.setIdProducto(22);
        

        DetalleDAOImplementado detalleTest = new DetalleDAOImplementado();

        DetallePedido nuevoDetalle = new DetallePedido();
        nuevoDetalle.setIdPedido(22);
        nuevoDetalle.setCantidad(1);
        nuevoDetalle.setProducto(producto);
        nuevoDetalle.setTotalDetalle(2);

        DetallePedido nuevoDetalleDos = new DetallePedido();
        nuevoDetalleDos.setIdPedido(22);
        nuevoDetalleDos.setCantidad(1);
        nuevoDetalleDos.setProducto(productoDos);
        nuevoDetalle.setTotalDetalle(2);

        ArrayList<DetallePedido> listaDetalle = new ArrayList<DetallePedido>();
        listaDetalle.add(nuevoDetalle);
        listaDetalle.add(nuevoDetalleDos);

        
        if(detalleTest.crearDetalle(listaDetalle, 1))
            System.out.println("agregado");
       // detalleTest.eliminarDetalle(0);
       //detalleTest.listarDetalle(0);
       // detalleTest.actualizarDetalle(listaDetalle, 0);

    }

    public void pruebasEmpleado() {

        //-------------------------------------
        EmpleadoRunImplementado testEmpleadoDao = new EmpleadoRunImplementado();

        EmpleadoRun nuevoEmpleado = new EmpleadoRun();
        nuevoEmpleado.setComuna("La Cisterna");
        if (Utilidades.validarEMail("empleado@sushi.cl")) {
            nuevoEmpleado.setCorreoElectronico("empleado@sushi.cl");
        }
        nuevoEmpleado.setDireccion("Pedro Prado #431");
        nuevoEmpleado.setFechaContrato("21/09/2016");
        nuevoEmpleado.setFechaNacimiento("09/10/1995");
        nuevoEmpleado.setGenero("Femenino");
        nuevoEmpleado.setNombre("Davida");
        nuevoEmpleado.setNumeroTelefonico("555-5555rriente");
        nuevoEmpleado.setPassword("alfilareina4");
        nuevoEmpleado.setProvincia("Santiago");
        nuevoEmpleado.setRegion("Metropolitana");
        if (Utilidades.validarRut("17.706.258-8")) {
            nuevoEmpleado.setRun("5.555.555-5");
        }
        nuevoEmpleado.setSueldoBruto(222222);
        nuevoEmpleado.setSueldoLiquido(200000);
        nuevoEmpleado.setTipo("Practicante");

        //Pruebas DAO 
        if (testEmpleadoDao.almacenarEmpleado(nuevoEmpleado)) {
            System.out.println("Almacenado");
        }

        nuevoEmpleado.setNombre("NombreNuevo");

        ArrayList<EmpleadoRun> listaEmpleado = testEmpleadoDao.listarEmpleados();
        for (EmpleadoRun empleadoRun : listaEmpleado) {
            System.out.println(empleadoRun.toString());
        }

        if (testEmpleadoDao.modificarEmpleado(nuevoEmpleado)) {
            System.out.println("Modificado");
        }

        listaEmpleado = testEmpleadoDao.listarEmpleados();
        for (EmpleadoRun empleadoRun : listaEmpleado) {
            System.out.println(empleadoRun.toString());
        }

        if (testEmpleadoDao.eliminarEmpleado(nuevoEmpleado.getRun())) {
            System.out.println("Eliminado");
        }

    }

    public void pruebasEstado() {

        //----------------------------------------------
        EstadoDAOImplementado testEstado = new EstadoDAOImplementado();

        EstadoPedido nuevoEstado = new EstadoPedido();
        nuevoEstado.setEstado("rechazado");
        nuevoEstado.setIdEstado(2);
       //Pruebas DAO Estado
        if(testEstado.crearEstado(nuevoEstado));
          System.out.println("Agregado");
 
          if(testEstado.eliminarEstado(1));
          System.out.println("Eliminado");
        System.out.println(testEstado.listarEstados());
        if(testEstado.modificarEstado(nuevoEstado))
            System.out.println("Editado");
    }

    public void pruebasPedido() {
        Producto producto = new Producto();
        producto.setCategoriaProducto("promo");
        producto.setDescripcion("descripcion producto 1");
        producto.setEn_oferta(true);
        producto.setIdProducto(1);
        producto.setNombre("Nombre");
        producto.setPrecio_normal(100);
        producto.setPrecio_oferta(50);
        producto.setStock(51);
        producto.setIdProducto(99);
        
        Producto productoDos = new Producto();
        productoDos.setCategoriaProducto("roll");
        productoDos.setDescripcion("un nuevo roll");
        productoDos.setEn_oferta(false);
        productoDos.setIdProducto(0);
        productoDos.setNombre("roll california");
        productoDos.setPrecio_normal(1000);
        productoDos.setPrecio_oferta(500);
        productoDos.setStock(100);
        productoDos.setIdProducto(200);
       

        DetallePedido nuevoDetalle = new DetallePedido();
        nuevoDetalle.setCantidad(15);
        nuevoDetalle.setProducto(producto);
        nuevoDetalle.setTotalDetalle(nuevoDetalle.getProducto().getPrecio_normal()*nuevoDetalle.getCantidad());

        DetallePedido nuevoDetalleDos = new DetallePedido();
        nuevoDetalleDos.setCantidad(1);
        nuevoDetalleDos.setProducto(productoDos);
        nuevoDetalle.setTotalDetalle(nuevoDetalle.getProducto().getPrecio_normal()*nuevoDetalle.getCantidad());

        ArrayList<DetallePedido> listaDetalle = new ArrayList<DetallePedido>();
        listaDetalle.add(nuevoDetalle);
        listaDetalle.add(nuevoDetalleDos);
        
        
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setClienteRun("17706258-8");
        nuevoCliente.setComuna("Pudahuel");
        nuevoCliente.setCorreoElectronico("seb.pavez@gmail.com");
        nuevoCliente.setDireccion("Marta burnet 123");
        nuevoCliente.setFechaNacimiento("16/11/1990");
        nuevoCliente.setGenero("masculino");
        nuevoCliente.setNombreCompleto("Sebastián Eduardo Pavez Morales");
        nuevoCliente.setNumeroTelefonico("+56956669308");
        nuevoCliente.setPassword("pecopeco");
        nuevoCliente.setProvincia("Santiago");
        nuevoCliente.setRegion("Metropolitana");

        PedidoDAOImplementado testPedido = new PedidoDAOImplementado();
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setCliente(nuevoCliente);
        nuevoPedido.setComentario("comentario");
        nuevoPedido.setDetallePedido(listaDetalle);
        nuevoPedido.setFechaHoraPedido("");
        nuevoPedido.setFormaEntrega("quiero comida");
        nuevoPedido.setId(6);
        nuevoPedido.setIdEstado(2);
        nuevoPedido.setTotalVenta(0);
        
        
        
        DetalleDAOImplementado detalleTest = new DetalleDAOImplementado();
        
        if(testPedido.crearPedido(nuevoPedido)>0)
            System.out.println("Pedido Agregado"); 
        
        if(detalleTest.crearDetalle(listaDetalle, 6))
            System.out.println("Detalle agregado");        
        
        nuevoPedido.setComentario("nuevoComentario");
        
        if(testPedido.actualizarPedido(nuevoPedido))
            System.out.println("comentario pedido editado");
        
        if(detalleTest.actualizarDetalle(listaDetalle, 6))        
            System.out.println("detalle actualizado");
        
        System.out.println("------------prueba listado detalle--------------");
        
        ArrayList<DetallePedido> listadoDetalleTest = detalleTest.listarDetalle(6);
        
        for (DetallePedido detallePedido : listadoDetalleTest) {
            System.out.println(detallePedido.toString());
        }
        
        System.out.println("PEDIDO BUSCADO: "+testPedido.buscarPedido(6).toString());
        
                
        if(detalleTest.eliminarDetalle(6))
            System.out.println("Detalle eliminado");
            
        if(testPedido.eliminarPedido(6))
            System.out.println("Eliminado");
        
    }
    
    public void pruebasCategoria (){
        
        String categoria ="Bebidas";
        
        
        CategoriaProductoDaoImplementado testCategoria = new CategoriaProductoDaoImplementado();
//        if(testCategoria.agregarCategoria(categoria))
//            System.out.println("Agregado");
//        
//        if(testCategoria.eliminarCategoria("Bebidas"))
//            System.out.println("Eliminado");
        
        ArrayList<CategoriaProducto> listado = testCategoria.listarCategoria();
            for (CategoriaProducto producto1 : listado) {
            System.out.println(producto1);
        }
    }

}
