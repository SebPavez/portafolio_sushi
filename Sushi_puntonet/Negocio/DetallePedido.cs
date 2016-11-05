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
        private Producto producto;
        private int intCantidad;

        #endregion atributos

        #region propiedades
        public int IdDetalle
        {
            get { return intIdDetalle; }
            set { intIdDetalle = value; }
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
