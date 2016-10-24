<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="WebApp.login" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html >

  <head>
    <meta charset="UTF-8">
    <title>Flat Login Form 3.0</title>
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
  <h1>Flat Login Form</h1><span>Pen <i class='fa fa-paint-brush'></i> + <i class='fa fa-code'></i> by <a href='http://andytran.me'>Andy Tran</a></span>
</div>

<!-- Form Module-->
<div class="module form-module">
  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
    <div class="tooltip">clikeame</div>
  </div>
  <div class="form">
    <h2>Ingresa a tu cuenta</h2>
    <form>
      <input type="text" placeholder="correo@ejemplo.cl" name="txbCorreoLogin"/>
      <input type="password" placeholder="Esto es una contraseña" name="txbPassLogin"/>
      <button>Login</button>
    </form>
  </div>
  <div class="form">
    <h2>Crea una cuenta nueva</h2>
    <form>
      <input type="text" placeholder="Rut" name="txbRun"/ >
      <input type="text" placeholder="Nombre completo" name="txbNombre"/>
      <input type="text" placeholder="Direccion" name="txbDireccion"/>
      <input type="text" placeholder="Comuna" name="txbComuna"/>
      <input type="text" placeholder="Provincia" name ="txbProvincia"/>
      <input type="text" placeholder="Region" name="txbRegion"/>
      <input type="Date" placeholder="fecha nacimiento" name="txbFechaNacimiento"/>
      <select>
        <option>Masculino</option>
        <option>Femenino</option>
        <option>No definido</option>
      </select>

      <input type="text" placeholder="Correo Electronico"/>
      <input type="text" placeholder="Numero telefonico"/>
      <input type="password" placeholder="Contraseña"/>
      <button>Registrar</button>
    </form>
  </div>
  <div class="cta"><a href="http://andytran.me">Forgot your password?</a></div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src='http://codepen.io/andytran/pen/vLmRVp.js'></script>
    <script src="js/index.js"></script>
  </body>
</html>

