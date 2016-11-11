using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Security;

namespace WebApp
{
    public partial class login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
                  
        }

        protected void controlLogin_Authenticate(object sender, EventArgs e) {
            ServicioCompras.ServicioClient seguridad = new ServicioCompras.ServicioClient();
            if (seguridad.AutenticarCliente(controlLogin.UserName, controlLogin.Password))
            {
                Session["UserName"] = controlLogin.UserName.Trim();
                //FormsAuthentication.RedirectFromLoginPage(controlLogin.UserName, false);
                //Response.Redirect("MainPage.aspx", true);
            }
            else {
                lblEstadoIngreso.Text = "Error al autenticar, intente nuevamente";
            }
            

        }       

    }
}