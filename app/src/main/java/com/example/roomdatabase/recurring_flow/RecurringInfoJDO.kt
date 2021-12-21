package com.example.roomdatabase.recurring_flow

import org.threeten.bp.LocalDateTime
import java.io.Serializable
import java.util.*

class RecurringInfoJDO(
    var frequency: String? = "No Repeat",
    var interval: String? = "1",
    var recurringKey: String? = "",
    var startDateStr: String? = null,
    var endDateStr: String? = null,
    var endDate: LocalDateTime? = null,
    var days: ArrayList<String>? = ArrayList<String>(),
    var conflicts: ArrayList<Long>? = ArrayList<Long>()
) : Serializable {


    fun checkAllInfoAvailable(): Boolean {
        var lResult = true
        if (frequency != null && interval != null) {
            if (frequency == "weekly") {
                if (days?.size!! <= 0) {
                    lResult = false
                }
            }
        } else {
            lResult = false
        }
        return lResult
    }

    override fun toString(): String {
        return "RecurringInfoJDO{" +
                "frequency='" + frequency + '\'' +
                ", interval='" + interval + '\'' +
                ", recurringKey='" + recurringKey + '\'' +
                ", startDateStr='" + startDateStr + '\'' +
                ", endDateStr='" + endDateStr + '\'' +
                ", endDate=" + endDate +
                ", days=" + days +
                ", conflicts=" + conflicts +
                '}'
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == null) return false
        if (this.javaClass != obj.javaClass) return false
        val lInfo = obj as RecurringInfoJDO
        var lResult = true

        if (lInfo.days != days) {
            lResult = false
        }
        if (lInfo.endDate != endDate) {
            lResult = false
        }
        if (lInfo.frequency != frequency) {
            lResult = false
        }
        if (lInfo.interval != interval) {
            lResult = false
        }
        return lResult
    }
}