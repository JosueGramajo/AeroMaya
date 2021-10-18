<%--
  Created by IntelliJ IDEA.
  User: Josue Gramajo
  Date: 11/10/21
  Time: 13:29
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
	<title>Inicio de Sesión</title>

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

	<link href="../assets/css/loader.css" rel="stylesheet" media="all">

	<!-- Jquery JS-->
	<script src="../assets/vendor/jquery-3.2.1.min.js"></script>
</head>

<body class="animsition">
<div class="page-wrapper">
	<div class="page-content--bge5">
		<div class="container">
			<div class="login-wrap">
				<div class="login-content">
					<div class="login-logo">
						<a href="#">
							<img src="../assets/images/icon/login-logo.png" alt="CoolAdmin">
						</a>
					</div>
					<div class="login-form">

							<div class="form-group">
								<label>Correo Electrónico</label>
								<input id="emailInput" class="au-input au-input--full" type="email" name="email" placeholder="Correo Electrónico">
							</div>
							<div class="form-group">
								<label>Contraseña</label>
								<input id="passwordInput" class="au-input au-input--full" type="password" name="password" placeholder="Contraseña">
							</div>
							<div class="login-checkbox">
								<label>

								</label>
								<label>
									<a href="#">¿Olvidaste Tu Contraseña?</a>
								</label>
							</div>

							<div id="login-button">
								<button id="loginButton" class="au-btn au-btn--block au-btn--lightblue m-b-20" type="submit">Iniciar Sesión</button>
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

						<div class="register-link">
							<p>
								¿No tienes una Cuenta?
								<a href="/register"> Registrate Aquí</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
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
<script src="../assets/vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="../assets/js/main.js"></script>
<script src="../assets/js/login.js"></script>

</body>

</html>
<!-- end document-->