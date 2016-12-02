using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApp
{
    public partial class Reportes : System.Web.UI.Page
    {
        Negocio.Producto producto = new Negocio.Producto();
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnEnviar_Click(object sender, EventArgs e)
        {
            //ServicioReporte.ServicioReporteClient servicio = new ServicioReporte.ServicioReporteClient();
            //int id = producto.IdProducto;
            //gridStock.DataSource = servicio.Stock().ToString();
            //gridStock.DataBind();
        }
    }
}