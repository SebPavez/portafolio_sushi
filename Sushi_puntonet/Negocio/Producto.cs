﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Negocio
{
    public class Producto
    {
        private int intIdProducto;

        public int IdProducto
        {
            get { return intIdProducto; }
            set { intIdProducto = value; }
        }

        private int intStock;

        public int Stock
        {
            get { return intStock; }
            set { intStock = value; }
        }

        private string strNombre;

        public string Nombre
        {
            get { return strNombre; }
            set { strNombre = value; }
        }

        private int intPrecioNormal;

        public int PrecioNormal
        {
            get { return intPrecioNormal; }
            set { intPrecioNormal = value; }
        }

        private int intPrecioOferta;

        public int PrecioOferta
        {
            get { return intPrecioOferta; }
            set { intPrecioOferta = value; }
        }

        private string blnEnOferta;

        public string EnOferta
        {
            get { return blnEnOferta; }
            set { blnEnOferta = value; }
        }

        private string strDescripcion;

        public string Descripcion
        {
            get { return strDescripcion; }
            set { strDescripcion = value; }
        }

        private string strCategoria;

        public string Categoria
        {
            get { return strCategoria; }
            set { strCategoria = value; }
        }

        private string strLinkInternet;

        public string LinkInternet
        {
            get { return strLinkInternet; }
            set { strLinkInternet = value; }
        }
        
    }
}
