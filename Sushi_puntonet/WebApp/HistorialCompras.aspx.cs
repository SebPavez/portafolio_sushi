﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApp
{
    public partial class HistorialCompras : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            CargarHistorial();
        }


        protected void CargarHistorial() {
            string runCliente = (string)Session["runCliente"];
            try
            {
                using (ServicioCompras.ServicioClient servicio = new ServicioCompras.ServicioClient())
                {
                    Negocio.Pedido[] listado = servicio.ListarHistorial(runCliente);
                    grillaHistorial.DataSource = listado;
                    grillaHistorial.DataBind();
                }
            }
            catch (Exception)
            {
                estadoGrilla.Text = "No se pudieron encontrar datos";
                estadoGrilla.Visible = true;
            }
            
        }
        protected void grillaHistorial_PreRender(object sender, EventArgs e)
        {
            if ((grillaHistorial.ShowHeader == true && grillaHistorial.Rows.Count > 0) || grillaHistorial.ShowHeaderWhenEmpty == true)
                grillaHistorial.HeaderRow.TableSection = TableRowSection.TableHeader;
            if (grillaHistorial.ShowFooter == true && grillaHistorial.Rows.Count > 0)
                grillaHistorial.FooterRow.TableSection = TableRowSection.TableFooter;
        }
    }
}