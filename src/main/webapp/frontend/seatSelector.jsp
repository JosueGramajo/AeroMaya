<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
    <title>AeroMaya - Seleccionar asientos</title>
    <!-- Seat selector -->
    <link rel="stylesheet" type="text/css" href="../assets/css/seats.css">
</head>

<body class="animsition">

    <t:base-page>
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- MAP DATA-->
                            <div class="map-data m-b-40">
                                <h3 class="title-3 m-b-30">
                                    <i class="zmdi zmdi-map"></i>Seleccione su asiento</h3>


                                <div class="plane">
                                    <div class="cockpit">
                                        <h1>Seleccione un asiento</h1>
                                    </div>
                                    <div class="exit exit--front fuselage"></div>

                                    <ol class="cabin fuselage">
                                        <c:forEach var="master" items="${seats}" varStatus="loop">
                                            <li class="row row--1">
                                                <ol class="seats" type="A">
                                                    <c:forEach var="item" items="${master}">
                                                        <li class="seat">
                                                            <c:choose>
                                                                <c:when test="${item.occupied eq true}">
                                                                    <input class="seatCheckbox" type="checkbox" id="${item.name}" disabled/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input class="seatCheckbox" type="checkbox" id="${item.name}" data-index="${loop.index}" data-seat="${item.name}"/>
                                                                </c:otherwise>
                                                            </c:choose>

                                                            <label for="${item.name}">${item.name}</label>
                                                        </li>
                                                    </c:forEach>
                                                </ol>
                                            </li>
                                        </c:forEach>
                                    </ol>
                                    <div class="exit exit--back fuselage">

                                    </div>
                                </div>

                                <br/><br/><br/>
                                <div class="d-flex justify-content-center">
                                    <input id="btnContinueToPayment" type="button" name="btn" class="btn btn-info" value="Continuar">
                                </div>
                            </div>
                            <!-- END MAP DATA-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </t:base-page>

    <script type="text/javascript">
        var ticketsAmount = ${amount};
        var flightId = "${id}";
        var total = ${total};
    </script>

    <script src="../assets/js/seatSelector.js"></script>

</body>

</html>
<!-- end document-->
