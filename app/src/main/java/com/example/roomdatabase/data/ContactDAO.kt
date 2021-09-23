package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDAO {

    /**
     * This function list of item into our Database
     * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEntityToContactsModel(responseEntity: List<ContactEntity>)


    /**
     * This function fetch the list of item from our Database
     * */
    @Query("select * from contact_entity WHERE ownerID=:providerId")
    fun getEntity(providerId : String): ContactEntity

}