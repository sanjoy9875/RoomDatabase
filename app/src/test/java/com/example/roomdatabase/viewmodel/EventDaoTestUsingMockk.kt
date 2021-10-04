package com.example.roomdatabase.viewmodel
import com.example.roomdatabase.data.EventDAO
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test



class EventDaoTestUsingMockk {

//
//    @Test
//    fun get_event_entity_from_database_test(){
//
//        val eventList = mutableListOf<EventEntity>()
//        val eventEntity = EventEntity("event","test","r0055")
//        eventList.add(eventEntity)
//
//      val dao = mockk<EventDAO>()
//
//        every {
//            dao.getEntity()
//        } returns eventList
//
//        val result = dao.getEntity()
//
//        verify {
//            dao.getEntity()
//        }
//
//        val eventList2 = mutableListOf<EventEntity>()
//        val eventEntity2 = EventEntity("event","test","r0055")
//        eventList2.add(eventEntity2)
//
//        assertEquals(eventList2, result)
//
//    }
//
//    @Test
//    fun insert_event_entity_from_database_test(){
//
//        val eventList = mutableListOf<EventEntity>()
//        val eventEntity = EventEntity("event","test","r0050")
//        eventList.add(eventEntity)
//
//        val dao = mockk<EventDAO>()
//
//        coEvery {
//            dao.addEntityToEventsModel(eventList)
//        }just Runs
//
//       runBlocking {
//           dao.addEntityToEventsModel(eventList)
//       }
//
//        coVerify{
//            dao.addEntityToEventsModel(eventList)
//        }
//
//    }
//
//

}