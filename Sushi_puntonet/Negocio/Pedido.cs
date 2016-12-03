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
        private int idEstado;
        private List<DetallePedido> detallePedido;
        
        [DataMember]
        public int IdPedido
        {
            get { return intIdPedido; }
            set { intIdPedido = value; }
        }

        [DataMember]
        public string FormaEntrega
        {
            get { return strFormaEntrega; }
            set { strFormaEntrega = value; }
        }

        [DataMember]
        public string Comentario
        {
            get { return strComentario; }
            set { strComentario = value; }
        }

        [DataMember]
        public double TotalVenta
        {
            get { return intTotalVenta; }
            set { intTotalVenta = value; }
        }

        [DataMember]
        public DateTime FechaHoraPedido
        {
            get { return dtFechaHoraPedido; }
            set { dtFechaHoraPedido = value; }
        }

        [DataMember]
        public string RunCliente
        {
            get { return strRunCliente; }
            set { strRunCliente = value; }
        }

        [DataMember]
        public int Estado
        {
            get { return idEstado; }
            set { idEstado = value; }
        }

        [DataMember]
        public List<DetallePedido> DetallePedido
        {
            get { return detallePedido; }
            set { detallePedido = value; }
        }
        
    }
}
