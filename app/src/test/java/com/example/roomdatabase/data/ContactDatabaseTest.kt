package com.example.roomdatabase.data

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class ContactDatabaseTest{

    @Test
    fun getRoomDatabase_instanceCheck_true(){

       val database = mockk<ContactDatabase>()
        mockkObject(ContactDatabase)
        val context = mockk<Context>()

        every {
            ContactDatabase.getRoomDatabase(context)
        }returns database

        val result = ContactDatabase.getRoomDatabase(context)

//        assertThat(result).isNotNull()
        assertThat(result).isInstanceOf(ContactDatabase::class.java)
//        assertThat(result).isEqualTo(database)

    }

    @Test
    fun getRoomDatabase_notNullCheck_true(){

        val database = mockk<ContactDatabase>()
        mockkObject(ContactDatabase)
        val context = mockk<Context>()

        every {
            ContactDatabase.getRoomDatabase(context)
        }returns database

        val result = ContactDatabase.getRoomDatabase(context)

        assertThat(result).isNotNull()

    }

    @Test
    fun getRoomDatabase_equalityCheck_true(){

        val database = mockk<ContactDatabase>()
        mockkObject(ContactDatabase)
        val context = mockk<Context>()

        every {
            ContactDatabase.getRoomDatabase(context)
        }returns database

        val result = ContactDatabase.getRoomDatabase(context)

        assertThat(result).isEqualTo(database)

    }

}