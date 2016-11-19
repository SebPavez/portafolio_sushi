using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Web.Security;

namespace WebApp
{
    public partial class registrar : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            try
            {
                Negocio.Cliente nuevoCliente = new Negocio.Cliente();
                nuevoCliente.Run = HttpUtility.HtmlEncode(Request.Form["txbRutRegister"]);
                nuevoCliente.NombreCompleto = HttpUtility.HtmlEncode(Request.Form["txbNombreRegister"]);
                nuevoCliente.Genero = HttpUtility.HtmlEncode(Request.Form["cmbGenero"]);
                nuevoCliente.Email = HttpUtility.HtmlEncode(Request.Form["txbEmailRegister"]).ToLower();
                nuevoCliente.Password = HttpUtility.HtmlEncode(Request.Form["txbContraseñaRegister"]);
                nuevoCliente.FechaNacimiento = DateTime.Parse(HttpUtility.HtmlEncode(Request.Form["txbFechaRegister"]));
                nuevoCliente.Region = HttpUtility.HtmlEncode(Request.Form["txbRegionRegister"]);
                nuevoCliente.Provincia = HttpUtility.HtmlEncode(Request.Form["txbProvinciaRegister"]);
                nuevoCliente.Comuna = HttpUtility.HtmlEncode(Request.Form["txbComunaRegister"]);
                nuevoCliente.Direccion = HttpUtility.HtmlEncode(Request.Form["txbDireccionRegister"]);
                nuevoCliente.NumeroTelefonico = HttpUtility.HtmlEncode(Request.Form["txbTelRegister"]);

                ServicioCompras.ServicioClient servicio = new ServicioCompras.ServicioClient();
                if (servicio.RegistrarUsuario(nuevoCliente))
                {
                    lblResult.Text = "registrado con éxito";
                }
                else
                {
                    lblResult.Text = "falla al registrar";
                }
            }
            catch (Exception exc)
            {
                lblResult.Text = "falla en el registro: " + exc.Message;
            }

        }
    }
}