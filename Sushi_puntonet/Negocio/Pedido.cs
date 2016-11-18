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
        private string strFormaEntrega;
        private string strComentario;
        private double intTotalVenta;
        private DateTime dtFechaHoraPedido;
        private string strRunCliente;
        private List<DetallePedido> detallePedido;

        public int IdPedido
        {
            get { return intIdPedido; }
            set { intIdPedido = value; }
        }

        public string FormaEntrega
        {
            get { return strFormaEntrega; }
            set { strFormaEntrega = value; }
        }
        
        public string Comentario
        {
            get { return strComentario; }
            set { strComentario = value; }
        }
        
        public double TotalVenta
        {
            get { return intTotalVenta; }
            set { intTotalVenta = value; }
        }


        public DateTime FechaHoraPedido
        {
            get { return dtFechaHoraPedido; }
            set { dtFechaHoraPedido = value; }
        }

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

        public List<DetallePedido> DetallePedido
        {
            get { return detallePedido; }
            set { detallePedido = value; }
        }
        
    }
}
