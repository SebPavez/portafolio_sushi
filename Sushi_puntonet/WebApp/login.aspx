<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="WebApp.login" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Registro</title>
    <link rel="stylesheet" href="login/css/reset.css" />
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900' />
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css' />
    <link rel="stylesheet" href="login/css/style.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
        integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
        crossorigin="anonymous" />
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="template base/css/style.css" type="text/css" media="all" />
    <meta name="keywwords" content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms" />
    <meta name="description" content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms" />
    <script src="template base/js/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="template base/js/jquery.jcarousel.pack.js" type="text/javascript"></script>
    <script src="template base/js/jquery-func.js" type="text/javascript"></script>
</head>
<body>
    <div class="shell">
        <!-- Header -->
        <div id="header">
            <!-- Navigation -->
            <div id="navigation">
                <ul>
                    <li><a href="/PaginaPrincipal.aspx">Tienda</a></li>
                </ul>
            </div>
            <!-- End Navigation -->
        </div>
    </div>
    <!-- End Header -->
    <!-- Form Mixin-->
    <!-- Input Mixin-->
    <!-- Button Mixin-->
    <!-- Pen Title-->
    <div class="pen-title">
        <h1>
            Fukusuke Sushi-Delivery</h1>
    </div>
    <!-- Form Module-->
    <div class="module form-module">
        <div class="toggle">
            <i class="fa fa-times fa-pencil"></i>
            <div class="tooltip">
                Registrate</div>
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
                <select class="form-control" name="cmbGenero" required>
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
    </div>
    <script type="text/javascript" src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script type="text/javascript" src='http://codepen.io/andytran/pen/vLmRVp.js'></script>
    <script type="text/javascript" src="login/js/index.js"></script>    
</body>
</html>
