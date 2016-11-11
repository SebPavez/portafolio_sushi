using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace WebApp
{
    public partial class MainPage : System.Web.UI.Page
    {
        Negocio.CarroCompras carrito;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                carrito = new Negocio.CarroCompras();
                CargasProductosEnPagina();
            }
            else {
                carrito = (Negocio.CarroCompras)Session["carrito"];
            }

        }

        protected void CargasProductosEnPagina() {
            ServicioCompras.ServicioClient servicio = new ServicioCompras.ServicioClient();
            Negocio.Producto[] listadoProductos = servicio.ListarProductos();
            foreach (Negocio.Producto item in listadoProductos)
            {
                HtmlGenericControl colDiv = new HtmlGenericControl("div");
                colDiv.Attributes.Add("class", "col-sm-4 col-sm-4 col-sm-4");

                HtmlGenericControl thumb = new HtmlGenericControl("div");
                thumb.Attributes.Add("class", "thumbnail");

                HtmlImage imagen = new HtmlImage();
                //imagen.Src = item.LinkInternet;
                imagen.Src = "http://placehold.it/320x150";

                HtmlGenericControl detalles = new HtmlGenericControl("div");
                detalles.Attributes.Add("class", "caption");

                HtmlGenericControl headerPrecio = new HtmlGenericControl("h4");
                headerPrecio.Attributes.Add("class", "pull-right");
                if (item.EnOferta.Equals("1"))
                    headerPrecio.InnerText = item.PrecioOferta.ToString();
                else
                    headerPrecio.InnerText = item.PrecioNormal.ToString();

                HtmlGenericControl headerNombre = new HtmlGenericControl("h4");
                HtmlAnchor anclaInterna = new HtmlAnchor();
                anclaInterna.HRef = "#";
                anclaInterna.InnerText = item.Nombre;
                headerNombre.Controls.Add(anclaInterna);

                HtmlGenericControl descripcion = new HtmlGenericControl("p");
                descripcion.InnerText = item.Descripcion;

                detalles.Controls.Add(headerPrecio);
                detalles.Controls.Add(headerNombre);
                detalles.Controls.Add(descripcion);

                thumb.Controls.Add(imagen);
                thumb.Controls.Add(detalles);

                colDiv.Controls.Add(thumb);

                filaElementos.Controls.Add(colDiv);

            }
        }
    }
}