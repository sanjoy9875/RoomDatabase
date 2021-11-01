package com.example.roomdatabase.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.WeekFields
import java.util.*

class RecurringViewModel() : ViewModel() {

    private lateinit var day : String
    private lateinit var month : String

    val date: LocalDate = LocalDate.now()

    fun weekly() : String{
        day = date.dayOfWeek.toString().lowercase(Locale.getDefault())
        return "(on $day's)"
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

}