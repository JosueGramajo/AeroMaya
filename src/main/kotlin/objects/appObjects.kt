package objects

import com.google.cloud.firestore.annotation.DocumentId
import com.google.cloud.firestore.annotation.Exclude

open class BaseObject(
        @Exclude
        val id : String
){
        constructor() : this("")
}

data class FirestoreQuery(
        val firestoreKey : String,
        val expectedStringValue : String?,
        val expectedBooleanValue : Boolean?,
        val expectedNumericValue : Float?
){
        constructor() : this("", null, null, null)

        constructor(key : String, value : String) : this(key, value, null, null)

        constructor(key : String, value : Boolean) : this(key, null, value, null)

        constructor(key : String, value : Float) : this(key, null, null, value)
}

data class User(
        @DocumentId
        val id : String,

        val email : String,
        val password : String,
        val role : Int,
        val name : String,

        @Exclude
        var loggedIn : Boolean
){
        constructor() : this("","", "", 0, "", false)
}

data class Airline(
        @DocumentId
        val id : String,
        val name : String,
        val status : Boolean
){
        constructor() : this("","", false)
}

data class AirlinePrintData(
        val id : String,
        val name : String,
        val flightsNumber : Int,
        val planesNumber : Int
)

data class Plane(
        @DocumentId
        val id : String,

        val airline : String,
        val capacity : Int,
        val businessSeats : Int,
        val economicSeats : Int,
        val firstClassSeats : Int,
        val name : String,
        val seats : List<PlaneSeat>,

        @Exclude
        var airlineName : String
){
        constructor() : this("","", 0, 0, 0, 0, "", arrayListOf(), "")
}

data class PlaneSeat(
        @DocumentId
        val id : String,
        val classType : String,
        val name : String,
        val seat : Int,
        val section : String
){
        constructor() : this("","", "",0, "")
}

data class Flight(
        @DocumentId
        val id : String,

        val arrivalDate : String,
        val arrivalTime : String,
        val departureDate : String,
        val departureTime : String,
        val description : String,
        var destination : String,
        var origin : String,
        val flightNumber : Int,
        val plane : String,
        val price : Float,
        val status : Boolean,
        val seats : List<FlightSeat>,

        @Exclude
        var airlineName: String?
){
        constructor() : this("","","","","","","","",0,"", 0f, false, arrayListOf(),null)
}

data class FlightSeat(
        @DocumentId
        val id : String,

        val classType : String,
        val name : String,
        var occupied : Boolean,
        val level : Int
){
        constructor() : this("","", "",false, 0)
}

data class Ticket(
        @DocumentId
        val id : String,

        val classType : String,
        val flight : String,
        val seat : String,
        val user : String,
){
        constructor() : this("","", "","","")
}

data class GroupTicketBuy(
        @DocumentId
        val id : String,

        val tickets : List<String>,

        val userId : String,

        var status : Boolean,
){
        constructor() : this("", arrayListOf(), "", false)
}

data class Country(
        @DocumentId
        val id: String,

        var name: String,
        val code: String,
        var status: Boolean
){
        constructor() : this("","", "", false)
}

data class TicketPrintObject(
        val user : User,
        val flight : Flight,
        val seats: List<Ticket>,
        val status : Boolean
)

data class TicketGroupResume(
        var flightDesc : String,
        var amount : Int,
        var price : Float,
        var id : String,
        var status : Boolean
){
        constructor() : this("", 0, 0f, "", false)
}

data class TicketCancellation(
        val user : User,
        val flight : Flight,
        val tickets: List<Ticket>
)

//Reportes
/*
<th scope="col">ID</th>
<th scope="col">Destino</th>
<th scope="col">Asientos</th>
<th scope="col">Precio</th>
<th>Estado</th>
* */

data class TicketReport(
        val id: String,
        val trip : String,
        val seats : String,
        val price : Float,
        val status : Boolean
)

data class FlightReport(
        val id : String,
        val departureDate : String,
        val arrivalDate : String,
        val destination : String,
        val origin : String,
        val freeSeats : Int,
        val occupiedSeats : Int
)

data class UserReport(
        val id : String,
        val name : String,
        val email : String,
        val amountBuys : Int,
        val totalSpent : Float,
)