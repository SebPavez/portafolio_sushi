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

        public bool ListarProductos(Pedido listarProducto)
        {
            try
            {
                using (Entidades contexto = new Entidades())
                {
                    IQueryable<PRODUCTO> productsQuery = from producto in contexto.PRODUCTOes
                                                         select producto;

                    List<PRODUCTO> lista = productsQuery.ToList();

                }
                return true;

            }
            catch (Exception)
            {
                return false;
            }
        }

    }
}
