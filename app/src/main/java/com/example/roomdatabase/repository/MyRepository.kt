package com.example.roomdatabase.repository

import com.example.roomdatabase.contact_model.Contact
import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.data.ContactDAO
import com.example.roomdatabase.data.EventDAO
import com.example.roomdatabase.event_model.Event
import com.example.roomdatabase.event_model.EventsModel
import com.example.roomdatabase.remote.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository(val contactDAO: ContactDAO,val eventDAO: EventDAO)  {

    val CONTENT_TYPE = "application/json"
    val contactApi = RetrofitGenerator.getContactInstance().create(APIService::class.java)
    val eventApi = RetrofitGenerator.getEventInstance().create(APIService::class.java)

    val responseHandler = ResponseHandler()

    private var contactList = mutableListOf<Contact>()
    private var eventList = mutableListOf<Event>()


    suspend fun getContactResponse() : Resource<ContactsModel> {
        val result = contactApi.getContacts(CONTENT_TYPE)
        return responseHandler.handleSuccess(result)
    }

    suspend fun insertContactListIntoDatabase(contactList : List<Contact>){
        contactDAO.addEntityToContactsModel(contactList)
    }

    suspend fun getEventResponse() : Resource<EventsModel> {
        val result = eventApi.getEvents(CONTENT_TYPE)
        return responseHandler.handleSuccess(result)
    }

    suspend fun insertEventListIntoDatabase(eventList : List<Event>){
        eventDAO.addEntityToEventsModel(eventList)
    }

    fun getEventEntity() : List<Event>{
      return eventDAO.getEntity()
    }

    fun getContactEntity(providerId : String) : Contact{
        return contactDAO.getEntity(providerId)
    }


}