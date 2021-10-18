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
        val expectedValue : String
)

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
        val airlineObj : Airline?
){
        constructor() : this("","", 0, 0, 0, 0, "", arrayListOf(), null)
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
        var planeObj : Plane?
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

        val tickets : List<String>
)

data class Country(
        @DocumentId
        val id: String,

        var name: String,
        val code: String,
        val status: Boolean
){
        constructor() : this("","", "", false)
}

