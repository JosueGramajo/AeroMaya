<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Josue Gramajo
  Date: 11/10/21
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: Josue Gramajo
  Date: 11/10/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Aeromaya</title>
	<link rel="icon" type="image/x-icon" href="../assets/fav.ico" />
	<!-- Font Awesome icons (free version)-->
	<script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
	<!-- Google fonts-->
	<link rel="preconnect" href="https://fonts.gstatic.com" />
	<link href="https://fonts.googleapis.com/css2?family=Tinos:ital,wght@0,400;0,700;1,400;1,700&amp;display=swap" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,wght@0,400;0,500;0,700;1,400;1,500;1,700&amp;display=swap" rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="../assets/css/dashboard/styles.css" rel="stylesheet" />

	<!-- Jquery JS-->
	<script src="../assets/vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="../assets/vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="../assets/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<link rel="stylesheet" href="../assets/vendor/air-datepicker/datepicker.css">
	<script src="../assets/vendor/air-datepicker/datepicker.js"></script>
	<script src="../assets/vendor/air-datepicker/datepicker.es.js"></script>

	<link rel="stylesheet" href="../assets/css/loader.css">
</head>
<body>
<!-- Background Video-->
<video class="bg-video" playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop"><source src="../assets/media/bg.mp4" type="video/mp4" /></video>
<!-- Masthead-->
<div class="masthead">
	<div class="masthead-content text-white">
		<div class="container-fluid px-4 px-lg-0">
			<h1 class="fst-italic lh-1 mb-4">Viaja con nosotros!</h1>
			<p class="mb-5">Con AeroMaya puedes encontrar los boletos aereos con las aereolineas mas prestigiosas del mundo. Solo basta con escribir tu luegar de destino ¿A donde deseas viajar ahora?</p>
			<!-- Email address input-->
			<div class="row input-group-newsletter">
				<div class="col">
					<input class="form-control" id="destinationPlaceText" type="text" placeholder="Escribe un destino..." aria-label="Enter email address..." />
				</div>
				<div id="search-container" class="col-auto">
					<button class="btn btn-primary" id="submitButton" type="submit">Buscar vuelos</button>
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
			<div id="date-section">
				<br>
				<hr>
				<div class="row justify-content-center">
					<div class="">
						<label>Opcional</label>
					</div>
				</div>
				<br>
				<div class="row input-group-newsletter">
					<div class="col">
						<input id="startDate" type="text" name="test" class="form-control" placeholder="Fecha inicial" />
					</div>
					<div class="col">
						<input id="endDate" type="text" name="test" class="form-control" placeholder="Fecha final" />
					</div>
				</div>
			</div>
			<script>
				$("#date-section").hide();
			</script>
		</div>
	</div>
</div>
<!-- Social Icons-->
<!-- For more icon options, visit https://fontawesome.com/icons?d=gallery&p=2&s=brands-->

<c:if test="${user.loggedIn eq false}">
	<div class="social-icons">
		<div class="d-flex flex-row flex-lg-column justify-content-center align-items-center h-100 mt-3 mt-lg-0">
			<a class="btn btn-dark m-3" href="/login"><i class="fas fa-user"></i></a>
		</div>
	</div>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="../assets/js/dashboard/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

<script type="application/javascript">
	var countries = ${countries}
</script>

<script src="../assets/vendor/jquery-redirect.js"></script>

<script src="../assets/js/dashboard.js"></script>

</body>
</html>
