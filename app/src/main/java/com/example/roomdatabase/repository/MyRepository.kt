package com.example.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase.contact_model.ContactsModel

import com.example.roomdatabase.data.ContactDAO
import com.example.roomdatabase.data.ContactEntity
import com.example.roomdatabase.data.EventDAO
import com.example.roomdatabase.data.EventEntity
import com.example.roomdatabase.remote.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository(val contactDAO: ContactDAO,val eventDAO: EventDAO)  {

    val CONTENT_TYPE = "application/json"
    val contactApi = RetrofitGenerator.getInstance().create(APIService::class.java)
    val eventApi = RetrofitGenerator2.getInstance().create(APIService::class.java)

    private val responseHandler = ResponseHandler()

    private var contactList = mutableListOf<ContactEntity>()
    private var eventList = mutableListOf<EventEntity>()


    suspend fun getContact():Resource<ContactsModel>{
        return try{
            val result = contactApi.getContacts(CONTENT_TYPE)
            responseHandler.handleSuccess(result)
        }
        catch (e : Exception){
            responseHandler.handleException(e)
        }
    }

    /**
     * This function will call our API & give us the response
     * response will store in database
     * */
    suspend fun getContactResponse()  {
        CoroutineScope(Dispatchers.IO).launch {
            val result = contactApi.getContacts(CONTENT_TYPE)

            if (contactList.size==0) {
                for (i in 0 until (result?.contacts?.size!!)) {
                    var contactEntity = ContactEntity(
                        result.contacts[i].type,
                        result.contacts[i].firstName,
                        result.contacts[i].ownerID
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
                for (i in 0 until (result.data?.events?.size!! )) {
                    var eventEntity = EventEntity(
                        result.data.events[i].type,
                        result.data.events[i].title,
                        result.data.events[i].provider?.get(0)
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

    fun getEventEntity() : List<EventEntity>{
      return eventDAO.getEntity()
    }

    fun getContactEntity(providerId : String) : ContactEntity{
        return contactDAO.getEntity(providerId)
    }


}