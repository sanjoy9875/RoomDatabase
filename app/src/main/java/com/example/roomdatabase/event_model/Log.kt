package com.example.roomdatabase.event_model


import com.google.gson.annotations.SerializedName

data class Log(
    @SerializedName("changedProperties")
    val changedProperties: ChangedProperties? = null
)