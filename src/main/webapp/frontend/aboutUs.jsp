<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: josue
  Date: 13/10/2021
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<!-- Required meta tags-->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="au theme template">
	<meta name="author" content="Hau Nguyen">
	<meta name="keywords" content="au theme template">

	<!-- Title Page-->
	<title>Sobre nosotros</title>

</head>

<body>
<t:base-page>
	<aside class="menu-sidebar d-none d-lg-block">
		<div class="menu-sidebar__content js-scrollbar1">
			<nav class="navbar-sidebar">
				<div class="">
					<h4>Publicidad</h4>
					<img src="../assets/images/anuncio.gif" alt="">
				</div>
			</nav>
		</div>
	</aside>

	<div class="main-content">
		<div class="section__content section__content--p30">
			<div class="container-fluid">
				<div class="row m-t-25">
					<div class="col-sm-6 col-lg-3 col-xl-12">
						<div class="card">
							<div class="card-body">
								<h1 align="center">Sobre Nosotros</h1>
								<div align="center">
									<img src="../assets/images/icon/login-logo.png" alt="" height="300" width="300">
								</div>
								<h2>Somos una plataforma web confiable para la compra de boletos de vuelos comerciales.</h2>
								<h6>Tenemos tanto seguridad para la encriptacion de la informacion como para la conexion
									de la página con otras redes, creamos una página que deja al usuario libre para rondar por
									nuestras páginas de cotización y lista de afiliación con tal de hacer más fácil su selección de
									vuelo y que viajar con nostros sea la mejor experiencia.</h6>

								<hr>

								<h6>La Lista de los Creadores: </h6>

								<div class="table-responsive m-b-40">
									<table class="table table-borderless table-data3">
										<thead>
										<tr>
											<th>Nombre</th>
											<th>Carné</th>
										</tr>
										</thead>
										<tbody>
										<tr>
											<td>Andrea Paola Fernanda Ruano Hernández</td>
											<td>0900-13-20105</td>
										</tr>
										<tr>
											<td>Angel Alberto Oliva Garcia</td>
											<td>0900-17-228</td>
										</tr>
										<tr>
											<td>Diego Alexander Solórzano Garrido</td>
											<td>0900-17-3716</td>
										</tr>
										<tr>
											<td>Esvin Ricardo Mayorga Asturias</td>
											<td>0900-17-1154</td>
										</tr>
										<tr>
											<td>Jose Daniel Perez Sandoval</td>
											<td>0900-14-913</td>
										</tr>
										<tr>
											<td>Melanie Andrea Jolón Cabrera</td>
											<td>0900-17-1053</td>
										</tr>
										<tr>
											<td>Patrick Alessandro Franco Hernández</td>
											<td>0900-17-2900</td>
										</tr>
										<tr>
											<td>Manuel de Jesús Vega Gómez</td>
											<td>0900-15-2718</td>
										</tr>
										<tr>
											<td>Josué Alejandro Gramajo Cujantes</td>
											<td>0900-16-3067</td>
										</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>



					<!--FOOTER-->
					<footer class="footer">
						<div class="container-fluid">
							<div class="copyright">
								<p><a href="privacidad.php">Política de Privacidad</a></p>
								<p>Copyright © 2021 Aero Maya. Todos Los Derechos Reservados.</p>
							</div>
						</div>
					</footer>

				</div>
			</div>
		</div>
	</div>
</t:base-page>

</body>

</html>
<!-- end document-->
