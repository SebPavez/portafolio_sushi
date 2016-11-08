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
    <link href="css/reset.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">    
</head>
<body>    
    <!--Comienzo de formulario -->
    <div class="container" id="login_usuario">
        <div class="login">
            <h1 class="login-heading">
                <strong>Bienvenido</strong>, ingrese sus datos.</h1>
            <form runat="server">
            <asp:Label ID="lblEstadoIngreso" Text="" runat="server"></asp:Label>
            <asp:Login ID="controlLogin" runat="server">
                <LayoutTemplate>
                <asp:TextBox runat="server" ID="UserName" type="text" name="correo" placeholder="Correo" required="required" class="input-txt" />
                <asp:TextBox runat="server" ID="Password" type="password" name="pass" placeholder="Password" required="required" class="input-txt" />
                <div class="login-footer">                    
                    <a id="post_to_reg" href="#" class="lnk">
                        <span class="icon icon--min">(╯ರ ~ ರ）╯︵ ┻━┻</span> No tengo cuenta
                    </a> ||
                    <a class="lnk" href="MainPage.aspx">
                        <span class="icon icon--min">¯\(ツ)/¯</span> Volver a Inicio
                    </a>        
                    <asp:Button runat="server" ID="LoginButton" OnClick="controlLogin_Authenticate" CommandName="Login" type="submit" Text="Ingresar" class="btn btn--right" />
                </div>
                </LayoutTemplate>
            </asp:Login>                
            </form>
        </div>
    </div>

    <div id="registro_postulante" hidden class="container">
        <div class="login">
            <h1 class="login-heading">
                <strong>Formulario de registro</strong>, ingrese sus datos.</h1>
            <form method="post" action="registrar.aspx">
                <input class="input-txt" type="text" placeholder="Rut: ej: 19188621-6" name="txbRutRegister" required />
                <input class="input-txt" type="text" placeholder="Nombre: ej: Roberto Carlos" name="txbNombreRegister" required />
                <select class="input-txt" class="form-control" name="cmbGenero">
                        <option>Masculino</option>
                        <option>Femenino</option>
                        <option>Otro</option>
                    </select>
                <input class="input-txt" type="email" placeholder="Correo Electronico" name="txbEmailRegister" required />
                <input class="input-txt" type="password" placeholder="Contraseña" name="txbContraseñaRegister" required />
                <input class="input-txt" type="date" placeholder="fecha nacimiento" name="txbFechaRegister" required>
                <input class="input-txt" type="text" placeholder="Región" name="txbRegionRegister" required />
                <input class="input-txt" type="text" placeholder="Provincia" name="txbProvinciaRegister" required />
                <input class="input-txt" type="text" placeholder="Comuna" name="txbComunaRegister" required />
                <input class="input-txt" type="text" placeholder="Direccion" name="txbDireccionRegister" required />
                <input class="input-txt" type="tel" placeholder="Numero telefónico" name="txbTelRegister" required />                
                <div class="login-footer">
                    <a id="volver" href="#" class="lnk">
                        <span class="icon icon--min">(╯ರ ~ ರ）╯︵ ┻━┻</span> Ingresar
                    </a>||
                    <a class="lnk" href="MainPage.aspx">
                        <span class="icon icon--min">¯\(ツ)/¯</span> Volver a Inicio
                    </a>            
                    <button type="submit" class="btn btn--right">Registrar</button>
                </div>
            </form>
        </div>
    </div>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/login.js"></script>
    
</body>
</html>
