package com.example.roomdatabase.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.JoinEntity
import com.example.roomdatabase.data.ContactEntity
import com.example.roomdatabase.data.EventEntity
import com.example.roomdatabase.repository.MyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val repository: MyRepository) : ViewModel(){

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

    fun getContactEntity(): LiveData<List<ContactEntity>>{
        Log.d("viewModel",repository.getContactEntity().toString())
       return repository.getContactEntity()
    }

    fun getEventEntity(): LiveData<List<EventEntity>>{
        Log.d("viewModel",repository.getEventEntity().toString())
        return repository.getEventEntity()
    }


}
