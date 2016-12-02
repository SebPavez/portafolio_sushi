using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using DAL;
using Negocio;

namespace Servicio
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "IServicioReporte" en el código y en el archivo de configuración a la vez.
    [ServiceContract]
    public interface IServicioReporte
    {
        [OperationContract]
        List<Negocio.Producto> Stock();

        [OperationContract]
        List<Negocio.Pedido> ReporteVentasRealizadas(DateTime FechaDesde , DateTime FechaHasta);

        [OperationContract]
        List<Negocio.Pedido> reporteVentasAnuladas(DateTime FechaDesde, DateTime FechaHasta);
    }
}
