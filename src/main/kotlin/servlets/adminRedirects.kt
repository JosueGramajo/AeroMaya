package servlets

import firestore.FirestoreUtils
import objects.*
import utils.Companion
import java.io.PrintWriter
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class AdminDashboardServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req!!.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/admin/adminDashboard.jsp").forward(req, resp)
    }
}

class UserManagementServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (Companion.currentUser.loggedIn){
            if (Companion.currentUser.role != 1){
                resp!!.contentType = "text/html"
                val out: PrintWriter = resp.getWriter()
                out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
                return
            }

            val users = FirestoreUtils.getObjectList<User>(FirestoreUtils.USER_COLLECTION)

            req!!.setAttribute("users", users)
            req.getRequestDispatcher("/frontend/admin/userManagement.jsp").forward(req, resp)
        }else{
            resp!!.contentType = "text/html"
            val out: PrintWriter = resp.getWriter()
            out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
        }
    }
}

class PlaneManagementServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (Companion.currentUser.loggedIn){
            if (Companion.currentUser.role != 1){
                resp!!.contentType = "text/html"
                val out: PrintWriter = resp.getWriter()
                out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
                return
            }

            val planes = PlaneHandler.getPlanes()
            val airlines = FirestoreUtils.getObjectList<Airline>(FirestoreUtils.AIRLINES_COLLECTION)

            req!!.setAttribute("planes", planes)
            req.setAttribute("airlines", airlines)
            req.getRequestDispatcher("/frontend/admin/planeManagement.jsp").forward(req, resp)
        }else{
            resp!!.contentType = "text/html"
            val out: PrintWriter = resp.getWriter()
            out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
        }
    }
}

class CountriesManagementServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (Companion.currentUser.loggedIn){
            if (Companion.currentUser.role != 1){
                resp!!.contentType = "text/html"
                val out: PrintWriter = resp.getWriter()
                out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
                return
            }

            val countries = CountryHandler.getAllCountries()

            req!!.setAttribute("countries", countries)
            req.getRequestDispatcher("/frontend/admin/countriesManagement.jsp").forward(req, resp)
        }else{
            resp!!.contentType = "text/html"
            val out: PrintWriter = resp.getWriter()
            out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
        }
    }
}

class AirlinesManagementServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (Companion.currentUser.loggedIn){
            if (Companion.currentUser.role != 1){
                resp!!.contentType = "text/html"
                val out: PrintWriter = resp.getWriter()
                out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
                return
            }

            val airlines = FirestoreUtils.getObjectList<Airline>(FirestoreUtils.AIRLINES_COLLECTION)

            req!!.setAttribute("airlines", airlines)
            req.getRequestDispatcher("/frontend/admin/airlineManagement.jsp").forward(req, resp)
        }else{
            resp!!.contentType = "text/html"
            val out: PrintWriter = resp.getWriter()
            out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
        }
    }
}

class FlightsManagementServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (Companion.currentUser.loggedIn){
            if (Companion.currentUser.role != 1){
                resp!!.contentType = "text/html"
                val out: PrintWriter = resp.getWriter()
                out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
                return
            }

            val flights = FirestoreUtils.getObjectList<Flight>(FirestoreUtils.FLIGHTS_COLLECTION)
            val planes = PlaneHandler.getPlanes()
            val countries = CountryHandler.getCountries()

            req!!.setAttribute("flights", flights)
            req.setAttribute("planes", planes)
            req.setAttribute("countries", countries)
            req.getRequestDispatcher("/frontend/admin/flightsManagement.jsp").forward(req, resp)
        }else{
            resp!!.contentType = "text/html"
            val out: PrintWriter = resp.getWriter()
            out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
        }
    }
}

class TicketCancellationSearchServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (Companion.currentUser.loggedIn){
            if (Companion.currentUser.role != 1){
                resp!!.contentType = "text/html"
                val out: PrintWriter = resp.getWriter()
                out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
                return
            }

            req!!.getRequestDispatcher("/frontend/admin/ticketCancellationSearch.jsp").forward(req, resp)
        }else{
            resp!!.contentType = "text/html"
            val out: PrintWriter = resp.getWriter()
            out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
        }
    }
}

class TicketCancellationServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (Companion.currentUser.loggedIn){
            if (Companion.currentUser.role != 1){
                resp!!.contentType = "text/html"
                val out: PrintWriter = resp.getWriter()
                out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
                return
            }

            val id = req!!.getParameter("id")

            val info = TicketHandler.getTicketCancellationObject(id)

            req.setAttribute("info", info)
            req.setAttribute("id", id)
            req.getRequestDispatcher("/frontend/admin/ticketCancellation.jsp").forward(req, resp)
        }else{
            resp!!.contentType = "text/html"
            val out: PrintWriter = resp.getWriter()
            out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
        }
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doGet(req, resp)
    }
}

class TicketCancellationSuccessServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (Companion.currentUser.loggedIn){
            if (Companion.currentUser.role != 1){
                resp!!.contentType = "text/html"
                val out: PrintWriter = resp.getWriter()
                out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
                return
            }

            val id = req!!.getParameter("id")

            val groupTicket = TicketHandler.getTicketInfo(id)

            req.setAttribute("confirmation", id)
            req.setAttribute("groupTicket", groupTicket)
            req.getRequestDispatcher("/frontend/admin/ticketCancellationSuccess.jsp").forward(req, resp)
        }else{
            resp!!.contentType = "text/html"
            val out: PrintWriter = resp.getWriter()
            out.println("<html><head><title>Error</title></head><body bgcolor=\"white\"><h1>Usuario no autorizado</h1></body></html>")
        }


    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doGet(req, resp)
    }
}