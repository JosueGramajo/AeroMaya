import firestore.FirestoreUtils
import objects.*
import utils.Companion
import utils.DateUtils

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
            Companion.currentUser = it
            return true
        }

        return false
    }
}

object FlightsHandler{
    fun searchFlights(origin : String, destination : String?, departureDate : String?, arrivalDate : String?, classType : String) : List<Flight>{
        val queries = arrayListOf<FirestoreQuery>()
        queries.add(FirestoreQuery("origin", origin))

        if (!destination.isNullOrEmpty()){
            queries.add(FirestoreQuery("destination", destination))
        }
        if (!departureDate.isNullOrEmpty()){
            val parsedDate = DateUtils.changeDateFormat("MM/dd/yyyy", "dd/MM/yyyy", departureDate)
            queries.add(FirestoreQuery("departureDate", parsedDate))
        }
        if (!departureDate.isNullOrEmpty() && !arrivalDate.isNullOrEmpty()){
            val parsedDate = DateUtils.changeDateFormat("MM/dd/yyyy", "dd/MM/yyyy", arrivalDate)
            queries.add(FirestoreQuery("arrivalDate", parsedDate))
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

        val buyId = FirestoreUtils.insertObjectWithRandomDocumentID(FirestoreUtils.GROUP_TICKET_BUY, GroupTicketBuy("", response))

        return buyId
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