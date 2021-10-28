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
            listOf(
                FirestoreQuery("email", email),
                FirestoreQuery("password", password)
            )
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

        return Plane("", airline, capacity, businessClassAmount, economicClassAmount, firstClassAmount, name, seats, null)
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

        return FirestoreUtils.getObjectListWithQuery(FirestoreUtils.FLIGHTS_COLLECTION, queries)
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

        val buyId = FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.GROUP_TICKET_BUY, GroupTicketBuy("", response, Companion.currentUser.id))

        return buyId
    }
    fun getTicketInfo(groupId : String) : TicketPrintObject{
        val tickets = arrayListOf<Ticket>()

        var user : User? = null
        var flight : Flight? = null

        FirestoreUtils.getObjectWithId<GroupTicketBuy>(FirestoreUtils.GROUP_TICKET_BUY, groupId)?.let { it.tickets.map { s->
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

        return TicketPrintObject(user!!, flight!!, tickets)
    }

    fun getCurrentUserTickets() : List<TicketGroupResume>{
        val response = arrayListOf<TicketGroupResume>()

        FirestoreUtils.getObjectListWithQuery<GroupTicketBuy>(FirestoreUtils.GROUP_TICKET_BUY, listOf(FirestoreQuery("userId", Companion.currentUser.id))).map { group ->
            val current = TicketGroupResume()
            current.amount = group.tickets.size
            current.id = group.id

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

        var planeFlights = listOf<Flight>()
        var airlinePlanes = listOf<Plane>()

        val airlines = FirestoreUtils.getObjectList<Airline>(FirestoreUtils.AIRLINES_COLLECTION)
        airlines.map { airline ->
            airlinePlanes = FirestoreUtils.getObjectListWithQuery<Plane>(
                FirestoreUtils.PLANES_COLLECTION, listOf(FirestoreQuery("airline",airline.name))
            )

            airlinePlanes.map { plane ->
                planeFlights = FirestoreUtils.getObjectListWithQuery<Flight>(
                    FirestoreUtils.FLIGHTS_COLLECTION, listOf(FirestoreQuery("plane", plane.id))
                )
            }

            result.add(AirlinePrintData(airline.id, airline.name, planeFlights.size, airlinePlanes.size))
        }

        return result
    }
}

object CountryHandler{
    fun getCountriesJson() : String{
        val countriesStringList = getCountries()
        return ObjectMapper().writeValueAsString(countriesStringList)
    }
    fun getCountries() : List<String>{
        val countries = FirestoreUtils.getObjectListWithQuery<Country>(FirestoreUtils.COUNTRIES_COLLECTION, listOf(
            FirestoreQuery("status", true)
        )).sortedBy { it.name }
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