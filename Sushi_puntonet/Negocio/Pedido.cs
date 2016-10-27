using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace Negocio
{
    [DataContract]
    public class Pedido
    {
        private int intIdPedido;

        public int IdPedido
        {
            get { return intIdPedido; }
            set { intIdPedido = value; }
        }

        private string strFormaEntrega;

        public string FormaEntrega
        {
            get { return strFormaEntrega; }
            set { strFormaEntrega = value; }
        }

        private string strComentario;

        public string Comentario
        {
            get { return strComentario; }
            set { strComentario = value; }
        }

        private int intTotalVenta;

        public int TotalVenta
        {
            get { return intTotalVenta; }
            set { intTotalVenta = value; }
        }

        private DateTime dtFechaHoraPedido;

        public DateTime FechaHoraPedido
        {
            get { return dtFechaHoraPedido; }
            set { dtFechaHoraPedido = value; }
        }

        private string strRunCliente;

        public string RunCliente
        {
            get { return strRunCliente; }
            set { strRunCliente = value; }
        }

        private int idEstado;

        public int Estado
        {
            get { return idEstado; }
            set { idEstado = value; }
        }

        private List<DetallePedido> detallePedido;

        public List<DetallePedido> DetallePedido
        {
            get { return detallePedido; }
            set { detallePedido = value; }
        }
        
    }
}
