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
        val status : String
){
        constructor() : this("", "")
}

data class Plane(
        val airline : String,
        val capacity : Int,
        val businessSeats : Int,
        val economicSeats : Int,
        val firstClassSeats : Int,
        val name : String,

        @Exclude
        val airlineObj : Airline?
){
        constructor() : this("", 0, 0, 0, 0, "", null)
}

data class planeSeat(
        val classType : String,
        val seat : String,
        val section : String
){
        constructor() : this("", "", "")
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
        val status : String
){
        constructor() : this("","","","","","","",0,"", 0f, "")
}

data class FlightSeat(
        val classType: String,
        val seat : String,
        val status : String
){
        constructor() : this("", "", "")
}

data class Ticket(
        val classType : String,
        val flight : String,
        val seat : String,
        val user : String
){
        constructor() : this("", "","","")
}

