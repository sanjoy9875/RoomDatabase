package com.example.roomdatabase.viewmodel

import android.content.Context
import android.support.test.runner.AndroidJUnit4
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.roomdatabase.data.EventDAO
import com.example.roomdatabase.data.EventDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class EventDaoTest {

//private lateinit var eventDatabase: EventDatabase
//private lateinit var eventDAO: EventDAO
//
//@Before
//fun setUp(){
//    val context = ApplicationProvider.getApplicationContext<Context>()
//    eventDatabase = Room.inMemoryDatabaseBuilder(
//        context,
//        EventDatabase::class.java).build()
//    eventDAO = eventDatabase.getEventDao()
//
//}
//
//    @Test
//    fun `add entity to the database`(){
//
//        val eventList = mutableListOf<EventEntity>()
//        val eventEntity = EventEntity("event","test","r0055")
//        eventList.add(eventEntity)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            eventDAO.addEntityToEventsModel(eventList)
//            val result = eventDAO.getEntity()
//
//            assert(result.isNotEmpty())
//
//        }
//    }


}