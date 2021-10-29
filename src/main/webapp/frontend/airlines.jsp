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
                <div class="row">
                </div>
                <div class="row m-t-25">
                    <!--AVISO COVID-->
                    <div class="card bg-primary">
                        <strong style="color:#FFFFFF";><i class="fas fa-exclamation-circle" style="color:#FFFFFF";></i> ¡ADVERTENCIA!</strong>
                        <p style="color:#FFFFFF";>Debido a la Pandemia Mundial de COVID-19 se le recomienda investigar
                            sus destinos y la seguridad en los países que visitará. Mantenga la
                            distancia social y no salga o viaje si no es necesario. Para más información,
                            clic en el enlace de la OMG: <a style="color:#FFFF00"; href="https://www.who.int/es">Clic Aquí</a> </p>
                    </div>
                    <div class="col-sm-6 col-lg-3 col-xl-12">

                        <div class="overview-wrap">


                            <h2 class="title-1">Aerolineas Afiliadas</h2>

                        </div>
                    </div>

                    <c:forEach items="${airlines}" var="item" varStatus="loop">
                        <div class="col-md-4">
                            <div class="card">
                                <img class="card-img-top" src="../assets/images/airlines/badges/${item.id}.png" alt="Card image cap">
                                <div class="card-body">
                                    <h4 class="card-title mb-3">${item.name}</h4>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <!--FOOTER-->
                    <footer class="footer">
                        <div class="container-fluid">
                            <div class="copyright">
                                <p><a href="privacidad.php">Política de Privacidad</a></p>
                                <p>Copyright © 2021 Aero Maya. Todos Los Derechos Reservados.</p>
                            </div>
                        </div>
                    </footer>

                </div>
            </div>
        </div>
    </div>
</t:base-page>

</body>

</html>
<!-- end document-->
