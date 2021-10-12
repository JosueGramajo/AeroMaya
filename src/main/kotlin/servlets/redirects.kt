package servlets

import firestore.FirestoreUtils
import objects.Issue
import objects.Project
import objects.ProjectParsedData
import objects.Role
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
