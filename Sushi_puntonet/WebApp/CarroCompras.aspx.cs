using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace WebApp
{
    public partial class CarroCompras : System.Web.UI.Page
    {       
        
        Negocio.CarroCompras carrito;

        protected void Page_Load(object sender, EventArgs e)
        {
            PruebaCarro();
            //CargarTablaCarro();
            
        }

        protected void CargarTablaCarro() {
            if (Session["carrito"] == null)
            {
                this.estadoCarro.Text = "Carro vacio";
                grillaCompras.Visible = false;
                BtnAnular.Visible = false;
                BtnComprar.Visible = false;
            }
            else {
                grillaCompras.DataSource = carrito.ProductosEnCarro;
                grillaCompras.DataBind();
                
            }


        }

        protected void PruebaCarro() {
            Negocio.Producto producto1 = new Negocio.Producto();
            producto1.Nombre = "dummy1";
            producto1.EnOferta = "0";
            producto1.PrecioNormal = 80000;
            producto1.PrecioOferta = 65000;
            producto1.Stock = 3;

            Negocio.Producto producto2 = new Negocio.Producto();
            producto2.Nombre = "dummy2";
            producto2.EnOferta = "1";
            producto2.PrecioNormal = 40000;
            producto2.PrecioOferta = 34000;
            producto2.Stock = 8;

            Negocio.CarroCompras carroDummy = new Negocio.CarroCompras();
            List<Negocio.Producto> listado = new List<Negocio.Producto>();
            listado.Add(producto1);
            listado.Add(producto2);

            carroDummy.ProductosEnCarro = listado;
            carroDummy.TotalCompra = 000000;

            grillaCompras.DataSource = carroDummy.ProductosEnCarro;
            grillaCompras.DataBind();
        }

        protected void BtnComprar_Click(object sender, EventArgs e)
        {

        }

        protected void BtnAnular_Click(object sender, EventArgs e)
        {
            Session["carrito"] = null;
        }

        protected void grillaCompras_PreRender(object sender, EventArgs e)
        {
            if((grillaCompras.ShowHeader == true && grillaCompras.Rows.Count > 0) || grillaCompras.ShowHeaderWhenEmpty == true)
                grillaCompras.HeaderRow.TableSection = TableRowSection.TableHeader;
            if(grillaCompras.ShowFooter == true && grillaCompras.Rows.Count > 0) 
                grillaCompras.FooterRow.TableSection = TableRowSection.TableFooter;        
        }
    }
}