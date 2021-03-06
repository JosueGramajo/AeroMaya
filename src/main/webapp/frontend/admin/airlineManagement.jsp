<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: promerica
  Date: 25/10/21
  Time: 11:30
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
	<title>Admin - Inicio</title>

	<!-- Fontfaces CSS-->
	<link href="../../assets/css/font-face.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

	<!-- Bootstrap CSS-->
	<link href="../../assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

	<!-- Vendor CSS-->
	<link href="../../assets/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/wow/animate.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/slick/slick.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/select2/select2.min.css" rel="stylesheet" media="all">
	<link href="../../assets/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

	<!-- Main CSS-->
	<link href="../../assets/css/admin/theme.css" rel="stylesheet" media="all">

	<!-- Jquery JS-->
	<script src="../../assets/vendor/jquery-3.2.1.min.js"></script>
</head>

<body class="animsition">
<div class="page-wrapper">
	<!-- HEADER MOBILE-->
	<header class="header-mobile d-block d-lg-none">
		<div class="header-mobile__bar">
			<div class="container-fluid">
				<div class="header-mobile-inner">
					<a class="logo" href="">
						<img src="../../assets/images/icon/logo.png" alt="CoolAdmin" />
					</a>
					<button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
					</button>
				</div>
			</div>
		</div>
		<nav class="navbar-mobile">
			<div class="container-fluid">
				<ul class="navbar-mobile__list list-unstyled">
					<li class="has-sub">
						<a href="/adminDashboard">
							<i class="fas fa-minus-circle"></i>Dashboard</a>
					</li>
					<li>
						<a class="js-arrow" href="#">
							<i class="fas fa-copy"></i>Reportes</a>
						<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
							<li>
								<a href="/ticketReport">Reporte de Boletos</a>
							</li>
							<li>
								<a href="/flightReport">Reporte de Vuelos</a>
							</li>
							<li>
								<a href="/userReport">Reporte de Usuarios</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="/ticketCancellationSearch">
							<i class="fas fa-minus-circle"></i>Cancelaci??n de Boletos</a>
					</li>
					<li class="has-sub">
						<a class="js-arrow" href="#">
							<i class="fas fa-pencil-square"></i>Mantenimientos</a>
						<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
							<li>
								<a href="/userManagement">Usuarios</a>
							</li>
							<li>
								<a href="/countryManagement">Paises</a>
							</li>
							<li>
								<a href="/airlineManagement">Aerolineas</a>
							</li>
							<li>
								<a href="/planeManagement">Aviones</a>
							</li>
							<li>
								<a href="/flightsManagement">Vuelos</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- END HEADER MOBILE-->

	<!-- MENU SIDEBAR-->
	<aside class="menu-sidebar d-none d-lg-block">
		<div class="logo">
			<a href="#">
				<img src="../../assets/images/icon/logo.png" alt="Cool Admin" />
			</a>
		</div>
		<div class="menu-sidebar__content js-scrollbar1">
			<nav class="navbar-sidebar">
				<ul class="list-unstyled navbar__list">
					<li class="active has-sub">
						<a href="/adminDashboard">
							<i class="fas fa-minus-circle"></i>Dashboard</a>
					</li>
					<li class="has-sub">
						<a class="js-arrow" href="#">
							<i class="fas fa-copy"></i>Reportes</a>
						<ul class="list-unstyled navbar__sub-list js-sub-list">
							<li>
								<a href="/ticketReport">Reporte de Boletos</a>
							</li>
							<li>
								<a href="/flightReport">Reporte de Vuelos</a>
							</li>
							<li>
								<a href="/userReport">Reporte de Usuarios</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="/ticketCancellationSearch">
							<i class="fas fa-minus-circle"></i>Cancelaci??n de Boletos</a>
					</li>
					<li class="has-sub">
						<a class="js-arrow" href="#">
							<i class="fas fa-pencil-square"></i>Mantenimientos</a>
						<ul class="list-unstyled navbar__sub-list js-sub-list">
							<li>
								<a href="/userManagement">Usuarios</a>
							</li>
							<li>
								<a href="/countryManagement">Paises</a>
							</li>
							<li>
								<a href="/airlineManagement">Aerolineas</a>
							</li>
							<li>
								<a href="/planeManagement">Aviones</a>
							</li>
							<li>
								<a href="/flightsManagement">Vuelos</a>
							</li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
	</aside>
	<!-- END MENU SIDEBAR-->

	<!-- PAGE CONTAINER-->
	<div class="page-container">
		<!-- HEADER DESKTOP-->
		<header class="header-desktop">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="header-wrap">
						<div class="header-button">
							<div class="account-wrap">
								<div class="account-item clearfix js-item-menu">
									<div class="image">
										<img src="../../assets/images/icon/avatar-01.jpg" alt="John Doe" />
									</div>
									<div class="content">
										<a class="js-acc-btn" href="#">Administrador</a>
									</div>
									<div class="account-dropdown js-dropdown">
										<div class="info clearfix">
											<div class="image">
												<a href="#">
													<img src="../../assets/images/icon/avatar-01.jpg" alt="John Doe" />
												</a>
											</div>
											<div class="content">
												<h5 class="name">
													<a href="#">${user.name}</a>
												</h5>
												<span class="email">${user.email}</span>
											</div>
										</div>
										<div class="account-dropdown__footer">
											<a href="/logout">
												<i class="zmdi zmdi-power"></i>Logout</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!-- HEADER DESKTOP-->

		<!-- MAIN CONTENT-->
		<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="overview-wrap">
								<h2 class="title-1">Manejo de aerolineas</h2>
							</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" id="addAirlineButton"><i class="fas fa-plus"></i> Agregar aerolinea</button>
						</div>
					</div>
					<hr>
					<div class="row m-t-25">
						<div class="col-10">
							<div class="card">
								<div class="card-header">
									<div class="row justify-content-end">
										<div class="col-sm">
											Aerolineas existentes
										</div>
									</div>

								</div>
								<div class="card-body">
									<div class="container">
										<table id="userTable" class="table table-striped">
											<thead>
											<tr>
												<th></th>
												<th scope="col">ID</th>
												<th scope="col">Nombre</th>
												<th scope="col">Estado</th>
												<th></th>
												<th></th>
											</tr>
											</thead>
											<tbody>
												<c:forEach items="${airlines}" var="item">
													<tr>
														<td>
															<img src="../../assets/images/airlines/${item.id}.png" style="max-height: 100px; max-width: 100px">
														</td>
														<td>${item.id}</td>
														<td>${item.name}</td>
														<td>
															<c:choose>
																<c:when test="${item.status eq true}">
																	<span class="badge badge-success">Activo</span>
																</c:when>
																<c:otherwise>
																	<span class="badge badge-danger">Inactivo</span>
																</c:otherwise>
															</c:choose>
														</td>
														<td><button class="btn btn-info editAirline" data-id="${item.id}"><i class="fas fa-edit"></i></button></td>
														<td><button class="btn btn-danger deleteAirline" data-id="${item.id}"><i class="fas fa-trash-alt"></i></button></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="copyright">
									<p>Copyright ?? 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT-->
		<!-- END PAGE CONTAINER-->
	</div>

</div>

<div id="confirmationModal" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Eliminar aerolinea</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>Esta seguro que desea eliminar a esta aerolinea?</p>
			</div>
			<div id="errorLabelContainer-Confirmation" class="form-group">
				<label id="errorLabel-Confirmation" style="color: red;"></label>
			</div>
			<script>
				$("#errorLabelContainer").hide();
			</script>

			<div class="modal-footer">
				<button id="deleteAirlineConfirmation" type="button" class="btn btn-primary">Aceptar</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			</div>
		</div>
	</div>
</div>

<div id="airlineCreationModal" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div id="login-form" class="login-form">
					<div class="form-group">
						<label>Nombre</label>
						<input id="nameInput" class="au-input au-input--full" type="text" placeholder="Nombre">
					</div>

					<div id="statusContainer" class="custom-control custom-switch">
						<input type="checkbox" class="custom-control-input" id="statusSwitch">
						<label class="custom-control-label" for="statusSwitch">Activo</label>
					</div>
					<script>
						$("#statusContainer").hide();
					</script>

					<br>
					<div id="errorLabelContainer" class="form-group">
						<label id="errorLabel" style="color: red;"></label>
					</div>
					<script>
						$("#errorLabelContainer").hide();
					</script>
				</div>
			</div>
			<div id="creationOptions" class="modal-footer">
				<button id="airlineCreationAccept" type="button" class="btn btn-primary">Aceptar</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>

			</div>
			<div class="row justify-content-md-center">
				<div id="loader" class="col-xs-6">
					<svg class="spinner" width="45px" height="45px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg" style="margin-right: 5px;">
						<circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
					</svg>
				</div>
				<script>
					$("#loader").hide();
				</script>
			</div>
		</div>
	</div>
</div>


<!-- Bootstrap JS-->
<script src="../../assets/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="../../assets/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="../../assets/vendor/slick/slick.min.js">
</script>
<script src="../../assets/vendor/wow/wow.min.js"></script>
<script src="../../assets/vendor/animsition/animsition.min.js"></script>
<script src="../../assets/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="../../assets/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="../../assets/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="../../assets/vendor/circle-progress/circle-progress.min.js"></script>
<script src="../../assets/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../../assets/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="../../assets/vendor/select2/select2.min.js">
</script>

<link rel="stylesheet" type="text/css" href="../../assets/vendor/data-tables/datatables.min.css"/>
<script type="text/javascript" src="../../assets/vendor/data-tables/datatables.min.js"></script>

<!-- Main JS-->
<script src="../../assets/js/main.js"></script>

<script src="../../assets/js/admin/airlineManagement.js"></script>

</body>

</html>
<!-- end document-->
