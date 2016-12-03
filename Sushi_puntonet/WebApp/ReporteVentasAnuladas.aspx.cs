using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApp
{
    public partial class ReporteVentasAnuladas : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnAnuladas_Click(object sender, EventArgs e)
        {
            ServicioReporte.ServicioReporteClient servicio = new ServicioReporte.ServicioReporteClient();
        }
    }
}