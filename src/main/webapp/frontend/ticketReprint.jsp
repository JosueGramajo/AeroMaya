<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: josue
  Date: 12/10/2021
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<!-- Title Page-->
	<title>AeroMaya</title>
	<link href="../assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
	<link href="../assets/css/theme.css" rel="stylesheet" media="all">
	<link href="../assets/css/ticket.css" rel="stylesheet" media="all">
</head>

<body class="animsition">
	<div class="main-content">
	<div class="section__content section__content--p30">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<!-- MAP DATA-->
					<div class="map-data m-b-40">
						<h3 class="title-3 m-b-30">Compra realizada exitosamente!</h3>
						<br>
						<a id="pdfVisualizationButton" href="/downloadPdf?confirmation=${confirmation}" type="submit" class="btn btn-danger"><i class="far fa-file-pdf"></i>&nbsp;Descargar PDF</a>


						<c:forEach items="${groupTicket.seats}" var="item">
							<div class="ticket">
								<div class="ticket--start">
									<img src="https://i.ibb.co/W3cK42J/image-1.png"/>
								</div>
								<div class="ticket--center">
									<div class="ticket--center--row">
										<div class="ticket--center--col">
											<span>Tu boleto para el vuelo</span>
											<strong>${groupTicket.flight.origin} -> ${groupTicket.flight.destination}</strong>
										</div>

										<div class="ticket--center--col">
											<span>Numero de boleto</span>
											<strong>${item.seat}</strong>
										</div>
									</div>
									<div class="ticket--center--row">
										<div class="ticket--center--col">
											<span class="ticket--info--title">Fecha y hora</span>
											<span class="ticket--info--content">${groupTicket.flight.departureDate}</span>
											<span class="ticket--info--content">${groupTicket.flight.departureTime}</span>
										</div>
										<div class="ticket--center--col">
											<span class="ticket--info--title">Destino</span>
											<span class="ticket--info--content">${groupTicket.flight.destination}</span>
										</div>
									</div>
									<div class="ticket--center--row">
										<div class="ticket--center--col">
											<span class="ticket--info--title">Tipo de boleto</span>
											<span class="ticket--info--content">Event category</span>
										</div>
										<div class="ticket--center--col">
											<span class="ticket--info--title">Informacion</span>
											<span  class="ticket--info--content">Orden #${confirmation}. Ordenado por ${groupTicket.user.name}</span>
										</div>
									</div>
								</div>
								<div class="ticket--end">
									<div><img id='barcode' src="https://api.qrserver.com/v1/create-qr-code/?data=https:%2f%2faeromaya.appspot.com/generateTicket?confirmation=${confirmation}&amp;size=100x100" alt="" title="HELLO" width="50" height="50" /></div>
									<div><img class="ticket-logo" src="../assets/images/icon/logo.png"/></div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- END MAP DATA-->
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

