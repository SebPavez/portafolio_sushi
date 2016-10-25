using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using Negocio;
using DAL;

namespace Servicio
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    public class Servicio : IServicio
    {        
        public bool registrarUsuario(Cliente nuevoCliente)
        {
            bool resultado;
            if (nuevoCliente == null)
            {
                return false;
            }
            else
            {
                resultado = nuevoCliente.RegistrarCliente();
            }
            return resultado;
            
        }
    }
}
