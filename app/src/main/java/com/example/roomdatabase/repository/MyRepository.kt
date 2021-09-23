package com.example.roomdatabase.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData

import com.example.roomdatabase.JoinEntity
import com.example.roomdatabase.data.ContactDAO
import com.example.roomdatabase.data.ContactEntity
import com.example.roomdatabase.data.EventDAO
import com.example.roomdatabase.data.EventEntity
import com.example.roomdatabase.remote.APIService
import com.example.roomdatabase.remote.RetrofitGenerator
import com.example.roomdatabase.remote.RetrofitGenerator2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository(val contactDAO: ContactDAO,val eventDAO: EventDAO)  {

    val CONTENT_TYPE = "application/json"
    val contactApi = RetrofitGenerator.getInstance().create(APIService::class.java)
    val eventApi = RetrofitGenerator2.getInstance().create(APIService::class.java)

    private var contactList = mutableListOf<ContactEntity>()
    private var eventList = mutableListOf<EventEntity>()

    /**
     * This function will call our API & give us the response
     * response will store in database
     * */
    suspend fun getContactResponse()  {
        CoroutineScope(Dispatchers.IO).launch {
            val result = contactApi.getContacts(CONTENT_TYPE)

            if (contactList.size==0) {
                for (i in 0 until result.contacts.size) {
                    var contactEntity = ContactEntity(
                        result.contacts[i].type,
                        result.contacts[i].firstName,
                        result.contacts[i].brandID
                    )
                    contactList.add(contactEntity)
                }
                contactDAO.addEntityToContactsModel(contactList)
            }
        }
    }

    /**
     * This function will call our API & give us the response
     * response will store in database
     **/
    suspend fun getEventResponse()  {
        CoroutineScope(Dispatchers.IO).launch {
            val result = eventApi.getEvents(CONTENT_TYPE)

            if (eventList.size==0) {
                for (i in 0 until result.data.events.size) {
                    var eventEntity = EventEntity(
                        result.data.events[i].type,
                        result.data.events[i].title,
                        result.data.events[i].brand
                    )
                    eventList.add(eventEntity)
                }

                eventDAO.addEntityToEventsModel(eventList)
            }
        }
    }

    /**
     * Give us the list of ResponseEntity
     **/

    fun getContactEntity():LiveData<List<ContactEntity>>{
       return contactDAO.getEntity()
    }

    fun getEventEntity():LiveData<List<EventEntity>>{
        return eventDAO.getEntity()
    }

//  fun getEntity() : List<JoinEntity>{
//
//        var joinList = mutableListOf<JoinEntity>()
//        var contactEntity = mutableListOf<ContactEntity>()
//        var eventEntity = mutableListOf<EventEntity>()
//
//        CoroutineScope(Dispatchers.IO).launch {
//
//            contactEntity = contactDAO.getEntity() as MutableList<ContactEntity>
//            eventEntity = eventDAO.getEntity() as MutableList<EventEntity>
//
//            val contactSize = contactEntity.size
//            val eventSize = eventEntity.size
//
//            if (eventSize>0 && contactSize>0) {
//                for (i in 0 until eventSize){
//                  for (j in 0 until contactSize){
//                      if (eventEntity[i].brand==contactEntity[j].brandId){
//                          val joinEntity = JoinEntity(
//                              contactEntity[j].type,
//                              contactEntity[j].firstName,
//                              contactEntity[j].brandId,
//                              eventEntity[i].type,
//                              eventEntity[i].title,
//                              eventEntity[i].brand,
//                          )
//                          joinList.add(joinEntity)
//                      }
//                  }
//                }
//            }
//        }
//        return joinList
//    }
}