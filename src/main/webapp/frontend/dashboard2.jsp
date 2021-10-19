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
		<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
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
									<form action="/flights" method="POST" class="form-horizontal">

										<div class="row form-group">
											<div class="col col-md-3">
												<label for="selectClassType" class=" form-control-label">Tipo de Pasaje</label>
											</div>
											<div class="col-12 col-md-9">
												<select name="classType" id="selectClassType" class="form-control">
													<option value="0">Seleccionar...</option>
													<option value="1">Clase Economica</option>
													<option value="2">Clase de Negocios</option>
													<option value="3">Primera Clase</option>
												</select>
											</div>
										</div>


										<div class="row form-group">
											<div class="col col-md-3">
												<label for="origin" class=" form-control-label">Origen</label>
											</div>
											<div class="col-12 col-md-9">
												<select name="origin" id="origin" class="form-control">
													<option value="-1">Seleccionar...</option>
													<c:forEach items="${countries}" var="item">
														<option value="${item.name}">${item.name}</option>
													</c:forEach>
												</select>
											</div>
										</div>

										<div class="row form-group">
											<div class="col col-md-3">
												<label for="selectDestination" class=" form-control-label">Destino</label>
											</div>
											<div class="col-12 col-md-9">
												<select name="destination" id="selectDestination" class="form-control">
													<option value="0">Seleccionar...</option>
													<c:forEach items="${countries}" var="item">
														<option value="${item.name}">${item.name}</option>
													</c:forEach>
												</select>
											</div>
										</div>

										<div class="row form-group">
											<div class="col col-md-3">
												<label for="select" class=" form-control-label">Fecha de Salida</label>
											</div>
											<div class="col-12 col-md-9">
												<div class="input-group date" data-provide="datepicker">
													<input name="departureDate" type="text" class="form-control">
													<div class="input-group-addon">
														<span class="glyphicon glyphicon-th"></span>
													</div>
												</div>
											</div>
										</div>

										<div class="row form-group">
											<div class="col col-md-3">
												<label for="select" class=" form-control-label">Fecha de Regreso</label>
											</div>
											<div class="col-12 col-md-9">
												<div class="input-group date" data-provide="datepicker">
													<input name="arrivalDate" type="text" class="form-control">
													<div class="input-group-addon">
														<span class="glyphicon glyphicon-th"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="d-flex flex-row-reverse">
											<input id="btnContinueSearch" type="submit" name="btnContinue" value="Buscar" class="au-btn au-btn-icon au-btn--green" >
										</div>

									</form>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="copyright">
									<p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT-->
			<!-- END PAGE CONTAINER-->
		</div>
	</t:base-page>
</body>

</html>
<!-- end document-->
