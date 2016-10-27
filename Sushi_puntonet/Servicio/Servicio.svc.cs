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
        public bool RegistrarUsuario(Cliente nuevoCliente)
        {
            try{
                using (Entidades contexto = new Entidades())
                {
                    DAL.CLIENTE ClienteDal = new DAL.CLIENTE();
                    ClienteDal.CLIENTE_RUN = nuevoCliente.Run;
                    ClienteDal.NOMBRE_COMPLETO = nuevoCliente.NombreCompleto;
                    ClienteDal.DIRECCION = nuevoCliente.Direccion;
                    ClienteDal.COMUNA = nuevoCliente.Comuna;
                    ClienteDal.PROVINCIA = nuevoCliente.Provincia;
                    ClienteDal.REGION = nuevoCliente.Region;
                    ClienteDal.FECHA_NACIMIENTO = nuevoCliente.FechaNacimiento;
                    ClienteDal.GENERO = nuevoCliente.Genero;
                    ClienteDal.CORREO_ELECTRONICO = nuevoCliente.Email;
                    ClienteDal.NUMERO_TELEFONICO = nuevoCliente.NumeroTelefonico;
                    ClienteDal.PASSWORD = nuevoCliente.Password;
                    contexto.AddToCLIENTEs(ClienteDal);
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

        public bool EditarUsuario(Cliente clienteEditado)
        {
            throw new NotImplementedException();
        }

        public bool EliminarUsuario(string runCliente)
        {
            try
            {
                using (Entidades contexto = new Entidades()) {
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
            if (correo != null && password != null) {
                using (Entidades contexto = new Entidades()) {
                    CLIENTE cliente = contexto.CLIENTEs.Where(p => p.CORREO_ELECTRONICO == correo && p.PASSWORD == password).First();
                    if(cliente!=null)
                        resultado = true;
                }
            }
            return resultado;
            
        }

        public bool AnularPedido(int idPedido)
        {
            bool resultado = false;
            if (idPedido != null) {
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

        public bool GenerarPedido(Pedido nuevoPedido)
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

        bool IsAnyNullOrEmpty(object myObject)
        {
            foreach (PropertyInfo pi in myObject.GetType().GetProperties())
            {
                if (pi.PropertyType == typeof(string))
                {
                    string value = (string)pi.GetValue(myObject, null);
                    if (string.IsNullOrEmpty(value))
                    {
                        return true;
                    }
                }
                else if (pi.PropertyType == typeof(DateTime))
                {
                    DateTime valor = (DateTime)pi.GetValue(myObject, null);
                    if (valor == null)
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        
    }
}
