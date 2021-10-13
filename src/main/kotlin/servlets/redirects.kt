package servlets

import firestore.FirestoreUtils
import objects.Country
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

class DashboardServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val countries = FirestoreUtils.getObjectList<Country>(FirestoreUtils.COUNTRIES_COLLECTION).sortedBy { it.name }

        req!!.setAttribute("countries", countries)
        req.getRequestDispatcher("/frontend/dashboard.jsp").forward(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doGet(req, resp)
    }
}

class FlightsSevlet : HttpServlet(){
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val origin = req!!.getParameter("origin")
        val destination = req.getParameter("destination")
        val departureDate : String? = req.getParameter("departureDate") ?: null
        val arrivalDate : String? = req.getParameter("arrivalDate") ?: null
        val classType = req.getParameter("classType")

        val list = FirestoreUtils.getFlights(origin, destination, departureDate, arrivalDate, classType)

        req.setAttribute("flights", list)
        req.getRequestDispatcher("/frontend/flights.jsp").forward(req, resp)
    }
}

class SeatSelectorServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val id = req!!.getParameter("id")

        req.getRequestDispatcher("/frontend/seatSelector.jsp").forward(req, resp);
    }
}