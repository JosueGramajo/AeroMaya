<%@tag description="Base page" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
	<!-- Required meta tags-->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="au theme template">
	<meta name="author" content="Hau Nguyen">
	<meta name="keywords" content="au theme template">

	<!-- Title Page-->
	<title>Aeromaya</title>

	<link rel="icon" type="image/x-icon" href="../assets/fav.ico" />

	<!-- Fontfaces CSS-->
	<link href="../assets/css/font-face.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

	<!-- Bootstrap CSS-->
	<link href="../assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

	<!-- Vendor CSS-->
	<link href="../assets/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/wow/animate.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/slick/slick.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/select2/select2.min.css" rel="stylesheet" media="all">
	<link href="../assets/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

	<!-- Main CSS-->
	<link href="../assets/css/theme.css" rel="stylesheet" media="all">
	<link href="../assets/css/header.css" rel="stylesheet" media="all">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />

	<!-- Jquery JS-->
	<script src="../assets/vendor/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<link rel="stylesheet" href="../assets/css/loader.css">
</head>

<body class="animsition">
<div class="page-wrapper">
	<!-- PAGE CONTAINER-->
	<div class="page-container">
		<nav class="navbar navbar-expand-lg navbar-light fixed-top shadow-sm" id="mainNav">
			<div class="container px-5">
				<div>
					<a href="/dashboard">
						<img src="../assets/images/icon/logo.png" alt="Cool Admin" class="header-logo" />
					</a>
				</div>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
					Menu
					<i class="bi-list"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ms-auto me-4 my-3 my-lg-0">
						<li class="nav-item"><a class="nav-link me-lg-3" href="/dashboard">Home</a></li>
						<li class="nav-item"><a class="nav-link me-lg-3" href="/airlines">Aerolineas</a></li>
						<li class="nav-item"><a class="nav-link me-lg-3" href="/calendar">Calendario</a></li>
						<li class="nav-item"><a class="nav-link me-lg-3" href="/questions">Preguntas</a></li>
						<li class="nav-item"><a class="nav-link me-lg-3" href="/aboutUs">Sobre Nosotros</a></li>
					</ul>

					<c:choose>
						<c:when test="${user.loggedIn eq true}">
							<div class="account-wrap">
								<div class="account-item account-item--style2 clearfix js-item-menu">
									<div class="image">
										<img src="../assets/images/icon/avatar-01.jpg" alt="${user.name}" />
									</div>
									<div class="content">
										<a class="js-acc-btn" href="#">${user.name}</a>
									</div>
									<div class="account-dropdown js-dropdown">
										<div class="info clearfix">
											<div class="image">
												<a href="#">
													<img src="../assets/images/icon/avatar-01.jpg" alt="${user.name}" />
												</a>
											</div>
											<div class="content">
												<h5 class="name">
													<a href="#">${user.name}</a>
												</h5>
												<span class="email">${user.email}</span>
											</div>
										</div>
										<div class="account-dropdown__body">
											<div class="account-dropdown__item">
												<a href="/myTickets">
													<i class="zmdi zmdi-account"></i>Mis boletos</a>
											</div>
										</div>
										<div class="account-dropdown__footer">
											<a href="/logout">
												<i class="zmdi zmdi-power"></i>Cerrar Sesión</a>
										</div>
									</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div id="login-general-div">
								<form action="/login" method="get">
									<button type="submit" class="btn btn-primary rounded-pill px-3 mb-2 mb-lg-0">
								<span class="d-flex align-items-center">
									<i class="bi-chat-text-fill me-2"></i>
									<span class="small">Iniciar Sesión</span>
								</span>
									</button>
								</form>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</nav>

		<jsp:doBody/>

	</div>
</div>

<div id="genericModal" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 id="modalTitle" class="modal-title">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="modalBody">Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button id="modalAcceptButton" type="button" class="btn btn-primary">Aceptar</button>
			</div>
		</div>
	</div>
</div>

<div id="loginModal" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div id="user-message">
					<p>Es necesario que ingrese con una cuenta antes de comprar los boletos</p>
				</div>
				<div id="login-form" class="login-form">

					<div class="form-group">
						<label>Correo Electrónico</label>
						<input id="modalEmailInput" class="au-input au-input--full" type="email" name="email" placeholder="Correo Electrónico">
					</div>
					<div class="form-group">
						<label>Contraseña</label>
						<input id="modalPasswordInput" class="au-input au-input--full" type="password" name="password" placeholder="Contraseña">
					</div>
					<div class="register-link">
						<p>
							¿No tienes una Cuenta?
							<a href="/register"> Registrate Aquí</a>
						</p>
					</div>
					<br>
					<div id="errorLabelContainer" class="form-group">
						<label id="errorLabel" style="color: red;"></label>
					</div>
					<script>
                        $("#errorLabelContainer").hide();
					</script>
				</div>
				<script>
                    $("#login-form").hide();
				</script>

			</div>
			<div id="login-accept-modal-footer" class="modal-footer">
				<button id="modalLoginAcceptButton" type="button" class="btn btn-primary">Aceptar</button>
			</div>
			<div id="login-modal-footer" class="modal-footer">
				<button id="modalLoginButton" type="button" class="btn btn-primary">Iniciar Sesión</button>
			</div>
			<script>
                $("#login-modal-footer").hide();
			</script>
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

<div id="succesModal" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 id="modalTitle2" class="modal-title">Compra exitosa!</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="modalBody2">Se a realizado su compra exitosamente.</p>
			</div>
			<div class="modal-footer">
				<button id="acceptSuccess" type="button" class="btn btn-primary">Aceptar</button>
			</div>
		</div>
	</div>
</div>

<!--Date-->
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>

<!-- Bootstrap JS-->
<script src="../assets/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="../assets/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="../assets/vendor/slick/slick.min.js">
</script>
<script src="../assets/vendor/wow/wow.min.js"></script>
<script src="../assets/vendor/animsition/animsition.min.js"></script>
<script src="../assets/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="../assets/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="../assets/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="../assets/vendor/circle-progress/circle-progress.min.js"></script>
<script src="../assets/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../assets/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="../assets/vendor/select2/select2.min.js"></script>

<script src="../assets/vendor/jquery-redirect.js"></script>

<script src="../assets/js/general.js"></script>

<!-- Main JS-->
<script src="../assets/js/main.js"></script>

</body>

</html>