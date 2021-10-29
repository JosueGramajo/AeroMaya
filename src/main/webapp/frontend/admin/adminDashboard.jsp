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
								<a href="reporteBoletos.php">Reporte de Boletos</a>
							</li>
							<li>
								<a href="reporteVuelos.php">Reporte de Vuelos</a>
							</li>
							<li>
								<a href="reporteUsuarios.php">Reporte de Usuarios</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="cancelacionBoletos.php">
							<i class="fas fa-minus-circle"></i>Cancelación de Boletos</a>
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
								<a href="reporteBoletos.php">Reporte de Boletos</a>
							</li>
							<li>
								<a href="reporteVuelos.php">Reporte de Vuelos</a>
							</li>
							<li>
								<a href="reporteUsuarios.php">Reporte de Usuarios</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="cancelacionBoletos.php">
							<i class="fas fa-minus-circle"></i>Cancelación de Boletos</a>
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

						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="copyright">
								<p>Copyright © 2021 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
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

<!-- Jquery JS-->
<script src="../../assets/vendor/jquery-3.2.1.min.js"></script>
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

<!-- Main JS-->
<script src="../../assets/js/main.js"></script>

</body>

</html>
<!-- end document-->
