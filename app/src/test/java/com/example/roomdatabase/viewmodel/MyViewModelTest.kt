package com.example.roomdatabase.viewmodel

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.roomdatabase.contact_model.Contact
import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.data.*
import com.example.roomdatabase.remote.*
import com.example.roomdatabase.repository.MyRepository
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(manifest=Config.NONE)
class MyViewModelTest{

//    lateinit var myRepository: MyRepository
//
//    @Mock
//    lateinit var api: APIService
//
//    @Mock
//    lateinit var responseHandler: ResponseHandler
//
//    lateinit var contactsModel: ContactsModel
//
//    @Mock
//    lateinit var success: Resource<ContactsModel>
//
//    lateinit var myViewModel: MyViewModel
//
//    private lateinit var eventDatabase : EventDatabase
//    private lateinit var contactDatabase: ContactDatabase
//    lateinit var eventDAO: EventDAO
//    lateinit var contactDAO: ContactDAO
//
//
//    @Before
//    fun setUp(){
//        val c = mutableListOf<Contact>()
//        contactsModel = ContactsModel(c,
//            6924,
//            "%2Fapi%2Fcontact%2Faccount%2FSEN42%2Fscroll%2F20%2FUSER",
//        true)
//
//        responseHandler = ResponseHandler()
//        success = Resource.success(contactsModel)
//        success = responseHandler.handleSuccess(contactsModel)
//
//        val context1 = ApplicationProvider.getApplicationContext<Context>()
//        val context2 = ApplicationProvider.getApplicationContext<Context>()
//
//        eventDatabase = Room.inMemoryDatabaseBuilder(
//            context1,
//            EventDatabase::class.java).allowMainThreadQueries().build()
//        val eventList = mutableListOf<EventEntity>()
//        val eventEntity = EventEntity("event","test","r0050")
//        eventList.add(eventEntity)
//        eventDAO = eventDatabase.getEventDao()
//
//
//        contactDatabase = Room.inMemoryDatabaseBuilder(
//            context2,
//            ContactDatabase::class.java).allowMainThreadQueries().build()
//        val contactList = mutableListOf<ContactEntity>()
//        val contactEntity = ContactEntity("contact","amit","r0060")
//        contactList.add(contactEntity)
//        contactDAO = contactDatabase.getContactDao()
//
//        myRepository = MyRepository(contactDAO,eventDAO)
//
//        myViewModel = MyViewModel(myRepository)
//
//
//        CoroutineScope(Dispatchers.IO).launch {
//            eventDAO.addEntityToEventsModel(eventList)
//        }
//
//        CoroutineScope(Dispatchers.IO).launch {
//            contactDAO.addEntityToContactsModel(contactList)
//        }
//
//
//    }
//
//    @Test
//    fun test_insert_and_get_operation_from_event_database(){
//
//        val result = myViewModel.getEventEntity().find {
//            it.type=="event" && it.title=="test" && it.provider=="r0050"
//        }
//        assertThat(result).isNotNull()
//
//    }
//
//    @Test
//    fun test_insert_and_get_operation_from_contact_database(){
//
//        val contactEntity = ContactEntity("contact","amit","r0060")
//        val result = myViewModel.getContactEntity("r0060")
//
//        assertThat(result).isEqualTo(contactEntity)
//
//    }
//
//    @Test
//    fun  test_api_call(){
//        myViewModel.getContactResponse()
//        assertThat(success.status).isEqualTo(Status.SUCCESS)
//    }
//


}

