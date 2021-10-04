package com.example.roomdatabase.event_model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "event_entity")
data class Event(

    @ColumnInfo(name = "bookingId")
    val bookingId: String? = null,

    @ColumnInfo(name = "brand")
    val brand: String? = null,

    @ColumnInfo(name = "calendar")
    val calendar: String? = null,

    @ColumnInfo(name = "cancelEventId")
    val cancelEventId: String? = null,

    @ColumnInfo(name = "consumer")
    val consumer: List<String>? = null,

    @ColumnInfo(name = "cost")
    val cost: Double? = null,

    @ColumnInfo(name = "createdTime")
    val createdTime: Long? = null,

    @ColumnInfo(name = "endDateTime")
    val endDateTime: String? = null,

    @ColumnInfo(name = "endTime")
    val endTime: Long? = null,

    @ColumnInfo(name = "id")
    val id: String? = null,

    @ColumnInfo(name = "isDeleted")
    val isDeleted: Boolean? = null,

    @ColumnInfo(name = "isExternal")
    val isExternal: Boolean? = null,

    @ColumnInfo(name = "label")
    val label: String? = null,

    @ColumnInfo(name = "location")
    val location: Location? = null,

    @ColumnInfo(name = "log")
    val log: Log? = null,

    @ColumnInfo(name = "maxSeats")
    val maxSeats: Int? = null,

    @ColumnInfo(name = "merchant")
    val merchant: String? = null,

    @ColumnInfo(name = "metaData")
    val metaData: MetaData? = null,

    @ColumnInfo(name = "parentId")
    val parentId: String? = null,

    @ColumnInfo(name = "provider")
    val provider: List<String>? = null,

    @ColumnInfo(name = "resource")
    val resource: List<String>? = null,

    @ColumnInfo(name = "service")
    val service: List<String>? = null,

    @ColumnInfo(name = "source")
    val source: String? = null,

    @ColumnInfo(name = "startDateTime")
    val startDateTime: String? = null,

    @ColumnInfo(name = "startTime")
    val startTime: Long? = null,

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "type")
    val type: String? = null,

    @ColumnInfo(name = "updatedTime")
    val updatedTime: Long? = null
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "eId") var eId:Int? = null
}