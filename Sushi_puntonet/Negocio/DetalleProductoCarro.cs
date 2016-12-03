using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Negocio
{
    public class DetalleProductoCarro
    {

        private int id;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private string nombre;

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        private int cantidad;

        public int Cantidad{
                
            get { return cantidad; }
            set { cantidad = value; }
        }

        private double precioUnidad;

        public double PrecioUnidad
        {
            get { return precioUnidad; }
            set { precioUnidad = value; }
        }

        private double totalDetalle;

        public double TotalDetalle
        {
            get { return totalDetalle; }
            set { totalDetalle = value; }
        }
        
        
        
    }
}
