package com.example.roomdatabase.viewmodel

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.data.*
import com.example.roomdatabase.event_model.EventsModel
import com.example.roomdatabase.remote.APIService
import com.example.roomdatabase.remote.RetrofitGenerator
import com.example.roomdatabase.remote.RetrofitGenerator2
import com.example.roomdatabase.repository.MyRepository
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import org.junit.Before
import org.junit.Test

class ViewModelTest {


    @Before
    fun setUp(){
        val eventApi = RetrofitGenerator2.getInstance().create(APIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            eventApi.getEvents("application/json")


        }
    }


    @Test
    fun api_test(){


        val repository = mockk<MyRepository>()
        val viewModel = MyViewModel(repository)


        coEvery {
            repository.getEventResponse()
        }just Runs

        viewModel.getEventResponse()


        coVerify (exactly = 1){
            repository.getEventResponse()
        }


    }
}