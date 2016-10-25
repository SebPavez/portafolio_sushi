﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using Negocio;

namespace Servicio
{    
    [ServiceContract]
    public interface IServicio
    {
        [OperationContract]
        bool registrarUsuario(Negocio.Cliente nuevoCliente);        
    }
    
}
