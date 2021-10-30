import com.fasterxml.jackson.databind.ObjectMapper
import firestore.FirestoreUtils
import objects.*
import utils.Companion
import utils.DateUtils
import utils.capitalizeWords
import utils.isBetween

object UserHandler{
    fun authenticateUser(email : String, password : String) : Boolean{
        val user = FirestoreUtils.getObjectWithQuery<User>(
            FirestoreUtils.USER_COLLECTION,
            FirestoreQuery("email", email),
            FirestoreQuery("password", password)
        )

        user?.let {
            it.loggedIn = true
            Companion.currentUser = it
            return true
        }

        return false
    }

    fun registerUser(email: String, password: String, name : String, role : Int){
        val user = User("", email, password, role, name,false)

        FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.USER_COLLECTION, user)
    }

    fun updateUser(id : String, email: String, password: String, name : String, role : Int){
        val user = User("", email, password, role, name,false)

        FirestoreUtils.updateDocumentWithObject(FirestoreUtils.USER_COLLECTION, id, user)
    }
}

object PlaneHandler{
    fun getPlanes() : List<Plane>{
        val planes = FirestoreUtils.getObjectList<Plane>(FirestoreUtils.PLANES_COLLECTION)
        planes.forEach { plane ->
            val airline = FirestoreUtils.getObjectWithId<Airline>(FirestoreUtils.AIRLINES_COLLECTION, plane.airline)
            plane.airlineName = airline?.name ?: ""
        }

        return planes
    }

    fun createPlane(name : String, airline : String, capacity : Int){
        val plane = generatePlane(name, airline, capacity)

        FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.PLANES_COLLECTION, plane)
    }

    fun updatePlane(id : String, name : String, airline : String, capacity : Int) : Boolean{
        val flights = FirestoreUtils.getObjectList<Flight>(FirestoreUtils.FLIGHTS_COLLECTION)
        if (flights.map { it.plane }.contains(id)){
            return false
        }

        val plane = generatePlane(name, airline, capacity)

        FirestoreUtils.updateDocumentWithObject(FirestoreUtils.PLANES_COLLECTION, id, plane)

        return true
    }

    fun deletePlane(id : String) : Boolean{
        val flights = FirestoreUtils.getObjectList<Flight>(FirestoreUtils.FLIGHTS_COLLECTION)
        if (flights.map { it.plane }.contains(id)){
            return false
        }

        FirestoreUtils.deleteDocumentWithId(FirestoreUtils.PLANES_COLLECTION, id)

        return true
    }

    private fun generatePlane(name : String, airline : String, capacity : Int) : Plane{
        val seats = arrayListOf<PlaneSeat>()
        var firstClassAmount = 0
        var businessClassAmount = 0
        var economicClassAmount = 0

        val rows = capacity / 6
        for (e in 1 until rows){
            "ABCDEF".forEach { c ->
                val classType = if (e.isBetween(1, 3)){
                    firstClassAmount++
                    "Primera clase"
                }else if(e.isBetween(4, 6)){
                    businessClassAmount++
                    "Clase negocios"
                }else{
                    economicClassAmount++
                    "Clase economica"
                }

                seats.add(PlaneSeat("",classType,"$e$c", e, c.toString()))
            }
        }

        return Plane("", airline, capacity, businessClassAmount, economicClassAmount, firstClassAmount, name, seats, "")
    }
}

object FlightsHandler{
    fun searchFlights(destination : String?, departureDate : String?, arrivalDate : String?) : List<Flight>{
        val queries = arrayListOf<FirestoreQuery>()
        queries.add(FirestoreQuery("origin", "guatemala"))

        if (!destination.isNullOrEmpty()){
            queries.add(FirestoreQuery("destination", destination.lowercase()))
        }
        if (!departureDate.isNullOrEmpty()){
            queries.add(FirestoreQuery("departureDate", departureDate))
        }
        if (!departureDate.isNullOrEmpty() && !arrivalDate.isNullOrEmpty()){
            queries.add(FirestoreQuery("arrivalDate", arrivalDate))
        }

        val flights = FirestoreUtils.getObjectListWithQuery<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, *queries.toTypedArray())
        flights.forEach {
            val plane = FirestoreUtils.getObjectWithId<Plane>(FirestoreUtils.PLANES_COLLECTION, it.plane)
            val planeAirline = plane?.airline ?: ""

            val airline = FirestoreUtils.getObjectWithId<Airline>(FirestoreUtils.AIRLINES_COLLECTION, planeAirline)
            val airlineName = airline?.name ?: ""

            it.airlineName = airlineName
        }

        return flights
    }

    fun searchForAirline(airline: String) : List<Flight>{
        val airlineObj = FirestoreUtils.getObjectWithId<Airline>(FirestoreUtils.AIRLINES_COLLECTION, airline)!!

        val planesOfAirline = FirestoreUtils.getObjectListWithQuery<Plane>(FirestoreUtils.PLANES_COLLECTION, FirestoreQuery("airline", airline))

        val resp = arrayListOf<Flight>()

        planesOfAirline.forEach { plane ->
            val flighstForPlane = FirestoreUtils.getObjectListWithQuery<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, FirestoreQuery("plane", plane.id))

            flighstForPlane.map {
                it.airlineName = airlineObj.name
                resp.add(it)
            }
        }

        return resp
    }

    fun getFlightSeats(id : String) : List<List<FlightSeat>>{
        val result = arrayListOf<List<FlightSeat>>()

        FirestoreUtils.getObjectWithId<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, id)?.let {
            val seats = it.seats
            val uniqueLevels = seats.map { it.level }.distinct()
            uniqueLevels.map { l ->
                result.add(seats.filter { it.level == l })
            }
        }
        return result
    }

    fun createFlight(arrivalDate: String, arrivalTime : String, departureDate : String, departureTime : String, origin : String, destination : String, description : String, plane : String, price : Float){
        val planeObj = FirestoreUtils.getObjectWithId<Plane>(FirestoreUtils.PLANES_COLLECTION, plane)

        val seats = arrayListOf<FlightSeat>()
        planeObj!!.seats.forEach {
            seats.add(FlightSeat("", it.classType, it.name, false, it.seat))
        }

        val count = FirestoreUtils.amountOfDocumentsWithQuery(FirestoreUtils.FLIGHTS_COLLECTION)

        val flight = Flight(
            "",
            arrivalDate, arrivalTime,
            departureDate, departureTime,
            description,
            destination.lowercase(),
            origin.lowercase(),
            count+1,
            plane,
            price,
            true,
            seats,
            null
        )

        FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.FLIGHTS_COLLECTION, flight)
    }

    fun editFlight(id : String, arrivalDate: String, arrivalTime : String, departureDate : String, departureTime : String, origin : String, destination : String, description : String, plane : String, price : Float, status : Boolean) : Boolean{
        val amountTicket = FirestoreUtils.amountOfDocumentsWithQuery(FirestoreUtils.TICKETS_COLLECTION, FirestoreQuery("flight", id))
        if (amountTicket > 0){
            return false
        }

        val originalFlight = FirestoreUtils.getObjectWithId<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, id)

        var seats : ArrayList<FlightSeat> = ArrayList(originalFlight!!.seats)

        if (originalFlight.plane != plane){
            val planeObj = FirestoreUtils.getObjectWithId<Plane>(FirestoreUtils.PLANES_COLLECTION, plane)

            seats = arrayListOf()

            planeObj!!.seats.forEach {
                seats.add(FlightSeat("", it.classType, it.name, false, it.seat))
            }
        }

        val flight = Flight(
            "",
            arrivalDate, arrivalTime,
            departureDate, departureTime,
            description,
            destination,
            origin,
            originalFlight.flightNumber,
            plane,
            price,
            status,
            seats,
            null
        )

        FirestoreUtils.updateDocumentWithObject(FirestoreUtils.FLIGHTS_COLLECTION, id, flight)

        return true
    }

    fun deleteFlight(id : String) : Boolean{
        val amountTicket = FirestoreUtils.amountOfDocumentsWithQuery(FirestoreUtils.TICKETS_COLLECTION, FirestoreQuery("flight", id))
        if (amountTicket > 0){
            return false
        }

        FirestoreUtils.deleteDocumentWithId(FirestoreUtils.FLIGHTS_COLLECTION, id)

        return true
    }
}

object TicketHandler{
    fun addTickets(flight: String, seats : List<String>) : String{
        val response = arrayListOf<String>()

        seats.map { s ->
            val ticket = Ticket("","", flight, s, Companion.currentUser.id)
            val newTicketId = FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.TICKETS_COLLECTION, ticket)

            response.add(newTicketId)

            val originalFlight = FirestoreUtils.getObjectWithId<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, flight)

            originalFlight!!.seats.map { seat ->
                if (seat.name == s){
                    seat.occupied = true
                }
            }

            FirestoreUtils.updateDocumentWithObject(FirestoreUtils.FLIGHTS_COLLECTION, flight, originalFlight)
        }

        val buyId = FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.GROUP_TICKET_BUY, GroupTicketBuy("", response, Companion.currentUser.id, true))

        return buyId
    }
    fun getTicketInfo(groupId : String) : TicketPrintObject{
        val tickets = arrayListOf<Ticket>()

        var user : User? = null
        var flight : Flight? = null

        var status = false

        FirestoreUtils.getObjectWithId<GroupTicketBuy>(FirestoreUtils.GROUP_TICKET_BUY, groupId)?.let {
            status = it.status

            it.tickets.map { s->

            FirestoreUtils.getObjectWithId<Ticket>(FirestoreUtils.TICKETS_COLLECTION, s)?.let { ticket ->
                tickets.add(ticket)

                if (user == null){
                    user = FirestoreUtils.getObjectWithId(FirestoreUtils.USER_COLLECTION, ticket.user)
                }
                if (flight == null){
                    flight = FirestoreUtils.getObjectWithId(FirestoreUtils.FLIGHTS_COLLECTION, ticket.flight)
                }
            }
        } }

        return TicketPrintObject(user!!, flight!!, tickets, status)
    }

    fun getCurrentUserTickets() : List<TicketGroupResume>{
        return getGroupTicketsForUser(Companion.currentUser.id, false)
    }

    fun getUserActiveTickets(email: String) : List<TicketGroupResume>{
        val user = FirestoreUtils.getObjectWithQuery<User>(FirestoreUtils.USER_COLLECTION, FirestoreQuery("email", email))
        user?.let {
            return getGroupTicketsForUser(it.id, true)
        } ?: kotlin.run {
            return arrayListOf()
        }
    }

    fun getTicketCancellationObject(id : String) : TicketCancellation{
        val group = FirestoreUtils.getObjectWithId<GroupTicketBuy>(FirestoreUtils.GROUP_TICKET_BUY, id)!!

        val tickets = arrayListOf<Ticket>()
        group.tickets.forEach { ticketId ->
            val ticket = FirestoreUtils.getObjectWithId<Ticket>(FirestoreUtils.TICKETS_COLLECTION, ticketId)!!

            tickets.add(ticket)
        }

        var user = User()
        var flight = Flight()
        tickets.forEach { ticket ->
            user = FirestoreUtils.getObjectWithId(FirestoreUtils.USER_COLLECTION, ticket.user)!!
            flight = FirestoreUtils.getObjectWithId(FirestoreUtils.FLIGHTS_COLLECTION, ticket.flight)!!
        }

        return TicketCancellation(user, flight, tickets)
    }

    fun cancelTicket(id : String){
        val ticket = FirestoreUtils.getObjectWithId<GroupTicketBuy>(FirestoreUtils.GROUP_TICKET_BUY, id)!!
        ticket.status = false

        FirestoreUtils.updateDocumentWithObject(FirestoreUtils.GROUP_TICKET_BUY, id, ticket)
    }

    private fun getGroupTicketsForUser(id : String, searchActiveOnly : Boolean) : ArrayList<TicketGroupResume>{
        val response = arrayListOf<TicketGroupResume>()

        val queries = arrayListOf(FirestoreQuery("userId", id))
        if (searchActiveOnly){
            queries.add(FirestoreQuery("status", true))
        }

        FirestoreUtils.getObjectListWithQuery<GroupTicketBuy>(FirestoreUtils.GROUP_TICKET_BUY, *queries.toTypedArray()).map { group ->
            val current = TicketGroupResume()
            current.amount = group.tickets.size
            current.id = group.id
            current.status = group.status

            var currentFlight : Flight? = null

            group.tickets.forEach { t ->
                val ticket = FirestoreUtils.getObjectWithId<Ticket>(FirestoreUtils.TICKETS_COLLECTION, t)!!
                if (currentFlight == null){
                    currentFlight = FirestoreUtils.getObjectWithId(FirestoreUtils.FLIGHTS_COLLECTION, ticket.flight)
                    return@forEach
                }
            }

            current.flightDesc = currentFlight!!.origin + " -> " + currentFlight!!.destination
            current.price = current.amount * currentFlight!!.price

            response.add(current)
        }

        return response
    }
}

object AirlinesHandler{
    fun getAirlinesPrintData() : List<AirlinePrintData> {
        val result = arrayListOf<AirlinePrintData>()

        var planeFlights = 0
        var airlinePlanes = listOf<Plane>()

        val airlines = FirestoreUtils.getObjectList<Airline>(FirestoreUtils.AIRLINES_COLLECTION)
        airlines.forEach { airline ->
            airlinePlanes = FirestoreUtils.getObjectListWithQuery<Plane>(
                FirestoreUtils.PLANES_COLLECTION, FirestoreQuery("airline",airline.id)
            )

            airlinePlanes.forEach { plane ->
                planeFlights += FirestoreUtils.amountOfDocumentsWithQuery(
                    FirestoreUtils.FLIGHTS_COLLECTION, FirestoreQuery("plane", plane.id)
                )
            }

            result.add(AirlinePrintData(airline.id, airline.name, planeFlights, airlinePlanes.size))

            planeFlights = 0
        }

        return result
    }

    fun createAirline(name : String){
        val airline = Airline("", name, true)
        FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.AIRLINES_COLLECTION, airline)
    }

    fun deleteAirline(id : String) : Boolean{

        val airlinePlanes = FirestoreUtils.getObjectListWithQuery<Plane>(FirestoreUtils.PLANES_COLLECTION, FirestoreQuery("airline", id))

        if (airlinePlanes.isNotEmpty()){
            return false
        }

        FirestoreUtils.deleteDocumentWithId(FirestoreUtils.AIRLINES_COLLECTION, id)

        return true
    }

    fun updateAirline(id : String, name : String, status: Boolean){
        val airline = Airline("", name, status)
        FirestoreUtils.updateDocumentWithObject(FirestoreUtils.AIRLINES_COLLECTION, id, airline)
    }

    fun getAirline(id : String) : Airline?{
        return FirestoreUtils.getObjectWithId(FirestoreUtils.AIRLINES_COLLECTION, id)
    }
}

object CountryHandler{
    fun getCountriesJson() : String{
        val countriesStringList = getCountries()
        return ObjectMapper().writeValueAsString(countriesStringList)
    }
    fun getCountries() : List<String>{
        val countries = FirestoreUtils.getObjectListWithQuery<Country>(FirestoreUtils.COUNTRIES_COLLECTION,
            FirestoreQuery("status", true)
        ).sortedBy { it.name }
        countries.map { country ->
            country.name = country.name.capitalizeWords()
        }
        return countries.map { it.name }
    }

    fun getAllCountries() : List<Country>{
        val countries = FirestoreUtils.getObjectList<Country>(FirestoreUtils.COUNTRIES_COLLECTION).sortedBy { it.name }
        countries.map { country ->
            country.name = country.name.capitalizeWords()
        }
        return countries
    }

    fun updateCountryStatus(id : String, status : Boolean){
        val country = FirestoreUtils.getObjectWithId<Country>(FirestoreUtils.COUNTRIES_COLLECTION, id)
        country!!.status = status

        FirestoreUtils.updateDocumentWithObject(FirestoreUtils.COUNTRIES_COLLECTION, id, country)
    }
}

object ReportHandlers{
    fun getTicketReports() : List<TicketReport> {
        val response = arrayListOf<TicketReport>()

        val groupObj = FirestoreUtils.getObjectList<GroupTicketBuy>(FirestoreUtils.GROUP_TICKET_BUY)

        groupObj.forEach { group ->
            var flight : Flight? = null
            var seats = ""
            var amountTickets = 0
            group.tickets.forEach { ticketId ->
                val ticket = FirestoreUtils.getObjectWithId<Ticket>(FirestoreUtils.TICKETS_COLLECTION, ticketId)!!

                if (flight == null){
                    flight = FirestoreUtils.getObjectWithId<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, ticket.flight)!!
                }

                seats += ticket.seat + ", "
                amountTickets++
            }

            val rep = TicketReport(
                group.id,
                "${flight!!.origin} -> ${flight!!.destination}",
                seats,
                (amountTickets * flight!!.price),
                group.status
            )

            response.add(rep)

            seats = ""
            amountTickets = 0
        }

        return response
    }

    fun getTicketReportsForUser(id : String) : List<TicketReport> {
        val response = arrayListOf<TicketReport>()

        val groupObj = FirestoreUtils.getObjectListWithQuery<GroupTicketBuy>(FirestoreUtils.GROUP_TICKET_BUY, FirestoreQuery("userId",id))

        groupObj.forEach { group ->
            var flight : Flight? = null
            var seats = ""
            var amountTickets = 0
            group.tickets.forEach { ticketId ->
                val ticket = FirestoreUtils.getObjectWithId<Ticket>(FirestoreUtils.TICKETS_COLLECTION, ticketId)!!

                if (flight == null){
                    flight = FirestoreUtils.getObjectWithId<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, ticket.flight)!!
                }

                seats += ticket.seat + ", "
                amountTickets++
            }

            val rep = TicketReport(
                group.id,
                "${flight!!.origin} -> ${flight!!.destination}",
                seats,
                (amountTickets * flight!!.price),
                group.status
            )

            response.add(rep)

            seats = ""
            amountTickets = 0
        }

        return response
    }

    fun getFlightReport() : List<FlightReport>{
        val response = arrayListOf<FlightReport>()

        val flights = FirestoreUtils.getObjectList<Flight>(FirestoreUtils.FLIGHTS_COLLECTION)
        flights.forEach { flight ->
            val free = flight.seats.count { !it.occupied }
            val occupied = flight.seats.count { it.occupied }

            val rep = FlightReport(
                flight.id,
                flight.departureDate,
                flight.arrivalDate,
                flight.destination,
                flight.origin,
                free,
                occupied
            )

            response.add(rep)
        }

        return response
    }

    fun getUserReport() : List<UserReport>{
        val response = arrayListOf<UserReport>()

        val users = FirestoreUtils.getObjectList<User>(FirestoreUtils.USER_COLLECTION)
        users.forEach { user ->
            val ticketsForUser = FirestoreUtils.getObjectListWithQuery<Ticket>(FirestoreUtils.TICKETS_COLLECTION, FirestoreQuery("user", user.id))

            var totalSpent = 0f
            ticketsForUser.forEach { ticket ->
                val flight = FirestoreUtils.getObjectWithId<Flight>(FirestoreUtils.FLIGHTS_COLLECTION, ticket.flight)
                totalSpent += flight!!.price
            }

            response.add(UserReport(
                user.id,
                user.name,
                user.email,
                ticketsForUser.size,
                totalSpent
            ))
        }

        return response
    }
}