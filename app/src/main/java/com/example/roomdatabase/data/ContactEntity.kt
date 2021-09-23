package com.example.roomdatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_entity")
data class ContactEntity(

    @ColumnInfo(name = "type")
    var type: String?,

    @ColumnInfo(name = "firstName")
    var firstName: String?,

    @ColumnInfo(name = "ownerID")
    var ownerID: String?,

    ) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int? = null

}