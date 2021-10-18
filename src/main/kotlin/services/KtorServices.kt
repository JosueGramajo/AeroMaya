package services

import com.fasterxml.jackson.databind.ObjectMapper
import firestore.FirestoreUtils
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.jackson
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import objects.User
import java.text.DateFormat


// Entry Point of the application as defined in resources/application.conf.
// @see https://ktor.io/servers/configuration.html#hocon-file
fun Application.main() {
    // This adds Date and Server headers to each response, and allows custom additional headers
    install(DefaultHeaders)
    // This uses use the logger to log every call (request/response)
    install(CallLogging)

    install(ContentNegotiation) {
        jackson {
            dateFormat = DateFormat.getDateInstance()
            disableDefaultTyping()
        }
    }

    routing {
        get("/") {
            call.respondRedirect("/dashboard")
        }

        //USER OPERATIONS
        post("/doLogin") {
            val parameters = call.receiveParameters()
            val email = parameters["email"] ?: ""
            val password = parameters["password"] ?: ""

            if(UserHandler.authenticateUser(email, password)){
                call.response.status(HttpStatusCode.OK)
                call.respondText { "Login exitoso" }
            }else{
                call.response.status(HttpStatusCode.Unauthorized)
                call.respondText { "Usuario o contraseña incorrecta" }
            }
        }

        post("/doRegister"){
            val parameters = call.receiveParameters()
            val name = parameters["name"] ?: ""
            val email = parameters["email"] ?: ""
            val password = parameters["password"] ?: ""

            UserHandler.registerUser(email, password, name)

            call.respondText { "Registro exitoso" }
        }

        post("/addTickets"){
            val parameters = call.receiveParameters()
            val flightId = parameters["id"]
            val seats = parameters["seats"]

            val seatsList = ObjectMapper().readValue(seats, List::class.java) as List<String>

            val id = TicketHandler.addTickets(flightId!!, seatsList)

            call.respondText { id }
        }

    }
}