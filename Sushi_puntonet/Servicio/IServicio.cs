using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace Servicio
{    
    [ServiceContract]
    public interface IServicio
    {
        [OperationContract]
        bool RegistrarUsuario(Negocio.Cliente nuevoCliente);

        [OperationContract]
        bool EditarUsuario(Negocio.Cliente clienteEditado);

        [OperationContract]
        bool EliminarUsuario(string runCliente);

        [OperationContract]
        bool AutenticarCliente(string correo, string password);

        [OperationContract]
        bool AnularPedido(int idPedido);

        [OperationContract]
        bool GenerarPedido(Negocio.Pedido nuevoPedido);

        [OperationContract]
        List<Negocio.Producto> ListarProductos();

        [OperationContract]
        List<Negocio.Pedido> ListarHistorial();

        [OperationContract]
        Negocio.Cliente RecuperarUsuario();
    }
    
}
