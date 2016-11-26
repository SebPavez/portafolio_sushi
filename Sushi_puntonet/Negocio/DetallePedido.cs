using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Negocio
{
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
        public int IdDetalle
        {
            get { return intIdDetalle; }
            set { intIdDetalle = value; }
        }

        public int IdPedido
        {
            get { return idPedido; }
            set { idPedido = value; }
        }

        public int IdProducto
        {
            get { return idProducto; }
            set { idProducto = value; }
        }

        public Producto Producto
        {
            get { return producto; }
            set { producto = value; }
        }
        
        public int Cantidad
        {
            get { return intCantidad; }
            set { intCantidad = value; }
        }
        #endregion propiedades

    }
}
