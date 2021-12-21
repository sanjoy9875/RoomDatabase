package com.example.roomdatabase.recurring_flow


import android.util.Log
import androidx.lifecycle.ViewModel
import org.threeten.bp.LocalDateTime
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.WeekFields
import java.util.*

class RecurringViewModel() : ViewModel() {

    var day : String = ""
    var month : String = ""

    val date: LocalDateTime = LocalDateTime.now()  //2022-05-03T16:50:06.050

    var result = ""
    var freq = ""
    var wkst = ""
    var byDay = ""
    var until = ""

    //"FREQ=DAILY;WKST=SU;UNTIL=20211113T235959Z"
    //"FREQ=WEEKLY;WKST=SU;BYDAY=MO;UNTIL=20211122T235959Z"

    fun weekly() : String{
        day = date.dayOfWeek.toString().lowercase(Locale.getDefault())
        return "(on $day's)"
    }

    fun getRRulesString(str :String) : String {

        if (str.isNotEmpty()) {
            val data = str.split(";")

            if (data.size <= 3) {
                freq = data[0].replace(" ", "")
                wkst = data[1].replace(" ", "")
                until = data[2].replace(" ", "").replace("UNTIL=", "")

                when {
                    freq.contains("DAILY") -> {
                        freq = "DAILY"
                    }
                    freq.contains("WEEKLY") -> {
                        freq = "WEEKLY"
                    }
                    freq.contains("MONTHLY") -> {
                        freq = "MONTHLY"
                    }
                }
                when {
                    wkst.isEmpty() -> {
                        wkst = "SU"
                    }
                    wkst.isNotEmpty() -> {
                        wkst = "SU"
                    }
                }

                when {
                    until.isEmpty() -> {

                        val endDate = date.plusMonths(3).toString()

                        val newDate = endDate.replace(" ", "")
                            .replace("-", "")
                            .replace(":", "")
                            .replaceAfter(".", "")
                            .replace('.', 'Z')  //20220503T165006Z

                        until = newDate
                    }
                }
                return "FREQ=$freq;WKST=$wkst;UNTIL=$until"
            }
            if (data.size > 3) {
                freq = data[0].replace(" ", "")
                wkst = data[1].replace(" ", "")
                byDay = data[2].replace(" ","")
                until = data[3].replace(" ", "").replace("UNTIL=", "")

                when {
                    freq.contains("DAILY") -> {
                        freq = "DAILY"
                    }
                    freq.contains("WEEKLY") -> {
                        freq = "WEEKLY"
                    }
                    freq.contains("MONTHLY") -> {
                        freq = "MONTHLY"
                    }
                }
                when {
                    wkst.isEmpty() -> {
                        wkst = "SU"
                    }
                    wkst.isNotEmpty() -> {
                        wkst = "SU"
                    }
                }

                when{
                    byDay.contains("MO") -> {
                        byDay = "MO"
                    }
                    byDay.contains("TU") -> {
                        byDay = "TU"
                    }
                    byDay.contains("WE") -> {
                        byDay = "WE"
                    }
                    byDay.contains("TH") -> {
                        byDay = "TH"
                    }
                    byDay.contains("FR") -> {
                        byDay = "FR"
                    }
                }

                when {
                    until.isEmpty() -> {

                        val endDate = date.plusMonths(3).toString()

                        val newDate = endDate.replace(" ", "")
                            .replace("-", "")
                            .replace(":", "")
                            .replaceAfter(".", "")
                            .replace('.', 'Z')  //20220503T165006Z

                        until = newDate
                    }
                }
                return "FREQ=$freq;WKST=$wkst;BYDAY=${byDay};UNTIL=$until"
            }
        }
            return ""
    }

    fun monthly() : String{

        val firstDateOfMonth = date.withDayOfMonth(1)
        val firstDayOfWeek = firstDateOfMonth.dayOfWeek

        // create WeekFields
        val weekFields = WeekFields.of(firstDayOfWeek , 1)

        // apply weekOfMonth()
        val weekOfMonth = weekFields.weekOfMonth()

        // get week of month for localDate
        val wom = date[weekOfMonth]

        Log.d("TAG","$wom")

        var w = ""

        when (wom) {
            1 -> {
                w = "first"
            }
            2 -> {
                w = "second"
            }
            3 -> {
                w = "third"
            }
            else -> {

                val newDate = date.plusDays(7)
                if (date.month==newDate.month){
                    w = "fourth"
                }
                if (date.month!=newDate.month){
                    w = "last"
                }
            }
        }
        return "(on the $w $day)"
    }

    fun annually() : String{
        month = date.month.toString().lowercase(Locale.getDefault())
        val d = date.dayOfMonth
        return "(on $month $d)"
    }

    fun startDate() : String{
        return date.toString()
    }

    fun endDate() : LocalDateTime{
//        val d = Date().time
//        val longV = "$d"
//        val millisecond = longV.toLong()
//        val dateString: String = DateFormat.format("MM/dd/yyyy", Date(millisecond)).toString()


//        val date = Date()
//        val localdate = LocalDate.parse(SimpleDateFormat("yyyy-MM-dd").format(date.time))

        val endDate = date.plusMonths(6)

//        val df = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss 'GMT+05:30' yyyy", Locale.ENGLISH)
//        val myDate : String = endDate.format(df)


        return  endDate
    }

 //   Tue May 03 12:01:12 GMT+05:30 2022


}