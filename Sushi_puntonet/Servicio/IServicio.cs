using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using Negocio;

namespace Servicio
{    
    [ServiceContract]
    public interface IServicio
    {
        [OperationContract]
        bool RegistrarUsuario(Cliente nuevoCliente);
        bool EditarUsuario(Cliente clienteEditado);
        bool EliminarUsuario(string runCliente);
        bool AutenticarCliente(string correo, string password);
        bool AnularPedido(int idPedido);
        bool GenerarPedido(Pedido nuevoPedido);

    }
    
}
