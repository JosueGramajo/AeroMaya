import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.servlet.*


fun main() {
    /*
    val html = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "  <meta charset=\"utf-8\">\n" +
            "  <title>test</title>\n" +
            "  <style>\n" +
            "    @import url('https://fonts.googleapis.com/css?family=Oswald');\n" +
            "* {\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    border: 0;\n" +
            "    box-sizing: border-box\n" +
            "}\n" +
            "\n" +
            "body {\n" +
            "    background-color: #dadde6;\n" +
            "    font-family: arial\n" +
            "}\n" +
            "\n" +
            ".fl-left {\n" +
            "    float: left\n" +
            "}\n" +
            "\n" +
            ".fl-right {\n" +
            "    float: right\n" +
            "}\n" +
            "\n" +
            "h1 {\n" +
            "    text-transform: uppercase;\n" +
            "    font-weight: 900;\n" +
            "    border-left: 10px solid #fec500;\n" +
            "    padding-left: 10px;\n" +
            "    margin-bottom: 30px\n" +
            "}\n" +
            "\n" +
            ".row {\n" +
            "    overflow: hidden\n" +
            "}\n" +
            "\n" +
            ".card {\n" +
            "    display: table-row;\n" +
            "    width: 49%;\n" +
            "    background-color: #fff;\n" +
            "    color: #989898;\n" +
            "    margin-bottom: 10px;\n" +
            "    font-family: 'Oswald', sans-serif;\n" +
            "    text-transform: uppercase;\n" +
            "    border-radius: 4px;\n" +
            "    position: relative\n" +
            "}\n" +
            "\n" +
            ".card+.card {\n" +
            "    margin-left: 2%\n" +
            "}\n" +
            "\n" +
            ".date {\n" +
            "    display: table-cell;\n" +
            "    width: 25%;\n" +
            "    position: relative;\n" +
            "    text-align: center;\n" +
            "    border-right: 2px dashed #dadde6\n" +
            "}\n" +
            "\n" +
            ".date:before,\n" +
            ".date:after {\n" +
            "    content: \"\";\n" +
            "    display: block;\n" +
            "    width: 30px;\n" +
            "    height: 30px;\n" +
            "    background-color: #DADDE6;\n" +
            "    position: absolute;\n" +
            "    top: -15px;\n" +
            "    right: -15px;\n" +
            "    z-index: 1;\n" +
            "    border-radius: 50%\n" +
            "}\n" +
            "\n" +
            ".date:after {\n" +
            "    top: auto;\n" +
            "    bottom: -15px\n" +
            "}\n" +
            "\n" +
            ".date time {\n" +
            "    display: block;\n" +
            "    position: absolute;\n" +
            "    top: 50%;\n" +
            "    left: 50%;\n" +
            "    -webkit-transform: translate(-50%, -50%);\n" +
            "    -ms-transform: translate(-50%, -50%);\n" +
            "    transform: translate(-50%, -50%)\n" +
            "}\n" +
            "\n" +
            ".date time span {\n" +
            "    display: block\n" +
            "}\n" +
            "\n" +
            ".date time span:first-child {\n" +
            "    color: #2b2b2b;\n" +
            "    font-weight: 600;\n" +
            "    font-size: 250%\n" +
            "}\n" +
            "\n" +
            ".date time span:last-child {\n" +
            "    text-transform: uppercase;\n" +
            "    font-weight: 600;\n" +
            "    margin-top: -10px\n" +
            "}\n" +
            "\n" +
            ".card-cont {\n" +
            "    display: table-cell;\n" +
            "    width: 75%;\n" +
            "    font-size: 85%;\n" +
            "    padding: 10px 10px 30px 50px\n" +
            "}\n" +
            "\n" +
            ".card-cont h3 {\n" +
            "    color: #3C3C3C;\n" +
            "    font-size: 130%\n" +
            "}\n" +
            "\n" +
            ".row:last-child .card:last-of-type .card-cont h3 {\n" +
            "    text-decoration: line-through\n" +
            "}\n" +
            "\n" +
            ".card-cont>div {\n" +
            "    display: table-row\n" +
            "}\n" +
            "\n" +
            ".card-cont .even-date i,\n" +
            ".card-cont .even-info i,\n" +
            ".card-cont .even-date time,\n" +
            ".card-cont .even-info p {\n" +
            "    display: table-cell\n" +
            "}\n" +
            "\n" +
            ".card-cont .even-date i,\n" +
            ".card-cont .even-info i {\n" +
            "    padding: 5% 5% 0 0\n" +
            "}\n" +
            "\n" +
            ".card-cont .even-info p {\n" +
            "    padding: 30px 50px 0 0\n" +
            "}\n" +
            "\n" +
            ".card-cont .even-date time span {\n" +
            "    display: block\n" +
            "}\n" +
            "\n" +
            ".card-cont a {\n" +
            "    display: block;\n" +
            "    text-decoration: none;\n" +
            "    width: 80px;\n" +
            "    height: 30px;\n" +
            "    background-color: #D8DDE0;\n" +
            "    color: #fff;\n" +
            "    text-align: center;\n" +
            "    line-height: 30px;\n" +
            "    border-radius: 2px;\n" +
            "    position: absolute;\n" +
            "    right: 10px;\n" +
            "    bottom: 10px\n" +
            "}\n" +
            "\n" +
            ".row:last-child .card:first-child .card-cont a {\n" +
            "    background-color: #037FDD\n" +
            "}\n" +
            "\n" +
            ".row:last-child .card:last-child .card-cont a {\n" +
            "    background-color: #F8504C\n" +
            "}\n" +
            "\n" +
            "@media screen and (max-width: 860px) {\n" +
            "    .card {\n" +
            "        display: block;\n" +
            "        float: none;\n" +
            "        width: 100%;\n" +
            "        margin-bottom: 10px\n" +
            "    }\n" +
            "    .card+.card {\n" +
            "        margin-left: 0\n" +
            "    }\n" +
            "    .card-cont .even-date,\n" +
            "    .card-cont .even-info {\n" +
            "        font-size: 75%\n" +
            "    }\n" +
            "}\n" +
            "  </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<section class=\"container\">\n" +
            "<h1>Events</h1>\n" +
            "  <div class=\"row\">\n" +
            "    <article class=\"card fl-left\">\n" +
            "      <section class=\"date\">\n" +
            "        <time datetime=\"23th feb\">\n" +
            "          <span>23</span><span>feb</span>\n" +
            "        </time>\n" +
            "      </section>\n" +
            "      <section class=\"card-cont\">\n" +
            "        <small>dj khaled</small>\n" +
            "        <h3>live in sydney</h3>\n" +
            "        <div class=\"even-date\">\n" +
            "         <i class=\"fa fa-calendar\"></i>\n" +
            "         <time>\n" +
            "           <span>wednesday 28 december 2014</span>\n" +
            "           <span>08:55pm to 12:00 am</span>\n" +
            "         </time>\n" +
            "        </div>\n" +
            "        <div class=\"even-info\">\n" +
            "          <i class=\"fa fa-map-marker\"></i>\n" +
            "          <p>\n" +
            "            nexen square for people australia, sydney\n" +
            "          </p>\n" +
            "        </div>\n" +
            "        <a href=\"#\">tickets</a>\n" +
            "      </section>\n" +
            "    </article>\n" +
            "\n" +
            "  </div>\n" +
            "  <div class=\"row\">\n" +
            "    <article class=\"card fl-left\">\n" +
            "      <section class=\"date\">\n" +
            "        <time datetime=\"23th feb\">\n" +
            "          <span>23</span><span>feb</span>\n" +
            "        </time>\n" +
            "      </section>\n" +
            "      <section class=\"card-cont\">\n" +
            "        <small>dj khaled</small>\n" +
            "        <h3>music kaboom festivel</h3>\n" +
            "        <div class=\"even-date\">\n" +
            "         <i class=\"fa fa-calendar\"></i>\n" +
            "         <time>\n" +
            "           <span>wednesday 28 december 2014</span>\n" +
            "           <span>08:55pm to 12:00 am</span>\n" +
            "         </time>\n" +
            "        </div>\n" +
            "        <div class=\"even-info\">\n" +
            "          <i class=\"fa fa-map-marker\"></i>\n" +
            "          <p>\n" +
            "            nexen square for people australia, sydney\n" +
            "          </p>\n" +
            "        </div>\n" +
            "        <a href=\"#\">booked</a>\n" +
            "      </section>\n" +
            "    </article>\n" +
            "\n" +
            "  </div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>"

    val f = File("test" + ".pdf")
    HtmlConverter.convertToPdf(html, FileOutputStream(f))
    */

}

fun startLocalServer(){
    embeddedServer(Netty, 8989) {
        routing {
            get("/generateTicket/{id}"){
                val id = call.parameters["id"] ?: ""
                call.respondText { id }
            }

        }
    }.start(wait = true)
}


/*val airline = Airline("JetBlue Airways", true)
val airline2 = Airline("American Airlines", true)
val airline3 = Airline("United Airlines", true)
val airline4 = Airline("Southwest Airlines", true)
val airline5 = Airline("Spirit Airlines", true)

val planeSeats = arrayListOf<PlaneSeat>()

for (i in "ABCDEF"){
    for (e in 1 until 10){
        val classType = if (e.isBetween(1, 3)){
            "Primera clase"
        }else if(e.isBetween(4, 6)){
            "Clase negocios"
        }else{
            "Clase economica"
        }

        planeSeats.add(PlaneSeat(classType, "$e$i", e, i.toString()))
    }
}

val plane = Plane(airline.name, 60, 18, 18, 24, "Avion 1", planeSeats, null)
val plane2 = Plane(airline2.name, 60, 18, 18, 24, "Avion 2", planeSeats, null)
val plane3 = Plane(airline3.name, 60, 18, 18, 24, "Avion 3", planeSeats, null)
val plane4 = Plane(airline4.name, 60, 18, 18, 24, "Avion 4", planeSeats, null)
val plane5 = Plane(airline5.name, 60, 18, 18, 24, "Avion 5", planeSeats, null)

listOf(plane, plane2, plane3, plane4, plane5).map {
    FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.PLANES_COLLECTION, it)
}*/

/*
val plane1 = "N90kpD9MTk3yC30iB9Jm"
val plane2 = "RoDjxSvfqMPK6pKKsOlN"
val plane3 = "bhNHIyuM5V1sqlB7yfvM"
val plane4 = "ed1eO4poXF7v7ne7GzOS"
val plane5 = "oxuIrlfGdbbvxsPm7a36"
val fli1 = Flight("08/11/2021", "1:00PM", "15/10/2021", "6:00AM", "Vuelo a Suiza", "Suiza", "Guatemala", 765, plane1, 3478f, true, null, "")
val fli2 = Flight("31/10/2021", "5:00PM", "15/10/2021", "7:00AM", "Vuelo a Mexico", "Mexico", "Guatemala", 654, plane2, 1254f, true, null, "")
val fli3 = Flight("15/11/2021", "5:00PM", "25/10/2021", "10:00AM", "Vuelo a Italia", "Italia", "Guatemala", 432, plane3, 2478f, true, null, "")
val fli4 = Flight("10/11/2021", "1:00PM", "16/10/2021", "6:00AM", "Vuelo a Suiza", "Suiza", "Guatemala", 543, plane4, 3004f, true, null, "")
val fli5 = Flight("30/11/2021", "1:00PM", "15/11/2021", "7:00AM", "Vuelo a Alemania", "Alemania", "Guatemala", 890, plane5, 2134f, true, null, "")
listOf(fli1, fli2, fli3, fli4, fli5).map { FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.FLIGHTS_COLLECTION, it) }
*/

/*
listOf(

    Country("Alemania","DEU", true),
    Country("Angola","AGO", true),
    Country("Antigua y Barbuda","ATG", true),
    Country("Argentina","ARG", true),
    Country("Australia","AUS", true),
    Country("Austria","AUT", true),
    Country("Bahamas","BHS", true),
    Country("Bangladesh","BGD", true),
    Country("Barbados","BRB", true),
    Country("Brasil","BRA", true),
    Country("Bélgica","BEL", true),
    Country("Canadá","CAN", true),
    Country("Chile","CHL", true),
    Country("China","CHN", true),
    Country("Colombia","COL", true),
    Country("Costa Rica","CRI", true),
    Country("Croacia","HRV", true),
    Country("Egipto","EGY", true),
    Country("España","ESP", true),
    Country("Estados Unidos de América","USA", true),
    Country("Federación de Rusia","RUS", true),
    Country("Fiji","FJI", true),
    Country("Filipinas","PHL", true),
    Country("Finlandia","FIN", true),
    Country("Francia","FRA", true),
    Country("Ghana","GHA", true),
    Country("Grecia","GRC", true),
    Country("Guatemala","GTM", true),
    Country("Guyana","GUY", true),
    Country("India","IND", true),
    Country("Indonesia","IDN", true),
    Country("Irlanda","IRL", true),
    Country("Islandia","ISL", true),
    Country("Italia","ITA", true),
    Country("Jamaica","JAM", true),
    Country("Japón","JPN", true),
    Country("Kazajstán","KAZ", true),
    Country("Luxemburgo","LUX", true),
    Country("Madagascar","MDG", true),
    Country("Maldivas","MDV", true),
    Country("Marruecos","MAR", true),
    Country("Mongolia","MNG", true),
    Country("Montenegro","MNE", true),
    Country("Mexico","MEX", true),
    Country("Nigeria","NGA", true),
    Country("Noruega","NOR", true),
    Country("Nueva Zelandia","NZL", true),
    Country("Níger","NER", true),
    Country("Panamá","PAN", true),
    Country("Países Bajos","NLD", true),
    Country("Perú","PER", true),
    Country("Polonia","POL", true),
    Country("Portugal","PRT", true),
    Country("Qatar","QAT", true),
    Country("Reino Unido","GBR", true),
    Country("Sierra Leona","SLE", true),
    Country("Singapur","SGP", true),
    Country("Sudáfrica","ZAF", true),
    Country("Suecia","SWE", true),
    Country("Suiza","CHE", true),
    Country("Tailandia","THA", true),
    Country("Turquía","TUR", true),
    Country("Ucrania","UKR", true),
    Country("Uganda","UGA", true),
    Country("Uruguay","URY", true)

).map {
    FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.COUNTRIES_COLLECTION, it)
}

*/
