<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Josue Gramajo
  Date: 11/10/21
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<!-- Title Page-->
	<title>AeroMaya - Buscar vuelos</title>
</head>

<body class="animsition">
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
					<!--AVISO COVID-->
					<div class="card bg-primary">
						<strong style="color:#FFFFFF";><i class="fas fa-exclamation-circle" style="color:#FFFFFF";></i> ¡ADVERTENCIA!</strong>
						<p style="color:#FFFFFF";>Debido a la Pandemia Mundial de COVID-19 se le recomienda investigar
							sus destinos y la seguridad en los países que visitará. Mantenga la
							distancia social y no salga o viaje si no es necesario. Para más información,
							clic en el enlace de la OMG: <a target="_blank" style="color:#FFFF00"; href="https://www.who.int/es">Clic Aquí</a> </p>
					</div>


					<div class="row">
						<div class="col-md-12">
							<div class="overview-wrap">
								<h2 class="title-1">Selección De Boletos</h2>

							</div>
						</div>
					</div>
					<div class="row m-t-25">
						<div class="col-sm-6 col-lg-3 col-xl-12">
							<div class="card">
								<div class="card-header">
									<strong>¡Escoja sus Vuelos con Nosotros!</strong> Seleccione su origen y destino:
								</div>
								<div class="card-body card-block">
									<div class="row form-group">
										<div class="col col-md-3">
											<label for="destinationPlaceText" class=" form-control-label">Destino</label>
										</div>
										<div class="col-12 col-md-9">
											<input class="form-control" id="destinationPlaceText" type="text" placeholder="Escribe un destino..." aria-label="Escribe un destino..." />
										</div>
									</div>

									<div class="row form-group">
										<div class="col col-md-3">
											<label for="startDate" class=" form-control-label">Fecha de Salida</label>
										</div>
										<div class="col-12 col-md-9">
											<div class="input-group date">
												<input id="startDate" type="text" class="form-control" autocomplete="off">
												<div class="input-group-addon">
													<span class="glyphicon glyphicon-th"></span>
												</div>
											</div>
										</div>
									</div>

									<div class="row form-group">
										<div class="col col-md-3">
											<label for="endDate" class=" form-control-label">Fecha de Regreso</label>
										</div>
										<div class="col-12 col-md-9">
											<div class="input-group date">
												<input id="endDate" type="text" class="form-control" autocomplete="off">
												<div class="input-group-addon">
													<span class="glyphicon glyphicon-th"></span>
												</div>
											</div>
										</div>
									</div>
									<div id="search-container" class="d-flex flex-row-reverse">
										<input id="submitButton" type="button" name="btnContinue" value="Buscar" class="au-btn au-btn-icon au-btn--green" >
									</div>
									<div id="loader" class="col-auto">
										<svg class="spinner" width="45px" height="45px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg" style="margin-right: 5px;">
											<circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
										</svg>
									</div>
									<script>
										$("#loader").hide();
									</script>
								</div>
							</div>
							<div class="overview-wrap">
								<h2 class="title-1">Destinos Interesantes</h2>

							</div>
						</div>

						<div class="col-md-4">
							<div class="card">
								<img class="card-img-top" src="../assets/images/destino1.png" alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title mb-3">Madrid, España</h4>
									<p class="card-text">Además de poder disfrutar de la fiebre del futbol y de los mejores clubs,
										podrás deleitarte con los mejores hoteles, la gastronomía de la ciudad,
										tradiciones y sitios históricos en un solo lugar.
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card">
								<img class="card-img-top" src="../assets/images/destino2.png" alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title mb-3">Londes, Inglaterra</h4>
									<p class="card-text">El palacio de Buckingham, los puentes levadizos,
										autos y bares propios de James Bond, el mejor destino si quieres disfrutar
										de buenas bebidas junto a las miles de historias que cuenta la ciudad.
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card">
								<img class="card-img-top" src="../assets/images/destino3.png" alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title mb-3">Nueva York, USA</h4>
									<p class="card-text">Si te gusta el frio, no dormir y visitar centros históricos
										que aparecen en miles de películas, este es el destino indicado, una ciudad que
										nunca duerme junto a los miles de lugares que puedes visitar.
									</p>
								</div>
							</div>
						</div>

						<!--FOOTER-->
						<footer class="footer">
							<div class="container-fluid">
								<div class="copyright">
									<p><a href="privacidad.html">Política de Privacidad</a></p>
									<p>Copyright © 2021 Aero Maya. Todos Los Derechos Reservados.</p>
								</div>
							</div>
						</footer>

					</div>
				</div>
			</div>
		</div>
	</t:base-page>

	<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>

	<link rel="stylesheet" href="../assets/vendor/air-datepicker/datepicker.css">
	<script src="../assets/vendor/air-datepicker/datepicker.js"></script>
	<script src="../assets/vendor/air-datepicker/datepicker.es.js"></script>

	<script type="application/javascript">
		var countries = ${countries}
	</script>

	<script src="../assets/vendor/jquery-redirect.js"></script>

	<script src="../assets/js/dashboard.js"></script>

</body>

</html>
<!-- end document-->
