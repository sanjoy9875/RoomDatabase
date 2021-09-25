package com.example.roomdatabase.views

import android.app.Application
import com.example.roomdatabase.data.ContactDatabase
import com.example.roomdatabase.data.EventDatabase
import com.example.roomdatabase.repository.MyRepository

class MyApplication : Application() {

    private val contactDAO by lazy {
        val roomDatabase = ContactDatabase.getRoomDatabase(this)
        roomDatabase.getContactDao()
    }

    private val eventDAO by lazy {
        val roomDatabase = EventDatabase.getRoomDatabase(this)
        roomDatabase.getEventDao()
    }

    val repository by lazy {
        MyRepository(contactDAO,eventDAO)
    }


}