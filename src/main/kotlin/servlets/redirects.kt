package servlets

import com.fasterxml.jackson.databind.ObjectMapper
import utils.Companion
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LoginServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req!!.getRequestDispatcher("/frontend/login.jsp").forward(req, resp)
    }
}

class RegisterServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req!!.getRequestDispatcher("/frontend/register.jsp").forward(req, resp)
    }
}

class IndexServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val countries = CountryHandler.getCountriesJson()

        req!!.setAttribute("countries", countries)
        req.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/dashboard.jsp").forward(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doGet(req, resp)
    }
}

class DashboardServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val countries = CountryHandler.getCountriesJson()

        req!!.setAttribute("countries", countries)
        req.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/dashboard2.jsp").forward(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doGet(req, resp)
    }
}

class FlightsSevlet : HttpServlet(){
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val destination = req!!.getParameter("destination")
        val departureDate : String? = req.getParameter("departureDate") ?: null
        val arrivalDate : String? = req.getParameter("arrivalDate") ?: null

        val list = FlightsHandler.searchFlights(destination, departureDate, arrivalDate)

        req.setAttribute("flights", list)
        req.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/flights.jsp").forward(req, resp)
    }

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req, resp)
    }
}

class SeatSelectorServlet : HttpServlet(){
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val id = req!!.getParameter("id")
        val ticketsAmount = req.getParameter("ticketsAmount")
        val total = req.getParameter("total")

        val seats = FlightsHandler.getFlightSeats(id)

        req.setAttribute("id", id)
        req.setAttribute("amount", ticketsAmount)
        req.setAttribute("seats", seats)
        req.setAttribute("total", total)
        req.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/seatSelector.jsp").forward(req, resp)
    }

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req, resp)
    }
}

class AirlinesServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val airlines = AirlinesHandler.getAirlinesPrintData()

        req!!.setAttribute("airlines", airlines)
        req.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/airlines.jsp").forward(req, resp)
    }
}

class PaymentServlet : HttpServlet(){
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val flightId = req!!.getParameter("flightId")
        val seats = req.getParameter("seatsSelected")
        val total = req.getParameter("total")

        val ticketsNumber = ObjectMapper().readValue(seats, List::class.java).size

        req.setAttribute("list", seats)
        req.setAttribute("id", flightId)
        req.setAttribute("number",ticketsNumber)
        req.setAttribute("total", total)
        req.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/payment.jsp").forward(req, resp)
    }

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req, resp)
    }
}

class TicketSuccessServlet : HttpServlet(){
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val id = req!!.getParameter("confirmation")

        val groupTicket = TicketHandler.getTicketInfo(id)

        req.setAttribute("confirmation", id)
        req.setAttribute("groupTicket", groupTicket)
        req.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/ticketSuccess.jsp").forward(req, resp)
    }

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req, resp)
    }
}

class MyTicketServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val list = TicketHandler.getCurrentUserTickets()

        req!!.setAttribute("list", list)
        req.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/myTickets.jsp").forward(req, resp)
    }
}

class ReprintTicketServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val id = req!!.getParameter("confirmation")

        val groupTicket = TicketHandler.getTicketInfo(id)

        req.setAttribute("confirmation", id)
        req.setAttribute("groupTicket", groupTicket)
        req.getRequestDispatcher("/frontend/ticketReprint.jsp").forward(req, resp)
    }
}