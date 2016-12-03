using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApp
{
    public partial class ReporteVentas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnVentas_Click(object sender, EventArgs e)
        {
            ServicioReporte.ServicioReporteClient servicio = new ServicioReporte.ServicioReporteClient();

            DateTime fechaDesde = Convert.ToDateTime(txtFechaDesde.Text);
            DateTime fechaHasta = Convert.ToDateTime(txtFechaHasta.Text);

            Negocio.Pedido[] listaPedidos = servicio.ReporteVentasRealizadas(fechaDesde, fechaHasta);

            if (listaPedidos != null)
            {
                string resultado = string.Empty;
                int suma = 0;

                foreach (Negocio.Pedido item in listaPedidos)
                {
                    suma += (int)item.TotalVenta;
                    resultado += item.IdPedido;
                }

               txtVentasRealizadas.InnerText = resultado;

                this.Chart1.Series["Ventas"].Points.AddXY(0, suma);
                Chart1.DataBind();
            }
                                    
        }
    }
}
