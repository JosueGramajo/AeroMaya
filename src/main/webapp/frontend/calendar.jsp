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
	<title>Calendar</title>

	<!-- Calendar -->
	<link href='../assets/vendor/fullcalendar-3.10.0/fullcalendar.css' rel='stylesheet' media="all" />
</head>

<body>
<t:base-page>
<div class="main-content">
	<div class="section__content section__content--p30">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<!--AVISO COVID-->
					<div class="card bg-primary">
						<strong style="color:#FFFFFF;"><i class="fas fa-exclamation-circle" style="color:#FFFFFF;"></i> ¡ADVERTENCIA!</strong>
						<p style="color:#FFFFFF;">Debido a la Pandemia Mundial de COVID-19 se le recomienda investigar
							sus destinos y la seguridad en los países que visitará. Mantenga la
							distancia social y no salga o viaje si no es necesario. Para más información,
							clic en el enlace de la OMG: <a style="color:#FFFF00;" href="https://www.who.int/es">Clic Aquí</a> </p>
					</div>
					<div class="overview-wrap">
						<h1>Calendario</h1>
					</div>

				</div>
			</div>
			<div class="main-content">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col">
								<div class="au-card">
									<div id="calendar"></div>
								</div>
							</div><!-- .col -->
						</div>
					</div>
				</div>
			</div>
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
</t:base-page>

	<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>

	<!-- Main JS-->
	<script src="../assets/vendor/fullcalendar-3.10.0/lib/moment.min.js"></script>
	<script src="../assets/vendor/fullcalendar-3.10.0/fullcalendar.js"></script>
	<script src="../assets/js/main.js"></script>
	<script src="../assets/js/index.js"></script>
	<script type="text/javascript">
        $(function() {
            // for now, there is something adding a click handler to 'a'
            var tues = moment().day(2).hour(19);

            // build trival night events for example data
            var events = [
                {
                    title: "Ida",
                    start: moment().format('YYYY-MM-DD'),
                    url: '#'
                },
                {
                    title: "Vuelta",
                    start: moment().hour(0).add(2, 'days').toISOString(),
                    url: '#'
                }

            ];

            var trivia_nights = []

            for(var i = 1; i <= 4; i++) {
                var n = tues.clone().add(i, 'weeks');
                console.log("isoString: " + n.toISOString());
                trivia_nights.push({
                    title: 'Ofertas',
                    start: n.toISOString(),
                    allDay: false,
                    url: '#'
                });
            }

            // setup a few events
            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay,listWeek'
                },
                events: events.concat(trivia_nights)
            });
        });
	</script>


</body>

</html>
<!-- end document-->
