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
	<title>Aerolineas</title>

</head>

<body class="animsition">
<t:base-page>
	<div class="main-content">
	<div class="section__content section__content--p30">
		<div class="container-fluid">

			<div class="row m-t-25">
				<div class="col-sm-6 col-lg-3 col-xl-12">
					<div class="card">
						<div class="card-header">
							Compras realizadas
						</div>
						<div class="card-body card-block">
							<table class="table">
								<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Vuelo</th>
									<th scope="col">Cantidad boletos</th>
									<th scope="col">Precio</th>
									<th></th>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${list}" var="item" varStatus="loop">
									<tr>
										<th scope="row">${loop.index + 1}</th>
										<td>${item.flightDesc}</td>
										<td>${item.amount}</td>
										<td>${item.price}</td>
										<td><input type="button" class="btn btn-info select-buy" value="Ver boletos" data-id="${item.id}"></td>
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
						<p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</t:base-page>

<script src="../assets/vendor/jquery-redirect.js"></script>
<script src="../assets/js/myTickets.js"></script>

</body>

</html>
<!-- end document-->
