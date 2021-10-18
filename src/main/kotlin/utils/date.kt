package utils

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*


object DateUtils{
    fun getCurrentDateTimeAsLocalDate() : LocalDate{
        val currentGuatemalaDateTime = ZonedDateTime.now(ZoneId.of("America/Guatemala"))
        return currentGuatemalaDateTime.toLocalDate()
    }
    fun getTimeFromStringDateTime(strDate : String) : String{
        val dateTime = LocalDateTime.parse(strDate)
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        return formatter.format(dateTime)
    }
    fun getDateFromStringDateTime(strDate: String) : String{
        val dateTime = LocalDateTime.parse(strDate)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return formatter.format(dateTime)
    }
    fun parseStringDateTime(date : String) : DateTime{
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val dt = sdf.parse(date)
        return DateTime(dt)
    }
    fun parseStringDateFromDateTime(date : String) : Date {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        return sdf.parse(date)
    }
    fun parseStringDateToDateTime(date : String) : DateTime{
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val dt = sdf.parse("${date}T00:00:00")
        return DateTime(dt)
    }
    fun parseStringDateToLocalDateTime(date : String) : LocalDateTime{
        val datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        return LocalDateTime.parse(date, datetimeFormatter)
    }
    fun parseStringDateToLocalDate(date : String) : LocalDate{
        val dateStr = if (date.contains("T")){
            date.split("T").first()
        }else{
            date
        }
        val datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return LocalDate.parse(dateStr, datetimeFormatter)
    }
    fun isFutureDate(dt : String) : Boolean{
        val dateTime = LocalDate.parse(getDateFromStringDateTime(dt))
        val currentTime = LocalDate.now()
        return dateTime.isAfter(currentTime)
    }
    fun changeDateFormat(inputFormatStr : String, outputFormatStr : String, dateStr : String) : String{
        val inputFormat = SimpleDateFormat(inputFormatStr)
        val date= inputFormat.parse(dateStr)
        val outputFormat = SimpleDateFormat(outputFormatStr)
        return outputFormat.format(date)
    }
    fun parseDateTimeObjectToStringDateTime(dateTime : Date) : String{
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        return dateFormat.format(dateTime)
    }
    fun parseDateTimeObjectToStringDate(dateTime : Date) : String{
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(dateTime)
    }
    fun parseDateToStringDate(dateTime : Date) : String{
        val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy")
        return dateFormat.format(dateTime)
    }
    fun addYearsToDateTime(dt : DateTime, amount : Int) : DateTime{
        val cal = Calendar.getInstance()
        cal.time = dt.toDate()
        cal.add(Calendar.YEAR, amount)
        return DateTime(cal.time)
    }
    fun dateTimeToString(dt : DateTime?) : String{
        val fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
        return fmt.print(dt)
    }

    fun parseDateWithoutTime(date : String) : Date {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.parse(date)
    }

    fun dateTimeToLocalDate(date : DateTime) : LocalDate{
        val fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        val str = fmt.print(date)
        val datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return LocalDate.parse(str, datetimeFormatter)
    }

    fun getMonthName(month : Int) : String = when(month){
        1 -> "enero"
        2 -> "febrero"
        3 -> "marzo"
        4 -> "abril"
        5 -> "mayo"
        6 -> "junio"
        7 -> "julio"
        8 -> "agosto"
        9 -> "septiembre"
        10 -> "octubre"
        11 -> "noviembre"
        12 -> "diciembre"
        else -> ""
    }
}