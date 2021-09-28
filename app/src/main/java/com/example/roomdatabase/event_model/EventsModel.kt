package com.example.roomdatabase.event_model


import com.google.gson.annotations.SerializedName

data class EventsModel(
    @SerializedName("data")
    val `data`: Data? = null,
    @SerializedName("response")
    val response: Boolean? = null
)