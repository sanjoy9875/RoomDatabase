package com.example.roomdatabase.views

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.roomdatabase.R
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

    private lateinit var mTvWeekly : TextView
    private lateinit var mTvMonthly : TextView
    private lateinit var mTvAnnually : TextView
    private lateinit var day : String
    private lateinit var month : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTvWeekly = view.findViewById(R.id.tvWeekly)
        mTvMonthly = view.findViewById(R.id.tvMonthly)
        mTvAnnually = view.findViewById(R.id.tvAnnually)

        val date: LocalDate = LocalDate.parse("2021-09-22")
        weekly(date)
        monthly(date)
        annually(date)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun weekly(date: LocalDate){
        day = date.dayOfWeek.toString().lowercase(Locale.getDefault())
        mTvWeekly.text = "Weekly (on $day's)"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun monthly(date: LocalDate){

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

        mTvMonthly.text = "Monthly (on the $w $day)"

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun annually(date: LocalDate){
        month = date.month.toString().lowercase(Locale.getDefault())
        val d = date.dayOfMonth
        mTvAnnually.text = "Annually (on $month $d)"
    }

}