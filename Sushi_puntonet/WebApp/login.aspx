<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="WebApp.login" %>

<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Registro Cliente</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
<!-- Form Mixin-->
<!-- Input Mixin-->
<!-- Button Mixin-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Registrate</h1>
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
    <div class="tooltip">Click Me</div>
  </div>
  <div class="form">
    <h2>Inicia session</h2>
    <form>
      <input type="text" placeholder="Correo electronico" name="txbLoginUsuario"/>
      <input type="password" placeholder="Password", name="txbLoginPass"/>
      <button>Iniciar</button>
    </form>
  </div>
  <div class="form">
    <h2>Create tu cuenta </h2>
    <form>
      <input type="text" placeholder="Rut ej: 11111111-1" name="txbRutCli"/>
      <input type="text" placeholder="Nombre Completo" name="txbNombreCli"/>
      <input type="text" placeholder="Region" name="txbRegionCli"/>
      <input type="text" placeholder="Provincia ej: Santiago" name="txbProvinciaCli"/>
      <input type="text" placeholder="Comuna ej: Las Condes" name="txbComunaCli"/>
      <input type="text" placeholder="Direccion ej: Mi direccion # 213" name="txbDireccionCli"/>
      <label class="form-check-label">
         <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                Masculino
       </label>
       <label class="form-check-label">
         <input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios2" value="option2">
            Femenino
        </label>
       <input type="email" placeholder="correo@correo.cl" name="txbCorreoCli"/> 
       <input type="password" placeholder="Password" name="txbPassCli"/>
       <input type="date"  name="txbNacimientoCli"/> 
       <input type="tel" placeholder="Numero Telefonico" name="txbTelCli"/>
      
      <button>Registrar</button>
    </form>
  </div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/index.js"></script>
  </body>
</html>
