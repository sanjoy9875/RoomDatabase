package com.example.roomdatabase.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.roomdatabase.JoinEntity
import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.data.ContactEntity
import com.example.roomdatabase.data.EventEntity
import com.example.roomdatabase.remote.Resource
import com.example.roomdatabase.repository.MyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val repository: MyRepository) : ViewModel(){

    fun getContact():LiveData<Resource<ContactsModel>>{
        return liveData(Dispatchers.IO){
            emit(Resource.loading(null))
            val data = repository.getContact()
            emit(data)
        }
    }

    /**
     * Getting the response from api
     * */
    fun getContactResponse(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.getContactResponse()
        }
    }


    /**
     * Getting the response from api
     * */
    fun getEventResponse(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.getEventResponse()
        }
    }

    fun getEventEntity():List<EventEntity>{
        return repository.getEventEntity()
    }

    fun getContactEntity(providerId : String) : ContactEntity{
        return repository.getContactEntity(providerId)
    }


}
