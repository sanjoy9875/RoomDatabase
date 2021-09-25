package com.example.roomdatabase.viewmodel

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.data.*
import com.example.roomdatabase.remote.*
import com.example.roomdatabase.repository.MyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doReturn
import org.robolectric.annotation.Config
import java.net.SocketException

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MyViewModelTest{

    @Mock
    lateinit var myRepository: MyRepository

    @Mock
    lateinit var api: APIService

    @Mock
    lateinit var responseHandler: ResponseHandler

    @Mock
    lateinit var contactsModel: ContactsModel

    @Mock
    lateinit var success: Resource<ContactsModel>

    lateinit var myViewModel: MyViewModel

    private lateinit var eventDatabase : EventDatabase
    private lateinit var contactDatabase: ContactDatabase
    lateinit var eventDAO: EventDAO
    lateinit var contactDAO: ContactDAO


    @Before
    fun setUp(){

        val context1 = ApplicationProvider.getApplicationContext<Context>()
        val context2 = ApplicationProvider.getApplicationContext<Context>()

        eventDatabase = Room.inMemoryDatabaseBuilder(
            context1,
            EventDatabase::class.java).allowMainThreadQueries().build()
        val eventList = mutableListOf<EventEntity>()
        val eventEntity = EventEntity("event","test","r0050")
        eventList.add(eventEntity)
        eventDAO = eventDatabase.getEventDao()


        contactDatabase = Room.inMemoryDatabaseBuilder(
            context2,
            ContactDatabase::class.java).allowMainThreadQueries().build()
        val contactList = mutableListOf<ContactEntity>()
        val contactEntity = ContactEntity("contact","amit","r0060")
        contactList.add(contactEntity)
        contactDAO = contactDatabase.getContactDao()

        myRepository = MyRepository(contactDAO,eventDAO)

        myViewModel = MyViewModel(myRepository)


        CoroutineScope(Dispatchers.IO).launch {
            eventDAO.addEntityToEventsModel(eventList)
        }

        CoroutineScope(Dispatchers.IO).launch {
            contactDAO.addEntityToContactsModel(contactList)
        }
        CoroutineScope(Dispatchers.IO).launch {
            data()
        }

    }

    @Test
    fun `get list of eventEntity from event database`(){

        val result = myViewModel.getEventEntity().find {
            it.type=="event" && it.title=="test" && it.provider=="r0050"
        }
        assert(result!=null)

    }

    @Test
    fun `get contactEntity from contact database`(){

        val contactEntity = ContactEntity("contact","amit","r0060")
        val result = myViewModel.getContactEntity("r0060")

        assert(result==contactEntity)

    }

    @Test
    fun  `get contacts model from api successful`(){
        myViewModel.getContactResponse()
        assertEquals(success.status,Status.SUCCESS)
    }


    suspend fun data() {
        responseHandler = ResponseHandler()
        success = responseHandler.handleSuccess(contactsModel)

        `when`<ContactsModel>(
            api.getContacts(
                "application/json"
            )
        ).thenReturn(contactsModel)

        `when`<Resource<ContactsModel>>(
            myRepository.getContact()
        ).thenReturn(success)


    }
}

