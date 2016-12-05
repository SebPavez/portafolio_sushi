using System;
using System.Collections.Generic;
using System.Linq;
using System.Data.Entity;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using Negocio;
using DAL;
using System.ServiceModel.Activation;

namespace Servicio
{
    [AspNetCompatibilityRequirements(RequirementsMode = AspNetCompatibilityRequirementsMode.Allowed)]
    public class Servicio : IServicio
    {        
        public bool RegistrarUsuario(Negocio.Cliente nuevoCliente)
        {
            try
            {
                using (Entidades contexto = new Entidades())
                {
                    DAL.CLIENTE clienteDal = new DAL.CLIENTE();
                    clienteDal.CLIENTE_RUN = nuevoCliente.Run;
                    clienteDal.NOMBRE_COMPLETO = nuevoCliente.NombreCompleto;
                    clienteDal.DIRECCION = nuevoCliente.Direccion;
                    clienteDal.COMUNA = nuevoCliente.Comuna;
                    clienteDal.PROVINCIA = nuevoCliente.Provincia;
                    clienteDal.REGION = nuevoCliente.Region;
                    clienteDal.FECHA_NACIMIENTO = nuevoCliente.FechaNacimiento;
                    clienteDal.GENERO = nuevoCliente.Genero;
                    clienteDal.CORREO_ELECTRONICO = nuevoCliente.Email;
                    clienteDal.NUMERO_TELEFONICO = nuevoCliente.NumeroTelefonico;
                    clienteDal.PASSWORD = nuevoCliente.Password;
                    contexto.AddToCLIENTEs(clienteDal);
                    contexto.SaveChanges();
                    contexto.Dispose();
                }
                return true;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public bool EditarUsuario(Negocio.Cliente clienteEditado)
        {
            try
            {
                using (Entidades contexto = new Entidades())
                {
                    DAL.CLIENTE clienteEditar = contexto.CLIENTEs.Where(p => p.CLIENTE_RUN == clienteEditado.Run).First();
                    clienteEditar.NOMBRE_COMPLETO = clienteEditado.NombreCompleto;
                    clienteEditar.DIRECCION = clienteEditado.Direccion;
                    clienteEditar.COMUNA = clienteEditado.Comuna;
                    clienteEditar.PROVINCIA = clienteEditado.Provincia;
                    clienteEditar.REGION = clienteEditado.Region;
                    clienteEditar.FECHA_NACIMIENTO = clienteEditado.FechaNacimiento;
                    clienteEditar.GENERO = clienteEditado.Genero;
                    clienteEditar.CORREO_ELECTRONICO = clienteEditado.Email;
                    clienteEditar.NUMERO_TELEFONICO = clienteEditado.NumeroTelefonico;
                    clienteEditar.PASSWORD = clienteEditado.Password;
                    contexto.SaveChanges();
                    contexto.Dispose();
                    return true;
                }
            }
            catch (Exception)
            {
                return false;
            }
        }

        public bool EliminarUsuario(string runCliente)
        {
            try
            {
                using (Entidades contexto = new Entidades())
                {
                    contexto.DeleteObject(contexto.CLIENTEs.Where(p => p.CLIENTE_RUN == runCliente).First());
                    contexto.SaveChanges();
                    contexto.Dispose();
                }
                return true;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public bool AutenticarCliente(string correo, string password)
        {
            bool resultado = false;
            try
            {
                if (correo != null && password != null)
                {
                    using (Entidades contexto = new Entidades())
                    {
                        CLIENTE cliente = contexto.CLIENTEs.Where(p => p.CORREO_ELECTRONICO == correo && p.PASSWORD == password).First();
                        if (cliente != null)
                            resultado = true;
                    }
                }
                return resultado;
            }
            catch (Exception)
            {
                return resultado;
            }
        }

        public bool AnularPedido(int idPedido)
        {
            bool resultado = false;
            if (idPedido != 0)
            {
                try
                {
                    using (Entidades contexto = new Entidades())
                    {
                        PEDIDO pedido = contexto.PEDIDOes.Where(p => p.ID_PEDIDO == idPedido).First();
                        if (pedido != null)
                        {
                            pedido.ID_ESTADO = (decimal)Estado.ANULADO;
                            contexto.SaveChanges();
                            resultado = true;
                        }
                        contexto.Dispose();
                    }
                }
                catch (Exception)
                {
                    resultado = false;
                }
            }
            return resultado;
        }

        public bool GenerarPedido(Negocio.Pedido nuevoPedido)
        {
            if (nuevoPedido != null)
            {
                try
                {
                    using (Entidades contexto = new Entidades())
                    {
                        System.Data.Objects.ObjectParameter id_salida = new System.Data.Objects.ObjectParameter("ID_SALIDA", typeof(int?));                        
                        
                        contexto.INSERTARPEDIDO(nuevoPedido.FormaEntrega, nuevoPedido.Comentario, (decimal?)nuevoPedido.TotalVenta, nuevoPedido.RunCliente, 1, id_salida);
                        decimal? idAdquirido = Decimal.ToInt32((decimal)id_salida.Value);
                        foreach (Negocio.DetallePedido item in nuevoPedido.DetallePedido)
                        {                            
                            contexto.INSERTARDETALLEPEDIDO(idAdquirido, (decimal?) item.Producto.IdProducto, (decimal?)item.Cantidad);
                            
                        }                        
                        contexto.Dispose();
                    }
                    return true;
                }
                catch (Exception)
                {
                    return false;
                }
            }
            else
                return false;
        }

        public List<Negocio.Producto> ListarProductos()
        {
            List<Negocio.Producto> listaResultado = new List<Producto>();
            try
            {
                using (Entidades contexto = new Entidades())
                {
                    List<DAL.PRODUCTO> lista = contexto.PRODUCTOes.ToList<DAL.PRODUCTO>();
                    
                    foreach (DAL.PRODUCTO item in lista)
                    {
                        Negocio.Producto producto = new Negocio.Producto();
                        producto.IdProducto = (int)item.ID_PRODUCTO;
                        producto.Nombre = item.NOMBRE;
                        producto.PrecioNormal = (int)item.PRECIO_NORMAL;
                        producto.PrecioOferta = (int)item.PRECIO_OFERTA;
                        producto.EnOferta = item.EN_OFERTA;
                        producto.Descripcion = item.DESCRIPCION;
                        producto.Categoria = item.CATEGORIA_PRODUCTO.CATEGORIA;
                        listaResultado.Add(producto);                        
                    }
                    contexto.Dispose();
                }
                return listaResultado;
                

            }
            catch (Exception)
            {
                return listaResultado;
            }
        }

        //TO_DO
        public List<Negocio.Pedido> ListarHistorial(string runCliente) {
            List<Negocio.Pedido> listaRetorno = new List<Pedido>();
            try
            {
                using (DAL.Entidades contexto = new DAL.Entidades()) {
                    List<DAL.PEDIDO> pedidosEnBD = contexto.PEDIDOes.Where(obj => obj.RUN_CLIENTE == runCliente).ToList<DAL.PEDIDO>();
                    foreach (DAL.PEDIDO item in pedidosEnBD)
                    {
                        Negocio.Pedido elementoAResultado = new Negocio.Pedido();
                        elementoAResultado.IdPedido = Decimal.ToInt32(item.ID_PEDIDO);
                        elementoAResultado.FormaEntrega = item.FORMA_ENTREGA;
                        elementoAResultado.Comentario = item.COMENTARIO;
                        elementoAResultado.TotalVenta = Decimal.ToInt32(item.TOTAL_VENTA);
                        elementoAResultado.FechaHoraPedido = item.FECHA_HORA;
                        elementoAResultado.RunCliente = item.RUN_CLIENTE;
                        elementoAResultado.Estado = Decimal.ToInt32(item.ESTADO_PEDIDO.ID_ESTADO);
                        //no se agrega el detalle del pedido
                        listaRetorno.Add(elementoAResultado);
                    }

                }
            }
            catch (Exception)
            {                
                throw;
            }
            return listaRetorno;
        }

        //TO_DO
        public Negocio.Cliente RecuperarUsuario(string correo) {
            return new Negocio.Cliente();
        }

        public Negocio.Producto BuscarProductoID(int id) {
            Negocio.Producto producto = new Negocio.Producto();
            try
            {
                using (Entidades contexto = new Entidades()) 
                {
                    var salida = (from b in contexto.PRODUCTOes
                                  where b.ID_PRODUCTO == id
                                  select b).FirstOrDefault();
                    producto.IdProducto = (int)salida.ID_PRODUCTO;
                    producto.Stock = (int)salida.STOCK;
                    producto.Nombre = salida.NOMBRE;
                    producto.PrecioNormal = (int)salida.PRECIO_NORMAL;
                    producto.PrecioOferta = (int)salida.PRECIO_OFERTA;
                    producto.EnOferta = salida.EN_OFERTA;
                    producto.Descripcion = salida.DESCRIPCION;
                    producto.Categoria = salida.CATEGORIA.ToString();
                    producto.LinkInternet = salida.LINK_INTERNET;
                }
                return producto;
            }
            catch (Exception)
            {

                return producto;
            }
        }
        

        public string RecuperarRUNCliente(string correo)
        {
            string run = "";
            try
            {
                using (DAL.Entidades contexto = new DAL.Entidades()) {                    
                    DAL.CLIENTE encontrado = contexto.CLIENTEs.First(obj => obj.CORREO_ELECTRONICO == correo);
                    run = encontrado.CLIENTE_RUN;                    
                }

            }
            catch (Exception)
            {
                run = "";                  
            }            
            return run;
        }
    }
}
