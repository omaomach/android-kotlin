package com.example.mobilephonecompany

import android.annotation.SuppressLint
import java.time.LocalTime

class MobilePhoneCompany {
    companion object {
        const val day_time_start_hour = 6
        const val day_time_end_hour = 18
        const val daytime_call_rate = 4.0
        const val night_time_call_rates = 3.0
        const val other_networks_call_rates = 5.0
        const val vat_rate = 0.16
        const val minimum_duration_for_vat = 2
    }

    @SuppressLint("NewApi")
    fun calculateCallCost(callStartTime: LocalTime, callEndTime: LocalTime, isOtherNetwork: Boolean) : Double {
        val callDurationMinutes = (callEndTime.toSecondOfDay() - callStartTime.toSecondOfDay()) / 60.0
        val callRate = if (isOtherNetwork) {
            other_networks_call_rates
        }else if (isDayTime(callStartTime)) {
            daytime_call_rate
        }else {
            night_time_call_rates
        }

        var callCost = callDurationMinutes * callRate

        if (callDurationMinutes > minimum_duration_for_vat) {
            callCost += callCost * vat_rate
        }

        return callCost

    }

    @SuppressLint("NewApi")
    private fun isDayTime(time: LocalTime): Boolean {
        val hour = time.hour
        return hour >= day_time_start_hour && hour < day_time_end_hour
    }

}

@SuppressLint("NewApi")
fun main() {
    val company = MobilePhoneCompany()
    val callStartTime = LocalTime.of(9, 20, 24)
    val callEndTime = LocalTime.of(9, 30, 24)
    val isOtherNetwork = true

    val callCost = company.calculateCallCost(callStartTime, callEndTime, isOtherNetwork)
    println("Your call costs: Ksh $callCost")

}