package com.example.roomdatabase.repository


import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.roomdatabase.contact_model.Contact
import com.example.roomdatabase.contact_model.ContactsModel
import com.example.roomdatabase.data.ContactDAO
import com.example.roomdatabase.data.EventDAO
import com.example.roomdatabase.event_model.Event
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MyRepositoryTest{

    @Test
    fun getContactResponse_notNullCheck_true(){

        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)

        var contact = ContactsModel()

        runBlocking {
           contact = repository.getContactResponse().data!!
        }

        assertThat(contact).isNotNull()

    }

    @Test
    fun getContactResponse_instanceCheck_true(){

        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)

        var contact = ContactsModel()

        runBlocking {
            contact = repository.getContactResponse().data!!
        }

        assertThat(contact).isInstanceOf(ContactsModel::class.java)

    }

    @Test
    fun getContactResponse_equalityCheck_true(){

        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)

        var contact = ContactsModel()

        runBlocking {
            contact = repository.getContactResponse().data!!
        }

        assertThat(contact).isEqualTo(contact)

    }

    @Test
    fun insertContactListIntoDatabase_verifyFunctionCall_true(){
        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)
        val contact = mockk<Contact>()

        val contactList = mutableListOf<Contact>()
        contactList.add(contact)

        coEvery {
            repository.insertContactListIntoDatabase(contactList)
        }just Runs

        runBlocking {
           repository.insertContactListIntoDatabase(contactList)
        }

        coVerify{
            repository.insertContactListIntoDatabase(contactList)
        }
    }

    @Test
    fun getContactEntity_notNullCheck_true(){
        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)
        val contact = mockk<Contact>()

        val contactList = mutableListOf<Contact>()
        contactList.add(contact)

        every {
            repository.getContactEntity("r0050")
        }returns contact

       val result = repository.getContactEntity("r0050")

        assertThat(result).isNotNull()

    }

    @Test
    fun getContactEntity_equalityCheck_true(){
        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)
        val contact = mockk<Contact>()

        val contactList = mutableListOf<Contact>()
        contactList.add(contact)

        every {
            repository.getContactEntity("r0050")
        }returns contact

        val result = repository.getContactEntity("r0050")

        assertThat(result).isEqualTo(contact)

    }

    @Test
    fun insertEventListIntoDatabase_verifyFunctionCall_true(){
        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)
        val event = mockk<Event>()

        val eventList = mutableListOf<Event>()
        eventList.add(event)

        coEvery {
            repository.insertEventListIntoDatabase(eventList)
        }just Runs

        runBlocking {
            repository.insertEventListIntoDatabase(eventList)
        }

        coVerify{
            repository.insertEventListIntoDatabase(eventList)
        }
    }

    @Test
    fun getEventEntity_notNullCheck_true(){
        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)
        val event = mockk<Event>()

        val eventList = mutableListOf<Event>()
        eventList.add(event)

        every {
            repository.getEventEntity()
        }returns eventList

        val result = repository.getEventEntity()

        assertThat(result).isNotNull()

    }

    @Test
    fun getEventEntity_equalityCheck_true(){
        val contactDAO = mockk<ContactDAO>()
        val eventDAO = mockk<EventDAO>()
        val repository = MyRepository(contactDAO, eventDAO)
        val event = mockk<Event>()

        val eventList = mutableListOf<Event>()
        eventList.add(event)

        every {
            repository.getEventEntity()
        }returns eventList

        val result = repository.getEventEntity()

        assertThat(result).isEqualTo(eventList)

    }

}