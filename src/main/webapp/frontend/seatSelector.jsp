<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard</title>

    <!-- Seat selector -->
    <link rel="stylesheet" type="text/css" href="../assets/css/seats.css">

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
</head>

<body class="animsition">
<div class="page-wrapper">


    <!-- PAGE CONTAINER-->
    <div class="page-container">

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

        <!-- MAIN CONTENT-->
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
        <!-- END MAIN CONTENT-->
        <!-- END PAGE CONTAINER-->
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

<!--Date-->
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>

<!-- Jquery JS-->
<script src="../assets/vendor/jquery-3.2.1.min.js"></script>
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
<script src=../assets/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="../assets/vendor/circle-progress/circle-progress.min.js"></script>
<script src="../assets/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../assets/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="../assets/vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="../assets/js/main.js"></script>

<script type="text/javascript">
    var ticketsAmount = ${amount};
    var flightId = "${id}";
    var total = ${total};
</script>

<script src="../assets/vendor/jquery-redirect.js"></script>

<script src="../assets/js/seatSelector.js"></script>

</body>

</html>
<!-- end document-->
