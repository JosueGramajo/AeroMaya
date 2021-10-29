import com.itextpdf.html2pdf.HtmlConverter
import firestore.FirestoreUtils
import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.servlet.*
import objects.Country
import objects.Flight
import objects.Plane
import objects.User
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream


fun main() {
    val resp = AirlinesHandler.getAirlinesPrintData()

    println("")
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
