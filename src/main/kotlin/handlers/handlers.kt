import firestore.FirestoreUtils
import objects.*
import utils.Companion

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

object PlaneHandler{

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