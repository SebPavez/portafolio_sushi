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

        [OperationContract]
        bool EditarUsuario(Cliente clienteEditado);

        [OperationContract]
        bool EliminarUsuario(string runCliente);

        [OperationContract]
        bool AutenticarCliente(string correo, string password);

        [OperationContract]
        bool AnularPedido(int idPedido);

        [OperationContract]
        bool GenerarPedido(Pedido nuevoPedido);

        [OperationContract]
        bool ListarProductos(Pedido listarProducto);

    }
    
}
