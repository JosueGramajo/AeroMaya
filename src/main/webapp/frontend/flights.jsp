<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard</title>

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
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />

    <!-- Include Bootstrap Datepicker -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>

    <!-- Jquery JS-->
    <script src="../assets/vendor/jquery-3.2.1.min.js"></script>

    <script src="../assets/vendor/bootstrap-4.1/bootstrap-input-spinner.js"></script>

</head>

<body class="animsition">
<div class="page-wrapper">

    <nav class="navbar navbar-expand-lg navbar-light fixed-top shadow-sm" id="mainNav">
        <div class="container px-5">
            <div>
                <a href="#">
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
                    <li class="nav-item"><a class="nav-link me-lg-3" href="">Aerolineas</a></li>
                    <li class="nav-item"><a class="nav-link me-lg-3" href="">Calendario</a></li>
                    <li class="nav-item"><a class="nav-link me-lg-3" href="">Preguntas</a></li>
                    <li class="nav-item"><a class="nav-link me-lg-3" href="">Sobre Nosotros</a></li>
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
                                            <a href="#">
                                                <i class="zmdi zmdi-account"></i>Mis boletos</a>
                                        </div>
                                    </div>
                                    <div class="account-dropdown__footer">
                                        <a href="#">
                                            <i class="zmdi zmdi-power"></i>Cerrar Sesión</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <form action="/login" method="get">
                            <button type="submit" class="btn btn-primary rounded-pill px-3 mb-2 mb-lg-0">
								<span class="d-flex align-items-center">
									<i class="bi-chat-text-fill me-2"></i>
									<span class="small">Iniciar Sesión</span>
								</span>
                            </button>
                        </form>

                    </c:otherwise>
                </c:choose>


            </div>
        </div>
    </nav>

    <!-- PAGE CONTAINER-->
    <div class="page-container">
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
                                                ${item.planeObj.airline}
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
    <script src="../assets/js/flights.js"></script>

    <script>
        $("input[type='number']").inputSpinner();
    </script>

</body>

</html>
<!-- end document-->
