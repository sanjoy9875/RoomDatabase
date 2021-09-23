package com.example.roomdatabase.event_model


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("bookingId")
    val bookingId: String?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("calendar")
    val calendar: String?,
    @SerializedName("cancelEventId")
    val cancelEventId: String?,
    @SerializedName("consumer")
    val consumer: List<String>?,
    @SerializedName("cost")
    val cost: Double?,
    @SerializedName("createdTime")
    val createdTime: Long?,
    @SerializedName("endDateTime")
    val endDateTime: String?,
    @SerializedName("endTime")
    val endTime: Long?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isDeleted")
    val isDeleted: Boolean?,
    @SerializedName("isExternal")
    val isExternal: Boolean?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("log")
    val log: Log?,
    @SerializedName("maxSeats")
    val maxSeats: Int?,
    @SerializedName("merchant")
    val merchant: String?,
    @SerializedName("metaData")
    val metaData: MetaData?,
    @SerializedName("parentId")
    val parentId: String?,
    @SerializedName("provider")
    val provider: List<String>?,
    @SerializedName("resource")
    val resource: List<Any>?,
    @SerializedName("service")
    val service: List<String>?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("startDateTime")
    val startDateTime: String?,
    @SerializedName("startTime")
    val startTime: Long?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("updatedTime")
    val updatedTime: Long?
)