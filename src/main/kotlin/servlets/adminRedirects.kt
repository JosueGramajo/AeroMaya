package servlets

import firestore.FirestoreUtils
import objects.Airline
import objects.Country
import objects.Plane
import objects.User
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