using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Negocio
{
    public class DetallePedido
    {
        private int intIdDetalle;

        public int IdDetalle
        {
            get { return intIdDetalle; }
            set { intIdDetalle = value; }
        }

        private Producto producto;

        public Producto Producto
        {
            get { return producto; }
            set { producto = value; }
        }
        
        

        private int intCantidad;

        public int Cantidad
        {
            get { return intCantidad; }
            set { intCantidad = value; }
        }
        
        
    }
}
