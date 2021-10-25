package servlets

import utils.Companion
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AdminDashboardServlet : HttpServlet(){
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req!!.setAttribute("user", Companion.currentUser)
        req.getRequestDispatcher("/frontend/admin/adminDashboard.jsp").forward(req, resp)
    }
}