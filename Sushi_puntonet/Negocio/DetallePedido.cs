using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace Negocio
{
    [DataContract]
    public class DetallePedido
    {
        #region atributos
        private int intIdDetalle;
        private int idPedido;
        private int idProducto;
        private Producto producto;
        private int intCantidad;

        #endregion atributos

        #region propiedades

        [DataMember]
        public int IdDetalle
        {
            get { return intIdDetalle; }
            set { intIdDetalle = value; }
        }

        [DataMember]
        public int IdPedido
        {
            get { return idPedido; }
            set { idPedido = value; }
        }

        [DataMember]
        public int IdProducto
        {
            get { return idProducto; }
            set { idProducto = value; }
        }

        [DataMember]
        public Producto Producto
        {
            get { return producto; }
            set { producto = value; }
        }

        [DataMember]
        public int Cantidad
        {
            get { return intCantidad; }
            set { intCantidad = value; }
        }
        #endregion propiedades

    }
}
