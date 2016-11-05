using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace Negocio
{
    public class CarroCompras
    {
        private List<Producto> productoEnCarro;
        private double totalCompra;

        public List<Producto> ProductosEnCarro
        {
            get { return productoEnCarro;}
            set { productoEnCarro = value;}
        }

        public double TotalCompra
        {
            get { return totalCompra; }
            set { totalCompra = value; }
        }
        
	
	
    }
}
