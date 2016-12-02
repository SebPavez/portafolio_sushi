using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace Negocio
{
    public class CarroCompras
    {
        private List<DetalleProductoCarro> productoEnCarro;
        private double totalCompra;

        public List<DetalleProductoCarro> ProductosEnCarro
        {
            get { return productoEnCarro;}
            set { productoEnCarro = value;}
        }

        public double TotalCompra
        {
            get { return totalCompra; }
            set { totalCompra = value; }
        }

        public CarroCompras() {
            this.productoEnCarro = new List<DetalleProductoCarro>();
        }
        
	
	
    }
}
