﻿using System;
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

        protected void controlLogin_Authenticate(object sender, AuthenticateEventArgs e) {
            ServicioCompras.ServicioClient seguridad = new ServicioCompras.ServicioClient();
            if (seguridad.AutenticarCliente(controlLogin.UserName, controlLogin.Password)) {
                e.Authenticated = true;
                FormsAuthentication.RedirectFromLoginPage(controlLogin.UserName, false);
            }            
        }

    }
}