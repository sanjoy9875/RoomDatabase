package com.example.roomdatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_entity")
data class ContactEntity(

    @ColumnInfo(name = "type")
    var type: String? = null,

    @ColumnInfo(name = "firstName")
    var firstName: String? = null,

    @ColumnInfo(name = "ownerID")
    var ownerID: String? = null,

    ) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int? = null

}