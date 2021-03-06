package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdatabase.event_model.Event


@Dao
interface EventDAO {

    /**
     * This function list of item into our Database
     * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEntityToEventsModel(responseEntity: List<Event>)


    /**
     * This function fetch the list of item from our Database
     * */
    @Query("select * from event_entity")
    fun getEntity(): List<Event>

}