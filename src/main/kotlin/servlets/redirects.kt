package servlets

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
        req!!.getRequestDispatcher("/frontend/dashboard.jsp").forward(req, resp)
    }
}

class FlightsSevlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req!!.getRequestDispatcher("/frontend/flights.jsp").forward(req, resp)
    }
}