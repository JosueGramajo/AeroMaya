<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: josue
  Date: 11/10/2021
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Title Page-->
    <title>AeroMaya - Vuelos encontrados</title>
</head>

<body class="animsition">

    <t:base-page>
        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="overview-wrap">
                                <h2 class="title-1">Vuelos encontrados</h2>

                            </div>
                        </div>
                    </div>
                    <div class="row m-t-25">
                        <div class="col-10">
                            <c:if test="${empty flights}">
                                <h4>Ningun vuelo encontrado :c</h4>
                            </c:if>

                            <c:forEach items="${flights}" var="item" varStatus="loop">
                                <div class="card">
                                    <div class="card-header">
                                        <div class="row justify-content-end">
                                            <div class="col-sm">
                                                    ${item.airlineName}
                                            </div>
                                            <div class="col-sm">
                                                <div class="float-right">
                                                    <label class="price-label">$ ${item.price}</label>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="card-body">
                                        <div class="container">
                                            <div class="row justify-content-end">
                                                <div class="col-sm">
                                                        ${item.origin} -> ${item.destination}
                                                </div>
                                                <div class="col-sm">

                                                </div>
                                                <div class="col-sm">

                                                </div>
                                            </div>
                                            <div class="row justify-content-end">
                                                <div class="col-sm">
                                                    Salida: ${item.departureDate} (${item.departureTime})
                                                </div>
                                                <div class="col-sm">
                                                    Llegada: ${item.arrivalDate} (${item.arrivalTime})
                                                </div>
                                                <div class="col-sm">

                                                </div>
                                            </div>
                                            <br><br>
                                            <div class="row justify-content-end">
                                                <div class="col-sm">
                                                    <div class="d-flex justify-content-center">
                                                        <div id="seat-amount-selector">
                                                            <input id="seatAmountSelector${loop.index}" data-index="${loop.index}" data-price="${item.price}" class="seatAmountSelector" type="number" value="0" min="0" max="10" step="1"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row justify-content-end">
                                                <div class="col-sm">
                                                    <div class="d-flex justify-content-center">
                                                        <label id="totalLabel${loop.index}" class="total-label"></label>
                                                    </div>
                                                </div>
                                            </div>
                                            <br><br>
                                            <div class="row justify-content-end">
                                                <div class="col-sm">
                                                    <div class="d-flex justify-content-center">
                                                        <div id="continue-button${loop.index}" hidden>
                                                            <input type="button" name="select" class="btn btn-info select-flight" data-id="${item.id}" data-index="${loop.index}" value="Continuar con la compra">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
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

    <script src="../assets/vendor/bootstrap-4.1/bootstrap-input-spinner.js"></script>

    <script src="../assets/js/flights.js"></script>

    <script>
        $("input[type='number']").inputSpinner();
    </script>

</body>

</html>