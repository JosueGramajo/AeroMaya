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
  <!-- HEADER MOBILE-->
  <header class="header-mobile d-block d-lg-none">
    <div class="header-mobile__bar">
      <div class="container-fluid">
        <div class="header-mobile-inner">
          <a class="logo" href="index.html">
            <img src="../assets/images/icon/logo.png" alt="CoolAdmin" />
          </a>
          <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
          </button>
        </div>
      </div>
    </div>
    <nav class="navbar-mobile">
      <div class="container-fluid">
        <ul class="navbar-mobile__list list-unstyled">
          <li class="has-sub">
            <a class="js-arrow" href="#">
              <i class="fas fa-tachometer-alt"></i>Dashboard</a>
            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
              <li>
                <a href="index.html">Dashboard 1</a>
              </li>
              <li>
                <a href="index2.html">Dashboard 2</a>
              </li>
              <li>
                <a href="index3.html">Dashboard 3</a>
              </li>
              <li>
                <a href="index4.html">Dashboard 4</a>
              </li>
            </ul>
          </li>
          <li>
            <a href="chart.html">
              <i class="fas fa-chart-bar"></i>Charts</a>
          </li>
          <li>
            <a href="table.html">
              <i class="fas fa-table"></i>Tables</a>
          </li>
          <li>
            <a href="form.html">
              <i class="far fa-check-square"></i>Forms</a>
          </li>
          <li>
            <a href="calendar.html">
              <i class="fas fa-calendar-alt"></i>Calendar</a>
          </li>
          <li>
            <a href="map.html">
              <i class="fas fa-map-marker-alt"></i>Maps</a>
          </li>
          <li class="has-sub">
            <a class="js-arrow" href="#">
              <i class="fas fa-copy"></i>Pages</a>
            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
              <li>
                <a href="login.html">Login</a>
              </li>
              <li>
                <a href="register.html">Register</a>
              </li>
              <li>
                <a href="forget-pass.html">Forget Password</a>
              </li>
            </ul>
          </li>
          <li class="has-sub">
            <a class="js-arrow" href="#">
              <i class="fas fa-desktop"></i>UI Elements</a>
            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
              <li>
                <a href="button.html">Button</a>
              </li>
              <li>
                <a href="badge.html">Badges</a>
              </li>
              <li>
                <a href="tab.html">Tabs</a>
              </li>
              <li>
                <a href="card.html">Cards</a>
              </li>
              <li>
                <a href="alert.html">Alerts</a>
              </li>
              <li>
                <a href="progress-bar.html">Progress Bars</a>
              </li>
              <li>
                <a href="modal.html">Modals</a>
              </li>
              <li>
                <a href="switch.html">Switchs</a>
              </li>
              <li>
                <a href="grid.html">Grids</a>
              </li>
              <li>
                <a href="fontawesome.html">Fontawesome Icon</a>
              </li>
              <li>
                <a href="typo.html">Typography</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- END HEADER MOBILE-->

  <!-- MENU SIDEBAR-->
  <aside class="menu-sidebar d-none d-lg-block">
    <div class="logo">
      <a href="#">
        <img src="../assets/images/icon/logo.png" alt="Cool Admin" />
      </a>
    </div>
    <div class="menu-sidebar__content js-scrollbar1">
      <nav class="navbar-sidebar">
        <ul class="list-unstyled navbar__list">

          <li>
            <a href="#">
              <i class="fas fa-home"></i>Home</a>
          </li>

          <li>
            <a href="/airlines">
              <i class="fas fa-plane"></i>Aerolineas Afiliadas</a>
          </li>
          <li>
            <a href="#">
              <i class="fas fa-calendar-alt"></i>Calendario</a>
          </li>

          <li>
            <a href="#">
              <i class="fas fa-question"></i>Preguntas</a>
          </li>
          <li>
            <a href="#">
              <i class="fas  fa-bullhorn"></i>Sobre Nosotros</a>
          </li>


        </ul>
      </nav>
    </div>
  </aside>
  <!-- END MENU SIDEBAR-->

  <!-- PAGE CONTAINER-->
  <div class="page-container">
    <!-- HEADER DESKTOP-->
    <header class="header-desktop">
      <div class="section__content section__content--p30">
        <div class="container-fluid">
          <div class="header-wrap">
            <form class="form-header" action="" method="POST">
              <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports..." />
              <button class="au-btn--submit" type="submit">
                <i class="zmdi zmdi-search"></i>
              </button>
            </form>
            <div class="header-button">

              <div class="account-wrap"> </div>
            </div>
            <button id="btnRegister" class="au-btn au-btn-icon au-btn--green">
              <i class="zmdi"></i>Registrarse</button>
            <button id="btnLogin" class="au-btn au-btn-icon au-btn--blue">
              <i class="zmdi"></i>Iniciar Sesion</button>
          </div>
        </div>
      </div>
    </header>
    <!-- HEADER DESKTOP-->

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
                  <div class="exit exit--front fuselage">

                  </div>
                  <ol class="cabin fuselage">
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="1A" />
                          <label for="1A">1A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="1B" />
                          <label for="1B">1B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="1C" />
                          <label for="1C">1C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" disabled id="1D" />
                          <label for="1D">Occupied</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="1E" />
                          <label for="1E">1E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="1F" />
                          <label for="1F">1F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="2A" />
                          <label for="2A">2A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="2B" />
                          <label for="2B">2B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="2C" />
                          <label for="2C">2C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="2D" />
                          <label for="2D">2D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="2E" />
                          <label for="2E">2E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="2F" />
                          <label for="2F">2F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="3A" />
                          <label for="3A">3A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="3B" />
                          <label for="3B">3B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="3C" />
                          <label for="3C">3C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="3D" />
                          <label for="3D">3D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="3E" />
                          <label for="3E">3E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="3F" />
                          <label for="3F">3F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="4A" />
                          <label for="4A">4A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="4B" />
                          <label for="4B">4B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="4C" />
                          <label for="4C">4C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="4D" />
                          <label for="4D">4D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="4E" />
                          <label for="4E">4E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="4F" />
                          <label for="4F">4F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="5A" />
                          <label for="5A">5A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="5B" />
                          <label for="5B">5B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="5C" />
                          <label for="5C">5C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="5D" />
                          <label for="5D">5D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="5E" />
                          <label for="5E">5E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="5F" />
                          <label for="5F">5F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="6A" />
                          <label for="6A">6A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="6B" />
                          <label for="6B">6B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="6C" />
                          <label for="6C">6C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="6D" />
                          <label for="6D">6D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="6E" />
                          <label for="6E">6E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="6F" />
                          <label for="6F">6F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="7A" />
                          <label for="7A">7A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="7B" />
                          <label for="7B">7B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="7C" />
                          <label for="7C">7C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="7D" />
                          <label for="7D">7D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="7E" />
                          <label for="7E">7E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="7F" />
                          <label for="7F">7F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="8A" />
                          <label for="8A">8A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="8B" />
                          <label for="8B">8B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="8C" />
                          <label for="8C">8C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="8D" />
                          <label for="8D">8D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="8E" />
                          <label for="8E">8E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="8F" />
                          <label for="8F">8F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="9A" />
                          <label for="9A">9A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="9B" />
                          <label for="9B">9B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="9C" />
                          <label for="9C">9C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="9D" />
                          <label for="9D">9D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="9E" />
                          <label for="9E">9E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="9F" />
                          <label for="9F">9F</label>
                        </li>
                      </ol>
                    </li>
                    <li class="">
                      <ol class="seats" type="A">
                        <li class="seat">
                          <input type="checkbox" id="10A" />
                          <label for="10A">10A</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="10B" />
                          <label for="10B">10B</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="10C" />
                          <label for="10C">10C</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="10D" />
                          <label for="10D">10D</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="10E" />
                          <label for="10E">10E</label>
                        </li>
                        <li class="seat">
                          <input type="checkbox" id="10F" />
                          <label for="10F">10F</label>
                        </li>
                      </ol>
                    </li>
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
<script src="../assets/js/index.js"></script>

</body>

</html>
<!-- end document-->
