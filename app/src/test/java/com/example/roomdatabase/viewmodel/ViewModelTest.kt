package com.example.roomdatabase.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.roomdatabase.contact_model.Contact
import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.data.*
import com.example.roomdatabase.event_model.Event
import com.example.roomdatabase.event_model.EventsModel
import com.example.roomdatabase.remote.APIService
import com.example.roomdatabase.remote.RetrofitGenerator
import com.example.roomdatabase.repository.MyRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class ViewModelTest {

    @Test
    fun insertContactList_verifyFunctionCall(){

        val viewModel = mockk<MyViewModel>()

        val contactList = mutableListOf<Contact>()
        val contact = mockk<Contact>()
        contactList.add(contact)

        coEvery {
            viewModel.insertContactListIntoDatabase(contactList)
        }just Runs

        viewModel.insertContactListIntoDatabase(contactList)

        coVerify {
            viewModel.insertContactListIntoDatabase(contactList)
        }

    }

    @Test
    fun insertEventList_verifyingFunctionCall(){
        val viewModel = mockk<MyViewModel>()

        val eventList = mutableListOf<Event>()
        val event = mockk<Event>()
        eventList.add(event)

        coEvery {
            viewModel.insertEventListIntoDatabase(eventList)
        }just Runs

        viewModel.insertEventListIntoDatabase(eventList)

        coVerify {
            viewModel.insertEventListIntoDatabase(eventList)
        }
    }

    @Test
    fun getContactResponse_notNullCheck_true(){

        val viewModel = mockk<MyViewModel>()
        var contact = mockk<ContactsModel>()

        coEvery {
            viewModel.getContactResponse().value
        }returns contact

       runBlocking {
            contact = viewModel.getContactResponse().value!!
        }

        assertThat(contact).isNotNull()

    }

    @Test
    fun getContactResponse_instanceCheck_true(){

        val viewModel = mockk<MyViewModel>()
        var contact = mockk<ContactsModel>()

        coEvery {
            viewModel.getContactResponse().value
        }returns contact

        runBlocking {
            contact = viewModel.getContactResponse().value!!
        }

        assertThat(contact).isInstanceOf(ContactsModel::class.java)

    }

    @Test
    fun getEventResponse_notNullCheck_true(){

        val viewModel = mockk<MyViewModel>()
        var event = mockk<EventsModel>()

        coEvery {
            viewModel.getEventResponse().value
        }returns event

        runBlocking {
            event = viewModel.getEventResponse().value!!
        }

        assertThat(event).isNotNull()

    }

    @Test
    fun getEventResponse_instanceCheck_true(){

        val viewModel = mockk<MyViewModel>()
        var event = mockk<EventsModel>()

        coEvery {
            viewModel.getEventResponse().value
        }returns event

        runBlocking {
            event = viewModel.getEventResponse().value!!
        }

        assertThat(event).isInstanceOf(EventsModel::class.java)

    }

}