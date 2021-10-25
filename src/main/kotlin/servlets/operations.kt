package servlets

import utils.PdfUtilities
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class DownloadPdfServlet : HttpServlet(){
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val id = req!!.getParameter("confirmation")

        val pdfByteArray = PdfUtilities.generatePdf(id)

        resp!!.setHeader("Expires", "0")
        resp.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0")
        resp.setHeader("Pragma", "public")
        resp.setHeader("Content-disposition","attachment; filename=$id.pdf")
        resp.contentType = "application/pdf"
        resp.setContentLength(pdfByteArray.size())
        val os = resp.outputStream
        pdfByteArray.writeTo(os)
        os.flush()
        os.close()
    }

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        doPost(req, resp)
    }
}