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
            try
            {
                using (ServicioCompras.ServicioClient servicio = new ServicioCompras.ServicioClient())
                {
                    Negocio.CarroCompras carro = (Negocio.CarroCompras)Session["carrito"];

                    Negocio.Pedido nuevoPedido = new Negocio.Pedido();

                    nuevoPedido.RunCliente = (string)Session["runCliente"];
                    nuevoPedido.FormaEntrega = this.dropFormaEntrega.SelectedItem.Text;
                    nuevoPedido.Comentario = this.txbComentario.Text;

                    foreach (Negocio.DetalleProductoCarro item in carro.ProductosEnCarro)
                    {
                        nuevoPedido.TotalVenta += item.TotalDetalle;
                    };

                    nuevoPedido.DetallePedido = new List<Negocio.DetallePedido>();
                    foreach (Negocio.DetalleProductoCarro item in carro.ProductosEnCarro)
                    {
                        Negocio.DetallePedido detalle = new Negocio.DetallePedido();

                        detalle.Producto = new Negocio.Producto {IdProducto = item.Id};
                        detalle.Cantidad = item.Cantidad;
                        nuevoPedido.DetallePedido.Add(detalle);
                    }

                    if (servicio.GenerarPedido(nuevoPedido))
                    {
                        this.estadoCompra.Text = "Pedido realizado con éxito";
                        Session["carrito"] = null;
                        CargarTablaCarro();
                    }
                    else
                    {
                        this.estadoCompra.Text = "Falla al realizar pedido, intente más tarde";
                    }
                }
            }
            catch (Exception)
            {
                this.estadoCompra.Text = "Falla al realizar pedido, intente más tarde";                
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