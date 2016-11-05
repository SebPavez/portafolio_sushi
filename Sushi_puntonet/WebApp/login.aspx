<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="WebApp.login" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registro Sushi</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Sushi Fukusuke</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav  navbar-nav pull-right">                    
                    <li><a href="/MainPage.aspx">Volver</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <div class="pen-title">
        <h1>
            Fukusuke Sushi-Delivery</h1>
    </div>
    <!-- Form Module-->
    <div class="module form-module">
        <div class="toggle">
            <i class="fa fa-times fa-pencil"></i>
            <div class="tooltip">Regístrate</div>
        </div>
        <!--Autenticar usuario-->
        <div class="form">
            <h2>Entra a tu cuenta</h2>
            <form id="LoginForm" runat="server">
            <asp:Login ID="controlLogin" runat="server" OnAuthenticate="controlLogin_Authenticate"
                LoginButtonText="Entrar" RenderOuterTable="false">
                <LayoutTemplate>
                    <asp:TextBox ID="UserName" placeholder="Correo" runat="server"></asp:TextBox>
                    <asp:TextBox ID="Password" placeholder="Password" runat="server" TextMode="Password"></asp:TextBox>
                    <asp:Button Text="Ingresar" runat="server" />
                </LayoutTemplate>
            </asp:Login>
            </form>
        </div>
        <!--Crear usuario-->
        <div class="form">
            <h2>Crear una cuenta</h2>
            <form action="registrar.aspx" method="post">
            <input type="text" placeholder="Rut: ej: 19188621-6" name="txbRutRegister" required/>
            <input type="text" placeholder="Nombre: ej: Roberto Carlos" name="txbNombreRegister" required/>
            <div class="form-group">
                <label for="sel1">
                    Genero</label>
                <select class="form-control" name="cmbGenero">
                    <option>Masculino</option>
                    <option>Femenino</option>
                    <option>Otro</option>
                </select>
            </div>
            <input type="email" placeholder="Correo Electronico: correo@gmail.com" name="txbEmailRegister" required />
            <input type="password" placeholder="Contraseña" name="txbContraseñaRegister" required/>
            <input class="date" placeholder="fecha nacimiento" name="txbFechaRegister" required>
            <input type="text" placeholder="Region ej: Metropolitana" name="txbRegionRegister" required />
            <input type="text" placeholder="Provincia ej: Santiago" name="txbProvinciaRegister" required/>
            <input type="text" placeholder="Comuna ej: Las condes" name="txbComunaRegister" required />
            <input type="text" placeholder="Direccion ej: Mi casa #123" name="txbDireccionRegister" required />
            <input type="tel" placeholder="Numero telefonico ej: 12456" name="txbTelRegister" required />
            <button>Registrar</button>
            </form>
        </div>
        <div class="cta">
            <a href="#">¿Olvidaste tu contraseña?</a></div>
 
    <script type="text/javascript" src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script type="text/javascript" src='http://codepen.io/andytran/pen/vLmRVp.js'></script>
    <script type="text/javascript" src="login/js/index.js"></script>    
</body>
</html>
