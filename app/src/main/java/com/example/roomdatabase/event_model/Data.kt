package com.example.roomdatabase.event_model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("events")
    val events: List<Event>?
)