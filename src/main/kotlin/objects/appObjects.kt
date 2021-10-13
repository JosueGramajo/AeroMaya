package objects

import com.google.cloud.firestore.annotation.Exclude

data class User(
    val email : String,
    val password : String,
    val role : Int
){
        constructor() : this("", "", 0)
}

data class Airline(
        val name : String,
        val status : Boolean
){
        constructor() : this("", false)
}

data class Plane(
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
        constructor() : this("", 0, 0, 0, 0, "", arrayListOf(), null)
}

data class PlaneSeat(
        val classType : String,
        val name : String,
        val seat : Int,
        val section : String
){
        constructor() : this("", "",0, "")
}

data class Flight(
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
        var planeObj : Plane?,

        @Exclude
        var id : String
){
        constructor() : this("","","","","","","",0,"", 0f, false, null, "")
}

data class FlightSeat(
        val flight: String,
        val classType: String,
        val seat : String,
        val status : String
){
        constructor() : this("", "", "", "")
}

data class Ticket(
        val classType : String,
        val flight : String,
        val seat : String,
        val user : String
){
        constructor() : this("", "","","")
}

data class Country(
        val name: String,
        val code: String,
        val status: Boolean
){
        constructor() : this("", "", false)
}

