package utils

import com.itextpdf.html2pdf.HtmlConverter
import objects.TicketPrintObject
import java.io.ByteArrayOutputStream

object PdfUtilities {
    fun generatePdf(id : String) : ByteArrayOutputStream{
        val out = ByteArrayOutputStream()

        val groupTicketInfo = TicketHandler.getTicketInfo(id)

        var html = htmlHeader
        groupTicketInfo.seats.map { t ->
            html += generateItem(groupTicketInfo, t.seat, id)
        }
        html += htmlFooter

        HtmlConverter.convertToPdf(html, out)

        return out
    }

    private fun generateItem(info : TicketPrintObject, seat : String, id : String) : String{
        return  "    <div class=\"ticket\">" +
                "    <div class=\"ticket--end\">" +
                "                <div><img id='barcode' src=\"https://api.qrserver.com/v1/create-qr-code/?data=https:%2f%2faeromaya.appspot.com/generateTicket?confirmation=$id&amp;size=100x100\" alt=\"\" title=\"HELLO\" width=\"50\" height=\"50\" /></div>" +
                "            </div>" +
                "    <div class=\"ticket--center\">" +
                "    <div class=\"ticket--center--row\">" +
                "    <div class=\"ticket--center--col\">" +
                "    <span>Tu boleto para el vuelo:</span>&nbsp;&nbsp;&nbsp;" +
                "    <span>${info.flight.origin} -> ${info.flight.destination}</span>" +
                "    </div>" +
                "    </div>" +
                "                <div class=\"ticket--center--row\">" +
                "                    <div class=\"ticket--center--col\">" +
                "                        <span>Numero de boleto:</span>&nbsp;&nbsp;&nbsp;" +
                "                        <span>$seat</span>" +
                "                    </div>" +
                "                </div>" +
                "    <div class=\"ticket--center--row\">" +
                "    <div class=\"ticket--center--col\">" +
                "    <span class=\"ticket--info--title\">Fecha y hora:</span>&nbsp;&nbsp;&nbsp;" +
                "    <span class=\"ticket--info--content\">${info.flight.departureDate}</span>&nbsp;" +
                "    <span class=\"ticket--info--content\">${info.flight.departureTime}</span>" +
                "    </div>" +
                "    " +
                "    </div>" +
                "                <div class=\"ticket--center--row\">" +
                "                    <div class=\"ticket--center--col\">" +
                "                        <span class=\"ticket--info--title\">Destino:</span>&nbsp;&nbsp;&nbsp;" +
                "                        <span class=\"ticket--info--content\">${info.flight.destination}</span>" +
                "                    </div>" +
                "                </div>" +
                "    <div class=\"ticket--center--row\">" +
                "    <div class=\"ticket--center--col\">" +
                "    <span class=\"ticket--info--title\">Tipo de boleto:</span>&nbsp;&nbsp;&nbsp;" +
                "    <span class=\"ticket--info--content\">Event category</span>" +
                "    </div>" +
                "    " +
                "    </div>" +
                "                <div class=\"ticket--center--row\">" +
                "                    <div class=\"ticket--center--col\">" +
                "                        <span class=\"ticket--info--title\">Informacion:</span>&nbsp;&nbsp;&nbsp;" +
                "                        <span  class=\"ticket--info--content\">Orden #$id. Ordenado por ${info.user.name}</span>" +
                "                    </div>" +
                "                </div>" +
                "    </div>" +
                "    " +
                "    </div>"
    }

    val htmlHeader = "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<meta charset=\"utf-8\">" +
            "<style type=\"text/css\">" +
            ".ticket {" +
            "     display: flex;" +
            "     font-family: Roboto;" +
            "     margin: 16px;" +
            "     border: 1px solid #e0e0e0;" +
            "     position: relative;" +
            "}" +
            " .ticket:before {" +
            "     content: '';" +
            "     width: 32px;" +
            "     height: 32px;" +
            "     background-color: #fff;" +
            "     border: 1px solid #e0e0e0;" +
            "     border-top-color: transparent;" +
            "     border-left-color: transparent;" +
            "     position: absolute;" +
            "     transform: rotate(-45deg);" +
            "     left: -18px;" +
            "     top: 50%;" +
            "     margin-top: -16px;" +
            "     border-radius: 50%;" +
            "}" +
            " .ticket:after {" +
            "     content: '';" +
            "     width: 32px;" +
            "     height: 32px;" +
            "     background-color: #fff;" +
            "     border: 1px solid #e0e0e0;" +
            "     border-top-color: transparent;" +
            "     border-left-color: transparent;" +
            "     position: absolute;" +
            "     transform: rotate(135deg);" +
            "     right: -18px;" +
            "     top: 50%;" +
            "     margin-top: -16px;" +
            "     border-radius: 50%;" +
            "}" +
            " .ticket--start {" +
            "     position: relative;" +
            "     border-right: 1px dashed #e0e0e0;" +
            "}" +
            " .ticket--start:before {" +
            "     content: '';" +
            "     width: 32px;" +
            "     height: 32px;" +
            "     background-color: #fff;" +
            "     border: 1px solid #e0e0e0;" +
            "     border-top-color: transparent;" +
            "     border-left-color: transparent;" +
            "     border-right-color: transparent;" +
            "     position: absolute;" +
            "     transform: rotate(-45deg);" +
            "     left: -18px;" +
            "     top: -2px;" +
            "     margin-top: -16px;" +
            "     border-radius: 50%;" +
            "}" +
            " .ticket--start:after {" +
            "     content: '';" +
            "     width: 32px;" +
            "     height: 32px;" +
            "     background-color: #fff;" +
            "     border: 1px solid #e0e0e0;" +
            "     border-top-color: transparent;" +
            "     border-left-color: transparent;" +
            "     border-bottom-color: transparent;" +
            "     position: absolute;" +
            "     transform: rotate(-45deg);" +
            "     left: -18px;" +
            "     top: 100%;" +
            "     margin-top: -16px;" +
            "     border-radius: 50%;" +
            "}" +
            " .ticket--start > img {" +
            "     display: block;" +
            "     padding: 24px;" +
            "     height: 270px;" +
            "}" +
            " .ticket--center {" +
            "     padding: 24px;" +
            "     flex: 1;" +
            "}" +
            " .ticket--center--row {" +
            "     display: flex;" +
            "}" +
            " .ticket--center--row:not(:last-child) {" +
            "     padding-bottom: 48px;" +
            "}" +
            " .ticket--center--row:first-child span {" +
            "     color: #4872b0;" +
            "     text-transform: uppercase;" +
            "     line-height: 24px;" +
            "     font-size: 13px;" +
            "     font-weight: 500;" +
            "}" +
            " .ticket--center--row:first-child strong {" +
            "     font-size: 20px;" +
            "     font-weight: 400;" +
            "     text-transform: uppercase;" +
            "}" +
            " .ticket--center--col {" +
            "     display: flex;" +
            "     flex: 1;" +
            "     width: 50%;" +
            "     box-sizing: border-box;" +
            "     flex-direction: column;" +
            "}" +
            " .ticket--center--col:not(:last-child) {" +
            "     padding-right: 16px;" +
            "}" +
            ".ticket-logo{" +
            "    width: 150px;" +
            "    height: 60px;" +
            "}" +
            " .ticket--end {" +
            "     padding: 24px;" +
            "     background-color: #00A5F3;" +
            "     display: flex;" +
            "     flex-direction: column;" +
            "     position: relative;" +
            "}" +
            "" +
            " .ticket--end:before {" +
            "     content: '';" +
            "     width: 32px;" +
            "     height: 32px;" +
            "     background-color: #fff;" +
            "     border: 1px solid #e0e0e0;" +
            "     border-top-color: transparent;" +
            "     border-right-color: transparent;" +
            "     border-bottom-color: transparent;" +
            "     position: absolute;" +
            "     transform: rotate(-45deg);" +
            "     right: -18px;" +
            "     top: -2px;" +
            "     margin-top: -16px;" +
            "     border-radius: 50%;" +
            "}" +
            " .ticket--end:after {" +
            "     content: '';" +
            "     width: 32px;" +
            "     height: 32px;" +
            "     background-color: #fff;" +
            "     border: 1px solid #e0e0e0;" +
            "     border-right-color: transparent;" +
            "     border-left-color: transparent;" +
            "     border-bottom-color: transparent;" +
            "     position: absolute;" +
            "     transform: rotate(-45deg);" +
            "     right: -18px;" +
            "     top: 100%;" +
            "     margin-top: -16px;" +
            "     border-radius: 50%;" +
            "}" +
            " .ticket--end > div:first-child {" +
            "     flex: 1;" +
            "}" +
            " .ticket--end > div:first-child > img {" +
            "     width: 128px;" +
            "     padding: 4px;" +
            "     background-color: #fff;" +
            "}" +
            " .ticket--end > div:last-child > img {" +
            "     display: block;" +
            "     margin: 0 auto;" +
            "     filter: brightness(0) invert(1);" +
            "     opacity: 0.64;" +
            "}" +
            " .ticket--info--title {" +
            "     text-transform: uppercase;" +
            "     color: #757575;" +
            "     font-size: 13px;" +
            "     line-height: 24px;" +
            "     font-weight: 600;" +
            "     white-space: nowrap;" +
            "     overflow: hidden;" +
            "     text-overflow: ellipsis;" +
            "}" +
            " .ticket--info--subtitle {" +
            "     font-size: 16px;" +
            "     line-height: 24px;" +
            "     font-weight: 500;" +
            "     color: #4872b0;" +
            "     white-space: nowrap;" +
            "     overflow: hidden;" +
            "     text-overflow: ellipsis;" +
            "}" +
            " .ticket--info--content {" +
            "     font-size: 13px;" +
            "     line-height: 24px;" +
            "     font-weight: 500;" +
            "     white-space: nowrap;" +
            "     overflow: hidden;" +
            "     text-overflow: ellipsis;" +
            "}" +
            " " +
            "</style>" +
            "</head>" +
            "<body>" +
            "    <div class=\"map-data m-b-40\">"

    val htmlFooter = "    </div>" +
            "</body>" +
            "</html>"


}