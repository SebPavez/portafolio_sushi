using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Oracle.DataAccess.Client;
using System.Configuration;

namespace DAL
{
    class Conexion
    {
        private OracleConnection cn { get; set; }

        public OracleConnection getConexion() 
        {
            if (this.cn == null) {
                string conexion = System.Configuration.ConfigurationManager.AppSettings["CONEXION"].ToString();
                cn = new OracleConnection(conexion);
            }
            return cn;
        }        


    }
}
