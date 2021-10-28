package servlets

import firestore.FirestoreUtils
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