<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="carrito.aspx.cs" Inherits="WebApp.carrito" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>Proyecto sushi</title>
	<link rel="stylesheet" href="template base/css/style.css" type="text/css" media="all" />
	<!--[if lte IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->
	
	<meta name="keywwords" content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms" />
	<meta name="description" content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms" />
	
	<!-- JS -->
	<script src="template base/js/jquery-1.4.1.min.js" type="text/javascript"></script>	
	<script src="template base/js/jquery.jcarousel.pack.js" type="text/javascript"></script>	
	<script src="template base/js/jquery-func.js" type="text/javascript"></script>	
	<!-- End JS -->

    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
    <style type="text/css">
        .style1
        {
            height: 37px;
        }
    </style>
	
</head>
<body>
	<!-- Header -->	
	<div id="header">
		<!-- Navigation -->
		<div id="navigation">
			<ul>
			    <li><a href="/registrado.aspx">Tienda</a></li>
                <li><a href="/carrito.aspx">Mi carrito</a></li>
                <li><a href="/MiPerfil.aspx">Mi Perfil</a></li>
			    <li><a href="/Contactenos.aspx">Contactenos</a></li>
                <li><a href="/login.aspx">Salir</a></li>
			</ul>
		</div>
		<!-- End Navigation -->
	</div>
	<!-- End Header -->

   <div class="container" style="padding-top: 1em;">
  <div class="table-responsive">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>Nombre Producto</th>
          <th>Categoria</th>
          <th>Precio</th>
        </tr>
      </thead>
      <tbody>
        <tr class="active">
          <td>1</td>
          <td>Bebidas distintos sabores</td>
          <td>Bebidas</td>
          <td>1000</td>
        </tr>
        <tr>
          <td class="style1">2</td>
          <td class="style1">sushi roll tradicional</td>
          <td class="style1">sushi roll</td>
          <td class="style1">4000</td>
        </tr>
        <tr class="success">
          <td>3</td>
          <td>Promocion 1</td>
          <td>Promocion</td>
          <td>5000</td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
