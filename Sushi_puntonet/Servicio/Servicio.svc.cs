using System;
using System.Collections.Generic;
using System.Linq;
using System.Data.Entity;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Reflection;
using Negocio;
using DAL;

namespace Servicio
{
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
                    }
                }
                catch (Exception)
                {
                    resultado = false;
                }
            }
            return resultado;
        }

        //TO_DO
        public bool GenerarPedido(Negocio.Pedido nuevoPedido)
        {
            if (nuevoPedido != null)
            {
                try
                {
                    using (Entidades contexto = new Entidades())
                    {
                        DAL.PEDIDO pedidoDAL = new DAL.PEDIDO();
                        pedidoDAL.RUN_CLIENTE = nuevoPedido.RunCliente;
                        pedidoDAL.FORMA_ENTREGA = nuevoPedido.FormaEntrega;
                        pedidoDAL.COMENTARIO = nuevoPedido.Comentario;
                        pedidoDAL.TOTAL_VENTA = (decimal) nuevoPedido.TotalVenta;
                        pedidoDAL.FECHA_HORA = DateTime.Now;                                                   
                        contexto.AddToPEDIDOes(pedidoDAL);
                        contexto.SaveChanges();
                        foreach (Negocio.DetallePedido item in nuevoPedido.DetallePedido)
                        {
                            DAL.DETALLE_PEDIDO nuevoDetalle = new DAL.DETALLE_PEDIDO();
                            nuevoDetalle.ID_PRODUCTO = item.IdDetalle;
                            nuevoDetalle.CANTIDAD = item.Cantidad;
                            nuevoDetalle.ID_PEDIDO = pedidoDAL.ID_PEDIDO;
                            contexto.AddToDETALLE_PEDIDO(nuevoDetalle);
                        }
                        contexto.SaveChanges();
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
                        //producto.LinkInternet = item.
                        listaResultado.Add(producto);
                    }

                }
                return listaResultado;

            }
            catch (Exception)
            {
                return listaResultado;
            }
        }

    }
}
