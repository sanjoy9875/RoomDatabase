package com.example.roomdatabase.event_model


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("bookingId")
    val bookingId: String? = null,
    @SerializedName("brand")
    val brand: String? = null,
    @SerializedName("calendar")
    val calendar: String? = null,
    @SerializedName("cancelEventId")
    val cancelEventId: String? = null,
    @SerializedName("consumer")
    val consumer: List<String>? = null,
    @SerializedName("cost")
    val cost: Double? = null,
    @SerializedName("createdTime")
    val createdTime: Long? = null,
    @SerializedName("endDateTime")
    val endDateTime: String? = null,
    @SerializedName("endTime")
    val endTime: Long? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("isDeleted")
    val isDeleted: Boolean? = null,
    @SerializedName("isExternal")
    val isExternal: Boolean? = null,
    @SerializedName("label")
    val label: String? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("log")
    val log: Log? = null,
    @SerializedName("maxSeats")
    val maxSeats: Int? = null,
    @SerializedName("merchant")
    val merchant: String? = null,
    @SerializedName("metaData")
    val metaData: MetaData? = null,
    @SerializedName("parentId")
    val parentId: String? = null,
    @SerializedName("provider")
    val provider: List<String>? = null,
    @SerializedName("resource")
    val resource: List<Any>? = null,
    @SerializedName("service")
    val service: List<String>? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("startDateTime")
    val startDateTime: String? = null,
    @SerializedName("startTime")
    val startTime: Long? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("updatedTime")
    val updatedTime: Long? = null
)