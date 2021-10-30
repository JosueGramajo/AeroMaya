package services

import CountryHandler
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import firestore.FirestoreUtils
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.jackson
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import objects.Flight
import objects.Plane
import objects.User
import utils.Companion
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

    val routing = routing {
        get("/") {
            call.respondRedirect("/index")
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

        post("/loginRedirect") {
            val parameters = call.receiveParameters()
            val email = parameters["email"] ?: ""
            val password = parameters["password"] ?: ""

            if(UserHandler.authenticateUser(email, password)){
                call.response.status(HttpStatusCode.OK)
                if (Companion.currentUser.role == 1){
                    call.respondText{ "/adminDashboard" }
                }else{
                    call.respondText{ "/dashboard" }
                }
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

            UserHandler.registerUser(email, password, name, 2)

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

        get("/logout"){
            Companion.currentUser = User()
            call.respondRedirect("/login")
        }

        get("/searchTicketsForUser") {
            val email = call.request.queryParameters["email"] ?: ""
            if (email.isEmpty()){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@get
            }

            val tickets = TicketHandler.getUserTickets(email);

            call.respondText { Gson().toJson(tickets) }
        }

        post("/cancelTicket"){
            val id = call.receiveParameters()["id"] ?: ""
            TicketHandler.cancelTicket(id)

            call.respondText { "Ticket cancelado exitosamente" }
        }

        //=======USER CRUD=======
        post("/createUser"){
            val params = call.receiveParameters()
            val name = params["name"] ?: ""
            val email = params["email"] ?: ""
            val password = params["password"] ?: ""
            val role = params["role"]?.toIntOrNull() ?: -1

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || role == -1){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@post
            }

            UserHandler.registerUser(email, password, name, role)

            call.respondText { "Usuario creado exitosamente" }
        }

        post("/getUser"){
            val id = call.receiveParameters()["id"] ?: ""
            val user = FirestoreUtils.getObjectWithId<User>(FirestoreUtils.USER_COLLECTION, id)
            user?.let {
                call.respondText { Gson().toJson(it) }
            } ?: kotlin.run {
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Usuario no encontrado" }
                return@post
            }
        }

        put("/updateUser"){
            val params = call.receiveParameters()
            val id = params["id"] ?: ""
            val name = params["name"] ?: ""
            val email = params["email"] ?: ""
            val password = params["password"] ?: ""
            val role = params["role"]?.toIntOrNull() ?: -1

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || role == -1){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@put
            }

            UserHandler.updateUser(id, email, password, name, role)

            call.respondText { "Usuario actualizado exitosamente" }
        }

        delete("/deleteUser") {
            val id = call.receiveParameters()["id"] ?: ""
            FirestoreUtils.deleteDocumentWithId(FirestoreUtils.USER_COLLECTION, id)
            call.respondText { "Usuario eliminado exitosamente" }
        }
        //==============

        //======PLANE CRUD======
        post("/createPlane"){
            val params = call.receiveParameters()
            val name = params["name"] ?: ""
            val airline = params["airline"] ?: ""
            val capacity = params["capacity"]?.toIntOrNull() ?: -1

            if (name.isEmpty() || airline.isEmpty() || capacity == -1){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@post
            }

            PlaneHandler.createPlane(name, airline, capacity)

            call.respondText { "Avion creado exitosamente" }
        }

        get("/getPlane") {
            val id = call.request.queryParameters["id"] ?: ""
            val plane = FirestoreUtils.getObjectWithId<Plane>(FirestoreUtils.PLANES_COLLECTION, id)
            plane?.let {
                call.respondText { Gson().toJson(it) }
            } ?: kotlin.run {
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Avion no encontrado" }
                return@get
            }
        }
        put("/updatePlane"){
            val params = call.receiveParameters()
            val id = params["id"] ?: ""
            val name = params["name"] ?: ""
            val airline = params["airline"] ?: ""
            val capacity = params["capacity"]?.toIntOrNull() ?: -1

            if (id.isEmpty() || name.isEmpty() || airline.isEmpty() || capacity == -1){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@put
            }

            val result = PlaneHandler.updatePlane(id, name, airline, capacity)

            if (result){
                call.response.status(HttpStatusCode.OK)
                call.respondText { "Avion editado exitosamente" }
            }else{
                call.response.status(HttpStatusCode.Conflict)
                call.respondText { "Este avion ya se encuentra asignado a un vuelo y no se puede editar" }
            }
        }

        delete("/deletePlane") {
            val id = call.receiveParameters()["id"] ?: ""
            val result = PlaneHandler.deletePlane(id)
            if (result){
                call.response.status(HttpStatusCode.OK)
                call.respondText { "Avion eliminado exitosamente" }
            }else{
                call.response.status(HttpStatusCode.Conflict)
                call.respondText { "Este avion ya se encuentra asignado a un vuelo y no se puede eliminar" }
            }
        }
        //============

        //======Countries======
        put("/changeCountryStatus") {
            val params = call.receiveParameters()
            val id = params["id"] ?: ""
            val status = params["status"]?.toBooleanStrictOrNull() ?: false

            CountryHandler.updateCountryStatus(id, status)

            call.respondText { "Estado actualizado exitosamente" }
        }
        //====================

        //=====Airlines=====
        post("/createAirline"){
            val params = call.receiveParameters()
            val name = params["name"] ?: ""

            if (name.isEmpty()){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@post
            }

            AirlinesHandler.createAirline(name)

            call.respondText { "Aerolinea creado exitosamente" }
        }

        get("/getAirline") {
            val id = call.request.queryParameters["id"] ?: ""
            val plane = AirlinesHandler.getAirline(id)
            plane?.let {
                call.respondText { Gson().toJson(it) }
            } ?: kotlin.run {
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Aerolinea no encontrado" }
                return@get
            }
        }
        put("/updateAirline"){
            val params = call.receiveParameters()
            val id = params["id"] ?: ""
            val name = params["name"] ?: ""
            val status = params["status"]?.toBooleanStrictOrNull() ?: false

            if (id.isEmpty() || name.isEmpty()){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@put
            }

            AirlinesHandler.updateAirline(id, name, status)

            call.response.status(HttpStatusCode.OK)
            call.respondText { "Aerolinea editado exitosamente" }
        }

        delete("/deleteAirline") {
            val id = call.receiveParameters()["id"] ?: ""
            val result = AirlinesHandler.deleteAirline(id)
            if (result){
                call.response.status(HttpStatusCode.OK)
                call.respondText { "Aerolinea eliminado exitosamente" }
            }else{
                call.response.status(HttpStatusCode.Conflict)
                call.respondText { "Esta aerolinea ya se encuentra asignado a uno o mas aviones, por lo tanto no se puede eliminar" }
            }
        }
        //======

        //=====Flights====
        post("/createFlight"){
            val params = call.receiveParameters()
            val arrivalDate = params["arrivalDate"] ?: ""
            val arrivalTime = params["arrivalTime"] ?: ""
            val departureDate = params["departureDate"] ?: ""
            val departureTime = params["departureTime"] ?: ""
            val origin = params["origin"] ?: ""
            val destination = params["destination"] ?: ""
            val description = params["description"] ?: ""
            val plane = params["plane"] ?: ""
            val price = params["price"]?.toFloatOrNull() ?: -1f

            if (arrivalDate.isEmpty() || arrivalTime.isEmpty() || departureDate.isEmpty() || departureTime.isEmpty() || origin.isEmpty()
                || description.isEmpty() || destination.isEmpty() || plane.isEmpty() || price == -1f){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@post
            }

            FlightsHandler.createFlight(arrivalDate, arrivalTime, departureDate, departureTime, origin, destination, description, plane, price)

            call.respondText { "Vuelo creado exitosamente" }
        }

        get("/getFlight") {
            val id = call.request.queryParameters["id"] ?: ""
            val flight = FirestoreUtils.getObjectWithId<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, id)
            flight?.let {
                call.respondText { Gson().toJson(it) }
            } ?: kotlin.run {
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Vuelo no encontrado" }
                return@get
            }
        }
        put("/updateFlight"){
            val params = call.receiveParameters()
            val id = params["id"] ?: ""
            val arrivalDate = params["arrivalDate"] ?: ""
            val arrivalTime = params["arrivalTime"] ?: ""
            val departureDate = params["departureDate"] ?: ""
            val departureTime = params["departureTime"] ?: ""
            val origin = params["origin"] ?: ""
            val destination = params["destination"] ?: ""
            val description = params["description"] ?: ""
            val plane = params["plane"] ?: ""
            val price = params["price"]?.toFloatOrNull() ?: -1f
            val status = params["status"]?.toBooleanStrictOrNull() ?: false

            if (id.isEmpty() || arrivalDate.isEmpty() || arrivalTime.isEmpty() || departureDate.isEmpty() || departureTime.isEmpty() || origin.isEmpty()
                || description.isEmpty() || destination.isEmpty() || plane.isEmpty() || price == -1f){
                call.response.status(HttpStatusCode.BadRequest)
                call.respondText { "Datos erroneos" }
                return@put
            }

            val result = FlightsHandler.editFlight(id, arrivalDate, arrivalTime, departureDate, departureTime, origin, destination, description, plane, price, status)

            if (result){
                call.response.status(HttpStatusCode.OK)
                call.respondText { "Aerolinea editado exitosamente" }
            }else{
                call.response.status(HttpStatusCode.Forbidden)
                call.respondText { "Ya existen uno o mas tickets comprados para este vuelo, por lo que no puede ser editado" }
            }
        }

        delete("/deleteFlight") {
            val id = call.receiveParameters()["id"] ?: ""
            val result = FlightsHandler.deleteFlight(id)
            if (result){
                call.response.status(HttpStatusCode.OK)
                call.respondText { "Vuelo eliminado exitosamente" }
            }else{
                call.response.status(HttpStatusCode.Conflict)
                call.respondText { "Ya existen uno o mas tickets comprados para este vuelo, por lo que no puede ser editado" }
            }
        }
        //======
    }
}