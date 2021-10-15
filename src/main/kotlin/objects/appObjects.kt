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
        val role : Int
){
        constructor() : this("","", "", 0)
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
        val destination : String,
        val origin : String,
        val flightNumber : Int,
        val plane : String,
        val price : Float,
        val status : Boolean,

        @Exclude
        var planeObj : Plane?
){
        constructor() : this("","","","","","","","",0,"", 0f, false, null)
}

data class FlightSeat(
        @DocumentId
        val id : String,
        val flight: String,
        val classType: String,
        val seat : String,
        val status : String
){
        constructor() : this("","", "", "", "")
}

data class Ticket(
        @DocumentId
        val id : String,
        val classType : String,
        val flight : String,
        val seat : String,
        val user : String
){
        constructor() : this("","", "","","")
}

data class Country(
        val name: String,
        val code: String,
        val status: Boolean
){
        constructor() : this("", "", false)
}

