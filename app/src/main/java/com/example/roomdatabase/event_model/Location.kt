package com.example.roomdatabase.event_model


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("videoMeeting")
    val videoMeeting: String?
)