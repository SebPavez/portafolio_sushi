using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace Negocio
{
    [DataContract]
    public class Cliente
    {
        #region Atributos
        private string strRun;
        private string strNombreCompleto;
        private string strDireccion;
        private string strComuna;
        private string strProvincia;
        private string strRegion;
        private DateTime dtFechaNacimiento;
        private string strGenero;
        private string strEmail;
        private string strNumeroTelefonico;
        private string strPassword;
        #endregion

        #region Propiedades
        [DataMember]
        public string Run
        {
            get { return strRun; }
            set { strRun = value; }
        }

        [DataMember]
        public string NombreCompleto
        {
            get { return strNombreCompleto; }
            set { strNombreCompleto = value; }
        }

        [DataMember]
        public string Direccion
        {
            get { return strDireccion; }
            set { strDireccion = value; }
        }

        [DataMember]
        public string Comuna
        {
            get { return strComuna; }
            set { strComuna = value; }
        }

        
        [DataMember]
        public string Provincia
        {
            get { return strProvincia; }
            set { strProvincia = value; }
        }

        
        [DataMember]
        public string Region
        {
            get { return strRegion; }
            set { strRegion = value; }
        }

        
        [DataMember]
        public DateTime FechaNacimiento
        {
            get { return dtFechaNacimiento; }
            set { dtFechaNacimiento = value; }
        }

        
        [DataMember]
        public string Genero
        {
            get { return strGenero; }
            set { strGenero = value; }
        }

        
        [DataMember]
        public string Email
        {
            get { return strEmail; }
            set { strEmail = value; }
        }

        
        [DataMember]
        public string NumeroTelefonico
        {
            get { return strNumeroTelefonico; }
            set { strNumeroTelefonico = value; }
        }

        
        [DataMember]
        public string Password
        {
            get { return strPassword; }
            set { strPassword = value; }
        }
        #endregion
        
    }
}
