package com.example.roomdatabase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.roomdatabase.JoinEntity
import com.example.roomdatabase.contact_model.Contact
import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.event_model.Event
import com.example.roomdatabase.event_model.EventsModel
import com.example.roomdatabase.repository.MyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val repository: MyRepository) : ViewModel(){


    fun getContactResponse() : LiveData<ContactsModel>{
        return liveData (Dispatchers.IO){
            val data = repository.getContactResponse()
            emit(data.data!!)
        }
    }

     fun insertContactListIntoDatabase(contactList : List<Contact>){
        CoroutineScope(Dispatchers.IO).launch {
            repository.insertContactListIntoDatabase(contactList)
        }
    }


    fun getEventResponse() : LiveData<EventsModel>{
        return liveData (Dispatchers.IO){
            val data = repository.getEventResponse()
            emit(data.data!!)
        }

    }

    fun insertEventListIntoDatabase(eventList : List<Event>){
        CoroutineScope(Dispatchers.IO).launch {
            repository.insertEventListIntoDatabase(eventList)
        }
    }

    fun mergeContactAndEventById():LiveData<List<JoinEntity>>{

        val eventList = mutableListOf<Event>()
        val joinList = mutableListOf<JoinEntity>()

        return liveData(Dispatchers.IO){
            val event = repository.getEventEntity()
                eventList.addAll(event)
                joinList.clear()

                val contactList = HashMap<String, Contact>()

                for (i in 0 until eventList.size) {

                    if (!contactList.containsKey(eventList[i].provider?.get(0)!!)) {

                        val data = repository.getContactEntity(eventList[i].provider?.get(0)!!)

                        contactList.put(eventList[i].provider?.get(0)!!, data)

                        val joinEntity = JoinEntity(data, eventList[i])
                        joinList.add(joinEntity)

                    }
                    else {

                        val data = contactList.get(eventList[i].provider?.get(0)!!)
                        val joinEntity = JoinEntity(data, eventList[i])
                        joinList.add(joinEntity)

                    }
                }
            emit(joinList)
            }

         }

    }























