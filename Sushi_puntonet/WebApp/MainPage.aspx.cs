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
        
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                Negocio.CarroCompras carrito = new Negocio.CarroCompras();
                Session["carrito"] = carrito;
            }
            else {
                Negocio.CarroCompras carrito = (Negocio.CarroCompras)Session["carrito"];
                if (Request.Params.Get("__EVENTARGUMENT").Equals("ejecutar")){
                    CargarProductosAlCarrito();
                }
                if(Request.QueryString["idProducto"]!=null)
                    CargarProductosAlCarrito();
            }
            CargasProductosEnPagina();
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
                //anclaInterna.HRef = "/MainPage.aspx?idProducto="+item.IdProducto;
                anclaInterna.InnerText = item.Nombre;
                anclaInterna.Attributes.Add("runat", "server");
                anclaInterna.Attributes.Add("onclick", "__doPostBack('"+item.IdProducto+"', 'ejecutar')");
                anclaInterna.ClientIDMode = ClientIDMode.Static;
                anclaInterna.Attributes.Add("id",  item.IdProducto.ToString());
                anclaInterna.ServerClick += Ancla_click;
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

        protected void Ancla_click(object sender, EventArgs e) {
            int id = Int32.Parse(((HtmlAnchor)sender).ID);
            Negocio.CarroCompras carrito = (Negocio.CarroCompras)Session["carrito"];
            carrito.ProductosEnCarro.Add(new ServicioCompras.ServicioClient().buscarProductoID(id));
            Session["carrito"] = carrito;
        }

        // Metodo que trae el id de la base desde la url y lo pasa a la consulta lo cual devuelve un producto
        // este guarda el producto al carrito
        protected void CargarProductosAlCarrito() {
            using (ServicioCompras.ServicioClient servicio = new ServicioCompras.ServicioClient())
            {

                int id = Int32.Parse(Request.Params.Get("__EVENTTARGET"));
                Negocio.CarroCompras carrito = (Negocio.CarroCompras)Session["carrito"];
                carrito.ProductosEnCarro.Add(servicio.buscarProductoID(id));
                Session["carrito"] = carrito;
                servicio.Close();
            }
        }
    }
}