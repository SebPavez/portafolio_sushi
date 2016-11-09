using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace WebApp
{
    public partial class Prueba : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            int contador = 0;
            while (contador < 10)
            {
                Negocio.Producto item = new Negocio.Producto();
                item.Nombre = "dummy";
                item.IdProducto = contador;
                item.LinkInternet = "http://placehold.it/320x150";
                item.EnOferta = "1";
                item.PrecioOferta = 89990;
                item.Descripcion = "bla bla bla bla descripción, bla";

                HtmlGenericControl colDiv = new HtmlGenericControl("div");
                colDiv.Attributes.Add("class", "col-sm-4 col-sm-4 col-sm-4");

                HtmlGenericControl thumb = new HtmlGenericControl("div");
                thumb.Attributes.Add("class", "thumbnail");

                HtmlImage imagen = new HtmlImage();
                imagen.Src = item.LinkInternet;

                HtmlGenericControl detalles = new HtmlGenericControl("div");
                detalles.Attributes.Add("class", "caption");

                HtmlGenericControl headerPrecio = new HtmlGenericControl("h4");
                headerPrecio.Attributes.Add("class", "pull-right");
                if (item.EnOferta.Equals("1"))
                    headerPrecio.InnerText = "$" + item.PrecioOferta.ToString();
                else
                    headerPrecio.InnerText = item.PrecioNormal.ToString();

                HtmlGenericControl headerNombre = new HtmlGenericControl("h4");
                HtmlAnchor anclaInterna = new HtmlAnchor();
                anclaInterna.HRef = item.IdProducto.ToString();
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

                contador++;
            }
        }
    }
}