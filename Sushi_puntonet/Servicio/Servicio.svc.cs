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
            if (nuevoCliente == null)
            {
                return false;
            }
            else
            {
                if(IsAnyNullOrEmpty(nuevoCliente))
                    return false;
                else{
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
            }
        }        

        public bool EditarUsuario(Cliente clienteEditado)
        {
            throw new NotImplementedException();
        }

        public bool EliminarUsuario(string runCliente)
        {
            throw new NotImplementedException();
        }

        public bool AutenticarCliente(string correo, string password)
        {
            throw new NotImplementedException();
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
