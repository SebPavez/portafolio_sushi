<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="registrado.aspx.cs" Inherits="WebApp.registrado" %>

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
	
</head>
<body>
	
<!-- Shell -->	
<div class="shell">
	
	<!-- Header -->	
	<div id="header">
		<h1 id="logo"><a href="#">shoparound</a></h1>	
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
	
	<!-- Main -->
	<div id="main">
		<div class="cl">&nbsp;</div>
		
		<!-- Content -->
		<div id="content">
			
			<!-- Content Slider -->
			<div id="slider" class="box">
				<div id="slider-holder">
					<ul>
					    <li><a href="1"><img src="template base/css/images/promo 1.jpg" alt="" /></a></li>
					    <li><a href="2"><img src="template base/css/images/promo 3.jpg" alt="" /></a></li>
					    <li><a href="3"><img src="template base/css/images/promo5.png" alt="" /></a></li>
					</ul>
				</div>
				<div id="slider-nav">
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
				</div>
			</div>
			<!-- End Content Slider -->
			
			<!-- Products -->
			<div class="products">
				<div class="cl">&nbsp;</div>
				<ul>
				    <li>
				    	<a href="5"><img src="template base/css/images/bebidas.jpg" alt="" /></a>
				    	<div class="product-info">
				    		<h3>Bebidas</h3>
				    		<div class="product-desc">
								<h4>Distintos sabores</h4>
				    			<p>Bebidas de distintas categorias</p>
				    			<strong class="price">$1000</strong>
				    		</div>
				    	</div>
			    	</li>
                    <li>
				    	<a href="6"><img src="template base/css/images/bebidas2.jpg" alt="" /></a>
				    	<div class="product-info">
				    		<h3>Bebidas</h3>
				    		<div class="product-desc">
								<h4>Distintos sabores</h4>
				    			<p>Promocion bebidas</p>
				    			<strong class="price">$3000</strong>
				    		</div>
				    	</div>
			    	</li>
			    	<li>
				    	<a href="7"><img src="template base/css/images/índice.jpg" alt="" /></a>
				    	<div class="product-info">
				    		<h3>sushi roll</h3>
				    		<div class="product-desc">
								<h4>Sushi</h4>
				    			<p>suhi roll tradicional 15 piezas</p>
				    			<strong class="price">$4000</strong>
				    		</div>
				    	</div>
			    	</li>
                    <li>
				    	<a href="8"><img src="template base/css/images/índice2.jpg" alt="" /></a>
				    	<div class="product-info">
				    		<h3>sushi roll</h3>
				    		<div class="product-desc">
								<h4>Sushi</h4>
				    			<p>suhi roll con queso 15 piezas</p>
				    			<strong class="price">$7000</strong>
				    		</div>
				    	</div>
			    	</li>
                    <li>
				    	<a href="9"><img src="template base/css/images/indice3.jpg" alt="" /></a>
				    	<div class="product-info">
				    		<h3>sushi roll</h3>
				    		<div class="product-desc">
								<h4>Sushi</h4>
				    			<p>suhi roll con chia  15 piezas</p>
				    			<strong class="price">$7000</strong>
				    		</div>
				    	</div>
			    	</li>
                    <li>
				    	<a href="11"><img src="template base/css/images/índice8.jpg" alt="" /></a>
				    	<div class="product-info">
				    		<h3>sushi roll</h3>
				    		<div class="product-desc">
								<h4>sushi</h4>
				    			<p>sushi tempura con salsa de soya</p>
				    			<strong class="price">$10000</strong>
				    		</div>
				    	</div>
			    	</li>
				</ul>
				<div class="cl">&nbsp;</div>
			</div>
			<!-- End Products -->
			
		</div>
		<!-- End Content -->
		
		<!-- Sidebar -->
		<div id="sidebar">
			
			<!-- Search -->
			<div class="box search">
				<h2>Buscar Productos <span></span></h2>
				<div class="box-content">
					<form action="" method="post">
						
						<label>Nombre Producto</label>
						<input type="text" class="field" />
						
						<label>Categoria</label>
						<select class="field">
							<option value="">-- Selecciona producto --</option>
                            <option value="">Sushi roll</option>
                            <option value="">Promociones</option>
                            <option value="">Bebidas</option>
						</select>
						
						<div class="inline-field">
							<label>Precio</label>
							<select>
								<option value="">$1000</option>
                                <option value="">$2000</option>
                                <option value="">$3000</option>
                                <option value="">$4000</option>
							</select>
							<label>a</label>
							<select >
								<option value="">$5000</option>
                                <option value="">$6000</option>
                                <option value="">$7000</option>
                                <option value="">$8000</option>
							</select>
						</div>
						
						<input type="submit" class="search-submit" value="Buscar" />
					</form>
				</div>
			</div>
			<!-- End Search -->
			
			<!-- Categories -->
			<div class="box categories">
				<h2>Categorias <span></span></h2>
				<div class="box-content">
					<ul>
					    <li><a href="#">Hand Roll</a></li>
					    <li><a href="#">Sushi Roll</a></li>
					    <li><a href="#">Bebidas</a></li>
					    <li><a href="#">Promociones</a></li>
					</ul>
				</div>
			</div>
			<!-- End Categories -->
		</div>
		<!-- End Sidebar -->
		
		<div class="cl">&nbsp;</div>
	</div>
	<!-- End Main -->
	
	<!-- Side Full -->
	<div class="side-full">
		
		<!-- More Products -->
		<div class="more-products">
			<div class="more-products-holder">
				<ul>
				    <li><a href="#"><img src="template base/css/images/bebidas.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/bebidas2.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/indice 6.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/índice.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/índice1.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/índice2.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/indice3.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/índice4.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/indice5.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/indice 6.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/indice7.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/índice8.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/promo 1.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/promo 3.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="template base/css/images/promo5.png" alt="" /></a></li>
				</ul>
			</div>
			<div class="more-nav">
				<a href="#" class="prev">previous</a>
				<a href="#" class="next">next</a>
			</div>
		</div>
		<!-- End More Products -->
	</div>
	<!-- End Side Full -->
	
	<!-- Footer -->
	<div id="footer">
		<p class="left">
			<a href="#">Home</a>
			<span>|</span>
			<a href="#">Support</a>
			<span>|</span>
			<a href="#">My Account</a>
			<span>|</span>
			<a href="#">The Store</a>
			<span>|</span>
			<a href="#">Contact</a>
		</p>
		<p class="right">
			&copy; 2010 Shop Around.
			Design by <a href="http://chocotemplates.com" target="_blank" title="The Sweetest CSS Templates WorldWide">Chocotemplates.com</a>
		</p>
	</div>
	<!-- End Footer -->
	
</div>	
<!-- End Shell -->
	
	
</body>
</html>