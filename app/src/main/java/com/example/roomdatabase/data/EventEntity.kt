package com.example.roomdatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_entity")
data class EventEntity(

    @ColumnInfo(name = "type")
    var type: String?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "provider")
    var provider: String?,

    ) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int? = null

}