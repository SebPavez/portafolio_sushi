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
        protected void Page_Load(object sender, EventArgs e)
        {
            CargarTablaCarro();            
        }

        protected void CargarTablaCarro() {
            if (Session["carrito"] == null)
            {
                this.estadoCarro.Text = "Carro vacio";                
                grillaCompras.Visible = false;
                panelComentario.Visible = false;
                panelFormaEntrega.Visible = false;
                BtnAnular.Visible = false;
                BtnComprar.Visible = false;
            }
            else {
                Negocio.CarroCompras carrito = (Negocio.CarroCompras)Session["carrito"];
                grillaCompras.DataSource = carrito.ProductosEnCarro;
                grillaCompras.DataBind();                
            }
        }       

        protected void BtnComprar_Click(object sender, EventArgs e)
        {
            using (ServicioCompras.ServicioClient servicio = new ServicioCompras.ServicioClient()) {
                Negocio.CarroCompras carro = (Negocio.CarroCompras)Session["carrito"];
                Negocio.Pedido nuevoPedido = new Negocio.Pedido();
                nuevoPedido.RunCliente = (String)Session["runCliente"];
                nuevoPedido.FormaEntrega = this.dropFormaEntrega.SelectedItem.Text;
                nuevoPedido.Comentario = this.txbComentario.Text;
                nuevoPedido.TotalVenta = carro.TotalCompra;
                List<Negocio.DetallePedido> listaDetalle = new List<Negocio.DetallePedido>();
                foreach (Negocio.Producto item in carro.ProductosEnCarro)
                {
                    Negocio.DetallePedido detalle = new Negocio.DetallePedido();
                    detalle.Producto = item;
                    detalle.Cantidad = item.Stock;
                }
                nuevoPedido.DetallePedido = listaDetalle;
                if (servicio.GenerarPedido(nuevoPedido))
                {
                    this.estadoCarro.Text = "Pedido realizado con éxito";
                    Session["carrito"] = null;
                }
                else {
                    this.estadoCarro.Text = "Falla al realizar pedido, intente más tarde";
                }

            }

        }

        protected void BtnAnular_Click(object sender, EventArgs e)
        {
            Session["carrito"] = null;
            Response.Redirect("MainPage.aspx");
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