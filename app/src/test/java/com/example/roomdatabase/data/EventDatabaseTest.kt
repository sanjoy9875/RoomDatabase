package com.example.roomdatabase.data

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class EventDatabaseTest{

    @Test
    fun getRoomDatabase_instanceCheck_true(){

        val database = mockk<EventDatabase>()
        mockkObject(EventDatabase)
        val context = mockk<Context>()

        every {
            EventDatabase.getRoomDatabase(context)
        }returns database

        val result = EventDatabase.getRoomDatabase(context)

        assertThat(result).isInstanceOf(EventDatabase::class.java)

    }

    @Test
    fun getRoomDatabase_notNullCheck_true(){

        val database = mockk<EventDatabase>()
        mockkObject(EventDatabase)
        val context = mockk<Context>()

        every {
            EventDatabase.getRoomDatabase(context)
        }returns database

        val result = EventDatabase.getRoomDatabase(context)

        assertThat(result).isNotNull()

    }


    @Test
    fun getRoomDatabase_equalityCheck_true(){

        val database = mockk<EventDatabase>()
        mockkObject(EventDatabase)
        val context = mockk<Context>()

        every {
            EventDatabase.getRoomDatabase(context)
        }returns database

        val result = EventDatabase.getRoomDatabase(context)

        assertThat(result).isEqualTo(database)

    }

}