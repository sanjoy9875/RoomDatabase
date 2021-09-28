package com.example.roomdatabase.event_model


import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("bookingId")
    val bookingId: String? = null
)